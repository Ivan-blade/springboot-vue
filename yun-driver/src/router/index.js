import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ItemTeen from '../components/item-teen.vue'
import ItemToday from '../components/item-today.vue'
import Service from '../components/service.vue'
import MyHome from '../components/myhome.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/item-teen',
    name: 'item-teen',
    component: ItemTeen
  },
  {
    path: '/item-today',
    name: 'item-today',
    component: ItemToday
  },
  {
    path: '/service',
    name: 'service',
    component: Service
  },
  {
    path: '/myhome',
    name: 'myhome',
    component: MyHome
  }
]

const router = new VueRouter({
  routes
})

export default router
