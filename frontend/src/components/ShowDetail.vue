<template>
  <div class="container mt-5" v-if="show">
    <h2 class="mb-3">{{ show.title }}</h2>

    <div class="row">
      <div class="col-md-4">
        <img
          v-if="show.posterUrl"
          :src="show.posterUrl"
          :alt="show.title"
          class="img-fluid rounded"
        />
        <div v-else class="text-muted">Aucune affiche disponible</div>
      </div>

      <div class="col-md-8">
        <ul class="list-group">
          <li class="list-group-item">
            <strong>Durée :</strong> {{ show.duration }} minutes
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
          <li class="list-group-item">
            <strong>Lieu :</strong> {{ show.location?.designation || 'Non spécifié' }}
          </li>
        </ul>
      </div>
    </div>

    <router-link to="/" class="btn btn-secondary mt-4">Retour</router-link>
  </div>

  <div v-else class="text-center mt-5">
    <p>Chargement...</p>
  </div>
</template>

<script>
export default {
  name: "ShowDetail",
  data() {
    return {
      show: null,
    };
  },
  mounted() {
    const id = this.$route.params.id;
    fetch(`/api/shows/${id}`)
      .then((res) => res.json())
      .then((data) => {
        this.show = data;
      })
      .catch((err) => {
        console.error("Erreur lors du chargement :", err);
      });
  },
};
</script>

<style scoped>
img {
  max-height: 300px;
  object-fit: cover;
}
</style>
