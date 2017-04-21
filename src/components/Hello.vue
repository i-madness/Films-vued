<template>
  <div class="helloween">
    <h1>{{ msg }}</h1>
    <input v-model="wussh"/>
    <ul>
      <li v-for="w in wussh">{{ w.title }}</li>
    </ul>
    <ul>
      <li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li>
      <li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li>
      <li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li>
    </ul>
  </div>
</template>

<script>
import VueResource from 'vue-resource'

export default {
  name: 'hello',
  data () {
    return {
      wussh: [],
      msg: 'Meeeh?'
    }
  },

  created() {
    this.$http.get('http://jsonplaceholder.typicode.com/posts')
      .then(response => { 
         this.wussh = response.data
         console.log(response.data)
         window.res = response.data
      })
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
