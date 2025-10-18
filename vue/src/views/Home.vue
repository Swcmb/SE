<template>
  <div class="home">
    <h1>Element Plus 常用组件示例</h1>

    <!-- 按钮组件 -->
    <el-button type="primary" @click="handleClick">点击我</el-button>

    <!-- 输入框组件 -->
    <el-input v-model="inputValue" placeholder="请输入内容" />

    <!-- 下拉选择组件 -->
    <el-select v-model="selectValue" placeholder="请选择">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
      />
    </el-select>

    <!-- 复选框组件 -->
    <el-checkbox v-model="checked">复选框</el-checkbox>

    <!-- 单选框组件 -->
    <el-radio v-model="radioValue" label="1">选项1</el-radio>
    <el-radio v-model="radioValue" label="2">选项2</el-radio>

    <!-- 开关组件 -->
    <el-switch v-model="switchValue" active-text="开" inactive-text="关" />

    <!-- 日期选择器组件 -->
    <el-date-picker v-model="dateValue" type="date" placeholder="选择日期" />

    <!-- 表格组件 -->
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="date" label="日期" width="180" />
      <el-table-column prop="name" label="姓名" width="180" />
      <el-table-column prop="address" label="地址" />
    </el-table>

    <!-- 对话框组件 -->
    <el-button type="text" @click="dialogVisible = true">打开对话框</el-button>
    <el-dialog v-model="dialogVisible" title="提示">
      <span>这是一个对话框</span>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// 按钮事件
const handleClick = () => {
  ElMessage.success('按钮点击事件触发');
};

// 输入框数据
const inputValue = ref('');

// 下拉选择数据
const selectValue = ref('');
const options = [
  { value: 'option1', label: '选项1' },
  { value: 'option2', label: '选项2' },
  { value: 'option3', label: '选项3' },
];

// 复选框数据
const checked = ref(false);

// 单选框数据
const radioValue = ref('1');

// 开关数据
const switchValue = ref(true);

// 日期选择器数据
const dateValue = ref('');

// 表格数据
const tableData = [
  { date: '2025-10-18', name: '张三', address: '北京市' },
  { date: '2025-10-19', name: '李四', address: '上海市' },
  { date: '2025-10-20', name: '王五', address: '广州市' },
];

// 对话框数据
const dialogVisible = ref(false);
</script>

<style scoped>
.home {
  padding: 20px;
}
</style>