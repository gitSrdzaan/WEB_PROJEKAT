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
                <LocationComponent v-bind:apartmentLocation="apartment.apartmentLocation"  id="input-5"/><!--Two way binding-->
            </b-form-group>

            <b-form-group id="input-group-6" label="Available dates" label-for="input-6" >
                <FunctionalCalendar  v-model="calendarData" :configs="calendarConfigs"
                @choseDay="dayClicked" @selectedDaysCount="daysCount" id="input-6"/>
            </b-form-group>

            <b-form-group id="input-group-7" label="Price per night" label-for="input-7">
                <b-form-input id="input-7" v-model="apartment.pricePerNight" type="number" 
                step="0.0001" placeholder="Entert price per night"/>
            </b-form-group>

            <b-form-group id="input-group-8" label="Check in time" label-for="input-8">
                <b-time v-model="checkInTime" id="input-8" locale="en"/>
            </b-form-group>
            <b-form-group id="input-group-9" label="Check out time" label-for="input-9">
                <b-time v-model="checkOutTime" id="input-9" locale="en"/>
            </b-form-group>

            <b-form-group id="input-group-10" label="Apartment amenities" label-for="input-10">
                <div>
                    <b-list-group v-for="amenity in this.amenities" :key="amenity.id">
                        <input type="checkbox" :id="amenity.id + '-' + amenity.name" name="CheckBoxInputName"
                         @click="checkBoxClicked(amenity,$event)" />
                        <b-list-group-item label :for="amenity.id">{{amenity.name}}</b-list-group-item>
                        
                    </b-list-group>
                </div>
               
            </b-form-group>

            <b-form-group id="input-group-11" label="Apartment status" label-for="input-11">
                <b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=true>Active</b-form-radio>
                <b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=false>Not-Active</b-form-radio>
            </b-form-group>

            <b-form-group id="input-group-12" lable="Apartment pictures" label-for="input-12">
                <span v-for="source in apartment.imageSource" :key="source">
                    <img  
                        :src="getImage(source)"  fluid :alt="source"  style="width : 100px;height : 100px"/>
                </span>
                <input id="input-group-12" type="file" @change="chooseImages" multiple 
                accept="image/*"/>
            </b-form-group>
            
            <div v-for="comment in apartment.comments" :key="comment">
                <div class="mt-2">Comment: {{ comment.text }}</div>
                <div class="mt-2">Grade: {{ comment.grade }}</div>
                <div class="mt-2">Visibility: {{comment.visible}}</div>
                <b-button @click="SaveComment(comment)">
                    Allow
                </b-button>
            </div>

            <b-form-group id="submitBtn">
                <b-button type="submit"> Submit</b-button>
            </b-form-group>     


        </b-form>
        <b-button type="warning" @click="deleteApartment($event)">Delete apartment</b-button>


    </div>
</template>

<script>

import LocationComponent from "../components/LocationComponent"

import {FunctionalCalendar} from 'vue-functional-calendar';
import Axios from 'axios';



export default {
    components:{
        LocationComponent,
        
        FunctionalCalendar
    },
    props : {
         apartment : {
               type : Object
            },
            amenities :{
                type : Array
            }
    },
    data(){
        return {
           
            types : [
                "FULL",
                "ROOM"
            ],
            
            images : [],
            calendarData : {},
            calendarConfigs : {
                sundayStart : false,
                dataFormat : 'dd/mm/yyyy',
                limits : false,
                isDatePicker : true,
                isDateRange : true,
                isMultipleDatePicker : true,
                isMultiple : false,
                withTimePicker : false,
                isDark : true,
                markedDateRange : [],
                markedDates : []
                //isModal : true
            },
            daysNumber : 0,
            startDate : null,
            endDate : null,
            dateRange : {
                start : false,
                end : false
            },
            checkInTime : '14:00:00',
            checkOutTime : '10:00:00',
            imageSources : [],
            
        }
        
    },
    methods : {
        onSubmit(event){
            event.prevent;
            this.uploadImages();
            this.setApartmentDates();
            this.getCheckIOTime();


            console.log(this.apartment);

            if(this.apartment.id != ""){
                Axios
                .put('http://localhost:8080/RACompany/rest/apartment/modify/'+this.apartment.id, this.apartment)
                .then(response => (alert("Successfull change of apartment " + response.statusText)));

            }
            else{
                
                Axios
                .post('http://localhost:8080/RACompany/rest/apartment/new', this.apartment)
                .then(response => (alert("Successfull creation of apartment " + response.statusText)));
            }

            this.$emit('input');
        },
        deleteApartment(event){
            event.prevent;

            Axios
            .delete("http://localhost:8080/RACompany/rest/apartment/delete/"+this.apartment.id)
            .then(response =>(alert("Successfull delete of apartment " + response.statusText)));

             this.$emit('remove');
        },

        SaveComment(comment){
            let temp = comment.visible;
            comment.visible = !temp;
            
            Axios.put("http://localhost:8080/RACompany/rest/apartment/commentVisibility/"+ this.apartment.id, comment)
            .then(response => (alert("Successfull change of comment visibility " + response.statusText)
            ));
        },
        
        checkBoxClicked(value,event){
             let temp = {

                    id : value.id,
                    name : value.name
            }
            if(event.target.checked){
              
               
                this.apartment.amenities.push(temp);
            }
            else{
                for(let a in this.apartment.amenities){
                    if(this.apartment.amenities[a].id === temp.id){
                       
                        this.apartment.amenities.splice(a,1);
                    }
                }


            }

        },
        //#region odabir slike i upload slike
        chooseImages(event){          
            let length = event.target.files.length;
            for(let i=0; i < length; i++){
                this.images.push(event.target.files[i]);
            }
            
           

        },
        uploadImages(){
            for(let image in this.images) {
                this.apartment.imageSource.push(this.images[image].name);
            }
           
        },
        //#endregion
        //#region funckije za citanje datuma iz kalendara
        dayClicked(value){
            if(this.daysNumber === 0){
                this.startDate = value;
                this.startDate.isDateRangeStart = true;
                this.dateRange.start =  this.startDate.date;
                
            }
            else{
                this.endDate = value;
                this.endDate.isDateRangeEnd = true;
                this.dateRange.end = this.endDate.date;
                this.calendarConfigs.markedDateRange.push(this.dateRange);
                
                this.markDatesFromRange();
                this.daysNumber = 0;
            }
            

        },
        daysCount(value){
            this.daysNumber = value;
        },
        markDatesFromRange(){
          
            let dateIter = this.startDate.date;
            let [day,month,year] = dateIter.split("/");
            dateIter = new Date(year,month,day);
             
            for(let i = 0; i < this.daysNumber; i++){  
              
                           
                let markDate = dateIter.getDate() + "/" + dateIter.getMonth() + "/" + dateIter.getFullYear();
                this.calendarConfigs.markedDates.push(markDate);
                dateIter.setDate(dateIter.getDate() + 1);
                
            }
           
        },
        //#endregion
        //#region podesavanje datuma i vremena ulazska/izlaska apartmana 
        setApartmentDates(){
            for(let i = 0 ; i < this.calendarConfigs.markedDates.length ; i++){
                let [day,month,year] = this.calendarConfigs.markedDates[i].split("/");
                let markDate = new Date(year,month,day);
                
                this.apartment.apartmentResevartionDates.push({
                    date : markDate.getTime(),
                    status : false
                });
            }
        },
        getApartmentDates(){
            
            for(let index in this.apartment.apartmentResevartionDates){
                let date = new Date(this.apartment.apartmentResevartionDates[index].date);
               
                
                let markDate = date.getDate() + "/" + date.getMonth() + "/" + date.getFullYear();
                this.calendarConfigs.markedDates.push(markDate);
                


            }

        },
        getCheckIOTime(){
            let [hour,minutes,seconds] = this.checkInTime.split(":");
            
            this.apartment.checkInTime = new Date(2020, 1,1,hour,minutes,seconds);
            
            [hour, minutes, seconds] = this.checkOutTime.split(":");
            
           this.apartment.checkOutTime = new Date(2020,1,1,hour,minutes,seconds);
        },
        setCheckIOTime(milliseconds){

            if(milliseconds === null){
                return 0;
            }

            let date = new Date(milliseconds);
            let hour = date .getHours();
            let minutes = date .getMinutes();
            let seconds = date .getSeconds();

            return hour + ":" + minutes + ":" + seconds;


        },
        //#endregion kraj podesavanja datuma apartmana
        
        checkedAmenities(){
            for(let i in this.amenities){
                for(let j in this.apartment.amenities){
                    if(this.amenities[i].id === this.apartment.amenities[j].id){
                        //ne radi jer nije renderovan html
                       document.getElementById(this.amenities[i].id+"-"+this.amenities[i].name).checked = true;
                    }
                }
            }
        },
        getImage(source){
           
             return require("../data/images/"+source);
        }

    },
    created () {
        this.checkInTime = this.setCheckIOTime(this.apartment.checkInTime);
        if(this.checkInTime === 0){
            this.checkInTime = "14:00:00";
        }
        this.checkOutTime = this.setCheckIOTime(this.apartment.checkOutTime);
        if(this.checkOutTime === 0){
            this.checkOutTime = "10:00:00";
        }
        this.getApartmentDates();
        

        this.imageSources = this.apartment.imageSource;
        
        //sadrzaj apartmana
       
        

       
    },
    mounted(){
        this.checkedAmenities();

    }


}
</script>

<style scoped>

</style>