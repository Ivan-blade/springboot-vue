<template>
    <div>
        <v-header>
            <div>
                <ul class="recordInfo">
                    <li class="re-mar">消息</li>
                    <li class="re-pad">配货大厅</li>
                    <li class="re-mar">找货记录</li>
                </ul>
            </div>
        </v-header>
        <div class="item-teen-content">
            <div class="first">
                <p class="fir-fir">添加常跑路线</p>
                <p class="fir-sec">新货源第一时间通知</p>
            </div>
            <div class="second">
                <div class="random-one">
                    <div class="sec-fir"></div>
                    <p class="sec-sec">选择出发地(最多3个)</p>
                </div>
                <div class="sec-thi">
                    <p>+ 选择</p>
                </div>
            </div>
            <div class="third">
                <div class="random-two">
                    <div class="thi-fir"></div>
                    <p class="thi-sec">选择目的地(最多3个)</p>
                </div>
                <div class="thi-thi">
                    <p>+ 选择</p>
                </div>
            </div>
            <div class="fourth">
                <i></i>
                <p>需要的车长车型</p>
                <i></i>
            </div>
            <div class="fifth">
                <button>确定</button>
            </div>
        </div>
    </div>
</template>

<script>
import mHeader from '../components/mHeader'
export default {
  name: 'item-teen',
  components: {
    'v-header': mHeader
  }
}
</script>

<style lang="less" scoped>
.recordInfo{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    .re-mar{
        font-size: 28px;
        margin: 0 20px;
    }
    .re-pad{
        padding-left: 45px;
    }
}
.item-teen-content{
    position: fixed;
    left: 0;
    right: 0;
    top: 90px;
    .first{
        margin: 30px 0;
        margin-left: 20px;
        letter-spacing: 3px;
        display: flex;
        flex-direction: row;
        .fir-fir{
            font-size: 30px;
        }
        .fir-sec{
            margin-top: 6px;
            font-size: 22px;
            color: grey;
            margin-left: 10px;
        }
    }
    .second{
        background-color: white;
        line-height: 70px;
        padding: 30px 0;
        .random-one{
            display: flex;
            flex-direction: row;
            position: relative;
            p{
                position: absolute;
                left: 60px;
                top: -27px;
                right: 0;
                letter-spacing: 2px;
            }
        }
        .sec-fir{
            margin-left: 20px;
            width: 17px;
            height: 17px;
            background-color: rgb(29, 142, 248);
            border-radius: 100px;
        }
        .sec-thi{
            border: 1px solid grey;
            width: 18%;
            line-height: 45px;
            margin-left: 50px;
            margin-top: 27px;
            p{
                padding: 8px 5px;
                padding-left: 23px;
                color: gray;
            }
        }
    }
    .third{
        margin-top: 30px;
        background-color: white;
        line-height: 70px;
        padding: 30px 0;
        .random-two{
            display: flex;
            flex-direction: row;
            position: relative;
            p{
                position: absolute;
                left: 60px;
                top: -27px;
                right: 0;
                letter-spacing: 2px;
            }
        }
        .thi-fir{
            margin-left: 20px;
            width: 17px;
            height: 17px;
            background-color: rgb(241, 113, 9);
            border-radius: 100px;
        }
        .thi-thi{
            border: 1px solid grey;
            width: 18%;
            line-height: 45px;
            margin-left: 50px;
            margin-top: 27px;
            p{
                padding: 8px 5px;
                padding-left: 23px;
                color: gray;
            }
        }
    }
    .fourth{
        margin-top: 20px;
        background-color: white;
        line-height: 70px;
        display: flex;
        justify-content: center;
        p{
            font-size: 24px;
            color: grey;
            // margin-left: 30px;
        }
    }
    .fifth{
      margin-top: 30px;
      display: flex;
      justify-content: center;
      button{
        width: 80%;
        line-height: 50px;
        background-color: #f8763a;
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 24px;
      }
    }
}
</style>
