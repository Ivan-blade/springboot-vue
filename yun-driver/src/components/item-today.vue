<template>
    <div>
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
        <v-scroll class="scroll-class">
            <item-list :data="OrderInfo"></item-list>
        </v-scroll>
    </div>
</template>

<script>
import ItemList from './item-list'
import Scroll from './scroll'
import axios from 'axios'
import mHeader from './mHeader'
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
      const { data } = await axios.get('/bpi/item')
      console.log(data)
      this.OrderInfo = data
    }
  },
  mounted () {
    this.getOrderInfo()
  }
}
</script>

<style lang="less" scoped>
.scroll-class{
  position: fixed;
  right: 0;
  left: 0;
  top: 90px;
}
</style>
