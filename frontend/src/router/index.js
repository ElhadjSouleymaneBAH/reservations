import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EditProfile from '../components/EditProfile.vue' //Ajout de la page d'édition du profil

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/edit-profile',
      name: 'edit-profile',
      component: EditProfile, // Ajout de la route pour modifier le profil
    },
  ],
})

export default router
