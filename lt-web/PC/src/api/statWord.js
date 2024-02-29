import { statService } from "@/utils/request"

export function recordWord(data) {
    return statService({
        url: '/word/record',
        method: 'post',
        data
    })
}