<template>
    <div>
        <b-form @submit.prevent="onSubmit">
            <b-form-group id="input-group-1" label= "Apratment amenity id" label-for="input-1">
                <b-form-input id="input-1" type="number" v-model="amenity.id" placeholder="Entert id"/>
            </b-form-group>
            <b-form-group id="input-group-2" label= "Apratment amenity name" label-for="input-2">
                <b-form-input id="input-2" type="text" v-model="amenity.name" placeholder="Entert name"/>
            </b-form-group>
             <b-form-group id="submitBtn">
                <b-button type="submit"> Submit </b-button>
             </b-form-group>     
        </b-form>
        <b-button type="warning" @click="deleteAmenity($event)">Delete amenity </b-button> 
    </div>
</template>

<script>
import Axios from 'axios';
export default {
    props : {
        amenity :{
            type : Object
        }
    },
    methods  : {
        onSubmit(){
            console.log(this.amenity);


            if(this.amenity.id === ''){
                Axios
                .post("http://localhost:8080/RACompany/rest/amneities/new", this.amenity)
                .then(response => (console.log(response)))
                .catch(error => (console.log(error)));
            }
            else{
                Axios
                .put("http://localhost:8080/RACompany/rest/amneities/modify/"+this.amenity.id, this.amenity)
                .then(response => (console.log(response)))
                .catch(error => (console.log(error)));
            }

            this.$emit('input');
        },
        deleteAmenity(event){
            event.prevent;
            Axios
            .delete("http://localhost:8080/RACompany/rest/amneities/delete/"+this.amenity.id)
            .then(response => (console.log(response)))
            .catch(error => (console.log(error)));

            this.$emit('remove');
        }
    }
}
</script>

<style scoped>

</style>