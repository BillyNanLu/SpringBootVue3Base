// 定制请求的实例

// 导入axios实例 通过npm install axios 安装axios
import axios from "axios"

// 定义变量，记录公共的前缀 ，baseURL
const baseURL = 'http://localhost:8080'
const instance = axios.create({ baseURL })

// 添加响应拦截器
instance.interceptors.response.use(
    result=> {
        return result.data
    },
    err=> {
        alert('响应异常')
        return Promise.reject(err)      // 异步的状态转化为失败的状态
    }
)

export default instance