import Vue from "vue";
import VueRouter from "vue-router";
import HomePage from "../Pages/HomePage";
import LogInPage from "../Pages/LogInPage";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomePage",
    component: HomePage,
  },
  {
    path: "/login",
    name: "LogInPage",
    component: LogInPage,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
