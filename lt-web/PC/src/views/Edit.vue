<template>
    <div class="frame">
        <el-select v-model="word.srcLang" size="large" placeholder="Select Language">
            <el-option v-for="item in languageInfoList" :key="item.name" :label="item.label" :value="item.name">
            </el-option>
        </el-select>

        <div class="edit-wrap">
            <el-input v-model="word.name" clearable></el-input>
            <el-button type="primary" size="large" :icon="Check" class="save-button" @click="save">Save</el-button>
        </div>
        <div class="src-info-wrap">
            <div class="phonetic-wrap">
                <span>音标：</span>
                <el-input class="phonetic-input" v-model="word.phoneticSymbol" clearable></el-input>
            </div>
            <div class="phonetic-wrap">
                <span>等级：</span>
                <el-select v-model="word.level" size="large" placeholder="Select Level">
                    <el-option v-for="item in levelInfoList" :key="item.code" :label="item.desc" :value="item.code">
                    </el-option>
                </el-select>
            </div>
        </div>

        <div>
            <el-tabs v-model="tgtLang" type="card" class="demo-tabs" @tab-click="handleClick">
                <el-tab-pane v-for="item in languageInfoList" :label="item.label" :name="item.name">
                    <div class="info-wrap" v-for="sentenceInfo in sentenceInfoMap[item.name]" :key="sentenceInfo.srcMeaning"
                        @mouseenter="sentenceInfo.focus = true" @mouseleave="sentenceInfo.focus = false">
                        <el-select v-model="sentenceInfo.partOfSpeech" class="partOfSpeech"
                            placeholder="Select part of speech">
                            <el-option v-for="item in partOfSpeechInfoList" :key="item.name" :label="item.label"
                                :value="item.name">
                            </el-option>
                        </el-select>
                        <div class="sampleUnit">
                            <el-input class="sample means" v-model="sentenceInfo.srcMeaning" clearable></el-input>
                            <el-input class="sample means" v-model="sentenceInfo.tgtMeaning" clearable></el-input>
                            <el-input class="sample" v-model="sentenceInfo.srcSentence" clearable></el-input>
                            <el-input class="sample targetInfo" v-model="sentenceInfo.tgtSentence" clearable></el-input>
                        </div>
                        <div v-show="sentenceInfo.focus">
                            <el-button type="primary" :icon="Plus" @click="addItem(sentenceInfo)"></el-button>
                            <el-button type="danger" :icon="Delete" @click="deleteItem(sentenceInfo)"></el-button>
                        </div>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { Check, Plus, Delete } from '@element-plus/icons-vue'
import { getDictInfo, getDictInfo2 } from '@/api/dict'
import { getLexicalInfo, saveLexicalInfo } from '@/api/wordManager'
import { getLevelInfo } from '@/api/info'
// import { ElMessage } from 'element-plus'

const route = useRoute()

// const languageInfoList = getDictInfo2('language')
const languageInfoList = reactive([])
const partOfSpeechInfoList = getDictInfo2('partOfSpeech')
const levelInfoList = reactive([])

const word = reactive({})
const sentenceInfoMap = reactive({})

const tgtLang = ref('')

const getLevelInfoList = async () => {
    const levelInfos = await getLevelInfo()

    console.log('aa' + levelInfos)

    levelInfoList.push(...levelInfos)
}

onMounted(async () => {
    const { result: langResult } = await getDictInfo('language')
    languageInfoList.push(...langResult)

    getLevelInfoList()

    if (route.params.id) {
        let params = {
            'id': route.params.id
        }
        const { result } = await getLexicalInfo(params)
        Object.assign(word, result.word)
        if (result.sentenceList && result.sentenceList.length > 0) {
            // sentenceInfoList.push(...result.sentenceList)
            for (const sentence of result.sentenceList) {
                const tgtLang = sentence.tgtLang
                if (!sentenceInfoMap[tgtLang]) {
                    sentenceInfoMap[tgtLang] = []
                }

                sentenceInfoMap[tgtLang].push(sentence)
            }
        }
    }

    for (const langInfo of languageInfoList) {
        if (!sentenceInfoMap[langInfo.name]) {
            sentenceInfoMap[langInfo.name] = []
            sentenceInfoMap[langInfo.name].push({})
        }
    }

    console.log('aa' + languageInfoList.value)
})

const save = async () => {
    if (!word.srcLang || word.srcLang === '' || !word.name || word.name === '') {
        ElMessage.warning({
            message: '语言信息为空'
        })

        return
    }

    const sentenceInfoList = []
    for (const lang in sentenceInfoMap) {
        if (sentenceInfoMap[lang] || sentenceInfoMap[lang].size > 0) {
            for (const sentenceInfo of sentenceInfoMap[lang]) {
                if (sentenceInfo.partOfSpeech && sentenceInfo.srcMeaning && sentenceInfo.srcSentence && sentenceInfo.tgtSentence) {
                    sentenceInfo['tgtLang'] = lang
                    sentenceInfoList.push(sentenceInfo)
                }
            }
        }
    }

    const data = {
        word,
        sentenceList: sentenceInfoList,
    }
    const { result } = await saveLexicalInfo(data)

    const success = result == null
    ElMessage({
        message: success ? '保存成功' : result,
        type: success ? 'success' : 'error'
    })
}

const addItem = (sentenceInfo) => {
    const index = sentenceInfoMap[tgtLang.value].indexOf(sentenceInfo)
    if (index > -1) {
        sentenceInfoMap[tgtLang.value].splice(index + 1, 0, {})
        // if (sentenceInfo[partOfSpeech].length === 0) {
        //     delete sentenceInfo[partOfSpeech]
        // }
    }
}

const deleteItem = (sentenceInfo) => {
    const index = sentenceInfoMap[tgtLang.value].indexOf(sentenceInfo)
    if (index > -1) {
        sentenceInfoMap[tgtLang.value].splice(index, 1)
        // if (sentenceInfo[partOfSpeech].length === 0) {
        //     delete sentenceInfo[partOfSpeech]
        // }
    }

    if (sentenceInfoMap[tgtLang.value].length == 0) {
        sentenceInfoMap[tgtLang.value].push({})
    }
}

const formRef = ref()

const rules = reactive({
    partOfSpeech: [{ required: true, message: 'Please select part of speech', trigger: 'change' }],
    means: [{ required: true, message: 'Please input means', trigger: 'blur' }],
    srcSentence: [{ required: true, message: 'Please input source sentence', trigger: 'blur' }],
    tgtSentence: [{ required: true, message: 'Please input target sentence', trigger: 'blur' }]
})

</script>

<style scoped>
.frame {
    width: 800px;
    margin: auto;
    padding-top: 30px;
}

.edit-wrap {
    display: flex;
    justify-content: center;
    height: 60px;
    padding: 20px 0;
}

.save-button {
    width: 125px;
    height: 60px;
    font-size: 16px;
}

.src-info-wrap {
    height: 50px;
    display: flex;
}

.info-wrap {
    display: flex;
    align-items: center;
}

.partOfSpeech {
    width: 20%;
}

.phonetic-input {
    display: inline-block;
    width: 250px;
}

.sample {
    margin: 10px 0;
}

.sampleUnit {
    margin-bottom: 20px;
    width: 60%;
    margin: 5px;
}

.operate {
    width: 20%;
}

.partOfSpeech {
    font-weight: bold;
}

.targetInfo {
    color: darkgray;
}

.means {
    font-size: 18px;
}
</style>
