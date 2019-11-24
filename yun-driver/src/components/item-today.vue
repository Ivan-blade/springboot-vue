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
    </div>
</template>

<script>
import mHeader from './mHeader'
export default {
  name: 'item-today',
  components: {
    'v-header': mHeader
  },
  data () {
    return {
      pageIndex: 1,
      isRotate1: false,
      isRotate2: false,
      isRotate3: false,
      isRotate4: false
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
    }
  }
}
</script>

<style lang="less" scoped>
.pageInfo{
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    margin-top: 15px;
    line-height: 54px;
    font-size: 26px;
    .info-deal{
        padding: 3px 8px;
        border: 1px solid white;
        width: 14%;
        &:hover{
            color: #f8763a;
            background-color: white;
        }
    }
    li{
        letter-spacing: 2px;
    }
    .pageInfo-first{
        position: fixed;
        left: 20px;
        font-size: 28px;
    }
    .pageInfo-last{
        position: fixed;
        right: 20px;
        font-size: 28px;
    }
}
</style>
