<script setup>
  import { ref, onMounted } from 'vue'
  import {articleGetAllService, articleSearchService} from './api/article'

  // 创建一个ref对象，保存文章列表数据
  const articleList = ref([])
  // 发送异步请求，获取所有文章数据
  // 同步获取articleGetAllService()返回的结果 async await
  const getAllArticle = async () => {
    articleList.value = await articleGetAllService()
  }
  getAllArticle()

  // 定义响应式数据 searchCondition，保存搜索条件
  const searchCondition = ref({
    category: '',
    state: ''
  })
  // 定义搜索方法
  const search = async () => {
    // 发送异步请求，根据搜索条件查询文章数据
    articleList.value = await articleSearchService(searchCondition.value)
  }

</script>

<template>
  <div>

    文章分类: <input type="text" v-model="searchCondition.category">

    发布状态: <input type="text" v-model="searchCondition.state">

    <button v-on:click="search">搜索</button>

    <br />
    <br />
    <table border="1 solid" colspa="0" cellspacing="0">
      <tr>
        <th>文章标题</th>
        <th>分类</th>
        <th>发表时间</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      <tr v-for="articleList in articleList" :key="articleList.id">
        <td>{{articleList.title}}</td>
        <td>{{articleList.category}}</td>
        <td>{{articleList.time}}</td>
        <td>{{articleList.state}}</td>
        <td>
          <button>编辑</button>
          <button>删除</button>
        </td>
      </tr>
    </table>
  </div>

</template>

<style scoped>

</style>