<template>
  <div class="show-main">
    <b-jumbotron :header="show.title_rus" :lead="show.title" class="jumb-header">
      <b-btn variant="danger" :href="show.wikilink">Wikipedia</b-btn>
    </b-jumbotron>
    <b-jumbotron class="jumb-pic" :style="jumbortonStyle"></b-jumbotron>
    <div class="show-wrapper">
      
    </div>
  </div>
</template>

<script>
import VueResource from 'vue-resource'
import ApiService from '../api.service'
import Factory from '../utils/dynamic-asset-factory'

export default {
  name: 'show',
  data () {
    return {
      show: Factory.stubForShow(),
      jumbortonStyle: Factory.jumbotronShowStyle(Factory.stubForShow())
    }
  },

  created() {
    ApiService.findExactShow(this.$http, this.$route.params.name)
      .then(show => { 
        this.show = show
        this.show["wikilink"] = `http://ru.wikipedia.org/w/index.php?search=${show.title_rus}`
        this.jumbortonStyle = Factory.jumbotronShowStyle(show)
      })
  }
} 
</script>

<style scoped>
  .main-container {
    padding: 10px 0;
  }

  .jumb-pic {
    background-color: #000;
    background-size: contain !important;
    background-repeat: no-repeat;
    background-position-x: 50%;
  }

  .jumb-header {
    background: linear-gradient(to right, rgba(3,83,149,1) 0%, rgba(3,83,149,1) 5%, rgba(65,184,131,1) 100%);
    border-radius: 0;
    margin-bottom: 0;
    padding: 0 20px;
    height: 200px;
    color: #fff;
    text-shadow: 3px 2px 2px #3a3946
  }

  .jumb-header > container > .btn {
    text-shadow: none !important;
  }

  .show-wrapper {
    margin: 5px 15%;
    padding: 10px;
    border-radius: 10px;
    background-color: #fff;
  }

  .show-picture {
    float: left;
    margin: 1em;
    width: 300px;
    height: 400px;
  }
</style>
