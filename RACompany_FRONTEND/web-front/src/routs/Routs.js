import Vue from "vue";
import VueRouter from "vue-router";
import LogInPage from "../Pages/LogInPage";
import HomeContentComponent from "../components/HomeContentComponent";
import RegisterPage from "../Pages/RegisterPage";
<<<<<<< HEAD
import User from "../Pages/User";
=======
import AdminPage from "../Pages/AdminPage";
>>>>>>> 71e13021b92860d23429f9500899fa856069eef3

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
