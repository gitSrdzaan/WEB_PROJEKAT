<template>
  <div>
    <router-link to="/">Home</router-link>
    <router-link to="/login">LogIn</router-link>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'HomePage',

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>