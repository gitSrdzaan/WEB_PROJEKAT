<template>
    <div>
        <b-form>
            <b-form-group id="input-group-1" label="Apartment id" label-for="input-1">
                <b-form-input id="input-1" v-model="apartment.id" type="text" placeholder="Entert id"/>
            </b-form-group>
            <b-form-group id="input-group-2" label="Apartment type" label-for="input-2">
                <b-form-select id="input-2" v-model="apartment.type" :options="types" required="true"/>
            </b-form-group> 
            <b-form-group id="input-group-3" label="Number of rooms" label-for="input-3">
                <b-form-input id="input-3" v-model="apartment.roomNumber" type="number" placeholder="Entert number of rooms"/>
            </b-form-group>
            <b-form-group id="input-group-4" label="Number of guests" label-for="input-4">
                <b-form-input id="input-4" v-model="apartment.guestNumber" type="number" placeholder="Entert number of guests"/>
            </b-form-group>
            <b-form-group id="input-group-5" label="Location" label-for="input-5">
                <LocationComponent id="input-5"/>
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

            <b-form-group id="input-group-10" label="Apartment amenitie" label-for="input-10">
                <ListAmenitiesComponent id="input-10"/>
            </b-form-group>

            <b-form-group id="input-group-11" label="Apartment status" label-for="input-11">
                <b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=true>Active</b-form-radio>
                <b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=false>Not-Active</b-form-radio>
            </b-form-group>

        </b-form>
    </div>
</template>

<script>

import LocationComponent from "../components/LocationComponent"
import ListAmenitiesComponent from "../components/ListAmenitiesComponent"

export default {
    components:{
        LocationComponent,
        ListAmenitiesComponent
    },
    data(){
        return {
            apartment : {},
            types : [
                "FULL",
                "ROOM"
            ]
        }
    }


}
</script>

<style scoped>

</style>