<template>
    <div>

        <div>
            <b-form>
                 <b-form-group id="input-group-type" label="Type" label-for="input-type">
                    <b-form-select id="input-type" v-model="type" :options="types" />
                </b-form-group>
                <b-form-group id="input-group-status" label="Status" label-for="input-status">
                    <b-form-select id="input-status" v-model="status" :options="statuses" />
                </b-form-group>
                <b-form-group id="input-group-amenities" label="Amenities" label-for="input-amenities">
                    <b-form-select id="input-amenities" v-model="amenity" :options="getAmenitiesNames" />
                </b-form-group>
            </b-form>
        </div>

        <b-button @click="sortMethod">{{ sortOrder}}</b-button>

        <b-list-group v-for="apartment in filterApartments" :key="apartment.id">
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
            amenities : [],
            sortOrder : 'Descending order',
            sort : 'desc',
            type : '',
            types : [
                "FULL",
                "ROOM",
                ""
            ],
            status : null,
            statuses : [
                "Active",
                "Not-Active",
                ""
            ],
            amenity : "",
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
             
        
        },
        sortMethod(){
            if(this.sort === 'asc'){
                this.sortOrder = "Ascending order";
                this.sort = "desc";
            }else{
                this.sortOrder = 'Descending order';
                this.sort = 'asc';
            }
        }
    },
    created : function(){
        this.getAllAmenities();
    },
    computed :{
        filterApartments(){
            let data = this.apartments;
            if(this.sort === 'asc'){
                data = data.sort(function(a,b){
                    return  a.pricePerNight-b.pricePerNight
                });
            
            }
            if(this.sort === 'desc'){
                data = data.sort(function(a,b){
                    return  b.pricePerNight-a.pricePerNight
                });
            }

            if(this.type != ''){
                data = data.filter(item =>
                String(item.type).match(this.type));
            }
            if(this.status != ''){
                let filter = false;
                if(this.status === "Active"){
                    filter = true;
                }
                data = data.filter(item =>
                (item.apartmentStatus === filter));
            }
            if(this.amenity != ''){
                data = data.filter(item =>
                {
                    for(let iter in item.amenities){
                        
                        if(item.amenities[iter].name === this.amenity){
                           
                            return item;
                        }
                        
                    }
                    
                }
                )
            }

            return data;
        },
        getAmenitiesNames(){
            let names = [];
            for(let iter in this.amenities){
                names.push(this.amenities[iter].name);
            }

            names.push("");

            return names;
        }
    }
    
}
</script>

<style scoped>

</style>