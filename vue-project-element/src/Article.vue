<script lang="ts" setup>
import { ref, reactive } from 'vue'
import {Delete, Edit} from "@element-plus/icons-vue";
import type { ComponentSize } from 'element-plus'

const currentPage4 = ref(2)
const pageSize4 = ref(5)
const size = ref<ComponentSize>('default')
const background = ref(false)
const disabled = ref(false)
const total = ref(20)

const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
}

const formInline = reactive({
  user: '',
  region: '',
  date: '',
})

const onSubmit = () => {
  console.log('submit!')
}

const tableData = [
    {
      title: '标题1',
      category: '时事',
      time: '2000-01-01',
      state: '已发布'
    },
    {
      title: '标题1',
      category: '时事',
      time: '2000-01-01',
      state: '已发布'
    },
    {
      title: '标题1',
      category: '时事',
      time: '2000-01-01',
      state: '已发布'
    },
    {
      title: '标题1',
      category: '时事',
      time: '2000-01-01',
      state: '已发布'
    },
    {
      title: '标题1',
      category: '时事',
      time: '2000-01-01',
      state: '已发布'
    },
  ]
</script>

<template>
  <el-card class="box-card">
    <div class="card-header">
      <span>文章管理</span>
      <el-button type="primary">发布文章</el-button>
    </div>

    <div style="margin-top: 20px">
      <hr>
    </div>

    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="文章分类：">
        <el-select
            v-model="formInline.region"
            placeholder="请选择"
            clearable
        >
          <el-option label="时事" value="时事" />
          <el-option label="篮球" value="篮球" />
        </el-select>
      </el-form-item>

      <el-form-item label="发布状态：">
        <el-select
            v-model="formInline.region"
            placeholder="请选择"
            clearable
        >
          <el-option label="草稿" value="草稿" />
          <el-option label="已发布" value="已发布" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">搜索</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="default" @click="onSubmit">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="title" label="文章标题" />
      <el-table-column prop="category" label="分类" />
      <el-table-column prop="time" label="发表时间" />
      <el-table-column prop="state" label="状态" width="180" />
      <el-table-column prop="option" label="操作" width="180">
        <div class="button-row">
          <el-button type="primary" :icon="Edit" circle />
          <el-button type="danger" :icon="Delete" circle />
        </div>
      </el-table-column>
    </el-table>

    <el-pagination
        class="el-p"
        v-model:current-page="currentPage4"
        v-model:page-size="pageSize4"
        :page-sizes="[5, 10, 15, 20]"
        :size="size"
        :disabled="disabled"
        :background="background"
        layout="jumper, total, sizes, prev, pager, next"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </el-card>

</template>

<style scoped>
  .card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .demo-form-inline .el-input {
    --el-input-width: 220px;
  }

  .demo-form-inline .el-select {
    --el-select-width: 220px;
  }

  .el-p {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
  }
</style>