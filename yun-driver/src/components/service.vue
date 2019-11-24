<template>
    <div>
        <v-header :orange=false>
            <p class="title">满满服务</p>
        </v-header>
    </div>
</template>

<script>
import mHeader from './mHeader'
export default {
  name: 'service',
  components: {
    'v-header': mHeader
  }
}
</script>

<style lang="less" scoped>
.title{
    color: black;
    font-size: 35px;
}
</style>
