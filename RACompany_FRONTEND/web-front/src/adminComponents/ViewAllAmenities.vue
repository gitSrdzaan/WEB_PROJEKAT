<template>
    <div>
         <b-list-group v-for="amenity in this.amenities" :key="amenity.id">
            <b-list-group-item button @click="showAmenity(amenity)" v-b-modal.modal>{{amenity.id}}</b-list-group-item>
        </b-list-group>
        <div>
            <b-button @click="createNewAmenity" v-b-modal.modal>Create new Amenity</b-button>
        </div>

        <b-modal id="modal">
            <AmenityComponent v-bind:amenity="selectedAmenity"/>
        </b-modal>

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
            selectedAmenity : {}
            
        }
    },
    methods : {
        showAmenity(amenity){
            this.selectedAmenity = amenity;
        },
        createNewAmenity(){
            let emptyAmenity = {
                id : '',
                name : ''
            }
            this.selectedAmenity = emptyAmenity;
        }
    }
}
</script>

<style scoped>

</style>