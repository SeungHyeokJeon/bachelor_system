<script setup lang="ts">
import { useSidebarStore } from "@/store/sidebar";

const sidbarStore = useSidebarStore();
</script>

<template>
  <div class="navbar bg-base-100 justify-between">
    <!-- mobile sidebar toggle -->
    <div class="flex-none">
      <button
        class="btn btn-square btn-ghost lg:hidden"
        :class="sidbarStore.sideBarOpen ? 'hidden' : ''"
        @click="sidbarStore.toggleSidebar"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          class="inline-block w-5 h-5 stroke-current"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M4 6h16M4 12h16M4 18h16"
          ></path>
        </svg>
      </button>
    </div>

    <div class="flex-none dropdown dropdown-end">
      <label tabindex="0" class="btn btn-square btn-ghost"
        ><svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          class="inline-block w-5 h-5 stroke-current"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M5 12h.01M12 12h.01M19 12h.01M6 12a1 1 0 11-2 0 1 1 0 012 0zm7 0a1 1 0 11-2 0 1 1 0 012 0zm7 0a1 1 0 11-2 0 1 1 0 012 0z"
          ></path></svg
      ></label>
      <ul
        tabindex="0"
        class="dropdown-content menu p-2 shadow bg-base-100 rounded-box w-52"
      >
        <li><a>Logout</a></li>
      </ul>
    </div>
  </div>
</template>

<style scoped></style>
