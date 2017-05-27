import Vue from 'vue'
import VueResource from 'vue-resource'
import BootstrapVue from 'bootstrap-vue';
import App from './App'
import router from './router'

Vue.use(VueResource)
Vue.use(BootstrapVue);
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
