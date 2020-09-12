<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button   @click="selectApartment(apartment)" >{{apartment.id}}
                 <ApartmentComponent v-bind:apartment="selectedApartment" v-if="selectedApartment.id === apartment.id && showUpdApartment" v-on:remove="deleteApartment(selectedApartment.id)" 
                 v-on:input="closeComponent()" />
            </b-list-group-item>
           

        </b-list-group>
        <div>
            <b-button type="primary" @click="createNewApartment" >Create new apartment</b-button>
        </div>
        <ApartmentComponent v-bind:apartment="selectedApartment" v-if="showNewApartment"  v-on:input="closeComponent()"/>

    
           
        
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
            showNewApartment : false,
            showUpdApartment : false
        }
    },
   
    methods :{
        selectApartment(apartment)  {
            console.log(apartment);
            this.selectedApartment = apartment;
            console.log(this.selectedApartment);
            this.showApartment = false;
            this.showUpdApartment = true;
           

        },
        createNewApartment(){
             let emptyApartment = {
                id : '',
                type : '',
                roomNumber : 0,
                guestNumber : 0,
                apartmentLocation : {
                    longitude : '',
                    latitude : '',
                    adress : {
                        street : '',
                        number : 0,
                        city : '',
                        postalCode : 0
                    }
                },
                apartmentResevartionDates : [],
                comments : [],
                pricePerNight : 0.0,
                checkInTime : null,
                checkOutTime : null,
                apartmentStatus : false,
               
                reservations : [],
                imageSource : []
            }


            this.selectedApartment = emptyApartment;
            this.getAllAmenities();
            this.selectedApartment.apartmentHost = this.host;
            
            
            this.showApartment = true;
           
        },
        getAllAmenities : function(){
            Axios
            .get('http://localhost:8080/RACompany/rest/amneities/all')
            .then(response => (this.selectedApartment.amenities = response.data))
        },
        deleteApartment(id){
            this.apartments.splice(id-1,1);
        },
        closeComponent(){
            this.showNewApartment = false;
            this.showUpdApartment = false;
           
             
        
        }
    }
    
}
</script>

<style scoped>

</style>