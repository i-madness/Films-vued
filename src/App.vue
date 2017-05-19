<template>
  <div id="app">
    <nav>
      <router-link to="/">Main</router-link>
      <router-link to="/other">othr</router-link>
    </nav>
    <div class="main-container">
      <router-view></router-view>
    </div>    
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body, html {
  height: 100vh;
  margin: 0;
}

.main-container {

}

</style>
