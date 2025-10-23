<template>
  <div class="user-settings">
    <h2>用户设置</h2>
    <el-tabs type="border-card">
      <el-tab-pane label="基本设置">
        <el-form label-width="100px">
          <el-form-item label="用户名">
            <el-input placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input placeholder="请输入邮箱"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary">保存</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="安全设置">
        <el-form label-width="100px">
          <el-form-item label="旧密码">
            <el-input type="password" placeholder="请输入旧密码"></el-input>
          </el-form-item>
          <el-form-item label="新密码">
            <el-input type="password" placeholder="请输入新密码"></el-input>
          </el-form-item>
          <el-form-item label="确认密码">
            <el-input type="password" placeholder="请确认新密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary">修改密码</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup>
// 用户设置页面
</script>

<style scoped>
.user-settings {
  padding: 20px;
}
</style>