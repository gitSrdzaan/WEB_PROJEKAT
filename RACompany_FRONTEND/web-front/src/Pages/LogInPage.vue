<template>
  <div class="position">
    <b-form >
      <b-form-group 
        id="input-group-1"
        label="Password:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.password"
          type="password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>

      <b-form-group 
        id="input-group-2" 
        label="Username:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="$v.form.name.$model"
          :state="validateState('name')"
          aria-describedby="input-1-live-feedback"
          placeholder="Enter username"
        ></b-form-input>
        <b-form-invalid-feedback id="input-1-live-feedback">
          This is a requrired field and must be at least 3 characters
        </b-form-invalid-feedback>
      </b-form-group>

       <b-button @click="login()">
         LogIn
       </b-button>
      
    </b-form>
  </div>
</template>

<script>
import AuthService from '../service/AuthService'
import { validationMixin } from 'vuelidate'
import { required, minLength } from 'vuelidate/lib/validators'

  export default {
    mixins: [validationMixin],
    data() {
      return {
        form: {
          password: '',
          name: ''
        },
        msg: ''
      }
    },
    validations: {
      form: {
        password: {
          required,
          minLength: minLength(4)
        },
        name: {
          required,
          minLength: minLength(3)
        }
      }
    },
    methods: {
      validateState(name) {
        const { $dirty, $error } = this.$v.form[name];
        return $dirty ? !$error : null;
      },
      async login() {
        try{
        const credentials = {
          username: this.form.name,
          password: this.form.password
        }
        await AuthService.login(credentials);

        this.$v.form.$touch();
        if(this.$v.form.$anyError) {
          return;
        }

        this.$router.push('/');
        this.$router.go();
        }catch (e){
          this.msg = e.response.data
        }
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