<template>
  <!-- <HelloWorld msg="Hello Vue 3.0 + Vite" /> -->
  <!-- <Translator /> -->
  <NavBar></NavBar>
  <div class="content">
    <router-view></router-view>
  </div>
</template>

<script>
import NavBar from '@/views/NavBar.vue'

export default {
  name: 'App',
  components: {
    NavBar
  }
}
</script>

<style>
  /* .nav {
    display: inline-block;
    width: 200px;
  }

  .content {
    display: inline-block;
  } */

  /* * {
    margin: 0;
    padding: 0;
  } */
</style>