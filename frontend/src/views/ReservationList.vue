<template>
  <div>
    <h2>Liste des réservations</h2>
    <ul>
      <li v-for="reservation in reservations" :key="reservation.id">
        <strong>Spectacle :</strong> {{ reservation.show.title }} <br>
        <strong>Date :</strong> {{ reservation.date }} <br>
        <strong>Places :</strong> {{ reservation.quantity }} <br>
        <strong>Prix :</strong> {{ reservation.price }} €
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      reservations: []
    };
  },
  mounted() {
    axios.get("http://localhost:8080/api/reservations/user/1") // Remplace 1 par l'ID dynamique
      .then(response => {
        this.reservations = response.data;
      })
      .catch(error => {
        console.error("Erreur lors du chargement des réservations :", error);
      });
  }
};
</script>

<style scoped>
ul {
  list-style-type: none;
}
</style>
