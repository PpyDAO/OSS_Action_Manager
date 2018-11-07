<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>username: <input type="text" v-model="username"></div>
    <div>password: <input type="text" v-model="password"></div>
    <div>remember: <input type="checkbox" ref="ref4Checkbox"></div>
    <div @click="click">login</div>
  </div>
</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        msg: 'Welcome to login',
        username: "",
        password: ""
      }
    },
    created() {
    },
    methods: {
      click() {
        let self = this;
        let json = {username: this.username, password: this.password};
        if (this.$refs.ref4Checkbox.checked) {
          json["remember-me"] = "on";
        }
        let qs = require('qs');
        this.$http.post("login", qs.stringify(json)).then(function (response) {
          console.log(response)
          if (response.data.status === "200") {
            console.log(response.data.jwtToken)
            localStorage.setItem("jwtToken", response.data.jwtToken);
            localStorage.setItem("ossUsername", response.data.result);
            self.$parent.setUsername(response.data.result);
            self.$router.push({path: '/home'});
          } else {
            alert("用户名或密码错误");
          }
        });
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1 h2 {
    font-weight: normal;
  }
</style>
