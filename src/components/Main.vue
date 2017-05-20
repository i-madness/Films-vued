<template>
  <div>
    <h1>Введите название сериала</h1>
      <div class="input-wrapper">
        <input id="inp" v-model="searchString" @keyup="onSearchChg"/>
      </div>
      <div class="results">
        <div class="result" v-for="res in searchResults">
          <img :src="res.pic" style="float: left">
          {{ res.title_rus }}
        </div>

      </div>
  </div>
</template>

<script>
import VueResource from 'vue-resource'
import ApiService from '../api.service'
import { debounce } from 'lodash'

const debouncedFindShow = debounce(ApiService.findShow, 300)

export default {
  name: 'main',
  data () {
    return {
      msg: 'Meeeh?',
      searchString: '',
      searchResults: []
    }
  },

  methods: {     
    onSearchChg(event) {
      let {value} = event.target
      debouncedFindShow(this.$http, value)
        .then(filteredData => this.searchResults = filteredData)
    },
    
  }
}
</script>

<style scoped>
.input-wrapper {
  width: 100%;
  text-align: center;
}
.results {
}
.result {
  color: #3a3946;
  width: 100%;
  padding: 20px;
  border: 1px solid rgba(0, 0, 0, 0.15);
  border-top: none;
  background-color: #e8e8e8;
  font-size: 15pt;
  vertical-align: middle;
}
.result:hover {
  color: #fff;
  text-shadow: 2px 2px 2px #3a3946;
  background-color: #94d09e;
  
}
#inp {
  border: 1px solid rgba(0, 0, 0, 0.15);
  border-radius: 6px 6px 0 0;
  padding: 15pt;
  font-size: 30pt;
  width: 100%
}
.res-last {
  border-radius: 0 0 6px 6px;
}
</style>
