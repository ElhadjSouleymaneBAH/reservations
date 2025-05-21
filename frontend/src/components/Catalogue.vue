<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Catalogue des Spectacles</h2>

    <div class="input-group mb-4">
      <input
        v-model="keyword"
        @input="fetchShows"
        type="text"
        class="form-control"
        placeholder="Rechercher un spectacle..."
      />
    </div>

    <div v-if="shows.length === 0" class="text-center text-muted">
      Aucun spectacle trouvé.
    </div>

    <div v-else class="row">
      <div class="col-md-6 mb-4" v-for="show in shows" :key="show.id">
        <div class="card h-100 shadow-sm">
          <img
            :src="getImageUrl(show.posterUrl)"
            :alt="show.title"
            class="card-img-top"
            style="max-height: 300px; object-fit: cover"
          />
          <div class="card-body">
            <h5 class="card-title">{{ show.title }}</h5>
            <p class="card-text">
              Durée : {{ show.duration }} minutes<br />
              Année : {{ formatDate(show.createdIn) }}
            </p>
            <span
              class="badge"
              :class="show.bookable ? 'bg-success' : 'bg-secondary'"
            >
              {{ show.bookable ? 'Réservable' : 'Non réservable' }}
            </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

const shows = ref([]);
const keyword = ref("");

const fetchShows = async () => {
  try {
    const response = await axios.get("/api/public/shows", {
      params: { keyword: keyword.value },
    });
    shows.value = response.data;
  } catch (error) {
    console.error("Erreur lors de la récupération des spectacles :", error);
  }
};

const formatDate = (dateStr) => {
  return new Date(dateStr).getFullYear();
};

const getImageUrl = (path) => {

  return path.startsWith("/") ? path : `/images/${path}`;
};

onMounted(fetchShows);
</script>

<style scoped>
.card-img-top {
  border-radius: 8px;
}
</style>
