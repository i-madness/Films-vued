<template>
  <div>
    <img :src="show.pic" />
    <h2 class="title">{{ show.title_rus }}</h2>
    <h3 class="title-en">{{ show.title }}</h3>
    <div class="description">{{ show.description || 'No description' }}</div>
  </div>
</template>

<script>
import VueResource from 'vue-resource'
import ApiService from '../api.service'

const showStub = {
  title: '(no title)',
  title_rus: '(no title)',
  description: '(no description)',
  pic: 'http://wizardvarnish.com/wv/wp-content/uploads/2014/01/mm1u4lDBjR1qz4rgp.jpg'
}

export default {
  name: 'show',
  data () {
    return {
      show: showStub
    }
  },

  created() {
    ApiService.findExactShow(this.$http, this.$route.params.name)
      .then(show => this.show = show)
  }
} 
</script>

<style scoped>
  .title-en {
    color: grey
  }
</style>
