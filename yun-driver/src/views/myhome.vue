<template>
    <div>
        <div class="top">
            <i class="iconfont icon-shezhi sp"></i>
        </div>
        <div>
            <div class="ids">
                <div class="is">
                    <img src="../assets/images/first.jpg" alt="" @click="goToLogin">
                </div>
                <div class="homeInfo">
                    <p>{{userName}}--{{userId}}<span class="fb" @click="authority">未认证</span></p>
                    <p class="fc">认证后享受更多服务</p>
                </div>
            </div>
            <div>
                <p class="sum">请先提交认证，认证通过才能联系货主哦！></p>
            </div>
        </div>
        <div class="tools">
            <p class="top-list">常用工具</p>
            <ul class="home-list">
                <li>
                    <div>
                        <i class="iconfont icon-kehufuwu"></i>
                    </div>
                    <p>客户服务</p>
                </li>
                <li>
                    <div>
                        <i class="iconfont icon-pingjiaguanli"></i>
                    </div>
                    <p>评价管理</p>
                </li>
                <li>
                    <div>
                        <i class="iconfont icon-yijianfankui"></i>
                    </div>
                    <p>意见反馈</p>
                </li>
            </ul>
            <p class="top-list">我的服务</p>
            <ul class="home-list">
                <li>
                    <div>
                        <i class="iconfont icon-wj-flyz"></i>
                    </div>
                    <p>法律公告</p>
                </li>
            </ul>
            <input type="text" v-model="userphone" placeholder="手机号" />
        </div>
    </div>
</template>

<script>
import { mapGetters, mapMutations } from 'vuex'
import axios from 'axios'
export default {
  name: 'myhome',
  data () {
    return {
      userphone: ''
    }
  },
  methods: {
    goToLogin () {
      this.$router.push({
        name: 'home'
      })
    },
    ...mapMutations([
      'SET_USERPHONE'
    ]),
    async authority () {
      const { data } = await axios({
        method: 'post',
        url: '/api/user/authority',
        params: {
          id: this.userId,
          userphone: this.userphone
        }
      })
      console.log(data)
      this.SET_USERPHONE(this.userphone)
    }
  },
  computed: {
    ...mapGetters([
      'userName',
      'userId',
      'userPhone'
    ])
  }
}
</script>

<style lang="less" scoped>
.top{
    width: 100%;
    height: 100px;
    .sp{
        float: right;
        font-size: 40px;
        margin-top: 20px;
        margin-right: 20px;
        color: gray;
    }
}
.ids{
    display: flex;
    flex-direction: row;
    .is{
        width: 110px;
        height: 110px;
        margin-left: 25px;
        flex-shrink: 0;
        border-radius: 50%;
        overflow: hidden;
        border: 1PX solid grey;
        margin-right: 20px;
        img{
            width: 100%;
        }
    }
    .homeInfo{
        margin-left: 20px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        p{
            padding: 10px 0;
        }
        .fb{
            border-radius: 10px;
            border: 1px solid #d3d3d3;
            color: grey;
            padding: 4px;
            margin: 3px;
            margin-left: 8px;
        }
        .fc{
            color: #ff4500;
            letter-spacing: 3px;
        }
    }
}
.sum{
    margin-top: 25px;
    margin-left: 25px;
    font-size: 28px;
    letter-spacing: 4px;
    color: #ff4500;
}
.tools{
    margin-top: 40px;
    background-color: white;
    padding-top: 30px;
    .home-list{
        display: flex;
        flex-direction: row;
        padding-bottom: 30px;
        text-align: center;
        li{
            margin: 15px 0;
            width: 25%;
            div{
                margin-top: 25px;
                margin-bottom: 20px;
            }
            i{
                font-size: 45px;
                color: #ff4500;
            }
            p{
                font-size: 24px;
            }
        }
    }
    .top-list{
        padding-left: 20px;
        font-size: 28px;
        letter-spacing: 2px;
        font-family: "Microsoft soft";
    }
}
</style>
