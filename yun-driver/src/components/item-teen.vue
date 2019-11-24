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
    </div>
</template>

<script>
import mHeader from './mHeader'
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
.record-content{
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
