<template>
  <div>
      <h1>Guest Component</h1>
      <div>
        <b-tabs>
          <b-tab title="Personal info">
            <UserInfoComponent v-bind:user="user"/>
          </b-tab>
          <b-tab title="Reservations" @click="getGuestReservation">
            <GuestReservationComponent v-bind:reservations="reservations" v-bind:role="user.userRole"/>
          </b-tab>
        </b-tabs>
      </div>
  </div>
</template>

<script>
import UserInfoComponent from "../components/UserInfoComponent"
import GuestReservationComponent from "../guest/GuestReservationComponent"
import Axios from 'axios';
export default {
  name: 'GuestComponent',
  components :{
    UserInfoComponent,
    GuestReservationComponent
  },
  data(){
    return {
      user : {},
      reservations : []
    }
  },
  methods : {
    getCurrUser(){
       Axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(response => (this.user = response.data))
      .catch(console.log("nema ulogovanog"));
      
    },
    getGuestReservation(){
      Axios
      .get('http://localhost:8080/RACompany/rest/reservation/getGuest/'+this.user.username)
      .then(response => (this.reservations = response.data))
      .catch(error => (console.log(error)));
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