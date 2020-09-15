<template>
    <div>
         <b-list-group v-for="amenity in this.amenities" :key="amenity.id">
            <b-list-group-item li @click="showAmenity(amenity)" >{{amenity.id}}
                 <AmenityComponent v-bind:amenity="selectedAmenity" v-if="selectedAmenity.id === amenity.id && showUpdAmenity"
                 v-on:remove="deleteAmenity(selectedAmenity.id)" v-on:input="closeComponent()"/>
            </b-list-group-item>
        </b-list-group>
        <div>
            <b-button @click="createNewAmenity" >Create new Amenity</b-button>
        </div>
        <AmenityComponent v-bind:amenity="selectedAmenity" v-if="showNewAmenity" v-on:input="closeComponent()"/>
        

    </div>
</template>

<script>
import AmenityComponent from "../components/AmenityComponent"
export default {
    name : "ViewAllAmenities",
    props : {
        amenities : {
            type : Array
        }
    },
    components :{
        AmenityComponent
    },
    data() {
        return {
            selectedAmenity : {},
            showUpdAmenity : false,
            showNewAmenity : false
            
        }
    },
    methods : {
        showAmenity(amenity){
            this.selectedAmenity = amenity;
            this.showUpdAmenity = true;
        },
        createNewAmenity(){
            let emptyAmenity = {
                id : '',
                name : ''
            }
            this.selectedAmenity = emptyAmenity;
            this.showNewAmenity = true;
        },
        deleteAmenity(index){
            this.amenities.splice(index-1,1);
            this.$emit('update');
        },
        closeComponent(){
            this.showUpdAmenity = false;
            this.showNewAmenity = false;
            this.$emit('update');
        }
    }
}
</script>

<style scoped>

</style>