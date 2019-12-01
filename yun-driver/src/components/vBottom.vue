<template>
  <ul class="bot">
    <li class="ml">
      <div><i class="iconfont icon-fahuo" @click="goToItem"></i></div>
      <p>配货大厅</p>
    </li>
    <li>
      <div><i class="iconfont icon-tonghuajilu" @click="goToRecord"></i></div>
      <p>当天货源</p>
    </li>
    <li>
      <div><i class="iconfont icon-dingdan" @click="goToService"></i></div>
      <p>服务</p>
    </li>
    <li>
      <div><i class="iconfont icon-dingdan" @click="goToOrder"></i></div>
      <p>订单</p>
    </li>
    <li class="mr">
      <div><i class="iconfont icon-wode1" @click="goToHome"></i></div>
      <p>我的</p>
    </li>
  </ul>
</template>

<script>
export default {
  name: 'vBottom',
  methods: {
    goToItem () {
      this.$router.push({
        name: 'item-teen'
      })
    },
    goToRecord () {
      this.$router.push({
        name: 'item-today'
      })
    },
    goToOrder () {
      this.$router.push({
        name: 'order'
      })
    },
    goToService () {
      this.$router.push({
        name: 'service'
      })
    },
    goToHome () {
      this.$router.push({
        name: 'myhome'
      })
    }
  }
}
</script>

<style lang="less" scoped>
.bot{
    width: 100%;
    position: fixed;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    color: #cdc5bf;
    padding: 15px 0;
    background-color: white;
    border-top: 1px solid #b5b5b5;
    bottom: 0;
    left: 0;
    right: 0;
    li{
      text-align: center;
      &:hover{
        color: #ff4500;
        transition: all .5s;
      }
    }
    i{
      font-size: 50px;
    }
    p{
      margin-top: 2px;
      font-size: 10px;
    }
}
</style>
