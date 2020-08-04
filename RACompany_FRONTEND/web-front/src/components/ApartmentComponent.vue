<template>
    <div>
        <b-form @submit.prevent="onSubmit">
            <b-form-group id="input-group-1" label="Apartment id" label-for="input-1">
                <b-form-input id="input-1" v-model="apartment.id" type="text" placeholder="Entert id"/>
            </b-form-group>
            <b-form-group id="input-group-2" label="Apartment type" label-for="input-2">
                <b-form-select id="input-2" v-model="apartment.type" :options="types" required/>
            </b-form-group> 
            <b-form-group id="input-group-3" label="Number of rooms" label-for="input-3">
                <b-form-input id="input-3" v-model="apartment.roomNumber" type="number" placeholder="Entert number of rooms"/>
            </b-form-group>
            <b-form-group id="input-group-4" label="Number of guests" label-for="input-4">
                <b-form-input id="input-4" v-model="apartment.guestNumber" type="number" placeholder="Entert number of guests"/>
            </b-form-group>
            <b-form-group id="input-group-5" label="Location" label-for="input-5">
                <LocationComponent v-model="apartment.apartmentLocation" id="input-5"/><!--Two way binding-->
            </b-form-group>
            <b-form-group id="input-group-6" label="Available dates" label-for="input-6" >
                <b-calendar id="input-6"/>
            </b-form-group>
            <b-form-group id="input-group-7" label="Price per night" label-for="input-7">
                <b-form-input id="input-7" v-model="apartment.pricePerNight" type="number" step="0.0001" placeholder="Entert price per night"/>
            </b-form-group>

            <b-form-group id="input-group-8" label="Check in time" label-for="input-8">
                <b-time v-model="apartment.checkInTime" id="input-8" locale="en"/>
            </b-form-group>
            <b-form-group id="input-group-9" label="Check out time" label-for="input-9">
                <b-time v-model="apartment.checkOutTime" id="input-9" locale="en"/>
            </b-form-group>

            <b-form-group id="input-group-10" label="Apartment amenities" label-for="input-10">
                <b-button type="primary">Choose amenities</b-button>
                <div>
                    <b-list-group v-for="amenity in this.amenities" :key="amenity.id">
                        <b-list-group-item label>{{amenity.name}}</b-list-group-item>
                        <input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox1"/>
                    </b-list-group>
                </div>
                <ListAmenitiesComponent id="input-10"/>
            </b-form-group>

            <b-form-group id="input-group-11" label="Apartment status" label-for="input-11">
                <b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=true>Active</b-form-radio>
                <b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=false>Not-Active</b-form-radio>
            </b-form-group>

            <b-form-group id="submitBtn">
                <b-button type="submit">
                    Submit
                </b-button>
            </b-form-group>


        </b-form>
    </div>
</template>

<script>

import LocationComponent from "../components/LocationComponent"
import ListAmenitiesComponent from "../components/ListAmenitiesComponent"
import Axios from 'axios'

export default {
    components:{
        LocationComponent,
        ListAmenitiesComponent
    },
    data(){
        return {
            apartment : {
                id : '',
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
                imageSource : ''
            },
            types : [
                "FULL",
                "ROOM"
            ],
            amenities : [{id : 1, name : 'name'},{id : 2, name : 'name'}]
        }
    },
    methods : {
        onSubmit(event){
            event.prevent;
            console.log(this.apartment)

        }
    },
    created : {
        getAllAmenities : function(){
            Axios
            .get('http://localhost:8080/RACompany/rest/amneities/all')
            .then(response => (this.amenities = response.data))
        }
    }


}
</script>

<style scoped>

</style>