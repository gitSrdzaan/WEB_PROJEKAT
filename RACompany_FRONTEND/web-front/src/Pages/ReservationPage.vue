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
            <b-form-group label-cols="4" label-cols-lg="4" label="Starting date" label-for="datepicker">
              <b-form-datepicker id="datepicker" 
              class="mb-2" 
              v-model="starting_date"></b-form-datepicker>
            </b-form-group>
          </b-col>
          <b-col></b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="4" label="Ending date" label-for="datepicker-end">
              <b-form-datepicker id="datepicker-end" 
              class="mb-2" 
              v-model="ending_date"></b-form-datepicker>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col></b-col>
          <b-col>Price per night: {{ apartments.pricePerNight }} </b-col>
          <b-col></b-col>
          <b-col> Total price: </b-col>
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
export default {
  
  name: 'ReservationPage',
  data() {
    return {
      starting_date: '',
      ending_date: '',
      apartments: [],
    }
  },
  created(){
    this.apartments = this.$route.params.data
  },
  methods: {
    goBack() {
      this.$router.push('/')
    }
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>