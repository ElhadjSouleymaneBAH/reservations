<template>
  <div class="container mt-5" v-if="show">
    <h2 class="mb-4 text-center">{{ show.title }}</h2>

    <img
      v-if="show.posterUrl"
      :src="show.posterUrl"
      :alt="show.title"
      class="img-fluid rounded d-block mx-auto mb-4"
      style="max-height: 400px; object-fit: cover"
    />

    <ul class="list-group">
      <li class="list-group-item">
        <strong>Durée :</strong> {{ show.duration }} min
      </li>
      <li class="list-group-item">
        <strong>Année de création :</strong> {{ show.createdIn }}
      </li>
      <li class="list-group-item">
        <strong>Réservable :</strong>
        <span :class="show.bookable ? 'text-success' : 'text-danger'">
          {{ show.bookable ? 'Oui' : 'Non' }}
        </span>
      </li>
      <li class="list-group-item" v-if="show.locationDesignation">
        <strong>Lieu :</strong> {{ show.locationDesignation }}
      </li>
    </ul>

    <!-- Mots-clés (tags) -->
    <div v-if="show.tags && show.tags.length" class="mt-4">
      <strong>Mots-clés :</strong>
      <span
        v-for="tag in show.tags"
        :key="tag"
        class="badge bg-info text-dark me-2"
      >
        {{ tag }}
      </span>
    </div>

    <!-- Formulaire d'ajout de tag (admin seulement) -->
    <div class="mt-4" v-if="isAdmin">
      <form @submit.prevent="addTag">
        <div class="input-group">
          <input
            v-model="newTag"
            type="text"
            class="form-control"
            placeholder="Ajouter un mot-clé"
            required
          />
          <button class="btn btn-outline-primary" type="submit">
            Ajouter
          </button>
        </div>
      </form>
      <p v-if="tagMessage" class="text-success mt-2">{{ tagMessage }}</p>
    </div>

    <!-- Représentations -->
    <h4 class="mt-5">Représentations disponibles</h4>
    <div v-if="show.representations?.length">
      <table class="table mt-3">
        <thead>
        <tr>
          <th>Date & Heure</th>
          <th>Lieu</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr
          v-for="repr in show.representations"
          :key="repr.id"
        >
          <td>{{ formatDate(repr.schedule) }}</td>
          <td>{{ repr.location?.designation || 'Non précisé' }}</td>
          <td>
            <router-link
              class="btn btn-sm btn-primary"
              :to="`/reserve/${repr.id}`"
            >
              Réserver
            </router-link>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <div v-else class="text-muted mt-2">
      Aucune représentation prévue.
    </div>

    <!-- Retour -->
    <div class="text-center mt-4">
      <router-link to="/" class="btn btn-secondary">
        ← Retour au catalogue
      </router-link>
    </div>
  </div>

  <div v-else class="text-center mt-5">
    <div class="spinner-border text-primary" role="status"></div>
    <p class="mt-3">Chargement du spectacle...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

const show = ref(null)
const route = useRoute()

const newTag = ref('')
const tagMessage = ref('')
const isAdmin = localStorage.getItem('role') === 'ADMIN'

const loadShow = async () => {
  try {
    const { data } = await axios.get(`/api/shows/${route.params.id}`)
    show.value = data
  } catch (err) {
    console.error('Erreur récupération show :', err)
  }
}

const formatDate = datetimeStr => {
  return new Date(datetimeStr).toLocaleString('fr-BE', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  })
}

const addTag = async () => {
  try {
    await axios.post(`/api/tags/show/${show.value.id}/add`, { tag: newTag.value })
    tagMessage.value = 'Mot-clé ajouté avec succès'
    newTag.value = ''
    await loadShow()   // recharge pour afficher le nouveau tag
  } catch (err) {
    tagMessage.value = 'Erreur lors de l’ajout du mot-clé'
    console.error(err)
  }
}

onMounted(loadShow)
</script>
