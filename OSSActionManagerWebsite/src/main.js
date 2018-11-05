// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 2.1 导入 vue-resource
import VueResource from 'vue-resource'
// 2.2 安装 vue-resource
Vue.use(VueResource)
// 设置请求的根路径
Vue.http.options.root = 'http://localhost:8080';
// 全局设置 post 时候表单数据格式组织形式   application/x-www-form-urlencoded
Vue.http.options.emulateJSON = true;

Vue.http.interceptors.push(function (request, next) {
  let token = "Bearer " + localStorage.getItem("jwtToken");
  if (token) {
    request.headers.set('Authorization', token);
  }

  next(response => {
    if (response.body.status === "300") {
      alert("权限不足");
      this.$router.push({path: '/home'});
    } else if (response.body.status === "000") {
      alert("请先登录后在进行操作");
      this.$router.push({path: '/login'});
    }
    return response;
  })
});


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
