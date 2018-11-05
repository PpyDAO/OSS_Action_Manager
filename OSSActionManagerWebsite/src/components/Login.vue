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
        this.$http.post("login", json, {emulateJSON: true}).then(response => {
          if (response.body.status === "200") {
            localStorage.setItem("jwtToken", response.body.jwtToken);
            localStorage.setItem("ossUsername", response.body.result);
            self.$parent.setUsername(response.body.result);
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
