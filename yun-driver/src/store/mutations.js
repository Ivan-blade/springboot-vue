const mutations = {
  SET_USERNAME (state, val) {
    state.username = val
    localStorage.setItem('UserName', JSON.stringify(state.username))
  },
  SET_USERID (state, val) {
    state.userid = val
    localStorage.setItem('UserId', JSON.stringify(state.userid))
  },
  SET_USERPHONE (state, val) {
    state.userphone = val
    localStorage.setItem('UserPhone', JSON.stringify(state.userphone))
  }
}
export default mutations
