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
                <li @click="dataAll">全部</li>
                <li @click="dataConfirm">待确认</li>
                <li @click="dataTransport">运输中</li>
                <li @click="dataUnpay">待支付</li>
                <li @click="dataUncomment">待评价</li>
                <li @click="dataRefund">取消/退款</li>
            </span>
        </ul>
        <v-scroll class="scroll-class">
            <item-list :data="OrderInfo" :backClick="backDecision" :backStatus="subStatus"></item-list>
        </v-scroll>
        <div class="page-content" v-show="!this.OrderInfo">
            <i class="iconfont icon-zanwudingdan"></i>
            <p>暂无相关订单</p>
        </div>
    </div>
</template>

<script>
import mHeader from '../components/mHeader'
import axios from 'axios'
import { mapGetters } from 'vuex'
import ItemList from '../components/item-list'
import Scroll from '../components/scroll'
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
      OrderInfo: [],
      backDecision: false,
      subStatus: 2
    }
  },
  methods: {
    async getdataAll () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/itemer/${this.userId}`,
        params: {
          itemerPhone: this.userPhone
        }
      })
      this.OrderInfo = data.detail
      console.log(data)
    },
    async getdataConfirm () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/2`,
        params: {
          itemerPhone: this.userPhone,
          orderStatus: 2
        }
      })
      this.OrderInfo = data.detail
    //   console.log(data)
    },
    async getdataTransport () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/3`,
        params: {
          itemerPhone: this.userPhone,
          orderStatus: 3
        }
      })
      this.OrderInfo = data.detail
    //   console.log(data)
    },
    async getdataUnpay () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/4`,
        params: {
          itemerPhone: this.userPhone,
          orderStatus: 4
        }
      })
      this.OrderInfo = data.detail
      console.log(data)
    },
    async getdataUncomment () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/5`,
        params: {
          itemerPhone: this.userPhone,
          orderStatus: 5
        }
      })
      this.OrderInfo = data.detail
    //   console.log(data)
    },
    async getdataRefund () {
      const { data } = await axios({
        method: 'post',
        url: `/api/order/${this.userId}/0`,
        params: {
          itemerPhone: this.userPhone,
          orderStatus: 0
        }
      })
      this.OrderInfo = data.detail
    //   console.log(data)
    },
    dataAll () {
      this.getdataAll()
    },
    dataConfirm () {
      this.subStatus = 3
      this.backDecision = true
      this.getdataConfirm()
    },
    dataTransport () {
      this.backDecision = false
      this.getdataTransport()
    },
    dataUnpay () {
      this.subStatus = 5
      this.backDecision = true
      this.getdataUnpay()
    },
    dataUncomment () {
      this.subStatus = 6
      this.backDecision = true
      this.getdataUncomment()
    },
    dataRefund () {
      this.subStatus = 0
      this.backDecision = true
      this.getdataRefund()
    }
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
