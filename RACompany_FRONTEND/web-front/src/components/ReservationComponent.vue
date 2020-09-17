<template>
    <div>
        <b-form @submit.prevent="onSubmit()">
            <b-form-group id="input-aprtment-id" label="Apartment id" label-for="input-reservation-apartment">
                <b-form-input id="input-reservation-apartment" v-model="reservation.reservedAppatment.id" :disabled="role === 'ADMIN'" />
            </b-form-group>
            <b-form-group id="input-guest-username" label="Guest username" label-for="input-reservation-guest">
                <b-form-input id="input-reservation-guest" v-model="reservation.guest.username" :disabled="role === 'ADMIN'" />
            </b-form-group>
            <b-form-group id="input-group-startDate" label="Start date" label-for="input-reservation-startdate">
                <b-form-datepicker id="input-reservation-startdate" v-model="startDate" :disabled="role === 'ADMIN'"  />
            </b-form-group>
            <b-form-group id="input-group-nightNumber" label="Number of nights" label-for="input-reservation-nightNumber">
                <b-form-input id="input-reservation-nightNumber" v-model="reservation.nightNumber" :disabled="role === 'ADMIN'" />
            </b-form-group>
            <b-form-group id="input-group-price" label="Final price" label-for="input-reservation-price">
                <b-form-input id="input-reservation-price" v-model="reservation.price" :disabled="role === 'ADMIN'" />
            </b-form-group>
            <b-form-group id="input-group-message" label="Message" label-for="input-reservation-message">
                <b-form-input id="input-reservation-message" v-model="reservation.message" :disabled="role === 'ADMIN'" />
            </b-form-group>
            <b-form-group id="input-group-status" label="Reservation status" label-for="input-reservation-status">
                <b-form-select id="input-reservation-status" v-model="reservation.status" :disabled="role === 'ADMIN'" :options="filterStatues"/>
            </b-form-group>

            <b-button @click="onSubmit" :hidden="role === 'ADMIN'">Submit</b-button>
            
        </b-form>
    </div>
</template>

<script>
import Axios from 'axios'
export default {
    name : 'ReservationComponent',
    props : {
        reservation  : {
            type : Object
        },
        role : {
            type : String
        },
        
    },
    data(){
        return {
            startDate : new Date(this.reservation.startDate),
            statuses : [
                "CREATED",
                "DENIED",
                "CANCELED",
                "ACCEPTED",
                "FINISHED"
                
            ]
        }
    },
    methods :{
        onSubmit(){
            Axios
            .put('http://localhost:8080/RACompany/rest/reservation/modify/'+this.reservation.id,this.reservation)
            .then(response => (console.log(response)))
            .catch(error => (console.log(error)));

        }
    },
    computed :{
        filterStatues(){
            let data = this.statuses;
            if(this.reservation.status === "CREATED" && this.role === "HOST"){
                data =["ACCEPTED","DENIED","CREATED"];
            }
            if(this.reservation.status === "ACCEPTED" && this.role === "HOST" && this.dateCompare){
                data = ["ACCEPTED", "FINISHED"];
                console.log(this.dateCompare)

            }
            if(this.reservation.status === "FINISHED" && this.role === "HOST"){
                data = ["FINISHED"];
            }
            

            return data;
        },
        dateCompare(){
            let currentDate = new Date();
            let endDate = new Date(this.reservation.startDate + (this.reservation.nightNumber * 86400*1000)); //datum zavrsetka rezervacije
           
            if(endDate.getTime() <= currentDate.getTime()){ //poredjenje trenutnog datuma i datuma kraja rezervacije
                
                return true;
            }
            return false;
        }
    }
    
}
</script>

<style scoped>

</style>