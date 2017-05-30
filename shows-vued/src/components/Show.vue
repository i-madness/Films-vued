<template>
  <div class="show-main">
    <b-jumbotron :header="show.title_rus" :lead="show.title" :style="jumbortonStyle">
      <b-btn variant="warning" :href="show.wikilink">Wikipedia</b-btn>
      <b-btn variant="danger" :href="show.wikilink">Something</b-btn>
    </b-jumbotron>
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
  .jumbotron {
    background-color: #000;
    background-size: contain !important;
    background-repeat: no-repeat;
    background-position-x: 50%;
  }

  .jumbotron > h1, p {
    text-shadow: 5px 5px 5px #fff;
    color: #000;
  }

  .show-wrapper {
    padding: 0 20%;
  }

  .show-picture {
    float: left;
    margin: 1em;
    width: 300px;
    height: 400px;
  }

  .title-en {
    color: grey;
  }
</style>
