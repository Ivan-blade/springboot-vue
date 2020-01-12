const state = {
  username: JSON.parse(localStorage.getItem('UserName')) || '',
  userid: JSON.parse(localStorage.getItem('UserId')) || ''
}
export default state
