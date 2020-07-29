import Vue from "vue";
import VueRouter from "vue-router";
import LogInPage from "../Pages/LogInPage";
import HomeContentComponent from "../components/HomeContentComponent";
import RegisterPage from "../Pages/RegisterPage";
import User from "../Pages/User";

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
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
