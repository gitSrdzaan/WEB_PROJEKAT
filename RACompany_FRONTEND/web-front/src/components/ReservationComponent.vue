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

            <div>
                <b-form-textarea
                    id="textarea"
                    v-model="comment"
                    placeholder="Enter your comment."
                    rows="3"
                    max-rows="6"
                ></b-form-textarea>

                <b-form-group id="input-group-3" label="Grade:" label-for="input-3">
                    <b-form-select
                        id="input-3"
                        v-model="grade"
                        :options="grades"
                       
                    ></b-form-select>
                </b-form-group>

                <b-button @click="Submit()">
                    Save Comment
                </b-button>
            </div>

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
                
            ],
            comment: '',
            grades: [
                'BAD',
                'GOOD',
                'EXCELLENT'
            ],
            grade: '',
            user: {}
        }
    },
    methods :{
        onSubmit(){
            Axios
            .put('http://localhost:8080/RACompany/rest/reservation/modify/'+this.reservation.id,this.reservation)
            .then(response => (console.log(response)))
            .catch(error => (console.log(error)));

        },
        Submit(){
            let comment = {
                
                guest : {},
                text: this.comment,
                grade: this.grade
            }

            Axios.put('http://localhost:8080/RACompany/rest/apartment/addComment/'+ this.user.username + '/' + this.reservation.reservedAppatment.id, comment)
        },
    },
    created(){
            Axios.get('http://localhost:8080/RACompany/rest/currentUser')
            .then(res => (this.user = res.data))
            .catch(console.log("currentUser"))
    },
    computed :{
        filterStatues(){
            let data = this.statuses;
            //#region status kod domacina
            if(this.reservation.status === "CREATED" && this.role === "HOST"){
                data =["ACCEPTED","DENIED","CREATED"];
            }
            if(this.reservation.status === "ACCEPTED" && this.role === "HOST" && this.dateCompare){
                data = ["ACCEPTED", "FINISHED"];
                
            }
           
            //#endregion
            //#region status kod gosta
            if((this.reservation.status === "CREATED" || this.reservation.status === "ACCEPTED") && this.role === "GUEST"){
                data = ["CREATED", "ACCEPTED", "CANCELED"];
            }
            //#endregion

            if(this.reservation.status === "FINISHED"){
                data = ["FINISHED"];
            }
            if(this.reservation.status === "CANCELED"){
                data = ["CANCELED"]
            }

            if(this.reservation.status === "CANCELED" && this.role === "HOST"){
                alert("Host can't cancel a reservation");
                data  = this.statuses;
                
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