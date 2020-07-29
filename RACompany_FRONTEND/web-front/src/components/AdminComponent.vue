<template>
  <div>
      <h1>Admin Component</h1>
      <div id="tabs">
        <b-tabs content-class="mt-3">
          <b-tab title="Personal Info" active ><UserInfoComponent v-bind:user="user"/></b-tab>
          <b-tab title="Users" ><p>I'm the first tab</p></b-tab>
          <b-tab title="Apartments"><p>I'm the second tab</p></b-tab>
          <b-tab title="Apartment amenities" ><p>I'm a disabled tab!</p></b-tab>
          <b-tab title="Reservations"><GuestComponent/></b-tab>
        </b-tabs>
    </div>
  </div>
</template>

<script>
import GuestComponent from "../components/GuestComponent";
import UserInfoComponent from "../components/UserInfoComponent";
import axios from 'axios';

export default {
  name: 'AdminComponent',
  components: {
    GuestComponent,
    UserInfoComponent
  },
  data(){
    return{
      user : {
        username : "admin",
        password : "admin",
        firstname : "admin",
        lastname : "admin",
        sex : "Male"
      }
    }
  },
  methods : {
    getCurrUser : function(){
      axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(response => (this.user = response))
      .catch(console.log("nema ulogovanog"))
    }
  },
  mounted (){
    this.getCurrUser();

  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>