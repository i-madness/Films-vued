<template>
  <div>
    {{ $route.params.name }}
  </div>
</template>

<script>
import VueResource from 'vue-resource'
import ApiService from '../api.service'

export default {
  name: 'show',
  data () {
    return {
    }
  }
}
</script>

<style scoped>

</style>
