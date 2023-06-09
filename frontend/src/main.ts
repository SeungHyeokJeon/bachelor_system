import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
import router from "./router";
import { createPinia } from "pinia";
import vClickOutside from "v-click-outside";

createApp(App).use(vClickOutside).use(createPinia()).use(router).mount("#app");
