<template>
    <div>
        <b-form>
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
                <b-form-input id="input-reservation-status" v-model="reservation.status" :disabled="role === 'ADMIN'"/>
            </b-form-group>
            
        </b-form>
    </div>
</template>

<script>
export default {
    name : 'ReservationComponent',
    props : {
        reservation  : {
            type : Object
        },
        role : {
            type : String
        }
    },
    data(){
        return {
            startDate : new Date(this.reservation.startDate)
        }
    }
    
}
</script>

<style scoped>

</style>