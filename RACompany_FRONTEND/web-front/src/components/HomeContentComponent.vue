<template>
  <div>
    <div class="searchBox">
      <b-container class="bv-example-row">
        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="3" label="Location" label-for="location">
              <b-form-input id="location" placeholder="Input location" v-model="location"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Number of guests" label-for="number-of-guest">
              <b-form-input id="number-of-guest" placeholder="Input number" v-model="guestNumber"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="4" label="Starting date" label-for="datepicker">
              <b-form-datepicker id="datepicker" class="mb-2"></b-form-datepicker>
            </b-form-group>
          </b-col>
        </b-row>

        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="4" label="Ending date" label-for="end-datepicker">
              <b-form-datepicker id="end-datepicker" class="mb-2"></b-form-datepicker>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Min cost" label-for="min-cost">
              <b-form-input id="min-cost" placeholder="Input min cost"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Max cost" label-for="max-cost">
              <b-form-input id="max-cost" placeholder="Input max cost"></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Min room numbers" label-for="min-room-numbers">
              <b-form-input id="min-room-numbers" placeholder="Input min rooms" v-model="minRoomNumber"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Max room numbers" label-for="max-room-numbers">
              <b-form-input id="max-room-numbers" placeholder="Input max rooms" v-model="maxRoomNumber"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
          </b-col>
        </b-row>
      </b-container>
    </div>
    <div class="content">
      <ul class="ul-content" >
        <li v-for="apartment in filteredApartment"
          :key="apartment.id">
          <div>
            <b-card
              img-src="https://picsum.photos/600/300/?image=25"
              img-alt="Image"
              img-top
              tag="article"
              style="max-width: 20rem;"
              class="mb-2"
            >
            <b-card-text>
              <div v-if="apartment.apartmentLocation.adress">
                <b>
                  {{ apartment.apartmentLocation.adress.street }}
                  {{ apartment.apartmentLocation.adress.number }}
                </b>
                <div>
                  {{ apartment.apartmentLocation.adress.city}}
                  {{ apartment.apartmentLocation.adress.postalCode }}
                </div>
                <div>
                  {{ apartment.apartmentLocation.longitude }} ,
                  {{ apartment.apartmentLocation.latitude }}
                </div>

              </div>
            </b-card-text>

            <b-button v-if="user != ''">
              <router-link to="/res">Open</router-link>
            </b-button>
            </b-card>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>


<script>
import axios from 'axios'

export default {
  name: 'HomeContentComponent',
  mounted: function(){
    axios
      .get('http://localhost:8080/RACompany/rest/apartment/helloWorld')
      .then(response => (this.info = response.data))
  },
  data() {
    return{
      info: [],
      user: '',
      infoHelp: null,
      location: "",
      guestNumber: '',
      minRoomNumber: '',
      maxRoomNumber: '',
    }
  },
  created: function(){
    axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(res => (this.user = res.data))
  },
  computed: {
    filteredApartment() {
      let data = this.info
      if(this.guestNumber != ''){
        data = data.filter(item =>
        String(item.guestNumber).match(this.guestNumber))
      }
      if(this.minRoomNumber != ''){
        data = data.filter(item =>
        parseInt(item.roomNumber) >= parseInt(this.minRoomNumber))
      }
      if(this.maxRoomNumber != ''){
        data = data.filter(item =>
        parseInt(item.roomNumber) <= parseInt(this.maxRoomNumber))
      }
      
      return data
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.searchBox{
  margin: 15px;
}

.content{
  display: inline;
}

.ul-content li{
  display: inline-flex;
  margin: 15px;
}

</style>