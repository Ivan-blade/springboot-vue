<template>
    <div class="header" :class="{'orange':orange}">
        <i class="iconfont icon-houtui" @click="goBack" v-show="backIcon"></i>
        <slot></slot>
    </div>
</template>

<script>
export default {
  name: 'm-header',
  props: {
    orange: {
      type: Boolean,
      default () {
        return true
      }
    },
    backIcon: {
      type: Boolean,
      default () {
        return false
      }
    }
  },
  methods: {
    goBack () {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="less" scoped>
    .header{
      width: 100%;
      position: fixed;
      top:0;
      left: 0;
      right: 0;
      height: 90px;
      line-height: 90px;
      font-size: 34px;
      color: #fefefe;
      text-align: center;
      z-index: 9;
      &.orange{
          background-color: #f8763a;
      }
      i{
          position: absolute;
          font-size: 50px;
          left: 20px;
      }
    }
</style>
