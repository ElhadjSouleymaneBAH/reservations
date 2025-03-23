<template>
  <div class="container mt-5">
    <h1 class="text-center mb-4">Gestion des Réservations & Commentaires</h1>


    <!-- Boutons d'action pour Réservations -->
    <div class="text-center mb-4">
      <button class="btn btn-primary me-2">Gérer mes Réservations</button>
      <button class="btn btn-success">Ajouter une Réservation</button>
    </div>

    <!-- Liste des Réservations -->
    <ReservationList />

    <hr class="my-5" />

    <!-- Commentaires sur les spectacles -->
    <div>
      <h2 class="text-center mb-3">Donner votre avis sur un spectacle</h2>
      <CommentForm />
    </div>

    <div class="mt-5">
      <h2 class="text-center mb-3">Commentaires publiés</h2>
      <CommentList />
    </div>
  </div>
</template>

<script>
import ReservationList from "./ReservationList.vue";
import CommentForm from "./CommentForm.vue";
import CommentList from "./CommentList.vue";

export default {
  components: {
    ReservationList,
    CommentForm,
    CommentList
  },
};
</script>

<style>
body {
  background-color: #f8f9fa;
}
.container {
  max-width: 900px;
  margin: auto;
}
</style>
