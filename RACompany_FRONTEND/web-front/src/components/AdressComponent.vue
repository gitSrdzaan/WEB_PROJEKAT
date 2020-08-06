<template>
    <div>
         <b-form>
            <b-form-group id="adress-input-group-1" label="Adress city" label-for="input-city">
                <b-form-input id="input-city" v-model="adress.city" type="text" 
                 placeholder="Entert city"/>
            </b-form-group>
            <b-form-group id="adress-input-group-2" label="Adress street" label-for="input-street">
                <b-form-input id="input-street" v-model="adress.street" type="text"
                 placeholder="Entert street" />
            </b-form-group> 
            <b-form-group id="adress-input-group-3" label="Street number" label-for="input-number">
                <b-form-input id="input-adress" v-model="adress.number" 
                type="number" placeholder="Entert number of rooms"/>
            </b-form-group> 
            <b-form-group id="adress-input-group-4" label="Postal code" label-for="input-postalCode">
                <b-form-input id="input-postalCode" v-model="adress.postalCode" 
                type="number" placeholder="Entert postal code"/>
            </b-form-group>
        </b-form>
    </div>
</template>

<script>
export default {
    props:{
        adress : {
            type : Object
        }
    },
    methods :{
        output : function(){
            this.$emit('input',this.apartmentLocation);
        }
    }
    
}
</script>

<style scoped>

</style>