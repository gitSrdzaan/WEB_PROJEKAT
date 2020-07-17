<template>
  <div>
      <app-header></app-header>
      <app-content></app-content>
  </div>
</template>

<script>

import HomeHeaderComponent from '../components/HomeHeaderComponent';
import HomeContentComponent from '../components/HomeContentComponent'

export default {
  name: 'HomePage',
  components: {
      'app-header': HomeHeaderComponent,
      'app-content': HomeContentComponent,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>