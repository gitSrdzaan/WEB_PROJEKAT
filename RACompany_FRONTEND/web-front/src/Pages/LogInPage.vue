<template>
  <div class="position">
    <b-form  @submit.prevent="onSubmit()" method="post">
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

       <b-button type="submit">
         Submit
         <div v-if="false">
          <router-link to="/">Submit</router-link>
         </div>
       </b-button>
      
    </b-form>
  </div>
</template>

<script>
import axios from 'axios'

  export default {
    prop: [
      'myRole'
    ],
    data() {
      return {
        form: {
          password: '',
          name: ''
        },
        info: null
      }
    },
    methods: {
      onSubmit() {
        var user = {
          username: this.form.name,
          password: this.form.password
        }
        axios
        .post('http://localhost:8080/RACompany/rest/login',user,{
          headers : {
            'Sec-Fetch-Mode': 'no-cors',
            'Access-Control-Allow-Headers' : '*',
            'Access-Control-Allow-Credentials': true,
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT, DELETE',
            'Access-Control-Expose-Headers': '*',
            'Access-Control-Request-Method' : 'POST',
            'Access-Control-Request-Headers' : '*'
          }
        })
        
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