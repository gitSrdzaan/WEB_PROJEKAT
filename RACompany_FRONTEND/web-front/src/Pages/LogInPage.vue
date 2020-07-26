<template>
  <div class="position">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group 
        id="input-group-1"
        label="Password:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.pasword"
          type="password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>

      <b-form-group 
        id="input-group-2" 
        label="Your Username:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="form.name"
          required
          placeholder="Enter username"
        ></b-form-input>
      </b-form-group>

       <b-button type="submit" variant="primary">Submit</b-button>
      
    </b-form>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          password: '',
          name: '',
        },
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      }
    }
  }
</script>

<style scoped>

.position{
  width: 25%;
  height: 100%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 80px;
  
}

</style>