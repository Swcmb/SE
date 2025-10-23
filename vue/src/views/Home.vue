<template>
  <div class="home">
    <h1>Element Plus 常用组件示例</h1>

    <!-- 路由导航示例 -->
    <div class="navigation-section">
      <h2>路由导航示例</h2>
      
      <!-- 声明式导航 -->
      <div class="declarative-navigation">
        <h3>声明式导航</h3>
        <el-button type="primary">
          <router-link to="/about" class="nav-link">关于我们</router-link>
        </el-button>
        <el-button type="success">
          <router-link to="/user" class="nav-link">用户中心</router-link>
        </el-button>
        <el-button type="warning">
          <router-link to="/product/1" class="nav-link">产品1</router-link>
        </el-button>
      </div>
      
      <!-- 编程式导航 -->
      <div class="programmatic-navigation">
        <h3>编程式导航</h3>
        <el-button type="primary" @click="goToAbout">关于我们</el-button>
        <el-button type="success" @click="goToUser">用户中心</el-button>
        <el-button type="warning" @click="goToProduct(2)">产品2</el-button>
        <el-button type="danger" @click="goToLogin">登录页面</el-button>
      </div>
      
      <!-- 参数传递示例 -->
      <div class="param-demo">
        <h3>路由参数传递示例</h3>
        <el-form :inline="true">
          <el-form-item label="产品ID">
            <el-input v-model="productId" placeholder="输入产品ID"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="goToProductById">动态参数跳转</el-button>
          </el-form-item>
        </el-form>
        
        <el-form :inline="true">
          <el-form-item label="搜索关键词">
            <el-input v-model="searchKeyword" placeholder="输入搜索词"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="goToProductWithQuery">查询参数跳转</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <!-- 原有组件示例 -->
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
    <el-button type="primary" text @click="dialogVisible = true">打开对话框</el-button>
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
import { useRouter } from 'vue-router';

const router = useRouter();

// 路由参数相关数据
const productId = ref('3');
const searchKeyword = ref('手机');

// 路由导航方法
const goToAbout = () => {
  router.push('/about');
};

const goToUser = () => {
  router.push('/user');
};

const goToProduct = (id) => {
  router.push(`/product/${id}`);
};

const goToLogin = () => {
  router.push('/login');
};

const goToProductById = () => {
  router.push(`/product/${productId.value}`);
};

const goToProductWithQuery = () => {
  router.push({
    path: `/product/${productId.value}`,
    query: { 
      search: searchKeyword.value,
      category: 'electronics'
    }
  });
};

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

.navigation-section {
  margin-bottom: 30px;
  padding: 20px;
  border: 1px solid #eee;
  border-radius: 4px;
}

.declarative-navigation, .programmatic-navigation, .param-demo {
  margin-bottom: 20px;
}

.nav-link {
  color: white;
  text-decoration: none;
}

.el-button {
  margin-right: 10px;
  margin-bottom: 10px;
}
</style>