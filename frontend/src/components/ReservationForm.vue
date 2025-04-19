<template>
  <div class="container mt-5">
    <h2 class="mb-4 text-center">Réserver : {{ show?.title }}</h2>

    <form @submit.prevent="submitReservation">
      <div class="mb-3">
        <label for="representation" class="form-label">Représentation</label>
        <select v-model="selectedRepresentationId" class="form-select" required>
          <option v-for="rep in representations" :key="rep.id" :value="rep.id">
            {{ formatDate(rep.schedule) }} - {{ rep.location?.designation || 'Lieu inconnu' }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="quantity" class="form-label">Quantité</label>
        <input type="number" v-model="quantity" class="form-control" min="1" required />
      </div>

      <button type="submit" class="btn btn-success">Valider la réservation</button>
      <router-link to="/" class="btn btn-secondary ms-2">Annuler</router-link>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const show = ref(null)
const representations = ref([])
const selectedRepresentationId = ref('')
const quantity = ref(1)

const loadData = async () => {
  try {
    const id = route.params.id
    const showResponse = await axios.get(`/api/shows/${id}`)
    const repResponse = await axios.get(`/api/representations/byShow/${id}`)

    show.value = showResponse.data
    representations.value = repResponse.data
  } catch (error) {
    console.error('Erreur lors du chargement des données :', error)
  }
}

const formatDate = (date) => {
  return new Date(date).toLocaleString('fr-BE', {
    weekday: 'long',
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  })
}

const submitReservation = async () => {
  try {
    const reservation = {
      representationId: selectedRepresentationId.value,
      quantity: quantity.value,
      userId: 1 //  À remplacer par l'utilisateur connecté une fois l'authentification implémentée
    }

    await axios.post('/api/reservations', reservation)
    alert('Réservation effectuée avec succès !')
  } catch (error) {
    console.error('Erreur lors de la réservation :', error)
    alert("Erreur lors de l'envoi de la réservation.")
  }
}

onMounted(loadData)
</script>
