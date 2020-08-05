<template>
  <div>
      <h1>Guest Component</h1>
      <div>
        <b-tabs>
          <b-tab title="Personal info">
            <UserInfoComponent v-bind:user="user"/>
          </b-tab>
          <b-tab title="Reservations">
            <p>Yours reservations</p>
          </b-tab>
        </b-tabs>
      </div>
  </div>
</template>

<script>
import UserInfoComponent from "../components/UserInfoComponent"
export default {
  name: 'GuestComponent',
  components :{
    UserInfoComponent
  },
  data(){
    return {
      user : {}
    }
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>