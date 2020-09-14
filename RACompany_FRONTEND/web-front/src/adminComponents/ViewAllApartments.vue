<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button  @click="selectApartment(apartment)">{{apartment.id}}
                 <ApartmentComponent v-bind:apartment="selectedApartment" v-if="selectedApartment.id === apartment.id && showApartment"
                v-on:remove="deleteApartment(selectedApartment.id)" v-on:input="closeComponent()" />
            </b-list-group-item>
        </b-list-group>
       

        

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
            selectedApartment : {},
            showApartment : false
        }
    },
    methods :{
        selectApartment(apartment){
            this.selectedApartment = apartment;
            this.showApartment = true;
        },
        deletedApartmen(id){
            this.apartments.splice(id-1,1);
        },
        closeComponent(){
            this.showApartment = false;
        }

    }
    
}
</script>



<style scoped>

</style>