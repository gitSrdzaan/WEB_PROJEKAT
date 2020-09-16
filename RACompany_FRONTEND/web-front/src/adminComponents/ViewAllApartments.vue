<template>
    <div>

        <div>
            <b-form>
                 <b-form-group id="input-group-type" label="Type" label-for="input-type">
                    <b-form-select id="input-type" v-model="type" :options="types" />
                </b-form-group>
                <b-form-group id="input-group-status" label="Status" label-for="input-status">
                    <b-form-select id="input-status" v-model="status" :options="statuses" />
                </b-form-group>
                <b-form-group id="input-group-amenities" label="Amenities" label-for="input-amenities">
                    <b-form-select id="input-amenities" v-model="amenity" :options="getAmenitiesNames" />
                </b-form-group>
            </b-form>
        </div>


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
            sort : 'desc',
            type : '',
            types : [
                "FULL",
                "ROOM",
                ""
            ],
            status : null,
            statuses : [
                "Active",
                "Not-Active",
                ""
            ],
            amenity : "",
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
            if(this.type != ''){
                data = data.filter(item =>
                String(item.type).match(this.type));
            }
            if(this.status != ''){
                let filter = false;
                if(this.status === "Active"){
                    filter = true;
                }
                data = data.filter(item =>
                (item.apartmentStatus === filter));
            }
            if(this.amenity != ''){
                data = data.filter(item =>
                {
                    for(let iter in item.amenities){
                        
                        if(item.amenities[iter].name === this.amenity){
                           
                            return item;
                        }
                        
                    }
                    
                }
                )
            }

            return data;
        },
        getAmenitiesNames(){
            let names = [];
            for(let iter in this.amenities){
                names.push(this.amenities[iter].name);
            }

            names.push("");

            return names;
        }
    }
    
}
</script>



<style scoped>

</style>