import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Show from '@/components/Show'
import MySeries from '@/components/MySeries'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/show/:name',
      name: 'Show',
      component: Show
    },
    {
      path: '/my-series',
      name: 'myseries',
      component: MySeries
    }
  ]
})
