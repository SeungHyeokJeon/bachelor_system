<script setup lang="ts">
import Header from "./components/Header.vue";
import Sidebar from "./components/Sidebar.vue";
import Footer from "./components/Footer.vue";
</script>

<template>
  <!-- login -->
  <router-view v-if="$route.name === 'login'" />

  <!-- else -->
  <div
    class="leading-normal tracking-normal"
    id="main-body"
    v-if="$route.name !== 'login'"
  >
    <div class="flex flex-wrap">
      <Sidebar />

      <!-- <div
        class="w-full bg-gray-100 pl-0 lg:pl-64 min-h-screen"
        :class="sideBarOpen ? 'overlay' : ''"
        id="main-content"
      > -->
      <div
        class="w-full bg-gray-100 pl-0 lg:pl-64 min-h-screen"
        id="main-content"
      >
        <Header />

        <div class="p-6 bg-gray-100 mb-20">
          <router-view />
        </div>
      </div>
    </div>
    <Footer />
  </div>
</template>

<style></style>
