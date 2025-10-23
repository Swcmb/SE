<template>
  <div id="app">
    <!-- 顶部导航栏 -->
    <el-menu mode="horizontal" :default-active="activeIndex" @select="handleSelect" router>
      <el-menu-item index="/">首页</el-menu-item>
      <el-menu-item index="/about">关于我们</el-menu-item>
      <el-menu-item index="/user">用户中心</el-menu-item>
      <el-menu-item index="/product/1">产品示例</el-menu-item>
      <el-menu-item index="/login">登录</el-menu-item>
    </el-menu>
    
    <!-- 路由视图 -->
    <div class="main-content">
      <RouterView />
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const activeIndex = ref(route.path)

// 监听路由变化，更新激活的菜单项
watch(
  () => route.path,
  (newPath) => {
    activeIndex.value = newPath
  }
)

const handleSelect = (key) => {
  console.log('选中菜单项:', key)
}
</script>

<style scoped>
#app {
  min-height: 100vh;
}

.main-content {
  padding: 20px;
  min-height: calc(100vh - 60px);
}
</style>