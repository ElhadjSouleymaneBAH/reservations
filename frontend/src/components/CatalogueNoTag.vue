<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Spectacles sans un mot-clé donné</h2>

    <div class="input-group mb-4">
      <input
        v-model="tagLabel"
        @keyup.enter="loadShows"
        type="text"
        class="form-control"
        placeholder="Entrez un mot-clé à exclure"
      />
      <button class="btn btn-outline-danger" @click="loadShows">Filtrer</button>
    </div>

    <div v-if="loading" class="text-center">
      <div class="spinner-border text-primary" role="status"></div>
      <p>Chargement...</p>
    </div>

    <div v-if="!loading && shows.length === 0" class="alert alert-warning text-center">
      Aucun spectacle trouvé.
    </div>

    <div class="row" v-else>
      <div class="col-md-6 mb-4" v-for="show in shows" :key="show.id">
        <div class="card h-100 shadow-sm">
          <img
            :src="show.posterUrl"
            :alt="show.title"
            class="card-img-top"
            style="max-height: 300px; object-fit: cover"
          />
          <div class="card-body">
            <h5 class="card-title">{{ show.title }}</h5>
            <p class="card-text">
              Durée : {{ show.duration }} min<br />
              Année : {{ show.createdIn }}
            </p>
            <router-link :to="`/shows/${show.id}`" class="btn btn-outline-primary btn-sm">
              Voir détails
            </router-link>
          </div>
        </div>
      </div>
    </div>

    <div class="text-center mt-4">
      <router-link to="/" class="btn btn-secondary">← Retour au catalogue</router-link>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const tagLabel = ref('')
const shows = ref([])
const loading = ref(false)

const loadShows = async () => {
  if (!tagLabel.value) return

  loading.value = true
  try {
    const response = await axios.get(`/api/tags/without/${tagLabel.value}`)
    shows.value = response.data
  } catch (err) {
    console.error('Erreur lors du chargement des spectacles :', err)
    shows.value = []
  } finally {
    loading.value = false
  }
}
</script>
