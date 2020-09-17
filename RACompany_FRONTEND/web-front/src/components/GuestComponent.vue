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
import Axios from 'axios';
export default {
  name: 'GuestComponent',
  components :{
    UserInfoComponent
  },
  data(){
    return {
      user : {}
    }
  },
  methods : {
    getCurrUser(){
       Axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(response => (this.user = response.data))
      .catch(console.log("nema ulogovanog"));
      
    }
  },
  created(){
    this.getCurrUser();
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>