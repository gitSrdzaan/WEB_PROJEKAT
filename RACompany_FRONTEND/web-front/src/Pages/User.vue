<template>
<div>
  <div v-if="user.userRole === admin">
      <AdminComponent/>
  </div>
  <div v-else-if="user.userRole === guest">
      <GuestComponent/>
  </div>
  <div v-else-if="user.userRole === host">
      <HostComponent v-bind:user="user"/>
  </div>
  
</div>
</template>

<script>
import AdminComponent from '../adminComponents/AdminComponent'
import GuestComponent from '../components/GuestComponent'
import HostComponent from '../components/HostComponent'

import axios from 'axios'


export default {
  name: 'User',
  components: {
    AdminComponent,
    GuestComponent,
    HostComponent,

  },
  created: function(){
    axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(res => (this.user = res.data))
      .catch(console.log("nesto"))
  },
  data() {
    return {
      user: {},
      admin: "ADMIN",
      guest: "GUEST",
      host: "HOST"
    }
  }
  
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>