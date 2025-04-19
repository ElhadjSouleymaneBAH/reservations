<template>
  <div class="container mt-5" style="max-width: 500px;">
    <h2 class="text-center mb-4">Créer un compte</h2>

    <form @submit.prevent="register">
      <div class="row mb-3">
        <div class="col">
          <input v-model="form.firstname" type="text" class="form-control" placeholder="Prénom" required />
        </div>
        <div class="col">
          <input v-model="form.lastname" type="text" class="form-control" placeholder="Nom" required />
        </div>
      </div>

      <div class="mb-3">
        <input v-model="form.login" type="text" class="form-control" placeholder="Nom d'utilisateur" required />
      </div>

      <div class="mb-3">
        <input v-model="form.password" type="password" class="form-control" placeholder="Mot de passe" required />
      </div>

      <div class="mb-3">
        <input v-model="form.email" type="email" class="form-control" placeholder="Email" required />
      </div>

      <div class="mb-3">
        <select v-model="form.langue" class="form-select" required>
          <option value="" disabled>Langue préférée</option>
          <option value="fr">Français</option>
          <option value="en">Anglais</option>
        </select>
      </div>

      <button type="submit" class="btn btn-success w-100">S’inscrire</button>
    </form>

    <div v-if="success" class="alert alert-success mt-3 text-center">
      Compte créé avec succès ! Vous pouvez maintenant vous connecter.
    </div>
    <div v-if="error" class="alert alert-danger mt-3 text-center">
      Une erreur est survenue lors de l'inscription.
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const form = ref({
  firstname: '',
  lastname: '',
  login: '',
  password: '',
  email: '',
  langue: '',
  role: 'MEMBER' // rôle par défaut
})

const success = ref(false)
const error = ref(false)

const register = async () => {
  try {
    await axios.post('/api/users', form.value)
    success.value = true
    error.value = false
    form.value = {
      firstname: '',
      lastname: '',
      login: '',
      password: '',
      email: '',
      langue: '',
      role: 'MEMBER'
    }
  } catch (err) {
    console.error(err)
    success.value = false
    error.value = true
  }
}
</script>
