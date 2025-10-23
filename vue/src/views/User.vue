<template>
  <div class="user">
    <h1>用户中心</h1>
    
    <!-- 嵌套路由导航 -->
    <div class="sub-nav">
      <el-button type="primary">
        <router-link to="/user/profile" class="nav-link">用户资料</router-link>
      </el-button>
      <el-button type="success">
        <router-link to="/user/settings" class="nav-link">用户设置</router-link>
      </el-button>
    </div>
    
    <!-- 嵌套路由视图 -->
    <div class="sub-content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script setup>
// 用户中心页面，包含嵌套路由
</script>

<style scoped>
.user {
  padding: 20px;
}

.sub-nav {
  margin-bottom: 20px;
}

.nav-link {
  color: white;
  text-decoration: none;
}
</style>