<template>
  <div class="user-profile">
    <h2>用户资料</h2>
    <el-card>
      <div class="profile-info">
        <el-avatar :size="100" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" />
        <div class="info-details">
          <p><strong>用户名:</strong> 张三</p>
          <p><strong>邮箱:</strong> zhangsan@example.com</p>
          <p><strong>注册时间:</strong> 2025-01-01</p>
        </div>
      </div>
      
      <!-- 参数传递示例 -->
      <div class="param-demo">
        <h3>路由参数示例</h3>
        <p>动态路由参数 (params): {{ route.params }}</p>
        <p>查询参数 (query): {{ route.query }}</p>
        
        <!-- 动态参数导航 -->
        <el-button @click="goToProduct(1)">查看产品1</el-button>
        <el-button @click="goToProductWithQuery">带查询参数的产品1</el-button>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

// 查看产品详情（动态路由参数）
const goToProduct = (id) => {
  router.push(`/product/${id}`)
}

// 带查询参数的产品详情
const goToProductWithQuery = () => {
  router.push({
    path: '/product/1',
    query: { 
      source: 'user-profile',
      timestamp: Date.now()
    }
  })
}
</script>

<style scoped>
.user-profile {
  padding: 20px;
}

.profile-info {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.info-details {
  margin-left: 20px;
}

.param-demo {
  margin-top: 20px;
  padding: 15px;
  border: 1px solid #eee;
  border-radius: 4px;
}
</style>