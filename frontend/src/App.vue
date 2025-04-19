<template>
  <div>
    <!-- Bandeau utilisateur connecté -->
    <div class="bg-light border-bottom p-3 d-flex justify-content-between align-items-center">
      <div>
        <router-link to="/" class="btn btn-outline-secondary btn-sm me-2">
          Catalogue
        </router-link>
        <router-link to="/catalogue-notag" class="btn btn-outline-danger btn-sm">
          Sans mot-clé
        </router-link>
      </div>

      <div v-if="user">
        Connecté en tant que <strong>{{ user.login }}</strong>
        <button class="btn btn-sm btn-outline-danger ms-3" @click="logout">
          Se déconnecter
        </button>
      </div>
      <div v-else>
        <router-link to="/login" class="btn btn-sm btn-primary">Se connecter</router-link>
      </div>
    </div>

    <!-- Affichage de la vue active -->
    <router-view />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const user = ref(null)

const logout = () => {
  localStorage.removeItem('user')
  location.reload()
}

onMounted(() => {
  const stored = localStorage.getItem('user')
  if (stored) {
    user.value = JSON.parse(stored)
  }
})
</script>

<style>
body {
  background-color: #f8f9fa;
  margin: 0;
  font-family: "Segoe UI", Roboto, sans-serif;
}
</style>
