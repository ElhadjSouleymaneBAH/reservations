<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Mes Réservations</h2>

    <div v-if="reservations.length === 0" class="text-muted text-center">
      Vous n'avez pas encore effectué de réservation.
    </div>

    <div v-else>
      <table class="table table-bordered table-hover">
        <thead class="table-light">
        <tr>
          <th>Spectacle</th>
          <th>Date & Heure</th>
          <th>Lieu</th>
          <th>Quantité</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="res in reservations" :key="res.id">
          <td>{{ res.representation?.show?.title || '-' }}</td>
          <td>{{ formatDate(res.representation?.schedule) }}</td>
          <td>{{ res.representation?.location?.designation || '-' }}</td>
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

//  Récupération de l'utilisateur connecté
const user = JSON.parse(localStorage.getItem('user'))
const userId = user?.id || null

const loadReservations = async () => {
  if (!userId) return
  try {
    const response = await axios.get(`/api/reservations/byUser/${userId}`)
    reservations.value = response.data
  } catch (error) {
    console.error('Erreur lors du chargement des réservations :', error)
  }
}

const formatDate = (dateStr) => {
  const date = new Date(dateStr)
  return date.toLocaleString('fr-BE', {
    weekday: 'long',
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  })
}

onMounted(loadReservations)
</script>
