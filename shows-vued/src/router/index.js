import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Show from '@/components/Show'
import Another from '@/components/Another'

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
      path: '/other',
      name: 'Another',
      component: Another
    }
  ]
})
