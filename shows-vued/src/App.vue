<template>
  <div id="app">
    <b-navbar toggleable type="inverse" variant="success">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>

      <b-link class="navbar-brand" to="#">
        <span>{{ appTitle }}</span>
      </b-link>
  
      <!--       <router-link to="/">Main</router-link>
      <router-link to="/other">othr</router-link>  -->
      <b-nav is-nav-bar>
        <router-link tag="b-nav-item" to="/other">Other</router-link>
        <b-nav-item>Support</b-nav-item>
        <b-nav-item>Docs</b-nav-item>
      </b-nav>   
    </b-navbar>

    <b-jumbotron header="BootstrapVue" lead="Bootstrap 4 Components for Vue.js 2">
      <p>For more information visit website</p>
      <b-btn variant="primary" href="#">Docs</b-btn>
    </b-jumbotron>

    <div class="main-container">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data() {
      return {
        appTitle: "Shows VUEd"
      }
    }
  }
</script>

<style>

</style>
