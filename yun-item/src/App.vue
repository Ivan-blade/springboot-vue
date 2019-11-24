<template>
  <div id="app">
    <router-view/>
    <div>
      <v-bottom></v-bottom>
    </div>
  </div>
</template>
<script>
import vBottom from './components/vBottom'
export default {
  name: 'app',
  components: {
    'v-bottom': vBottom
  }
}
</script>
<style lang="less">
</style>
