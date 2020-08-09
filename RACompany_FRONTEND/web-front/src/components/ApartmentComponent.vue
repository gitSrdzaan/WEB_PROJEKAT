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
				<LocationComponent v-bind:apartmentLocation="apartment.apartmentLocation" id="input-5"/><!--Two way binding-->
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
				<b-time v-model="apartment.checkInTime" id="input-8" locale="en"/>
			</b-form-group>
			<b-form-group id="input-group-9" label="Check out time" label-for="input-9">
				<b-time v-model="apartment.checkOutTime" id="input-9" locale="en"/>
			</b-form-group>

			<b-form-group id="input-group-10" label="Apartment amenities" label-for="input-10">
				<b-button type="primary">Choose amenities</b-button>
				<div>
					<b-list-group v-for="amenity in this.amenities" :key="amenity.id">
						<input type="checkbox" :id="amenity.id" name="CheckBoxInputName"
						 @click="checkBoxClicked(amenity,$event)" />
						<b-list-group-item label :for="amenity.id">{{amenity.name}}</b-list-group-item>
						
					</b-list-group>
				</div>
				<ListAmenitiesComponent id="input-10"/>
			</b-form-group>

			<b-form-group id="input-group-11" label="Apartment status" label-for="input-11">
				<b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=true>Active</b-form-radio>
				<b-form-radio v-model="apartment.apartmentStatus" name="some-radios" value=false>Not-Active</b-form-radio>
			</b-form-group>

			<b-form-group id="input-group-12" lable="Apartment pictures" label-for="input-12">
				<input id="input-group-12" type="file" @change="chooseImages" multiple
				accept="image/*"/>
			</b-form-group>

			<b-form-group id="submitBtn">
				<b-button type="submit"> Submit</b-button>
			</b-form-group>     

		</b-form>
	</div>
</template>

<script>

import LocationComponent from "../components/LocationComponent"
import ListAmenitiesComponent from "../components/ListAmenitiesComponent"
import {FunctionalCalendar} from 'vue-functional-calendar';
import Axios from 'axios';


export default {
	components:{
		LocationComponent,
		ListAmenitiesComponent,
		FunctionalCalendar
	},
	props : {
		 apartment : {
			   type : Object
			   
			}


	},
	data(){
		return {
		   
			types : [
				"FULL",
				"ROOM"
			],
			amenities : [{id : 1, name : 'name'},{id : 2, name : 'name'}],
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
			}
		}
		
	},
	methods : {
		onSubmit(event){
			event.prevent;
			this.uploadImages();
			this.setApartmentDates();
			console.log(this.apartment)
			Axios
			.post("http/localhost:8080/RACompany/rest/apartment/new",this.apartment)
			.catch(console.log("greska pri kreiranju apartmana"));

			

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
		setApartmentDates(){
			for(let i = 0 ; i < this.calendarConfigs.markedDates.length ; i++){
				let [day,month,year] = this.calendarConfigs.markedDates[i].splite("/");
				let markDate = new Date(year,month,day);
				
				this.apartment.apartmentResevartionDates.push({
					date : markDate.getTime(),
					status : false
				});
			}
		}
	},
	created () {
	   
	}


}
</script>

<style scoped>

</style>