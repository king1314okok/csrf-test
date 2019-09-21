import Vue from 'vue'
import Router from 'vue-router'
import TableTest from '@/components/TableTest'
import LoginPage from '@/components/Login'

Vue.use(Router)

export default new Router({
  mode : 'history',
  routes: [
    {
      path: '/',
      name: 'tableTest',
      component: TableTest,
      meta: {
        title: '首页',
        requireAuth: true
      }
    },
    {
      path: '/login',
      name: 'login',
      component: LoginPage,
      meta: {
        title: '登录'
      }
    }
  ]
})
