<template>
    <div>


        <b-button @click="sortMethod">{{ sortOrder}}</b-button>

        <b-list-group v-for="apartment in filterApartments" :key="apartment.id">
            <b-list-group-item li  @click="selectApartment(apartment)">{{apartment.id}}
                 <ApartmentComponent v-bind:apartment="selectedApartment" v-if="selectedApartment.id === apartment.id && showApartment"
                v-on:remove="deleteApartment(selectedApartment.id)" v-on:input="closeComponent()" v-bind:amenities="amenities"/>
            </b-list-group-item>
        </b-list-group>
       

        

    </div>
</template>

<script>
import Axios from 'axios';
import ApartmentComponent from "../components/ApartmentComponent"


export default {
    name : "ViewAllApartments",
    props : {
        apartments : {
            type : Array,
            required : true
        },
        
    },
    components : {
        ApartmentComponent
    },
    data(){
        return{
            selectedApartment : {},
            showApartment : false,
            amenities : [],
            sortOrder : 'Descending order',
            sort : 'desc'
        }
    },
    methods :{
        selectApartment(apartment){
             this.getAllAmenities();
            this.selectedApartment = apartment;
           
            this.showApartment = true;
        },
        deletedApartmen(id){
            this.apartments.splice(id-1,1);
            this.$emit('update');
        },
        closeComponent(){
            this.showApartment = false;
            this.$emit('update');
        },
        getAllAmenities : function(){
             Axios
            .get('http://localhost:8080/RACompany/rest/amneities/all')
            .then(response => (this.amenities = response.data))
        },
        sortMethod(){
            if(this.sort === 'asc'){
                this.sortOrder = "Ascending order";
                this.sort = "desc";
            }else{
                this.sortOrder = 'Descending order';
                this.sort = 'asc';
            }
        }

    },
    created :function(){
        this.getAllAmenities();

    },
    computed : {
        filterApartments(){
            let data = this.apartments;
            if(this.sort === 'asc'){
                data = data.sort(function(a,b){
                    return  a.pricePerNight-b.pricePerNight
                });
            
            }
            if(this.sort === 'desc'){
                data = data.sort(function(a,b){
                    return  b.pricePerNight-a.pricePerNight
                });
            }

            return data;
        }
    }
    
}
</script>



<style scoped>

</style>