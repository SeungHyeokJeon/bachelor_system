import { defineStore } from "pinia";
import { computed, ref, Ref } from "vue";

export const useSidebarStore = defineStore("sideBarOpen", () => {
  
  const sideBarOpen: Ref<boolean> = ref(false);

  const getSideBarOpen = computed(() => sideBarOpen);
  
  function openSidebar() {
    sideBarOpen.value = true;
  }

  function closeSidebar() {
    sideBarOpen.value = false;
  }

  function toggleSidebar() {
    sideBarOpen.value = !sideBarOpen.value;
    console.log(123);
  }

  return { sideBarOpen, getSideBarOpen, openSidebar, closeSidebar, toggleSidebar };
});
