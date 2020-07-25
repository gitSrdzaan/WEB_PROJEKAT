import Vue from "vue";
import App from "./App.vue";
import router from "./routs/Routs";

window.axios = require("axios");

Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
