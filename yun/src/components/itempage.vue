<template>
    <div>
        <v-header>
            <div>
                <ul class="pageInfo">
                    <li class="pageInfo-first">消息</li>
                    <li class="info-deal" @click="changeIntoFirst">在发货中</li>
                    <li class="info-deal" @click="changeIntoSecond">发货历史</li>
                    <li class="info-deal" @click="changeIntoThird">常发货源</li>
                </ul>
            </div>
        </v-header>
        <div class="page-content-first" v-if="pageIndex === 1">
            <div class="content-first">
                <p>您周围有<span>百万</span>司机等着您发货</p>
            </div>
            <div class="content-last">
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
    </div>
</template>

<script>
import mHeader from './mHeader'
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
      isRotate3: false
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
    changeIntoFirst () {
      this.pageIndex = 1
    },
    changeIntoSecond () {
      this.pageIndex = 2
    },
    changeIntoThird () {
      this.pageIndex = 3
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
</style>
