<template>
  <div class="container mt-5">
    <h2 class="mb-4">Commentaires</h2>

    <div v-for="comment in comments" :key="comment.id" class="card mb-3">
      <div class="card-body">
        <h5 class="card-title">{{ comment.user.login }}</h5>
        <p class="card-text">{{ comment.review }}</p>

        <!-- ⭐ Affichage des étoiles -->
        <div class="text-warning mb-2">
          <span v-for="n in 5" :key="n">
            <i :class="n <= comment.stars ? 'fas fa-star' : 'far fa-star'"></i>
          </span>
        </div>

        <p class="text-muted">
          Publié le {{ new Date(comment.createdAt).toLocaleDateString() }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommentList",
  data() {
    return {
      comments: [],
    };
  },
  mounted() {
    this.fetchComments();
  },
  methods: {
    async fetchComments() {
      try {
        const response = await this.$axios.get("/api/reviews"); // à adapter selon ton endpoint
        this.comments = response.data;
      } catch (error) {
        console.error("Erreur lors du chargement des commentaires :", error);
      }
    },
  },
};
</script>

<style>
.card {
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
}
</style>
