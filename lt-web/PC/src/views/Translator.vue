<template>
    <div class="frame">
        <el-select v-model="wordInfo.srcLang" size="large" placeholder="Select Language">
            <el-option v-for="item in languageInfoList" :key="item.name" :label="item.label" :value="item.name">
            </el-option>
        </el-select>

        <div class="search-wrap">
            <!-- <input type="text" class="search-input" /> -->
            <!-- <button class="search-button" @click="search">查询</button> -->
            <el-input v-model="wordInfo.name" clearable></el-input>
            <el-button type="primary" size="large" :icon="Search" class="search-button" @click="search">查询</el-button>
        </div>
        <div class="src-wrap">
            <p><span>[{{ wordInfo.phoneticSymbol }}]</span></p>
        </div>
        <div>
            <el-tabs v-model="tgtLang" type="card" class="demo-tabs" @tab-click="handleClick">
                <el-tab-pane v-for="item in languageInfoList" :label="item.label" :name="item.name">
                    <div class="info-wrap" v-for="(sentenceInfo, partOfSpeech) in sentenceInfoMap[item.name]"
                        :key="partOfSpeech">
                        <span class="part-of-speech">{{ partOfSpeech }}</span>
                        <div v-for="sentence in sentenceInfo" :key="sentence.srcMeaning" class="sampleUnit">
                            <p class="sample means">{{ sentence.srcMeaning }}</p>
                            <p class="sample means">{{ sentence.tgtMeaning }}</p>
                            <p class="sample">{{ sentence.srcSentence }}</p>
                            <p class="sample targetInfo">{{ sentence.tgtSentence }}</p>
                        </div>
                    </div>
                </el-tab-pane>
            </el-tabs>
            <div class="word-phonetic"></div>
            <div class="word-mean"></div>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { Search } from '@element-plus/icons-vue'
import { getLexicalInfo } from '@/api/wordManager'
import { getDictInfo2 } from '@/api/dict'
import { recordWord } from '@/api/statWord'

// let languageInfoList = ref([])

// const ff = (async () => {
//     const { result } = await getLanguageInfo()
//     languageInfoList.value = result
//     console.log(languageInfoList)
// })
// ff()

const route = useRoute()

const wordInfo = reactive({})
const sentenceInfoMap = reactive({})

const languageInfoList = getDictInfo2('language')

const tgtLang = ref('')

const search = () => {
    let params = {
        'srcLang': wordInfo.srcLang,
        'name': wordInfo.name,
    }
    searchLexical(params)
}

onMounted(() => {
    if (route.query.id) {
        let params = {
            'id': route.query.id,
        }
        searchLexical(params)
    }
})

const searchLexical = async (params) => {
    const { result } = await getLexicalInfo(params)

    if (result && result.word) {
        Object.assign(wordInfo, result.word)

        if (result.sentenceList && result.sentenceList.length > 0) {
            // sentenceInfoList.push(...result.sentenceList)
            for (const sentence of result.sentenceList) {
                const tgtLang = sentence.tgtLang
                if (!sentenceInfoMap[tgtLang]) {
                    sentenceInfoMap[tgtLang] = {}
                }
                if (!sentenceInfoMap[tgtLang][sentence.partOfSpeech]) {
                    sentenceInfoMap[tgtLang][sentence.partOfSpeech] = []
                }

                sentenceInfoMap[tgtLang][sentence.partOfSpeech].push(sentence)
            }
        }

        const data = {
            'wordId': wordInfo.id,
            'name': wordInfo.name,
            'srcLang': wordInfo.srcLang
        }
        recordWord(data)
    }


}

</script>

<style scoped>
.frame {
    width: 800px;
    margin: auto;
    padding-top: 30px;
}

.search-wrap {
    display: flex;
    justify-content: center;
    height: 60px;
    padding: 20px 0;
}

.search-input {
    width: 675px;
    font-size: 20px;
}

.search-button {
    width: 125px;
    height: 60px;
    font-size: 16px;
    /* background-color: dodgerblue;
    color: #fff;
    border: none; */
}

.src-wrap {
    height: 50px;
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

/* .info-wrap {
    background-image: linear-gradient(276deg, #5384fe, #4badff);
} */
</style>