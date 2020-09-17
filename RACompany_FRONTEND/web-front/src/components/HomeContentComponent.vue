<template>
  <div>
    <div class="searchBox">
      <b-container class="bv-example-row">
        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="3" label="Location" label-for="location">
              <b-form-input id="location"
               placeholder="Input city"
               v-model="location"
               type="text"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Number of guests" label-for="number-of-guest">
              <b-form-input id="number-of-guest" 
              placeholder="Input number" 
              v-model="guestNumber"
              type="number"></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>

        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Min cost" label-for="min-cost">
              <b-form-input id="min-cost" 
              placeholder="input min cost peer night"
              type="number"
              v-model="min_cost"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Max cost" label-for="max-cost">
              <b-form-input id="max-cost" 
              placeholder="input max cost peer night"
              type="number"
              v-model="max_cost"></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Min room numbers" label-for="min-room-numbers">
              <b-form-input id="min-room-numbers" 
              placeholder="Input min rooms" 
              v-model="minRoomNumber"
              type="number"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Max room numbers" label-for="max-room-numbers">
              <b-form-input id="max-room-numbers" 
              placeholder="Input max rooms" 
              v-model="maxRoomNumber"
              type="number"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col v-if="user != ''">
            <b-form-group label-cols="4" label-cols-lg="6" label="Type:" label-for="input-3">
              <b-form-select
                id="input-3"
                v-model="type"
                :options="types"
              ></b-form-select>
            </b-form-group>
          </b-col>
        </b-row>

        <b-row>
          <b-col v-if="user != ''">
            <b-button @click="sortMethod()">{{ sortButtonName }}</b-button>
          </b-col>
          <b-col v-if="user.userRole === 'HOST' || user.userRole === 'ADMIN'">
            <b-form-group label-cols="4" label-cols-lg="6" label="Apartment status:" label-for="input-4">
              <b-form-select
                id="input-4"
                v-model="status"
                :options="statuses"
              ></b-form-select>
            </b-form-group>
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

            <b-button @click="shareData(apartment)" v-if="user.userRole === 'GUEST'">
              Open
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
      location: '',
      guestNumber: '',
      minRoomNumber: '',
      maxRoomNumber: '',
      types: [
        'ROOM',
        'FULL',
        ''
      ],
      type: '',
      sort: false,
      sortButtonName: 'Descending order',
      status: '',
      statuses: [
        'true',
        'false',
        ''
      ],
      min_cost: '',
      max_cost: ''
    }
  },
  created: function(){
    axios
      .get('http://localhost:8080/RACompany/rest/currentUser')
      .then(res => (this.user = res.data))
  },
  methods: {
    shareData(data){
      this.$router.push({name:"ReservationPage", params: {data: data}})
    },
    sortMethod(){
      if(this.sort){
        this.sortButtonName = "Ascending order"
        this.sort = false
      }else{
        this.sortButtonName = "Descending order"
        this.sort = true
      }
      return this.sortButtonName
    }
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
      if(this.min_cost != ''){
        data = data.filter(item =>{
          return item.pricePerNight >= this.min_cost
        })
      }
      if(this.max_cost != ''){
        data = data.filter(item => {
          return item.pricePerNight <= this.max_cost
        })
      }
      if(this.location != ''){
        data = data.filter(item => {
          if(item.apartmentLocation.adress){
        return item.apartmentLocation.adress.city.toLowerCase().includes(this.location.toLowerCase())
          }
        })
      }
      // for Guest nije ya wifi napravljeno
      if(this.type != ''){
        data = data.filter(item =>
        item.type.match(this.type))
      }
      if(this.sort){
        data = data.sort(function(a, b){return a.pricePerNight-b.pricePerNight})
      }
      if(!this.sort){
        data = data.sort(function(a, b){return b.pricePerNight-a.pricePerNight})
      }
      // host admin pretraga 
      if(this.status != ''){
        data = data.filter(item =>
        String(item.apartmentStatus).match(this.status))
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