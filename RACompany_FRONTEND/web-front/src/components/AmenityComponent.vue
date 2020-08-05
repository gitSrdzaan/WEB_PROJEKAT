<template>
    <div>
        <b-form @submit.prevent="onSubmit">
            <b-form-group id="input-group-1" label= "Apratment amenity id" label-for="input-1">
                <b-form-input id="input-1" type="number" v-modal="amenity.id" placeholder="Entert id"/>
            </b-form-group>
            <b-form-group id="input-group-2" label= "Apratment amenity name" label-for="input-2">
                <b-form-input id="input-2" type="text" v-modal="amenity.name" placeholder="Entert name"/>
            </b-form-group>
             <b-form-group id="submitBtn">
                <b-button type="submit"> Submit </b-button>
             </b-form-group>     
        </b-form>
    </div>
</template>

<script>
export default {
    props : {
        amenity :{
            type : Object
        }
    },
    methods  : {
        onSubmit(){
            console.log(this.amenity)
        }
    }
}
</script>

<style scoped>

</style>