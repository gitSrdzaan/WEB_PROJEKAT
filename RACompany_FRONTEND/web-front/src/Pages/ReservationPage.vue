<template>
  <div>
      <h1>Make your reservation</h1>
      <b-container>
        <b-row>
          <b-col>
          <img src="../assets/logo.png" alt="apartments picture" />
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
          <b-col>Price per night: {{ apartments.pricePerNight }} </b-col>
          <b-col></b-col>
          <b-col> Total price: {{totalPrice}} </b-col>
        </b-row>
        <b-row>
          <b-col></b-col>
          <b-col></b-col>
          <b-col></b-col>
          <b-col>
            <b-button>Submit</b-button>
          </b-col>
          <b-col>
            <b-button @click="goBack()">Cancle</b-button>
          </b-col>
        </b-row>
      </b-container>
  </div>
</template>

<script>
import {FunctionalCalendar} from 'vue-functional-calendar';

export default {
  name: 'ReservationPage',
  components: {
    FunctionalCalendar
  },
  data() {
    return {
      apartments: [],
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
			endDate : null
    }
  },
  created(){
    this.apartments = this.$route.params.data
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
		}
  },
  
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>