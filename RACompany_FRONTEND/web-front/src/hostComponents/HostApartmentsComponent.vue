<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button   @click="selectApartment(apartment)">{{apartment.id}}
                 <ApartmentComponent v-bind:apartment="selectedApartment" v-if="selectedApartment.id === apartment.id" />
            </b-list-group-item>
           

        </b-list-group>
        <div>
            <b-button type="primary" @click="createNewApartment" >Create new apartment</b-button>
        </div>
        <ApartmentComponent v-bind:apartment="selectedApartment" v-if="showApartment"/>

    
           
        
    </div>
</template>

<script>
import ApartmentComponent from "../components/ApartmentComponent"

import Axios from 'axios'

export default {
    name : "HostApartmentsComponent",
    components : {
        ApartmentComponent
    },
    props : {
        apartments : {
            type : Array
        },
        host :{
            type : Object,
            required : true
        }
    },
    data(){
        return {
            selectedApartment : {             
            },
            showApartment : false
        }
    },
   
    methods :{
        selectApartment(apartment)  {
            console.log(apartment);
            this.selectedApartment = apartment;
            console.log(this.selectedApartment);
            this.showApartment = false;
           

        },
        createNewApartment(){
             let emptyApartment = {
                id : '',
                type : '',
                roomNumber : 0,
                guestNumber : 0,
                apartmentLocation : {},
                apartmentResevartionDates : [],
                comments : [],
                pricePerNight : 0.0,
                checkInTime : new Date(0),
                checkOutTime : new Date(0),
                apartmentStatus : false,
                amenities : [],
                reservations : [],
                imageSource : []
            }


            this.selectedApartment = emptyApartment;
            this.selectedApartment.apartmentHost = this.host;
            
            this.getAllAmenities();
            this.showApartment = true;
           
        },
        getAllAmenities : function(){
            Axios
            .get('http://localhost:8080/RACompany/rest/amneities/all')
            .then(response => (this.selectedApartment.amenities = response.data))
        }
    }
    
}
</script>

<style scoped>

</style>