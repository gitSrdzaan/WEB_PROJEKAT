<template>
  <div>
      <h1>Host Component</h1>
      <div>
        <b-tabs>
          <b-tab title="Personal Info" >
            <UserInfoComponent v-bind:user="user"/>
          </b-tab>
          <b-tab title="Apartments" @click="getAllApartments">
            <HostApartmentComponents  v-bind:apartments = "apartments" v-bind:host="user"/>
          </b-tab>
          <b-tab title="Reservations">
            <HostReservationsComponent/>
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
  data(){
    return{
      user : {},
      apartments : [
                {
                  id : 3,
                  type : 'FULL',
                  roomNumber : '',
                  guestNumber : '',
                  apartmentLocation : {
                    longitude : 25.478,
                    latitude : 24.486,
                    adress : {
                      city : "Novi Sad",
                      street : "Lasla Gala",
                      postalCode : "21000",
                      number : 3
                    }
                  },
                  apartmentResevartionDates : [],
                  comments : [],
                  pricePerNight : 0.0,
                  checkInTime : '',
                  checkOutTime : '',
                  apartmentStatus : false,
                  amenities : [],
                  reservations : [],
                  imageSource : []
            }
      ]
    }
  },
  methods : {
    getAllApartments : function(){
      let path = 'http://localhost:8080/RACompany/rest/apartment/hostAll/'+this.user.username;
      
      Axios
      .get(path)
      .then(response => (this.apartments = response.data))
      .catch(console.log("greska pri dobavljanju apartmana"))


    },
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