<template>
  <div>
      <h1>Admin Component</h1>
      <div id="tabs">
        <b-tabs content-class="mt-3">
          <b-tab title="Personal Info">
            <UserInfoComponent v-bind:user="user"/>
            </b-tab>
          <b-tab title="Users" @click="getAllUsers" >
            <ViewAllUsers v-bind:user="user" v-bind:users = "users"/>                                               
            </b-tab>
          <b-tab title="Apartments" @click="getAllApartments" >
            <ViewAllApartments v-bind:apartments = "apartments"/>
          </b-tab>
          <b-tab title="Apartment amenities" @click="getAllAmenities" >
            <ViewAllAmenities v-bind:amenities="amenities" v-on:update="getAllAmenities"/>
          </b-tab>
          <b-tab title="Reservations" @click="getAllReservations">
            <ViewAllResevations v-bind:reservations="reservations" />
            </b-tab>
        </b-tabs>
    </div>
  </div>
</template>

<script>

import UserInfoComponent from "../components/UserInfoComponent";
import ViewAllUsers from "../adminComponents/ViewAllUsers";
import ViewAllApartments from "../adminComponents/ViewAllApartments";
import ViewAllAmenities from "../adminComponents/ViewAllAmenities";
import ViewAllResevations from "../adminComponents/ViewAllReservations"

import axios from 'axios';

export default {
  name: 'AdminComponent',
  components: {
    UserInfoComponent,
    ViewAllUsers,
    ViewAllApartments,
    ViewAllAmenities,
    ViewAllResevations
  },
  data(){
    return{
      user : {
         
      },
      users : [],
      apartments : [],
      amenities : [],
      reservations : []
    }
    
    
  },
  methods : {
    getCurrUser : function(){
      axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(response => (this.user = response.data))
      .catch(console.log("nema ulogovanog"))
     
      
      
    },
    getAllUsers : function(){
      axios
          .get('http://localhost:8080/RACompany/rest/users/allUsers')
          .then(response => (this.users = response.data))
          .catch(console.log("greska pri dobavljanju korisnika"))
    },
    getAllApartments : function(){

      axios
      .get('http://localhost:8080/RACompany/rest/apartment/all')
      .then(response => (this.apartments = response.data))

    },
    getAllAmenities : function(){
      axios
      .get('http://localhost:8080/RACompany/rest/amneities/all')
      .then(response => (this.amenities = response.data))
    },
    getAllReservations : function(){
      
    }
  },
  created (){
    this.getCurrUser();
    
    

  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>