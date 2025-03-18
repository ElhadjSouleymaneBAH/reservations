<template>
  <div class="comment-form">
    <h2>Ajouter un commentaire</h2>
    <form @submit.prevent="submitComment">
      <textarea v-model="comment.review" placeholder="Votre commentaire..." required></textarea>
      <select v-model="comment.stars">
        <option disabled value="">Note (1 à 5)</option>
        <option v-for="n in 5" :key="n" :value="n">{{ n }} ⭐</option>
      </select>
      <button type="submit">Soumettre</button>
    </form>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      comment: {
        review: "",
        stars: "",
        userId: 1, // Simulé, à remplacer par l'ID de l'utilisateur connecté
        showId: 1, // Simulé, à remplacer dynamiquement
      },
      message: "",
    };
  },
  methods: {
    async submitComment() {
      try {
        await axios.post("http://localhost:8080/api/reviews", this.comment);
        this.message = "Commentaire soumis avec succès !";
        this.comment.review = "";
        this.comment.stars = "";
        this.$emit("comment-added"); // Pour rafraîchir la liste des commentaires
      } catch (error) {
        console.error("Erreur lors de l'ajout du commentaire :", error);
        this.message = "Erreur lors de l'envoi du commentaire.";
      }
    },
  },
};
</script>

<style scoped>
.comment-form {
  max-width: 400px;
  margin: 20px auto;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
textarea {
  width: 100%;
  height: 80px;
  margin-bottom: 10px;
}
button {
  background-color: #42b983;
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
}
</style>
