<template>
  <div class="home">
    <div class="content">
        <div class="input-class">
          <input type="text" v-model="username" />
          <input type="password" v-model="password" />
        </div>
        <div class="button-class">
          <button @click="Login">登录</button>
          <button @click="Regist">注册</button>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'home',
  components: {
  },
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
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
      console.log(data)
    }
  }
}
</script>

<style lang="less" scoped>
.home{
  .content{
    .input-class{
      input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 3px;
        padding: 13px 14px;
        width: 300px;
        font-size: 14px;
        font-weight: 700;
        font-family: "Microsoft soft";
      }
      input:focus{
          border-color: #66afe9;
          outline: 0;
          -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
          box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
      }
    }
    .button-class{}
  }
}
</style>
