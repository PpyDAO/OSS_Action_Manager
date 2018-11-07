// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'
// // 2.1 导入 vue-resource
// import VueResource from 'vue-resource'
// // 2.2 安装 vue-resource
// Vue.use(VueResource)
// // 设置请求的根路径
// Vue.http.options.root = 'http://localhost:8080';
// // 全局设置 post 时候表单数据格式组织形式   application/x-www-form-urlencoded
// Vue.http.options.emulateJSON = true;
//
// Vue.http.interceptors.push(function (request, next) {
//   if (request.url.indexOf("login") === -1) {
//     let token = "Bearer " + localStorage.getItem("jwtToken");
//     if (token) {
//       request.headers.set('Authorization', token);
//     }
//   }
//
//   next(response => {
//     if (response.body.status === "300") {
//       alert("权限不足");
//       this.$router.push({path: '/home'});
//     } else if (response.body.status === "000") {
//       alert("请先登录后在进行操作");
//       this.$router.push({path: '/login'});
//     }
//     return response;
//   })
// });

Vue.use(VueAxios, axios);
Vue.use(qs);

axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

//添加响应拦截器
let count = 0;
axios.interceptors.request.use(function (config) {
  config.headers.Authorization = "Bearer " + localStorage.getItem("jwtToken");
  config.headers["X-Requested-With"] = "XMLHttpRequest";
  console.log(count);
  count++;
  return config;
}, function (error) {
  //请求错误时做些事
  return Promise.reject(error);
});

let self = this;

axios.interceptors.response.use(function (response) {
  if (response.data.status === "300") {
    alert("权限不足");
    return;
  } else if (response.data.status === "000") {
    alert("请先登录后在进行操作");
    router.push({path: '/login'});
    return;
  }
  return response;
}, function (error) {
  //请求错误时做些事
  return Promise.reject(error);
});


Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
