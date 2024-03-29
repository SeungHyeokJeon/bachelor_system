import { defineStore } from "pinia";
import { computed, ref, Ref } from "vue";

export const useCommonStore = defineStore("sideBarOpen", () => {
  
  const sideBarOpen: Ref<boolean> = ref(false);

  const getSideBarOpen = computed(() => sideBarOpen);
  
  function toggleSidebar() {
    sideBarOpen.value = !sideBarOpen.value;
    console.log(sideBarOpen);
  }

  return { sideBarOpen, getSideBarOpen, toggleSidebar };
});
