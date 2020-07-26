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

      <b-form-group 
        id="input-group-3" 
        label="Your firstname:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="form.firstname"
          required
          placeholder="Enter firstname"
        ></b-form-input>
      </b-form-group>

      <b-form-group 
        id="input-group-3" 
        label="Your lastname:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="form.lastname"
          required
          placeholder="Enter lastname"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Sex:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.sex"
          :options="sexes"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-3" label="Role:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.role"
          :options="roles"
          required
        ></b-form-select>
      </b-form-group>

      <b-button type="submit" variant="primary">Sign Up</b-button>
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
        sexes: [
          'Male',
          'Female'
        ],
        roles: [
          'GUEST',
          'HOST'
        ],
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