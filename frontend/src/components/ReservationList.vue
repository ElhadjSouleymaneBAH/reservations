<template>
  <div class="container mt-4">
    <h2 class="text-center">Mes Réservations</h2>

    <div v-if="reservations.length > 0">
      <table class="table table-hover mt-3">
        <thead class="table-dark">
        <tr>
          <th>Spectacle</th>
          <th>Date</th>
          <th>Places</th>
          <th>Prix (€)</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="reservation in reservations" :key="reservation.id">
          <td>{{ reservation.spectacle }}</td>
          <td>{{ formatDate(reservation.date) }}</td>
          <td>{{ reservation.places }}</td>
          <td>{{ reservation.prix }}</td>
        </tr>
        </tbody>
      </table>
    </div>

    <div v-else class="alert alert-warning text-center mt-3">
      <strong>Aucune réservation trouvée.</strong>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      reservations: [],
    };
  },
  methods: {
    async fetchReservations() {
      try {
        const response = await axios.get("http://localhost:8080/api/reservations");
        this.reservations = response.data._embedded?.reservations || [];
      } catch (error) {
        console.error("Erreur lors de la récupération des réservations :", error);
      }
    },
    formatDate(date) {
      return new Date(date).toLocaleString();
    }
  },
  mounted() {
    this.fetchReservations();
  }
};
</script>

<style>
h2 {
  color: #007bff;
}
</style>
