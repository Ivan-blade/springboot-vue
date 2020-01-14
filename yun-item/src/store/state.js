const state = {
  username: JSON.parse(localStorage.getItem('UserName')) || '',
  userid: JSON.parse(localStorage.getItem('UserId')) || '',
  userphone: JSON.parse(localStorage.getItem('UserPhone')) || ''
}
export default state
