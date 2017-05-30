<template>
  <div class="main-content-wrapper">
    <div class="page-header">
      <h1>Введите название сериала</h1>
    </div>
    <div class="input-wrapper">
      <input id="inp" v-model="searchString" @keyup="onSearchChg"/>
    </div>
    <div class="results">
      <router-link :to="res.route" tag="div" class="result" v-for="(res,index) in searchResults" 
          :class="(index === searchResults.length - 1) ? 'res-last' : ''" :key="index">           
          <img :src="res.smPic" style="float: left">
          {{ res.title_rus }}     
      </router-link>
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
      searchString: '',
      searchResults: []
    }
  },

  methods: {     
    onSearchChg(event) {
      let {value} = event.target
      try {
        debouncedFindShow(this.$http, value)
          .then(filteredData => {
            this.searchResults = filteredData
            this.searchResults.forEach(result => result['route'] = '/show/' + result.title)
          })
      } catch (error) {
        // что-то может пойти не так в момент первых нажатий клавиш по непонятной причине
        console.log("Проигнорирована ошибка", error.name)
      }
    }
  }
}
</script>

<style scoped>
  .main-content-wrapper {
    padding: 10px 50px;
  }

  .input-wrapper {
    width: 100%;
    text-align: center;
  }

  .results {
    width: 100%;
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
    cursor: pointer; 
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
