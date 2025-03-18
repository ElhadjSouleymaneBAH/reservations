<template>
  <div class="comment-list">
    <h2>Commentaires</h2>
    <ul v-if="comments.length > 0">
      <li v-for="comment in comments" :key="comment.id">
        <p><strong>{{ comment.user.firstname }}</strong> : {{ comment.review }}</p>
        <p>⭐ {{ comment.stars }} étoiles</p>
      </li>
    </ul>
    <p v-else>Aucun commentaire pour ce spectacle.</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      comments: [],
    };
  },
  props: {
    showId: Number, // Récupéré dynamiquement
  },
  methods: {
    async fetchComments() {
      try {
        const response = await axios.get(`http://localhost:8080/api/reviews/show/${this.showId}`);
        this.comments = response.data;
      } catch (error) {
        console.error("Erreur lors du chargement des commentaires :", error);
      }
    },
  },
  created() {
    this.fetchComments();
  },
};
</script>

<style scoped>
.comment-list {
  max-width: 500px;
  margin: 20px auto;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  background: #f3f3f3;
  padding: 10px;
  margin: 10px 0;
  border-radius: 5px;
}
</style>
