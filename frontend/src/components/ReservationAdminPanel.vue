<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Réservations en attente de validation</h2>

    <div v-if="pending.length === 0" class="text-muted text-center">
      Aucune réservation à valider.
    </div>

    <div v-else>
      <table class="table table-bordered table-hover">
        <thead class="table-light">
        <tr>
          <th>Utilisateur</th>
          <th>Spectacle</th>
          <th>Date</th>
          <th>Lieu</th>
          <th>Quantité</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="res in pending" :key="res.id">
          <td>{{ res.user.firstname }} {{ res.user.lastname }}</td>
          <td>{{ res.representation.show.title }}</td>
          <td>{{ formatDate(res.representation.schedule) }}</td>
          <td>{{ res.representation.location.designation }}</td>
          <td>{{ res.quantity }}</td>
          <td>
            <button class="btn btn-success btn-sm me-2" @click="validate(res.id)">Valider</button>
            <button class="btn btn-danger btn-sm" @click="reject(res.id)">Rejeter</button>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const pending = ref([])

const loadPending = async () => {
  try {
    const response = await axios.get('/api/reservations/pending')
    pending.value = response.data
  } catch (error) {
    console.error("Erreur lors du chargement :", error)
  }
}

const validate = async (id) => {
  try {
    await axios.put(`/api/reservations/${id}/validate`)
    pending.value = pending.value.filter(r => r.id !== id)
  } catch (error) {
    console.error("Erreur lors de la validation :", error)
  }
}

const reject = async (id) => {
  try {
    await axios.put(`/api/reservations/${id}/reject`)
    pending.value = pending.value.filter(r => r.id !== id)
  } catch (error) {
    console.error("Erreur lors du rejet :", error)
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

onMounted(loadPending)
</script>
