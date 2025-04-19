<template>
  <div class="container mt-5" style="max-width: 400px;">
    <h2 class="text-center mb-4">Connexion</h2>

    <form @submit.prevent="login">
      <div class="mb-3">
        <label for="login" class="form-label">Identifiant</label>
        <input type="text" v-model="loginForm.login" class="form-control" required />
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">Mot de passe</label>
        <input type="password" v-model="loginForm.password" class="form-control" required />
      </div>

      <button type="submit" class="btn btn-primary w-100">Se connecter</button>
    </form>

    <div class="text-center mt-3 text-danger" v-if="error">
      Identifiant ou mot de passe incorrect.
    </div>

    <div class="text-center mt-4">
      <router-link to="/register" class="text-decoration-none">
        Vous n'avez pas de compte ? Créez-en un ici
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const loginForm = ref({ login: '', password: '' })
const error = ref(false)

const login = async () => {
  //  Authentification simulée (à remplacer avec le backend réel plus tard)
  if (
    (loginForm.value.login === 'admin' && loginForm.value.password === 'admin') ||
    (loginForm.value.login === 'user' && loginForm.value.password === '1234')
  ) {
    const user = {
      login: loginForm.value.login,
      role: loginForm.value.login === 'admin' ? 'ADMIN' : 'MEMBER',
      id: loginForm.value.login === 'admin' ? 99 : 1
    }

    localStorage.setItem('user', JSON.stringify(user))
    error.value = false
    router.push('/')
  } else {
    error.value = true
  }
}
</script>
