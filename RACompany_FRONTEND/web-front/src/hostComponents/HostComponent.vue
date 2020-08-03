<template>
  <div>
      <h1>Host Component</h1>
      <div>
        <b-tab title="Personal Info" >
          <UserInfoComponent v-bind:user="user"/>
        </b-tab>
        <b-tab title="Apartments">
          <HostApartmentComponents @click="getAllApartments" v-bind:apartments = "apartments"/>
        </b-tab>
        <b-tab title="Reservations">
          <HostReservationsComponent/>
        </b-tab>
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
      apartments : []
    }
  },
  methods : {
    getAllApartments : function(event){
      let path = 'http://localhost:8080/rest/apartment/hostAll/'
      let getPaht = path.concat(this.user.username)
      Axios
      .get('http://localhost:8080/rest/apartment/hostAll/')
      .then(response => (this.apartments = response.data))
      .catch(console.log("greska pri dobavljanju apartmana"))


    }
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>