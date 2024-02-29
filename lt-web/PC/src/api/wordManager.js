import { lexicalService } from "@/utils/request"

export function getLexicalInfo(params) {
    return lexicalService({
        url: '/word/info',
        method: 'get',
        params
    })
}

export function saveLexicalInfo(data) {
    return lexicalService({
        url: '/word/save',
        method: 'post',
        data
    })
}

export function selectWordPage(params) {
    return lexicalService({
        url: '/word/page',
        method: 'get',
        params
    })
}

export function deleteLexicalInfo(data) {
    return lexicalService({
        url: '/word/delete',
        method: 'post',
        data
    })
}
