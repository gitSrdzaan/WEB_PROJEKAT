<template>
  <div>
    <div>
      <b-navbar toggleable="lg" type="dark" variant="dark">
        <b-navbar-brand>
          <router-link to="/">Home</router-link>
        </b-navbar-brand>
        <div>
          <b-navbar-brand>
            <router-link to="/user">User</router-link>
          </b-navbar-brand>
        </div>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">

          <b-navbar-brand>
            <router-link to="/login">Log In</router-link>
          </b-navbar-brand>
          <b-navbar-brand>
            <router-link to="/reg">Sign In</router-link>
          </b-navbar-brand>
             <router-link to="/admin" v-bind:user="user">Admin</router-link>
        </b-navbar-nav>
      </b-collapse>
      </b-navbar>
    </div>
    <router-view/>
    <router-link to="/admin">Admin</router-link>
     
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HomePage',
<<<<<<< HEAD
  mounded: function(){
    axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(res => (this.user = res))
  },
  data() {
    return{
      user: null
    }
  }

=======
  data(){
    return {
      user : {
        username : "admin" 
      }
    }
  },
  mounted : function(){
    console.log(this.user);
  }
 
  
>>>>>>> 71e13021b92860d23429f9500899fa856069eef3
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>