<template>
    <div class="frame">
        <el-form :inline="true" :model="searchParam" class="demo-form-inline">
            <el-form-item label="Name">
                <el-input v-model="searchParam.name" placeholder="Name" clearable />
            </el-form-item>
            <el-form-item label="Source Language">
                <el-select v-model="searchParam.srcLang" placeholder="Select Language" clearable>
                    <el-option v-for="item in languageInfoList" :key="item.name" :label="item.label" :value="item.name">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="Part of Speech">
                <el-select v-model="searchParam.partOfSpeech" placeholder="Select Part of Speech" clearable>
                    <el-option v-for="item in partOfSpeechInfoList" :key="item.name" :label="item.label" :value="item.name">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSearch">Query</el-button>
            </el-form-item>
        </el-form>

        <el-table class="table" :data="tableData" border style="width: 100%">
            <el-table-column prop="name" label="Name" width="180">
                <template #default="scope">
                    <el-button link type="primary" size="small" @click="onView(scope.row)">{{ scope.row.name }}</el-button>
                </template>
            </el-table-column>
            <el-table-column prop="srcLang" label="Source Language" width="180" />
            <el-table-column prop="partOfSpeech" label="Part of Speech" />
            <el-table-column fixed="right" label="Operations" width="120">
                <template #default="scope">
                    <el-button link type="primary" size="small" @click="onEdit(scope.row)">Edit</el-button>
                    <el-button link type="danger" size="small" @click="onDelete(scope.row)">Delete</el-button>
                </template>
            </el-table-column>
        </el-table>

        <div class="demo-pagination-block">
            <el-pagination v-model:current-page="searchParam.current" v-model:page-size="searchParam.size" :small="small"
                :disabled="disabled" :background="background" layout="prev, pager, next, jumper" :total="searchParam.total"
                @size-change="handleSizeChange" @current-change="handleCurrentChange" />
        </div>
    </div>
</template>

<script setup>
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import { getDictInfo2 } from '@/api/dict'
import { selectWordPage, deleteLexicalInfo } from '@/api/wordManager'

const router = useRouter()

const languageInfoList = getDictInfo2('language')
const partOfSpeechInfoList = getDictInfo2('partOfSpeech')

const searchParam = reactive({
    name: '',
    srcLang: '',
    partOfSpeech: '',
    current: 1,
    size: 10,
    total: 0

})

const tableData = reactive([])

const onSearch = async () => {
    const { result } = await selectWordPage(searchParam)

    searchParam.total = result.total

    tableData.splice(0, tableData.length)
    if (result.records && result.records.length > 0) {
        for (const record of result.records) {
            tableData.push(record)
        }
    }
    // tableData.splice(0, -1, ...result.records)
    console.log('a', result)
    console.log('b', tableData)
}

const onDelete = async (item) => {
    const data = []
    data.push(item.id)
    const { result } = await deleteLexicalInfo(searchParam)

    ElMessage({
        message: success ? '删除成功' : result,
        type: success ? 'success' : 'error'
    })
}

const onView = (item) => {
    router.push({ path: '/translate', query: { id: item.id } })
}

const onEdit = (item) => {
    router.push({ path: `/edit/${item.id}` })
}
</script>

<style scoped>
.demo-form-inline .el-input {
    --el-input-width: 220px;
}

.frame {
    width: 800px;
    margin: auto;
    padding-top: 30px;
}

.table {
    margin-top: 50px;
}

.demo-pagination-block {
    margin-top: 20px;
}
</style>