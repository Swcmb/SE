<template>
  <div class="about">
    <h1>关于我们</h1>
    <p>这是关于我们的页面</p>
    
    <!-- 声明式导航示例 -->
    <div class="navigation-demo">
      <h2>声明式导航示例</h2>
      <el-button type="primary">
        <router-link to="/" class="nav-link">回到首页</router-link>
      </el-button>
      <el-button type="success">
        <router-link to="/user" class="nav-link">用户中心</router-link>
      </el-button>
    </div>
    
    <!-- 编程式导航示例 -->
    <div class="programmatic-navigation">
      <h2>编程式导航示例</h2>
      <el-button type="primary" @click="goHome">回到首页</el-button>
      <el-button type="success" @click="goToUser">前往用户中心</el-button>
      <el-button type="warning" @click="goBack">返回上一页</el-button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

// 编程式导航方法
const goHome = () => {
  router.push('/')
}

const goToUser = () => {
  router.push('/user')
}

const goBack = () => {
  router.back()
}
</script>

<style scoped>
.about {
  padding: 20px;
}

.navigation-demo {
  margin: 20px 0;
}

.nav-link {
  color: white;
  text-decoration: none;
}

.programmatic-navigation {
  margin: 20px 0;
}

.el-button {
  margin-right: 10px;
}
</style>