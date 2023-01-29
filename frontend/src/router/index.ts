import { createRouter, createWebHashHistory } from "vue-router";

// view file
import LoginView from "../views/main/LoginView.vue";
import TestView from "../views/main/TestView.vue";

const routes = [
  {
    path: "/login",
    name: "login",
    // component: () => import("../views/main/LoginView.vue")
    component: LoginView,
  },
  {
    path: "/",
    name: "test",
    // component: () => import("../views/main/LoginView.vue")
    component: TestView,
  },
  // {
  //   path: "/",
  //   redirect: { name: "login" },
  // },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
