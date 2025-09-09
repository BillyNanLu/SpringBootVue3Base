//定制请求的实例

//导入axios  npm install axios
import axios from 'axios';
// 导入element-plus
import { ElMessage } from 'element-plus'

//定义一个变量,记录公共的前缀  ,  baseURL
const baseURL = '/api';
const instance = axios.create({baseURL})

import { useTokenStore } from '@/stores/token'
// 添加请求拦截器
instance.interceptors.request.use (
    (config) => {
        // 在请求发送之前做些什么
        // 添加token
        const tokenStore = useTokenStore()
        // 判断有没有token
        if (tokenStore.token)
            config.headers.Authorization = tokenStore.token
        return config
    },
    (error) => {
        // 对请求错误做些什么
        Promise.reject(error)
    }
)

/* import { useRouter } from 'vue-router'
const router = useRouter() */
import router from '@/router'

//添加响应拦截器
instance.interceptors.response.use(
    result=>{
        // 判断业务状态码
        if (result.data.code === 0)
            return result.data;

        // 操作失败
        // alert(result.data.msg ? result.data.msg: '服务异常');
        ElMessage.error(result.data.msg ? result.data.msg: '服务异常');
        // 异步操作的状态转化为失败
        return Promise.reject(result.data.msg);
    },
    err=>{
        // 判断响应码，如果是401，则证明未登录，并跳转到登录页
        if (err.response.status === 401) {
            ElMessage.error('未登录，请先登录');
            router.push('/login')
        } else {
            ElMessage.error('服务异常');
        }
        return Promise.reject(err);//异步的状态转化成失败的状态
    }
)

export default instance;