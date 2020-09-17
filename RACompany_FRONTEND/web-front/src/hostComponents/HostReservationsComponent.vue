<template>
    <div>
        <b-list-group v-for="reservation in reservations" :key="reservation.id">
            <b-list-group-item li  @click="selectReservation(reservation)">{{reservation.id}}
                <ReservationComponent v-bind:reservation="reservation" v-if="selectedReservation.id === reservation.id"
               v-bind:role="role"/>
            </b-list-group-item>
        </b-list-group>
    </div>
</template>

<script>
import ReservationComponent from "../components/ReservationComponent"
export default {
    name : "ViewAllReservations",
    components :{
        ReservationComponent
    },
    props : {
        reservations : {
            type : Array
        },
        role : {
            type : String
        }
    },
    data(){
        return {
            selectedReservation : {

            },
            startDate : new Date(),
            user : {

            }
        }
    },
    methods :{
        selectReservation(reservation){
            this.selectedReservation = reservation;
        }
    }
    
    
}
</script>

<style scoped>

</style>