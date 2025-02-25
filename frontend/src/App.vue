<template>
  <div id="app">
    <h1>Bienvenue dans votre espace de réservation</h1>
    <nav>
      <router-link to="/reservations">Mes Réservations</router-link>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
body {
  font-family: Arial, sans-serif;
}
nav a {
  margin-right: 10px;
  text-decoration: none;
  color: blue;
}
</style>
