<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button>{{apartment.id}}</b-list-group-item>
        </b-list-group>
    </div>
</template>

<script>
export default {
    name : "HostApartmentsComponent",
    props : {
        apartments : {
            type : Array
        }
    }
    
}
</script>

<style scoped>

</style>