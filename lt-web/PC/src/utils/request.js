import axios from 'axios'

const lexicalService = axios.create({
    baseURL: import.meta.env.VITE_LEXICAL_BASE
})

const statService = axios.create({
    baseURL: import.meta.env.VITE_STAT_BASE
})


// 请求前处理
const requestSuccess = config => {
    return config
}

const requestError = error => {
    return error
}

lexicalService.interceptors.request.use(requestSuccess, requestError)
statService.interceptors.request.use(requestSuccess, requestError)

// 响应成功
const responseSuccess = response => {
    return response.data
}

// 响应错误
const responseError = error => {
    return Promise.reject(error)
}

lexicalService.interceptors.response.use(responseSuccess, responseError)
statService.interceptors.response.use(responseSuccess, responseError)

export { lexicalService, statService }