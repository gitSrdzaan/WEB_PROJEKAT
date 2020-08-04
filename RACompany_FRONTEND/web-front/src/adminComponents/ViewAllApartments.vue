<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button v-b-modal.modal @click="selectApartment(apartment)">{{apartment.id}}</b-list-group-item>
        </b-list-group>
       

        <b-modal id="modal" scrollable>
            <ApartmentComponent v-bind:apartment="selectedApartment"/>
        </b-modal>

    </div>
</template>

<script>
import ApartmentComponent from "../components/ApartmentComponent"

export default {
    name : "ViewAllApartments",
    props : {
        apartments : {
            type : Array,
            required : true
        }
    },
    components : {
        ApartmentComponent
    },
    data(){
        return{
            selectedApartment : {}
        }
    },
    methods :{
        selectApartment(apartment){
            this.selectedApartment = apartment;
        }
    }
    
}
</script>



<style scoped>

</style>