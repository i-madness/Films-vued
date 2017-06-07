<template>
  <div class="main-content-wrapper">
    <b-jumbotron class="main-head">
      <b-form-input id="inp" placeholder="Введите название сериала"
                    v-model="searchString" @keyup="onSearchChg"/>
    </b-jumbotron>

    <b-list-group v-if="searchResults.length">
      <b-list-group-item v-for="(res,index) in searchResults" 
                         :to="res.route" :key="index" class="search-result">
          <img :src="res.smPic" class="search-result-icon">
          <h4 class="series-title">{{ res.title_rus }}</h4>
      </b-list-group-item>
    </b-list-group>

    <b-carousel v-else controls :interval="10000" indicators background="#262b39" height="400px">
      <!-- Баг BootstrapVue не позволяет делать здесь v-for в коллекции, поэтому требуются шаманства -->
      <b-carousel-slide v-for="i in 4" 
                        :caption="recommendedShows[i] ? recommendedShows[i].title_rus : ''" 
                        :text="recommendedShows[i] ? recommendedShows[i].title : ''" 
                        :img="recommendedShows[i] ? recommendedShows[i].pic : ''"
                        :key="i"
                        @click="() => $router.push(recommendedShows[i].route)">
      </b-carousel-slide>
    </b-carousel>

  </div>
</template>

<script>
import VueResource from 'vue-resource'
import ApiService from '../api.service'
import debounce from 'lodash/debounce'

const debouncedFindShow = debounce(ApiService.findShow, 300)

export default {
  name: 'main',
  data () {
    return {
      searchString: '',
      searchResults: [],
      recommendedShows: []
    }
  },

  created () {
    ApiService.fetchRecommendedShows(this.$http)
      .then(shows => { 
        this.recommendedShows = shows.data
        this.recommendedShows.forEach(show => show['route'] = '/show/' + show.title)
      })
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
  .main-head {
    background: linear-gradient(to right, rgba(3,83,149,1) 0%, rgba(3,83,149,1) 5%, rgba(65,184,131,1) 100%);
    border-radius: 0;
    margin-bottom: 0;
  }

  .search-result:first-child {
    border-radius: 0;
  }

  .search-result:hover {
    color: #273361;
    background-color: #79d59e;
  }

  .search-result-icon {
    float: left;
    border: 1px solid #000;
  }

  #inp {
    padding: 15pt;
    font-size: 30pt;
    width: 100%
  }

  .res-last {
    border-radius: 0 0 6px 6px;
  }

  .series-title {
    margin-left: 15px;
  }

  .carousel-item {
    padding-top: 30px;
  }
</style>
