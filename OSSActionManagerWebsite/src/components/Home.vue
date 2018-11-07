<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>{{ username }}------{{ password }}</h2>
    <div @click="getPassword">getPassword</div>
  </div>
</template>

<script>
  export default {
    name: 'Home',
    data() {
      return {
        msg: 'Welcome home',
        username: "张5",
        password: ""
      }
    },
    methods: {
      getPassword() {
        this.$http({
          method: "post",
          url: "user/findByUsername",
          headers:{"Content-Type":"application/json"},
          data: {username: this.username}
        }).then(response => {
          console.log(response)
          this.password = response.data[0].password;
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
