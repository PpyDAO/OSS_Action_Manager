<template>
  <div id="app">
    <div class="header">
      <div class="userArea">
        <div class="loginArea" v-show="!isLogin">
          <router-link to="/login">login</router-link>
        </div>
        <div class="userHome" v-show="isLogin">
          <router-link to="/login" v-on:click.native="logout">logout</router-link>
          <router-link to="/home">{{username}}</router-link>
        </div>
      </div>
    </div>

    <img src="./assets/logo.png">
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'App',
    data: function () {
      return {
        username: ""
      }
    },
    computed: {
      isLogin() {
        return !(this.username == "" || this.username == undefined);
      }
    },
    methods: {
      logout() {
        this.$http.get("logout").then(response => {
          if (response.body.status === "100") {
            localStorage.clear();
            this.username = null;
          }
        });
      },
      setUsername(username) {
        this.username = username;
      }
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
