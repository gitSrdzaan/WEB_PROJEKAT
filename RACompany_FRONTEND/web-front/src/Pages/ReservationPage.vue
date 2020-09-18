<template>
  <div>
      <h1>Make your reservation</h1>
      <b-container>
        <b-row>
          <b-col>
            <span v-for="source in apartments.imageSource" :key="source">
              <img :src="getImage(source)" :alt="source" style="width : 200px;height : 200px"/>
            </span>
          
          </b-col>
          <b-col>
          <b-row>
            <b-col>longitude {{ apartments.apartmentLocation.longitude }}</b-col>
            <b-col>latitude {{ apartments.apartmentLocation.latitude }} </b-col>
          </b-row>
          
          <b-row v-if="apartments.apartmentLocation.adress">
            <b-col>city: {{ apartments.apartmentLocation.adress.city }} </b-col>
            <b-col> street and street number: {{ apartments.apartmentLocation.adress.street }} {{ apartments.apartmentLocation.adress.number }}</b-col>
          </b-row>
          </b-col>
        </b-row>
        <b-row>
          <b-col></b-col>
          <b-col>
            <FunctionalCalendar v-model="calendarData" :configs ="calendarConfigs" 
            @choseDay="dayClicked" @selectedDaysCount="daysCount"/>
          </b-col>
        </b-row>
        <b-row>
          <b-col></b-col>
          <b-col></b-col>
          <b-col v-if="endDate != null">
            First day for your reservation: {{calendarData.dateRange.start}}
          </b-col>
          <b-col v-if="endDate != null">
            Last day for your reservation: {{endDate.date}}
          </b-col>
        </b-row>
        <b-row>
          <b-col></b-col>
          <b-col>Price per night: {{ apartments.pricePerNight }} </b-col>
          <b-col>Number of picked days: {{daysNumber}} </b-col>
          <b-col> Total price: {{totalPrice}} </b-col>
        </b-row>
        <b-row>

        </b-row>
        <b-col>Comment: </b-col>
          <b-col v-for="comment in apartments.comments" :key="comment.guest.username + comment.text" :hidden="!comment.visible">
            <b-row>
              <b-col>
             <b-textarea :value="comment.text" disabled></b-textarea>
               </b-col>
              <b-col>
             <b-textarea :value="comment.grade" disabled></b-textarea>
          </b-col>
            </b-row>
            
          </b-col>
        <b-row>
          <b-col></b-col>
          <b-col>
            <b-form-textarea
              id="textarea"
              v-model="message"
              placeholder="Enter your message."
              rows="3"
              max-rows="6"
          ></b-form-textarea>
          </b-col>
        </b-row>
        <b-row>
          <b-col></b-col>
          <b-col></b-col>
          <b-col></b-col>
          <b-col>
            <b-button @click="Submit()">Submit</b-button>
          </b-col>
          <b-col>
            <b-button @click="goBack()">Cancel</b-button>
          </b-col>
        </b-row>
      </b-container>
  </div>
</template>

<script>
import {FunctionalCalendar} from 'vue-functional-calendar';
import axios from 'axios'

export default {
  name: 'ReservationPage',
  components: {
    FunctionalCalendar
  },
  props : {
    apartment : {
      type : Object
    }
  },
  data() {
    return {
      apartments: {},
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
				//isModal : true
				
			},
			daysNumber : 0,
			startDate : null,
			endDate : null,
      user: {},
      message: "",
      status: "CREATED",
      imageSource : []
    }
  },
  created(){
    this.apartments = this.$route.params.data,
    
    axios.get('http://localhost:8080/RACompany/rest/currentUser')
			.then(res => (this.user = res.data))
      .catch(console.log("currentUser"));
    axios
    .get('http://localhost:8080/RACompany/rest/apartment/images/'+this.apartments.id)
    .then(respone => (this.imageSource = respone.data));

    console.log(this.apartments.imageSource);
  },
  
  computed: {
    totalPrice(){
      if(this.daysNumber > 0){
        return this.daysNumber * this.apartments.pricePerNight
      }
      return this.apartments.pricePerNight
    }
  },
  methods: {
    Submit(){

      let [day,month,year] = this.calendarData.dateRange.start.split("/");
      let markDate = new Date(year,month,day);
      let date = markDate.getTime();

      let inputData = {
        reservedAppatment: this.apartments,
        startDate: date,
        nightNumber: this.daysNumber,
        price: this.totalPrice,
        message: this.message,
        guest: this.user,
        status: this.status
      }
      axios
        .post('http://localhost:8080/RACompany/rest/reservation/new/'+ this.user.username, inputData)
    },
    goBack() {
      this.$router.push('/')
    },
    dayClicked(value){
			if(this.daysNumber === null){
				this.startDate = value;
				this.startDate.isDateRangeStart = true;
			}
			else{
				this.endDate = value;
				this.endDate.isDateRangeEnd = true;
			}
			console.log(value);

		},
		daysCount(value){
			console.log("number of days "+value);
			this.daysNumber = value;
    },
    getImage(source){
      return require("../data/images/"+source);
    }
  }
  
  
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>