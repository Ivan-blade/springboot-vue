<template>
  <div class="page" v-show="!isRegist">
    <div class="content">
        <ul class="input-class">
          <li>
            <input type="text" v-model="username" placeholder="用户名" />
          </li>
          <li>
            <input type="password" v-model="password" placeholder="密码" />
          </li>
        </ul>
        <ul class="result">
          <li>
            <p>{{res}}</p>
          </li>
        </ul>
        <ul class="button-class">
          <li>
            <button @click="Login">登录</button>
          </li>
          <li>
            <button @click="Regist">注册</button>
          </li>
        </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { mapMutations } from 'vuex'
export default {
  name: 'home',
  components: {
  },
  data () {
    return {
      username: '',
      password: '',
      isRegist: false,
      res: null
    }
  },
  methods: {
    ...mapMutations([
      'SET_USERNAME',
      'SET_USERID'
    ]),
    async Regist () {
      const { data } = await axios({
        method: 'post',
        url: '/api/user/regist',
        params: {
          username: this.username,
          password: this.password
        }
      })
      console.log(data)
    },
    async Login () {
      const { data } = await axios({
        method: 'post',
        url: '/api/user/login',
        params: {
          username: this.username,
          password: this.password
        }
      })
      if (!data.success) {
        this.res = '用户名或密码错误，请重新输入'
      } else if (data.success) {
        this.isRegist = true
        this.SET_USERNAME(this.username)
        this.SET_USERID(data.detail.id)
        this.$router.push({
          name: 'myhome'
        })
      }
    }
  }
}
</script>

<style lang="less" scoped>
.page{
  z-index: 999;
  .content{
    width: 100%;
    position: fixed;
    top: 300px;
    left: 0;
    right: 0;
    height: 100px;
    .input-class{
      display: flex;
      flex-direction: column;
      text-align: center;
      position: relative;
      li{
        margin: 20px 0;
      }
      input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 3px;
        padding: 13px 14px;
        width: 400px;
        height: 50px;
        font-size: 20px;
        font-weight: 700;
        font-family: "Microsoft soft";
      }
      input:focus{
          border-color: #e78e1a;
          outline: 0;
          -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(255,97,0,.6);
          box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(255,97,0,.6)
      }
    }
    .button-class{
      position: absolute;
      top: 280px;
      left: 55px;
      text-align: center;
      display: flex;
      flex-direction: row;
      justify-content: center;
      li{
        margin: 0px 104px;
      }
      button{
        background-color: #ff4500; /* Green */
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 24px;
      }
    }
    .result{
      // margin-top: 20px;
      display: flex;
      flex-direction: row;
      justify-content: center;
      p{
        font-family: "Microsoft soft";
        font-size: 24px;
        color: #ccc;
      }
    }
  }
}
</style>
