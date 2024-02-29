import { lexicalService } from '@/utils/request'
import { ref } from 'vue'

export function getDictInfo2(type) {
    const dictInfoList = ref([])

    const params = {
        type: type
    }

    lexicalService({
        url: 'dict/list',
        method: 'get',
        params
    }).then(res => {
        dictInfoList.value = res.result || []
    })

    return dictInfoList
}

export function getDictInfo(type) {
    const params = {
        type: type
    }

    return lexicalService({
        url: 'dict/list',
        method: 'get',
        params
    })
}

// export async function getLanguageInfo() {
//     const languageInfoList = ref([])

//     const res = await service({
//         url: 'info/language',
//         method: 'get'
//     })

//     console.log(res)

//     languageInfoList.value = res.result || []

//     return languageInfoList
// }