<template>
    <div>
        <div>
            <b-form >
                <b-form-group id="input-group-role" label="Role" label-for="input-role">
                    <b-form-select id="input-role" v-model="role" :options="roles" />
                </b-form-group>
                <b-form-group id="input-group-sex" label="Sex" label-for="input-sex">
                    <b-form-select id="input-sex" v-model="sex" :options="sexes" />
                </b-form-group>
                <b-form-group id="input-group-username" label="Username" label-for="input-username">
                    <b-form-input id="input-username" v-model="username" />
                </b-form-group>
            </b-form>
        </div>


        <b-list-group v-for="temp in filterUsers" :key="temp.username" :id="temp.username">
            <b-list-group-item li>{{temp.username}}</b-list-group-item>
        </b-list-group>
    </div>
</template>>

<script>
import Axios from 'axios'
export default {
    name : 'ViewAllUsers',
    props : {
        user :{
            type : Object, //validacija tipa koji se prenosi
            required : true //validacija da li je potreban
        },
        users :{
            type : Array
        }
    },
    data(){
        return {
            role : '',
            roles : [
                "ADMIN",
                "GUEST",
                "HOST"
            ],
            sex : '',
            sexes : [
                "Male",
                "Female"
            ],
            username : ''
        }
        
    },
    methods :{
        getAllUsers(){
            Axios
            .get('http://localhost:8080/rest/users/allUsers')
            .then(response => (this.users = response.data))
            .catch(console.log("greska pri dobavljanju korisnika"))
        }

    },
    computed :{
        filterUsers(){
            let data = this.users;
            if(this.role != ''){
                data = data.filter(item =>
                 String(item.userRole).match(this.role));
            }
            if(this.sex != ''){
                data = data.filter(item =>
                String(item.sex).match(this.sex));
            }
            if(this.username != ''){
                data = data.filter(item =>
                String(item.username).match(this.username));
            }

            return data;
        }
    
    },
    mounted (){
       // this.getAllUsers();
    }
}
</script>

<style scoped>

</style>