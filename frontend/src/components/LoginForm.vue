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
import axios from 'axios'

const router = useRouter()
const loginForm = ref({ login: '', password: '' })
const error = ref(false)

const login = async () => {
  try {
    const response = await axios.post('/api/auth/login', loginForm.value)

    const user = {
      login: loginForm.value.login,
      role: response.data.role,
      token: response.data.token,
      userId: response.data.userId
    }

    localStorage.setItem('user', JSON.stringify(user))
    axios.defaults.headers.common['Authorization'] = `Bearer ${user.token}`

    error.value = false
    router.push('/')
  } catch (err) {
    error.value = true
  }
}
</script>
