import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ItemPage from '../components/itempage.vue'
import Record from '../components/record.vue'
import Order from '../components/order.vue'
import MyHome from '../components/myhome.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/item-page',
    name: 'item-page',
    component: ItemPage
  },
  {
    path: '/record',
    name: 'record',
    component: Record
  },
  {
    path: '/order',
    name: 'order',
    component: Order
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
