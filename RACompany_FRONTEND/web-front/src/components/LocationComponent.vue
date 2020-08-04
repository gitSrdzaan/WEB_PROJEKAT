<template>
    <div>

    </div>
</template>

<script>
export default {
    props : {
        apartmentLocation : {
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