// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false
Vue.use(ElementUI)

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  const requireAuth = to.meta.requireAuth
  // 判断该路由是否需要登录权限
  if (requireAuth) {
    if (window.sessionStorage.getItem('loginStatus')) {
      next()
    } else {
      next('/login')
    }
  } else {
    next()  // 确保一定要有next()被调用
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
