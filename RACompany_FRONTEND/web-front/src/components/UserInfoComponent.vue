<template>
    <div>
        <h1>UserInfoComponent</h1>
        <div class="position">
            <b-form @submit.prevent="onSubmit" method="post">
                <b-form-group 
                    id="input-group-1"
                    label="Password:"
                    label-for="input-1">
                    <b-form-input
                    id="input-1"
                    v-model="user.password"
                    type="password"
                    required
                    placeholder="Enter password"
                    ></b-form-input>
                </b-form-group>

            <b-form-group 
                id="input-group-3" 
                label="Your firstname:" 
                label-for="input-3"
                >
                <b-form-input
                id="input-3"
                v-model="user.firstname"
                required
                placeholder="Enter firstname"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4"  label="Your lastname:" label-for="input-4" >
                <b-form-input  id="input-4"   v-model="user.lastname" required  placeholder="Enter lastname" >
               </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Sex:" label-for="input-5">
                <b-form-select
                id="input-5"
                v-model="user.sex"
                :options="sexes"
                required
                ></b-form-select>
            </b-form-group>
            <b-button type="submit">
                <router-link to="/">Submit</router-link>
            </b-button>
            </b-form>
        </div>
    </div>
</template>


<script>
import Axios from 'axios'
export default {
    name : 'UserInfoComponent',
    props : {
        user :{
            type : Object, //validacija tipa koji se prenosi
            required : true //validacija da li je potreban
        }
    },
    data(){
        return {
            newUser : {
                username : '',
                password : '',
                firstname : '',
                lastname : '',
                sex : ''
            },
            sexes: [
            'Male',
            'Female'
            ]
        }
    },
    methods :{
        submintModifiedUser() {
            this.newUser.password = this.user.password
            this.newUser.firstname = this.user.firstname
            this.newUser.lastname = this.user.lastname
            this.newUser.sex = this.user.sex

            this.newUser.username = this.user.newUser

            Axios
            .put()
            .then()
            .catch(console.log("modifikacija nije prosla"))
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