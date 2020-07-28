import Vue from "vue";
import VueRouter from "vue-router";
import LogInPage from "../Pages/LogInPage";
import HomeContentComponent from "../components/HomeContentComponent";
import RegisterPage from "../Pages/RegisterPage";
import AdminPage from "../Pages/AdminPage";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeContentComponent",
    component: HomeContentComponent,
  },
  {
    path: "/login",
    name: "LogInPage",
    component: LogInPage,
  },
  {
    path: "/reg",
    name: "RegisterPage",
    component: RegisterPage,
  },
  {
    path : "/admin",
    name : "AdminPage",
    component : AdminPage
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
