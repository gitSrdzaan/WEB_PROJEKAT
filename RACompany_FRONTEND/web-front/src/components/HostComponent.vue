<template>
  <div>
      <h1>Host Component</h1>
      <div>
        <b-tabs>
          <b-tab title="Personal Info" >
            <UserInfoComponent v-bind:user="user"/>
          </b-tab>
          <b-tab title="Apartments" @click="getAllApartments">
            <HostApartmentComponents  v-bind:apartments = "apartments" v-bind:host="user" v-on:update="getAllApartments"/>
          </b-tab>
          <b-tab title="Reservations" @click="getHostReservations">
            <HostReservationsComponent v-bind:reservations="reservations" v-bind:role="user.userRole"/>
          </b-tab>
          <b-tab title="Users" @click="getHostGuests">
             <b-list-group v-for="temp in guests" :key="temp" >
            <b-list-group-item li>{{temp}}</b-list-group-item>
             </b-list-group>
            
          </b-tab>
        </b-tabs>
      </div>

  </div>
</template>

<script>

import UserInfoComponent from "../components/UserInfoComponent"
import HostApartmentComponents from "../hostComponents/HostApartmentsComponent"
import HostReservationsComponent from "../hostComponents/HostReservationsComponent"

import Axios from 'axios'

export default {
  name: 'HostComponent',
  components : {
    UserInfoComponent,
    HostApartmentComponents,
    HostReservationsComponent
  },
  props : {
    user :{
      type : Object
    }
  },
  data(){
    return{
      
      apartments : [],
      reservations : [],
      guests : []
    }
  },
  methods : {
    getAllApartments : function(){
      let path = 'http://localhost:8080/RACompany/rest/apartment/hostAll/'+this.user.username;
      
      Axios
      .get(path)
      .then(response => (this.apartments = response.data))
      .catch(error =>(console.log("greska pri dobavljanju apartmana"+error.response)));

      this.$forceUpdate();


    },
    getCurrUser(){
         Axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(response => (this.user = response.data))
      .catch(error => (console.log(error.data)));
    },
    getHostReservations(){
      Axios
      .get('http://localhost:8080/RACompany/rest/reservation/getHost/'+this.user.username)
      .then(response => (this.reservations = response.data))
      .catch(response => (console.log(response.data)))
    },
    getHostGuests(){
      Axios
      .get('http://localhost:8080/RACompany/rest/reservation/getGuests/'+this.user.username)
      .then(response => (this.guests = response.data));
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