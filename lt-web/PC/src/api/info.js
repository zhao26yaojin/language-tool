import { lexicalService } from "@/utils/request"

export async function getLevelInfo() {
    const res = await lexicalService({
        url: 'info/level',
        method: 'get'
    })

    return res.result
}