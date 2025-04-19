<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Toutes les Réservations</h2>

    <div v-if="reservations.length === 0" class="text-muted text-center">
      Aucune réservation trouvée.
    </div>

    <div v-else>
      <table class="table table-striped table-hover">
        <thead class="table-dark">
        <tr>
          <th>Utilisateur</th>
          <th>Spectacle</th>
          <th>Date</th>
          <th>Lieu</th>
          <th>Quantité</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="res in reservations" :key="res.id">
          <td>{{ res.user?.firstname }} {{ res.user?.lastname }}</td>
          <td>{{ res.representation?.show?.title }}</td>
          <td>{{ formatDate(res.representation?.schedule) }}</td>
          <td>{{ res.representation?.location?.designation }}</td>
          <td>{{ res.quantity }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const reservations = ref([])

const loadAllReservations = async () => {
  try {
    const response = await axios.get('/api/reservations')
    reservations.value = response.data
  } catch (error) {
    console.error('Erreur lors du chargement des réservations :', error)
  }
}

const formatDate = (dateStr) => {
  const date = new Date(dateStr)
  return date.toLocaleString('fr-BE', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  })
}

onMounted(loadAllReservations)
</script>
