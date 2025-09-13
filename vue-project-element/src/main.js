// import './assets/main.css'
import 'element-plus/dist/index.css'

import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import App from './App.vue'
import locale from 'element-plus/dist/locale/zh-cn'

createApp(App).use(ElementPlus, {locale}).mount('#app')
