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
        </b-navbar-nav>
      </b-collapse>
      </b-navbar>
    </div>
    <router-view/>
     
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HomePage',
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
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>