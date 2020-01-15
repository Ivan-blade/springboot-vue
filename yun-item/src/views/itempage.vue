<template>
    <div>
        <v-header>
            <div>
                <ul class="pageInfo">
                    <li class="pageInfo-first">消息</li>
                    <li class="info-deal" @click="changeIndex(1)">在发货中</li>
                    <li class="info-deal" @click="changeIndex(2)">发货历史</li>
                    <li class="info-deal" @click="changeIndex(3)">常发货源</li>
                </ul>
            </div>
        </v-header>
        <div class="page-content-first" v-if="pageIndex === 1">
            <div class="content-first">
                <p>您周围有<span>百万</span>司机等着您发货</p>
            </div>
            <div @click="changeIndex(4)" class="content-last">
                <p>发货</p>
            </div>
        </div>
        <div class="page-content-second" v-if="pageIndex === 2">
            <div class="second-top">
                <ul class="top-lists">
                    <li>
                        <p>全国</p>
                        <i class="iconfont icon-xiajiantou" :class="[isRotate1?'startRo':'backRo']" @click="decision1"></i>
                    </li>
                    <li>
                        <p>目的地</p>
                        <i class="iconfont icon-xiajiantou" :class="[isRotate2?'startRo':'backRo']" @click="decision2"></i>
                    </li>
                    <li>
                        <p>全部</p>
                        <i class="iconfont icon-xiajiantou" :class="[isRotate3?'startRo':'backRo']" @click="decision3"></i>
                    </li>
                </ul>
            </div>
            <div>
                <div class="second-content-top"><span>没有更多了</span></div>
                <div class="second-content">
                    <i class="iconfont icon-box"></i>
                    <p>暂无数据</p>
                </div>
            </div>
        </div>
        <div class="page-content-third" v-if="pageIndex === 3">
            <li><i class="iconfont icon-box"></i></li>
            <p>您尚未保存任何常发货源</p>
        </div>
        <div class="page-content-fourth" v-if="pageIndex === 4">
            <div class="input-display">
                <input type="text" v-model="ItemName" placeholder="货物名称" />
                <input type="text" v-model="CarSize" placeholder="货车规格" />
                <input type="text" v-model="Origin" placeholder="起点" />
                <input type="text" v-model="Destination" placeholder="终点" />
            </div>
            <ul class="result">
                <li>
                    <p>{{res}}</p>
                </li>
            </ul>
            <ul @click="item" class="order_init">
                <li>创建订单</li>
            </ul>
        </div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
import axios from 'axios'
import mHeader from '../components/mHeader'
export default {
  name: 'item-page',
  components: {
    'v-header': mHeader
  },
  data () {
    return {
      pageIndex: 1,
      isRotate1: false,
      isRotate2: false,
      isRotate3: false,
      ItemName: '',
      CarSize: '',
      Origin: '',
      Destination: '',
      res: ''
    }
  },
  computed: {
    ...mapGetters([
      'userName',
      'userId',
      'userPhone'
    ])
  },
  methods: {
    async item () {
      if (this.ItemName && this.Origin && this.Destination && this.CarSize) {
        // console.log(this.userId)
        console.log(this.userPhone)
        const { data } = await axios({
          method: 'post',
          url: '/api/order/item',
          params: {
            itemName: this.ItemName,
            senderName: this.userName,
            // senderPhone: this.userId,
            senderPhone: this.userPhone,
            carSize: this.CarSize,
            origin: this.Origin,
            destination: this.Destination
          }
        })
        console.log(data)
        this.res = '订单生成成功'
      } else {
        this.res = '请按提示输入货物信息'
      }
    },
    decision1 () {
      this.isRotate1 = !this.isRotate1
    },
    decision2 () {
      this.isRotate2 = !this.isRotate2
    },
    decision3 () {
      this.isRotate3 = !this.isRotate3
    },
    changeIndex (num) {
      this.pageIndex = num
    }
  }
}
</script>

<style lang="less" scoped>
.pageInfo{
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin-top: 15px;
    line-height: 54px;
    font-size: 26px;
    .info-deal{
        width: 17%;
        padding: 3px 8px;
        border: 1px solid white;
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
}
.page-content-first{
    position: fixed;
    left: 0;
    right: 0;
    bottom: 120px;
    display: flex;
    flex-direction: column;
    align-items: center;
    .content-first{
        margin-bottom: 25px;
        font-size: 25px;
        color: grey;
        letter-spacing: 4px;
        span{
            color: #ff4500;
        }
    }
    .content-last{
        margin-bottom: 40px;
        font-size: 32px;
        padding: 25px 65px;
        letter-spacing: 6px;
        background-color: #ee4e14;
        color: white;
    }
}
.page-content-second{
    .second-top{
        position: fixed;
        left: 0;
        right: 0;
        top: 90px;
        padding: 25px 0;
        border-bottom: 1px solid #b5b5b5;
        .top-lists{
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            text-align: center;
            li{
                padding-left: 70px;
                padding-right: 60px;
                border-right: 1px solid #b5b5b5;
                display: flex;
                flex-direction: row;
                align-items: center;
                &:last-child{
                    border: none;
                    margin-right: 0;
                }
                p{
                    font-size: 27px;
                    letter-spacing: 6px;
                }
                i{
                    margin-left: 10px;
                    font-size: 30px;
                }
                .backRo{
                    transition: all .3s;
                }
                .startRo{
                    transform: rotate(-180deg);
                    transition: all .3s;
                }
            }
        }
    }
    .second-content-top{
        position: fixed;
        left: 0;
        right: 0;
        top: 300px;
        text-align: center;
        span{
            font-size: 30px;
            letter-spacing: 4px;
            color: #c0c0c0;
        }
    }
    .second-content{
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
            color: grey;
            font-size: 35px;
            letter-spacing: 3px;
        }
    }
}
.page-content-third{
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
        color: grey;
        font-size: 30px;
        letter-spacing: 3px;
    }
}
.page-content-fourth{
    position: fixed;
    left: 0;
    right: 0;
    top: 130px;
    .input-display{
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .order_init{
        width: 300px;
        margin-bottom: 40px;
        font-size: 32px;
        padding: 25px 65px;
        letter-spacing: 6px;
        background-color: #ee4e14;
        color: white;
        margin:30px auto;
        text-align: center;
    }
    input{
        margin: 20px 0;
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
</style>
