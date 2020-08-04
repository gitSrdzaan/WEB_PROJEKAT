<template>
  <div class="position">
    <b-form >
      <b-form-group 
        id="input-group-1"
        label="Password:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.password"
          type="password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>

      <b-form-group 
        id="input-group-2" 
        label="Username:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="form.name"
          type="text"
          required
          placeholder="Enter username"
        ></b-form-input>
      </b-form-group>

       <b-button @click="login()">
         LogIn
       </b-button>
      
    </b-form>
  </div>
</template>

<script>
import AuthService from '../service/AuthService'

  export default {
    data() {
      return {
        form: {
          password: '',
          name: ''
        },
        msg: ''
      }
    },
    methods: {
      async login() {
        try{
        const credentials = {
          username: this.form.name,
          password: this.form.password
        }
        await AuthService.login(credentials);

        this.$router.push('/');
        this.$router.go();
        }catch (e){
          this.msg = e.response.data
        }
      }
      
    
    }
  }
</script>

<style scoped>

.position{
  width: 25%;
  height: 100%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 80px;
  
}

</style>