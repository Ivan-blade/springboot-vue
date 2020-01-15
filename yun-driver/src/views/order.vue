<template>
    <div>
        <v-header>
            <div class="orderInfo">
                <p>我的订单</p>
                <i class="iconfont icon-kaipiao right1"></i>
                <i class="iconfont icon-sousuo right2 fs"></i>
            </div>
        </v-header>
        <ul class="page-index">
            <span>
                <li @click="goToAll">全部</li>
                <li @click="goToUn">待确认</li>
                <li @click="goToTra">运输中</li>
                <li @click="goToFin">待评价</li>
                <li>取消/退款</li>
            </span>
        </ul>
        <v-scroll class="scroll-class">
            <item-list :data="OrderInfo"></item-list>
        </v-scroll>
        <div class="page-content" v-show="!this.OrderInfo">
            <i class="iconfont icon-zanwudingdan"></i>
            <p>暂无相关订单</p>
        </div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
import ItemList from '../components/item-list'
import Scroll from '../components/scroll'
import axios from 'axios'
import mHeader from '../components/mHeader'
export default {
  name: 'order',
  components: {
    'v-header': mHeader,
    'v-scroll': Scroll,
    'item-list': ItemList
  },
  computed: {
    ...mapGetters([
      'userPhone',
      'userId'
    ])
  },
  data () {
    return {
      OrderInfo: []
    }
  },
  methods: {
    async getOrderInfo_driver () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/2`,
        params: {
          driverPhone: this.userPhone,
          orderStatus: 2
        }
      })
      this.OrderInfo = data
      // console.log(data)
      // console.log(this.userId)
      // console.log(this.userPhone)
    },
    async getOrderInfo_un () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/3`,
        params: {
          driverPhone: this.userPhone,
          orderStatus: 3
        }
      })
      this.OrderInfo = data
      // console.log(data)
    },
    async getOrderInfo_tra () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/4`,
        params: {
          driverPhone: this.userPhone,
          orderStatus: 4
        }
      })
      this.OrderInfo = data
      // console.log(data)
    },
    async getOrderInfo_fin () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/5`,
        params: {
          driverPhone: this.userPhone,
          orderStatus: 5
        }
      })
      this.OrderInfo = data
      // console.log(data)
    },
    goToAll () {
      this.getOrderInfo_driver()
    },
    goToUn () {
      this.getOrderInfo_un()
    },
    goToFin () {
      this.getOrderInfo_fin()
    },
    goToTra () {
      this.getOrderInfo_tra()
    }
  },
  mounted () {
    this.getOrderInfo_driver()
  }
}
</script>

<style lang="less" scoped>
.orderInfo{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
    .right1{
        position: fixed;
        left: 5px;
    }
    .right2{
        position: fixed;
        left: 670px;
        font-size: 42px;
    }
}
.page-index::-webkit-scrollbar {
    display: none;
    // 不显示滚动条
}
.page-index{
    position: fixed;
    left: 0;
    right: 0;
    top: 90px;
    width: 100%;
    overflow-x: auto;
    span{
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow: hidden;
        li{
            width: 200px;
            height: 60px;
            display: inline-block;
            text-align: center;
            padding-top: 30px;
            border-bottom: 1px solid #b5b5b5;
            letter-spacing: 4px;
            font-size: 25px;
            &:hover{
                transition: all .1s;
                color: #f8763a;
                border-bottom: 2px solid #f8763a;
            }
        }
    }
}
.page-content{
    position: fixed;
    left: 0;
    right: 0;
    top: 500px;
    display: flex;
    flex-direction: column;
    align-items: center;
    i{
        font-size: 200px;
        color: #c0c0c0;
    }
    p{
        margin-top: 30px;
        color: grey;
        font-size: 25px;
        letter-spacing: 3px;
    }
}
.scroll-class{
  position: fixed;
  right: 0;
  left: 0;
  top: 185px;
  height: calc(100vh - 270px);
  overflow: hidden;
}
</style>
