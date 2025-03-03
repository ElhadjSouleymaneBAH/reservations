<template>
  <div class="container mt-5">
    <h1 class="text-center mb-4">Gestion des Réservations</h1>

    <!-- Section des boutons d'action -->
    <div class="text-center mb-4">
      <button class="btn btn-primary me-2">Gérer mes Réservations</button>
      <button class="btn btn-success">Ajouter une Réservation</button>
    </div>

    <!-- Composant Liste des Réservations -->
    <ReservationList />
  </div>
</template>

<script>
import ReservationList from "./components/ReservationList.vue";

export default {
  components: {
    ReservationList,
  },
};
</script>

<style>
body {
  background-color: #f8f9fa;
}
.container {
  max-width: 800px;
  margin: auto;
}
</style>
