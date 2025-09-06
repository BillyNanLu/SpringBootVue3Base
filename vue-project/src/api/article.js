/*
// 导入axios实例 通过npm install axios 安装axios
import axios from "axios"

// 定义变量，记录公共的前缀 ，baseURL
const baseURL = 'http://localhost:8080'
const instance = axios.create({ baseURL })
*/

import request from '../util/request'

// 获取文章所有列表
export function articleGetAllService() {
    // 同步等待服务器响应的结果，并返回 async,await
    return request.get('/article/getAll')
}


// 根据文章分类和发布状态搜索
export function articleSearchService(conditions) {
    return request.get('/article/search', {
        params: conditions
    })
}