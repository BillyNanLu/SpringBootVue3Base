<script setup>
  import { ref, onMounted } from 'vue'
  // 声明响应式数据ref，在组合式api中，一般要把数据定义为响应式
  const count = ref(0)

  // 声明函数
  function increment() {
    count.value++
  }

  // 生命周期钩子
  onMounted(() => {
    console.log('组件挂载完成')
  })
</script>

<template>
  <button @click="increment">count: {{ count }}</button>
</template>