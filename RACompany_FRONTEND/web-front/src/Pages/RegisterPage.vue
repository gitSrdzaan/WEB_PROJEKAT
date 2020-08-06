<template>
  <div class="position">
    <b-form @submit.prevent="signUp()">
      <b-form-group 
        id="input-group-1"
        label="Password:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="$v.form.password.$model"
          type="password"
          :state="validatePassword('password')"
          aria-describedby="password"
          placeholder="Enter password"
        ></b-form-input>
        <b-form-invalid-feedback id="password">
          This is a requrired field and must be at least 4 characters
        </b-form-invalid-feedback> 
      </b-form-group>

      <b-form-group 
        id="input-group-2" 
        label="Your Username:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="$v.form.name.$model"
          :state="validateName('name')"
          aria-describedby="name"
          placeholder="Enter username"
        ></b-form-input>
        <b-form-invalid-feedback id="name">
          This is a requrired field and must be at least 3 characters
        </b-form-invalid-feedback> 
      </b-form-group>

      <b-form-group 
        id="input-group-3" 
        label="Your firstname:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="$v.form.firstname.$model"
          :state="validateFirstname('firstname')"
          aria-describedby="firstname"
          placeholder="Enter firstname"
        ></b-form-input>
        <b-form-invalid-feedback id="firstname">
          This is a requrired field and must be at least 3 characters
        </b-form-invalid-feedback> 
      </b-form-group>

      <b-form-group 
        id="input-group-3" 
        label="Your lastname:" 
        label-for="input-2"
        >
        <b-form-input
          id="input-2"
          v-model="$v.form.lastname.$model"
          :state="validateLastname('lastname')"
          aria-describedby="lastname"
          placeholder="Enter lastname"
        ></b-form-input>
        <b-form-invalid-feedback id="lastname">
          This is a requrired field and must be at least 3 characters
        </b-form-invalid-feedback> 
      </b-form-group>

      <b-form-group id="input-group-3" label="Sex:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="$v.form.sex.$model"
          :options="sexes"
          :state="validateSex('sex')"
          aria-describedby="sex"
        ></b-form-select>
        <b-form-invalid-feedback id="sex">
          This is a requrired field.
        </b-form-invalid-feedback> 
      </b-form-group>

      <b-form-group id="input-group-3" label="Role:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="$v.form.role.$model"
          :options="roles"
          :state="validateRole('role')"
          aria-describedby="role"
        ></b-form-select>
        <b-form-invalid-feedback id="role">
          This is a requrired field.
        </b-form-invalid-feedback> 
      </b-form-group>

      <b-button type="submit">
        Register
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
          name: '',
          firstname: '',
          lastname:'',
          sex:'',
          role:'',
          msg: ''
        },
        sexes: [
          'Male',
          'Female'
        ],
        roles: [
          'GUEST',
          'HOST'
        ],
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
        },
        firstname: {
          required,
          minLength: minLength(3)
        },
        lastname: {
          required,
          minLength: minLength(3)
        },
        sex: {
          required
        },
        role: {
          required
        }
      }
    },
    methods: {
      validateName(name) {
        const { $dirty, $error } = this.$v.form[name];
        return $dirty ? !$error : null;
      },
      validatePassword(password){
        const { $dirty, $error } = this.$v.form[password];
        return $dirty ? !$error : null;
      },
      validateFirstname(firstname) {
        const { $dirty, $error } = this.$v.form[firstname];
        return $dirty ? !$error : null;
      },
      validateLastname(lastname){
        const { $dirty, $error } = this.$v.form[lastname];
        return $dirty ? !$error : null;
      },
      validateSex(sex) {
        const { $dirty, $error } = this.$v.form[sex];
        return $dirty ? !$error : null;
      },
      validateRole(role){
        const { $dirty, $error } = this.$v.form[role];
        return $dirty ? !$error : null;
      },
      async signUp() {
        this.$v.form.$touch();
        if(this.$v.form.$anyError) {
          return;
        }

        try{ 
          const credentials = {
            username: this.form.name,
            password: this.form.password,
            sex: this.form.sex,
            userRole: this.form.role,
            firstname: this.form.firstname,
            lastname: this.form.lastname
          };
          await AuthService.signUp(credentials);

          this.$router.push('/login');
        }catch (e) {
          this.form.msg = e.response.data
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