<template>
    <div>
        <b-list-group v-for="apartment in this.apartments" :key="apartment.id">
            <b-list-group-item button v-b-modal.modal >{{apartment.id}}</b-list-group-item>
        </b-list-group>

        <b-modal id="Modal">
            <p> Modal </p>
        </b-modal>
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