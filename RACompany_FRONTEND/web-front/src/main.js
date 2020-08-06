import Vue from "vue";
import Vuelidate from "vuelidate";
import FunctionalCalendar from "vue-functional-calendar";
import App from "./App.vue";
import router from "./routs/Routs";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.use(BootstrapVue);
Vue.use(Vuelidate);
Vue.use(FunctionalCalendar,{
  dayNames : ['Mo','Tu','We','Th','Fr','Sa','Su']
});

Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
