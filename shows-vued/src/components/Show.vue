<template>
  <div class="show-main">
    <b-jumbotron :header="show.title_rus" :lead="show.title" class="jumb-header">
      <b-btn variant="danger" :href="show.wikilink">Wikipedia</b-btn>
    </b-jumbotron>
    <!--b-jumbotron class="jumb-pic" :style="jumbotronStyle"></b-jumbotron-->
    <div class="row head-img">
      <div class="col-md-1 col-lg-4 blurred" :style="blurStyle"></div>
      <div class="col-md-10 col-lg-4" :style="jumbotronStyle"></div>
      <div class="col-md-1 col-lg-4 blurred" :style="blurStyle"></div>
    </div>
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
      jumbotronStyle: Factory.jumbotronShowStyle(Factory.stubForShow()),
      blurStyle: ''

    }
  },

  created() {
    ApiService.findExactShow(this.$http, this.$route.params.name)
      .then(show => { 
        this.show = show
        if (show.title_rus.length > 20) {
          show.title_rus = Array.from(show.title_rus).splice(0,20).join('')
        }
        this.show["wikilink"] = `http://ru.wikipedia.org/w/index.php?search=${show.title_rus}`
        this.blurStyle = `backgroundImage: url(${show.pic})`
        this.jumbotronStyle = Factory.jumbotronShowStyle(show)
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

  .head-img {
    margin-bottom: 10px;
  }

  .jumb-header > container > .btn {
    text-shadow: none !important;
  }

  .show-wrapper {
    margin: 25px 15%;
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

  .blurred {
    filter: blur(10px);
    z-index: -1;
  }
</style>
