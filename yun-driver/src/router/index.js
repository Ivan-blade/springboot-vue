import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ItemTeen from '../views/item-teen.vue'
import ItemToday from '../views/item-today.vue'
import Service from '../views/service.vue'
import MyHome from '../views/myhome.vue'
import Order from '../views/order.vue'

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
  },
  {
    path: '/order',
    name: 'order',
    component: Order
  }
]

const router = new VueRouter({
  routes
})

export default router
