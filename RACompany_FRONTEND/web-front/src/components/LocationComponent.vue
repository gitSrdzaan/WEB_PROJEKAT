<template>
    <div>
        <b-form>
            <b-form-group id="location-input-group-1" label="Location longitude" label-for="input-longitude">
                <b-form-input id="input-longitude" v-model="apartmentLocation.longitude" type="number" 
                step="0.000001" placeholder="Entert longitude"/>
            </b-form-group>
            <b-form-group id="location-input-group-2" label="Location latitude" label-for="input-latitude">
                <b-form-input id="input-latitude" v-model="apartmentLocation.latitude" type="number"
                step="0.000001" placeholder="Entert latitude" />
            </b-form-group> 
            <b-form-group id="location-input-group-3" label="Adress" label-for="input-adress">
                <AdressComponent v-bind:adress="apartmentLocation.adress"/>
            </b-form-group> 
        </b-form>
    </div>
</template>

<script>
import AdressComponent from "../components/AdressComponent"
export default {
    components:{
        AdressComponent
    },
    props : {
        apartmentLocation : {
            type : Object
           
        
        }
    },
    methods :{
        output : function(){
            this.$emit('input',this.apartmentLocation);
        }
    }
}
</script>

<style scoped>

</style>