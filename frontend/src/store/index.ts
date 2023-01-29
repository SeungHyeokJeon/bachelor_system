// import { createStore } from "vuex";

// export default createStore({
//   state: {
//     sideBarOpen: false,
//   },
//   getters: {
//     sideBarOpen: (state) => {
//       return state.sideBarOpen;
//     },
//   },
//   mutations: {
//     toggleSidebar(state) {
//       state.sideBarOpen = !state.sideBarOpen;
//     },
//   },
//   actions: {
//     toggleSidebar(context) {
//       context.commit("toggleSidebar");
//     },
//   },
//   modules: {},
// });

import { defineStore } from "pinia";
import { computed, ref } from "vue";

// export const useSidebarStore = defineStore("sideBarOpen", {
//   state: () => {
//     return {
//       sideBarOpen: false,
//     };
//   },
//   getters: {
//     sideBarOpen: (state) => {
//       return state.sideBarOpen;
//     },
//   },
//   actions: {
//     toggleSidebar() {
//       this.sideBarOpen = !this.sideBarOpen;
//     },
//     // toggleSidebar(context) {
//     //   context.commit("toogleSidebar");
//     // },
//   },
// });

export const useSidebarStore = defineStore("sideBarOpen", () => {
  const sideBarOpen = ref(false);
  const getSideBarOpen = computed(() => sideBarOpen);
  function toggleSidebar() {
    sideBarOpen.value = !sideBarOpen.value;
    console.log(sideBarOpen);
  }

  return { sideBarOpen, getSideBarOpen, toggleSidebar };
});
