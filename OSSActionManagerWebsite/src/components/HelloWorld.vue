<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>{{ success }}</h2>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      username: 'tom',
      password: '123',
      success: ""
    }
  },
  created() {
    this.getPassword();
  },
  methods: {
    getPassword() {
      this.$http.post("login",{username:this.username,password:this.password}, { emulateJSON: true }).then(result => {
        console.log(result.body)
        if (result.body.status === "200") {
          this.success = "登陆成功";
        }
        console.log(this.success)
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
