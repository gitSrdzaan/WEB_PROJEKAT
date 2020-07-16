<template>
  <div>
      <HomeHeaderComponent/>
      <HomeContentComponent/>
  </div>
</template>

<script>

import HomeHeaderComponent from '../components/HomeHeaderComponent'
import HomeContentComponent from '../components/HomeContentComponent'

export default {
  name: 'HomePage',
  components: {
      HomeHeaderComponent,
      HomeContentComponent
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>