<template>
    <div>
        <h1>UserInfoComponent</h1>
        <div class="position">
            <b-form @submit.prevent="submintModifiedUser" method="post">
                <b-form-group 
                    id="input-group-1"
                    label="Password:"
                    label-for="input-1">
                    <b-form-input
                    id="input-1"
                    v-model="this.user.password"
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
                v-model="this.user.firstname"
                required
                placeholder="Enter firstname"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4"  label="Your lastname:" label-for="input-4" >
                <b-form-input  id="input-4"  
                 v-model="this.user.lastname" 
                required 
                 placeholder="Enter lastname" >
               </b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Sex:" label-for="input-5">
                <b-form-select
                id="input-5"
                v-model="this.user.sex"
                :options="sexes"
                required
                ></b-form-select>
            </b-form-group>
            <b-button type="submit">
               <!-- <router-link to="/">Submit</router-link>-->
               Submit
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
            password : '',
            firstname : '',
            lastname : '',
            sex : '',
            sexes: [
            'Male',
            'Female'
            ]
        }
    },
    methods :{
        submintModifiedUser() {
            this.newUser.password = document.getElementById("input-1").value;
            this.newUser.firstname = document.getElementById("input-3").value;
            this.newUser.lastname = document.getElementById("input-4").value;
            this.newUser.sex = document.getElementById("input-5").value;


            this.newUser.username = this.user.username;
            this.newUser.userRole = this.user.userRole;
            console.log(this.newUser);

            let path = 'http://localhost:8080/RACompany/rest/users/modify';
            
            

            

            Axios
            .put(path,this.newUser)
            .then(response => (response))
            .catch(console.log("modifikacija nije prosla"))

            
        }
    },
    created (){
        
        
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