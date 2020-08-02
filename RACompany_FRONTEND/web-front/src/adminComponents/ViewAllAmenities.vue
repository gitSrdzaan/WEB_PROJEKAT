<template>
    <div>
         <b-list-group v-for="amenity in this.amenities" :key="amenity.id">
            <b-list-group-item button>{{amenity.id}}</b-list-group-item>
        </b-list-group>

    </div>
</template>

<script>
export default {
    name : "ViewAllAmenities",
    props : {
        amenities : {
            type : Array
        }
    }
}
</script>

<style scoped>

</style>