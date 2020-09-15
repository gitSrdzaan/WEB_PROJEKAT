<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item li  @click="selectApartment(apartment)">{{apartment.id}}
                 <ApartmentComponent v-bind:apartment="selectedApartment" v-if="selectedApartment.id === apartment.id && showApartment"
                v-on:remove="deleteApartment(selectedApartment.id)" v-on:input="closeComponent()" v-bind:amenities="amenities"/>
            </b-list-group-item>
        </b-list-group>
       

        

    </div>
</template>

<script>
import Axios from 'axios';
import ApartmentComponent from "../components/ApartmentComponent"

export default {
    name : "ViewAllApartments",
    props : {
        apartments : {
            type : Array,
            required : true
        },
        
    },
    components : {
        ApartmentComponent
    },
    data(){
        return{
            selectedApartment : {},
            showApartment : false,
            amenities : []
        }
    },
    methods :{
        selectApartment(apartment){
             this.getAllAmenities();
            this.selectedApartment = apartment;
           
            this.showApartment = true;
        },
        deletedApartmen(id){
            this.apartments.splice(id-1,1);
            this.$emit('update');
        },
        closeComponent(){
            this.showApartment = false;
            this.$emit('update');
        },
        getAllAmenities : function(){
             Axios
            .get('http://localhost:8080/RACompany/rest/amneities/all')
            .then(response => (this.amenities = response.data))
        },

    },
    created :function(){
        this.getAllAmenities();

    }
    
}
</script>



<style scoped>

</style>