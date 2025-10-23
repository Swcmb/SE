<template>
  <div class="product">
    <h1>产品详情</h1>
    
    <!-- 动态路由参数展示 -->
    <el-card>
      <h2>产品ID: {{ id }}</h2>
      <div class="product-info">
        <p><strong>产品名称:</strong> 产品{{ id }}</p>
        <p><strong>产品描述:</strong> 这是产品{{ id }}的详细描述信息</p>
        <p><strong>价格:</strong> ¥{{ 99 + Number(id) }}</p>
      </div>
      
      <!-- 参数对比 -->
      <div class="param-comparison">
        <h3>参数传递对比</h3>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-alert title="动态路由参数 (params)" type="info" :closable="false">
              <p>ID: {{ id }}</p>
              <p>特点: 参数作为URL的一部分</p>
              <p>URL格式: /product/1</p>
              <p>刷新后保留: 是</p>
            </el-alert>
          </el-col>
          <el-col :span="12">
            <el-alert title="查询参数 (query)" type="success" :closable="false">
              <p>查询参数: {{ route.query }}</p>
              <p>特点: 参数在?后面以键值对形式出现</p>
              <p>URL格式: /product/1?source=profile</p>
              <p>刷新后保留: 是</p>
            </el-alert>
          </el-col>
        </el-row>
      </div>
      
      <!-- 导航示例 -->
      <div class="navigation-examples">
        <h3>导航示例</h3>
        <el-button @click="goToSameProductWithParams">相同产品不同参数</el-button>
        <el-button @click="goToDifferentProduct">查看其他产品</el-button>
        <el-button @click="goBack">返回</el-button>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'

// 接收动态路由参数
const route = useRoute()
const router = useRouter()

// 从路由参数中获取产品ID
const id = route.params.id

// 导航方法
const goToSameProductWithParams = () => {
  router.push({
    name: 'product',
    params: { id: id },
    query: { 
      tab: 'details',
      timestamp: Date.now()
    }
  })
}

const goToDifferentProduct = () => {
  const newId = Number(id) + 1
  router.push(`/product/${newId}`)
}

const goBack = () => {
  router.back()
}
</script>

<style scoped>
.product {
  padding: 20px;
}

.product-info {
  margin: 20px 0;
}

.param-comparison {
  margin: 30px 0;
}

.navigation-examples {
  margin-top: 20px;
}

.el-button {
  margin-right: 10px;
}
</style>