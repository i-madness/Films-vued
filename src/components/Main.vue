<template>
  <div>
    <h1>Введите название сериала</h1> <!-- на будущее -->
    <input/> <!--  v-model="wussh[0].title" -->
    <ul>
      <li v-for="w in wussh">{{ w.title }} | {{ w.seasons.length }}</li>
    </ul>
  </div>
</template>

<script>
import VueResource from 'vue-resource'
import ApiService from '../api.service'

export default {
  name: 'main',
  data () {
    return {
      wussh: [],
      msg: 'Meeeh?'
    }
  },

  created() {
      ApiService.fetchShowList(this.$http, 1)
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
