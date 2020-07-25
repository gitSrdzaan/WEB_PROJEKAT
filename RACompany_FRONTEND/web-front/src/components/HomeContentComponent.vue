<template>
  <div class="row">
    <form class="SearchBox">
        <label>Type</label>
        <br/>
        <input type="text"/>
        <label>Number of rooms</label>
        <br/>
        <input type="number"/>
        <label>Number of guests</label>
        <br/>
        <input type="number"/>
        <label>Price per Night</label>
        <br/>
        <input type="text"/>
        <label>Host name</label>
        <br/>
        <input type="text"/>

    </form>
    <form class="content">
      <ul>
        <li v-for="apartment in info"
        :key="apartment.id">
          {{apartment.type}}
          
        </li>
      </ul>
    </form>
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
      info: null
    }
  }
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.row{
  display: flex;
}

.SearchBox{
  border-style: double;
  background: lightblue;
  width: 170px;
  height: 600px;
  margin: 40px;
}

.content{
  width: 100%;
  max-width: 1200px;
  margin: 40px auto;
  padding: 0 20px;
  box-sizing: border-box;
}
ul{
  display: flex;
  flex-wrap: wrap;
  list-style-type: none;
  padding: 0;
}
li{
  flex-grow: 1;
  flex-basis: 300px;
  text-align: center;
  padding: 30px;
  border: 1px solid #222;
  margin: 10px;
}
</style>