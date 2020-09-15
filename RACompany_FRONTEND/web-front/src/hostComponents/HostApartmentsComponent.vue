<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item li   @click="selectApartment(apartment)" >{{apartment.id}}
                 <ApartmentComponent v-bind:apartment="selectedApartment" v-if="selectedApartment.id === apartment.id && showUpdApartment" v-on:remove="deleteApartment(selectedApartment.id)" 
                 v-on:input="closeComponent()"  v-bind:amenities="amenities"/>
            </b-list-group-item>
           

        </b-list-group>
        <div>
            <b-button type="primary" @click="createNewApartment" >Create new apartment</b-button>
        </div>
        <ApartmentComponent v-bind:apartment="selectedApartment" v-if="showNewApartment"  v-on:input="closeComponent()"
        v-bind:amenities="amenities"/>

    
        
        
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
        host : {
            type : Object
        }      
    },
    data(){
        return {
            selectedApartment : {     
                      
            },
            showNewApartment : false,
            showUpdApartment : false,
            amenities : []
        }
    },
   
    methods :{
        selectApartment(apartment)  {
            
            this.selectedApartment = apartment;
            //this.getAllAmenities();
            this.showNewApartment = false;
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
                amenities : [],
                reservations : [],
                imageSource : [ "../../data/images/deborah-cortelazzi-gREquCUXQLI-unsplash.jpg", "../../data/images/nathan-fertig-FBXuXp57eM0-unsplash.jpg"]
            }


            this.selectedApartment = emptyApartment;
           // this.getAllAmenities();
            this.selectedApartment.apartmentHost = this.host;
            
            
            
            this.showNewApartment = true;
           
        },
        getAllAmenities : function(){
            Axios
            .get('http://localhost:8080/RACompany/rest/amneities/all')
            .then(response => (this.amenities = response.data))
            
           
        },
        deleteApartment(id){
            this.apartments.splice(id-1,1);
            this.$emit('update');
        },
        closeComponent(){
            this.showNewApartment = false;
            this.showUpdApartment = false;
            this.$emit('update');
             
        
        }
    },
    created : function(){
        this.getAllAmenities();
    }
    
}
</script>

<style scoped>

</style>