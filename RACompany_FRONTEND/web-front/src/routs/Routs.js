import Vue from "vue";
import VueRouter from "vue-router";
import LogInPage from "../Pages/LogInPage";
import HomeContentComponent from "../components/HomeContentComponent";
import RegisterPage from "../Pages/RegisterPage";
import User from "../Pages/User";
import ReservationPage from "../Pages/ReservationPage";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeContentComponent",
    component: HomeContentComponent,
  },
  {
    path: "/user",
    name: "User",
    component: User,
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
    path: "/res",
    name: "ReservationPage",
    component: ReservationPage,
  },
];

const router = new VueRouter({
  mode: "history",
  base: '/COMS',
  routes,
});

export default router;
