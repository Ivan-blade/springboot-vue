import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import mutations from './mutations'
import actions from './actions'
import state from './state'

Vue.use(Vuex)

const store = new Vuex.Store({
  actions,
  getters,
  mutations,
  state
})

export default store
