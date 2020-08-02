<template>
  <div>
    <div>
      <b-navbar toggleable="lg" type="dark" variant="dark">
        <b-navbar-brand>
          <router-link to="/">Home {{user.sex}}</router-link>
        </b-navbar-brand>
        <div>
          <b-navbar-brand v-show="user =! ''">
            <router-link to="/user">User: {{ user.firstname }}</router-link>
          </b-navbar-brand>
        </div>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">

          <b-navbar-brand >
            <router-link to="/login">Log In</router-link>
          </b-navbar-brand>
          <b-navbar-brand >
            <router-link to="/reg">Sign In </router-link>
          </b-navbar-brand>
          <b-navbar-brand >
            <b-button variant="primary" @click="LogOut()">
              LogOut 
            </b-button> 
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
  data() {
    return{
      user: '',
    }
  },
  created: function(){
    axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(res => (this.user = res.data))
      .catch(console.log("currentUser"))
  },
  methods: {
    LogOut() {
      var user={
        username: this.user.username,
          password: this.user.password,
          sex: this.user.sex,
          userRole: this.user.userRole,
          firstname: this.user.firstname,
          lastname: this.user.lastname
      }
      axios
        .post('http://localhost:8080/RACompany/rest/logout', user)
        .catch(console.log("logout"))
    },

  }
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>