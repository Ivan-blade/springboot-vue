<template>
    <div class="item">
        <ul class="item-list">
            <li v-for="(item,index) in data" :key="index" class="item-content">
              <div class="random-one">
                <div class="item-id">
                  <p>{{item.id}}</p>
                </div>
                <div class="item-info">
                    <ul class="item-ul">
                        <li>{{item.origin}} -> {{item.destination}}</li>
                        <li>{{item.carSize}}</li>
                        <li>会员:{{item.itemName}}</li>
                        <li class="comment">交易9999 好评率99%</li>
                    </ul>
                </div>
              </div>
              <div class="random-two">
                  <p>9分钟前</p>
                  <i class="iconfont icon-kaipiao" @click="StatusChange(item.id)"></i>
              </div>
            </li>
        </ul>
    </div>
</template>

<script>
import axios from 'axios'
import { mapGetters } from 'vuex'
export default {
  name: 'item-list',
  props: {
    data: {
      type: Array,
      default () {
        return []
      }
    }
  },
  methods: {
    async StatusChange (temp) {
      const { data } = await axios({
        method: 'post',
        url: '/api/order/driver',
        params: {
          id: temp,
          driverPhone: this.userPhone,
          orderStatus: 2,
          driverName: this.userName
        }
      })
      this.OrderInfo = data
      console.log(data)
      // console.log(this.userId)
      // console.log(this.userPhone)
    }
  },
  computed: {
    ...mapGetters([
      'userPhone',
      'userName',
      'userId'
    ])
  }
}
</script>

<style lang="less" scoped>
  .item{
    background-color: white;
  }
  .item-list{
    padding-top: 50px;
    .item-content{
      height: 200px;
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      .random-one{
        display: flex;
        flex-direction: row;
        width: 70%;
        .item-id{
          margin-left: 20px;
          width: 30%;
          p{
            text-align: center;
          }
        }
      }
      .item-info{
        .item-ul{
          display: flex;
          flex-direction: column;
          li{
            font-size: 27px;
            margin: 6px 6px;
          }
          .comment{
            font-size: 20px;
            color: grey;
          }
        }
      }
      .random-two{
        margin-right: 30px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        p{
          color: grey;
        }
        i{
          font-size: 45px;
          color: #f8763a;
          margin-bottom: 50px;
        }
      }
    }
  }
</style>
