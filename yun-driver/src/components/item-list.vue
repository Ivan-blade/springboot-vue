<template>
    <div>
        <ul class="item-list">
            <li v-for="(item,index) in data" :key="index" class="item-content">
                <div>
                        <p>{{item.id}}</p>
                    </div>
                <div>
                    <ul>
                        <li>{{item.Origin}} -> {{item.Destination}}</li>
                        <li>{{item.CarSize}}</li>
                        <li>会员{{item.ItemName}}</li>
                        <li>交易9999 好评率99%</li>
                    </ul>
                </div>
                <div>
                    <p>9分钟前</p>
                    <i></i>
                </div>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
  name: 'item-list',
  props: {
    data: {
      type: Array,
      default () {
        return []
      }
    }
  }
}
</script>

<style lang="less" scoped>
    .item-list{
      .item-content{
        height: 200px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
      }
    }
</style>
