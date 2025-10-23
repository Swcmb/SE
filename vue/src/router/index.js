import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

// 静态路由
const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    meta: { title: '首页' }
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/About.vue'),
    meta: { title: '关于我们' }
  },
  {
    path: '/user',
    name: 'user',
    component: () => import('../views/User.vue'),
    meta: { title: '用户中心' },
    children: [
      {
        path: 'profile',
        name: 'userProfile',
        component: () => import('../views/UserProfile.vue'),
        meta: { title: '用户资料' }
      },
      {
        path: 'settings',
        name: 'userSettings',
        component: () => import('../views/UserSettings.vue'),
        meta: { title: '用户设置' }
      }
    ]
  },
  // 动态路由参数示例
  {
    path: '/product/:id',
    name: 'product',
    component: () => import('../views/Product.vue'),
    meta: { title: '产品详情' },
    props: true,
    // 路由独享守卫
    beforeEnter: (to, from, next) => {
      // 模拟产品存在性检查
      const productId = to.params.id
      if (productId > 0 && productId < 1000) {
        next()
      } else {
        next('/not-found')
      }
    }
  },
  // 登录页面
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue'),
    meta: { title: '用户登录' }
  },
  // 404页面
  {
    path: '/:pathMatch(.*)*',
    name: 'notFound',
    component: () => import('../views/NotFound.vue'),
    meta: { title: '页面未找到' }
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

// 全局前置守卫
router.beforeEach((to, from, next) => {
  // 设置页面标题
  document.title = to.meta.title || 'Vue Router Demo'
  
  // 模拟权限验证
  const isAuthenticated = !!localStorage.getItem('token')
  
  // 需要登录的页面
  if (to.meta.requiresAuth && !isAuthenticated) {
    next('/login')
  } else {
    next()
  }
})

// 全局后置守卫
router.afterEach((to, from) => {
  // 记录页面访问日志
  console.log(`从 ${from.path} 导航到 ${to.path}`)
})

export default router