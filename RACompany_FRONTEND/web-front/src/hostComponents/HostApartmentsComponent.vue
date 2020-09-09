<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button v-b-modal.modal  @click="selectApartment(apartment)">{{apartment.id}}</b-list-group-item>
        </b-list-group>
        <div>
            <b-button type="primary" @click="createNewApartment" v-b-modal.modal>Create new apartment</b-button>
        </div>

        <b-modal id="modal" scrollable >
           <ApartmentComponent v-bind:apartment="selectedApartment"/>
        </b-modal>
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
        }
    },
    data(){
        return {
            selectedApartment : {
                id : 2,
                type : '',
                roomNumber : '',
                guestNumber : '',
                apartmentLocation : {},
                apartmentResevartionDates : [],
                comments : [],
                pricePerNight : 0.0,
                checkInTime : '',
                checkOutTime : '',
                apartmentStatus : false,
                amenities : [],
                reservations : [],
                imageSource : []
            }
        }
    },
   
    methods :{
        selectApartment(apartment)  {
            console.log(apartment);
            this.selectedApartment = apartment;
            console.log(this.selectedApartment);

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
                checkInTime : new Date(),
                checkOutTime : new Date(),
                apartmentStatus : false,
                amenities : [],
                reservations : [],
                imageSource : []
            }


            this.selectedApartment = emptyApartment;
            this.getAllAmenities();
           
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