<template>
  <div>
    <div class="searchBox">
      <b-container class="bv-example-row">
        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="3" label="Location" label-for="input-default">
              <b-form-input id="input-default" placeholder="Input location"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Number of guests" label-for="input-default">
              <b-form-input id="input-default" placeholder="Input number"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="4" label="Starting date" label-for="datepicker">
              <b-form-datepicker id="datepicker" v-model="value" class="mb-2"></b-form-datepicker>
            </b-form-group>
          </b-col>
        </b-row>

        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="4" label="Ending date" label-for="datepicker">
              <b-form-datepicker id="datepicker" v-model="value" class="mb-2"></b-form-datepicker>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Min cost" label-for="input-default">
              <b-form-input id="input-default" placeholder="Input min cost"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Max cost" label-for="input-default">
              <b-form-input id="input-default" placeholder="Input max cost"></b-form-input>
            </b-form-group>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Min room numbers" label-for="input-default">
              <b-form-input id="input-default" placeholder="Input min rooms"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col>
            <b-form-group label-cols="4" label-cols-lg="6" label="Max room numbers" label-for="input-default">
              <b-form-input id="input-default" placeholder="Input max rooms"></b-form-input>
            </b-form-group>
          </b-col>
          <b-col></b-col>
        </b-row>
      </b-container>
    </div>
    <div class="content">
      <ul class="ul-content">
        <li v-for="apartment in info"
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

            <b-button variant="primary">Open</b-button>
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
      info: null,
      user: null
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