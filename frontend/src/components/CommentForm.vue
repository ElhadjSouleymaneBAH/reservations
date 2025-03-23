<template>
  <div class="card p-4 mb-4">
    <h2>Laisser un commentaire</h2>

    <form @submit.prevent="submitComment">
      <div class="mb-3">
        <label for="review" class="form-label">Votre commentaire</label>
        <textarea v-model="review" id="review" class="form-control" rows="3" required></textarea>
      </div>

      <div class="mb-3">
        <label for="stars" class="form-label">Note</label>
        <select v-model="stars" id="stars" class="form-select" required>
          <option value="" disabled>Choisir une note</option>
          <option v-for="n in 5" :key="n" :value="n">{{ n }} étoile{{ n > 1 ? 's' : '' }}</option>
        </select>
      </div>

      <div class="mb-3">
        <label for="userId" class="form-label">Utilisateur</label>
        <input v-model="userId" type="number" id="userId" class="form-control" placeholder="ID utilisateur" required />
      </div>

      <div class="mb-3">
        <label for="showId" class="form-label">Spectacle</label>
        <input v-model="showId" type="number" id="showId" class="form-control" placeholder="ID du spectacle" required />
      </div>

      <button type="submit" class="btn btn-primary">Envoyer</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      review: '',
      stars: '',
      userId: '',
      showId: '',
    };
  },
  methods: {
    async submitComment() {
      const newComment = {
        review: this.review,
        stars: this.stars,
        validated: false, // en attente de modération
        user: { id: this.userId },
        show: { id: this.showId },
      };

      try {
        await fetch('/api/reviews', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(newComment),
        });

        this.review = '';
        this.stars = '';
        this.userId = '';
        this.showId = '';
        this.$emit('comment-submitted');
        alert("Commentaire envoyé !");
      } catch (error) {
        console.error('Erreur lors de l’envoi :', error);
        alert("Une erreur s'est produite.");
      }
    },
  },
};
</script>
