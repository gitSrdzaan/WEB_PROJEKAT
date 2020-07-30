<template>
    <div>
        <b-list-group v-for="user in users" :key="user.username">
            <b-list-group-item button>{{user.username}} </b-list-group-item>
        </b-list-group>
    </div>
</template>>

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
            users : [{username : "admin"},{username : "host"}, {username:"guest"}]
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
    mounted (){
        this.getAllUsers();
    }
}
</script>

<style scoped>

</style>