<template>
  <div id="app">
    <b-navbar toggleable type="inverse" variant="success">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>

      <b-link class="navbar-brand" to="/">
        <span>{{ appTitle }}</span>
      </b-link>

      <b-nav is-nav-bar>
        <b-nav-item to="/my-series">Мои сериалы</b-nav-item>
      </b-nav>   
    </b-navbar>

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
  body {
    background: #262b39;
  }

  .nav-link {
    color: #fff !important;
  }

  .nav-link:hover {
    color: #35495e !important;
  }

  .carousel-item > img.d-block.img-fluid {
    margin: auto !important;
    border-radius: 10px;
  }
</style>
