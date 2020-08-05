<template>
    <div>
        <b-list-group v-for="temp in this.users" :key="temp.username">
            <b-list-group-item button>{{temp.username}}</b-list-group-item>
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
        
    },
    methods :{
        getAllUsers(){
            Axios
            .get('http://localhost:8080/rest/users/allUsers')
            .then(response => (this.users = response.data))
            .catch(console.log("greska pri dobavljanju korisnika"))
        }

    },
    mounted (){
       // this.getAllUsers();
    }
}
</script>

<style scoped>

</style>