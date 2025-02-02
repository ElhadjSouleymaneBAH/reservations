<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

// Déclaration des variables réactives avec `ref()`
const user = ref({
  id: 1, // Remplace par l'ID de l'utilisateur connecté
  firstname: '',
  lastname: '',
  email: '',
  password: '',
  profilePicturePath: '',
})

// Fonction pour récupérer les infos de l'utilisateur
const fetchUser = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/users/${user.value.id}`)
    user.value = response.data
  } catch (error) {
    console.error('Erreur lors du chargement du profil :', error)
  }
}

// Fonction pour mettre à jour le profil
const updateProfile = async () => {
  try {
    await axios.put(`http://localhost:8080/api/users/${user.value.id}`, user.value)
    alert('Profil mis à jour !')
  } catch (error) {
    console.error('Erreur :', error)
  }
}

// Fonction pour gérer l'upload de la photo de profil
const uploadFile = async (event) => {
  const file = event.target.files[0]
  const formData = new FormData()
  formData.append('file', file)

  try {
    const response = await axios.post('http://localhost:8080/api/users/upload', formData, {
      headers: { 'Content-Type': 'multipart/form-data' },
    })
    user.value.profilePicturePath = response.data
  } catch (error) {
    console.error("Erreur lors de l'upload de l'image :", error)
  }
}

// Appel de la fonction au montage du composant
onMounted(fetchUser)
</script>

<template>
  <div class="edit-profile">
    <h2>Modifier le Profil</h2>

    <form @submit.prevent="updateProfile">
      <label for="firstname">Nom :</label>
      <input id="firstname" v-model="user.firstname" type="text" required />

      <label for="lastname">Prénom :</label>
      <input id="lastname" v-model="user.lastname" type="text" required />

      <label for="email">Email :</label>
      <input id="email" v-model="user.email" type="email" required />

      <label for="password">Mot de passe :</label>
      <input id="password" v-model="user.password" type="password" />

      <label for="profilePicture">Photo de Profil :</label>
      <input id="profilePicture" type="file" @change="uploadFile" />

      <button type="submit">Sauvegarder</button>
    </form>
  </div>
</template>

<style scoped>
.edit-profile {
  max-width: 450px;
  margin: 50px auto;
  padding: 25px;
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}

h2 {
  color: #333;
  text-align: center;
  margin-bottom: 20px;
}

label {
  font-weight: bold;
  display: block;
  margin-top: 15px;
  color: #333;
}

input {
  display: block;
  width: 100%;
  margin: 5px 0;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px;
}

input[type="file"] {
  padding: 5px;
  border: none;
}

button {
  background: #28a745;
  color: white;
  padding: 12px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-top: 20px;
  border-radius: 5px;
  font-size: 16px;
  transition: 0.3s;
}

button:hover {
  background: #218838;
}
</style>
