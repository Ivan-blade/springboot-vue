<template>
    <div class="item-today">
        <v-header>
            <div>
                <ul class="pageInfo">
                    <li class="pageInfo-first">消息</li>
                    <li class="info-deal" @click="changeIntoFirst">
                        <p>南京</p>
                    </li>
                    <li class="info-deal" @click="changeIntoSecond">
                        <p>周边</p>
                    </li>
                    <li class="pageInfo-last">找货记录</li>
                </ul>
            </div>
        </v-header>
        <ul class="page-index">
            <li>
              <p>南京</p>
              <i class="iconfont icon-xiajiantou"></i>
            </li>
            <li>
              <p>目的地</p>
              <i class="iconfont icon-xiajiantou"></i>
            </li>
            <li>
              <p>智能排序</p>
              <i class="iconfont icon-xiajiantou"></i>
            </li>
            <li>
              <p>筛选</p>
              <i class="iconfont icon-xiajiantou"></i>
            </li>
            <li class="li-last">
              <i class="iconfont icon-kaipiao"></i>
            </li>
        </ul>
        <v-scroll class="scroll-class">
            <item-list :data="OrderInfo"></item-list>
        </v-scroll>
    </div>
</template>

<script>
import ItemList from '../components/item-list'
import Scroll from '../components/scroll'
import axios from 'axios'
import mHeader from '../components/mHeader'
export default {
  name: 'item-today',
  components: {
    'v-header': mHeader,
    'v-scroll': Scroll,
    'item-list': ItemList
  },
  data () {
    return {
      pageIndex: 1,
      isRotate1: false,
      isRotate2: false,
      isRotate3: false,
      isRotate4: false,
      OrderInfo: []
    }
  },
  methods: {
    decision1 () {
      this.isRotate1 = !this.isRotate1
    },
    decision2 () {
      this.isRotate2 = !this.isRotate2
    },
    decision3 () {
      this.isRotate3 = !this.isRotate3
    },
    decision4 () {
      this.isRotate4 = !this.isRotate4
    },
    changeIntoFirst () {
      this.pageIndex = 1
    },
    changeIntoSecond () {
      this.pageIndex = 2
    },
    async getOrderInfo () {
      const { data } = await axios.post('/api/order/order_one')
      // console.log(data)
      this.OrderInfo = data
    }
  },
  mounted () {
    this.getOrderInfo()
  }
}
</script>

<style lang="less" scoped>
// .item-today{
//   background-color: white;
// }
.scroll-class{
  position: fixed;
  right: 0;
  left: 0;
  top: 185px;
  height: calc(100vh - 270px);
  overflow: hidden;
}
.pageInfo{
  display: flex;
  flex-direction: row;
  justify-content: center;
  position: relative;
  align-items: center;
  line-height: 54px;
  margin-top: 13px;
  .info-deal{
    line-height: 40px;
    border: 1PX solid white;
    padding: 8px 4px;
    width: 20%;
    font-size: 27px;
    &:hover{
        color: #f8763a;
        background-color: white;
    }
  }
  .pageInfo-first{
    position: absolute;
    left: 20px;
    font-size: 27px;
  }
  .pageInfo-last{
    position: absolute;
    right: 20px;
    font-size: 27px;
  }
}
.page-index{
  background-color: white;
  position: fixed;
  line-height: 90px;
  top: 90px;
  left: 0;
  right: 0;
  display: flex;
  flex-direction: row;
  text-align: center;
  align-items: center;
  border-bottom: 1px solid silver;
  margin-bottom: 15px;
  li{
    display: flex;
    flex-direction: row;
    justify-content: center;
    width: 22%;
    p{
      font-size: 26px;
      color: grey;
    }
    i{
      margin: 2px 4px;
      font-size: 25px;
    }
  }
  .li-last{
    i{
      font-size: 50px;
    }
  }
}
</style>
