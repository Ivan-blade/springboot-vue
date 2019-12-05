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
                <li>全部</li>
                <li>待确认</li>
                <li>运输中</li>
                <li>待支付</li>
                <li>待评价</li>
                <li>取消/退款</li>
            </span>
        </ul>
        <div class="page-content">
            <i class="iconfont icon-zanwudingdan"></i>
            <p>暂无相关订单</p>
        </div>
    </div>
</template>

<script>
import mHeader from '../components/mHeader'
export default {
  name: 'order',
  components: {
    'v-header': mHeader
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
</style>
