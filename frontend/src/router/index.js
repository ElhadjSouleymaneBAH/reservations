import { createRouter, createWebHistory } from 'vue-router'

import Catalogue from '@/components/Catalogue.vue'
import ShowDetails from '@/components/ShowDetails.vue'
import ReservationForm from '@/components/ReservationForm.vue'
import UserReservations from '@/components/UserReservations.vue'
import AllReservations from '@/components/AllReservations.vue'
import LoginForm from '@/components/LoginForm.vue'
import RegisterForm from '@/components/RegisterForm.vue'
import ReservationAdminPanel from '@/components/ReservationAdminPanel.vue'
import CatalogueNoTag from '@/components/CatalogueNoTag.vue'

const routes = [
  {
    path: '/',
    name: 'Catalogue',
    component: Catalogue
  },
  {
    path: '/show/:id',
    name: 'ShowDetails',
    component: ShowDetails
  },
  {
    path: '/reserve/:id',
    name: 'Reserve',
    component: ReservationForm,
    meta: { requiresAuth: true }
  },
  {
    path: '/mes-reservations',
    name: 'UserReservations',
    component: UserReservations,
    meta: { requiresAuth: true }
  },
  {
    path: '/admin/reservations',
    name: 'AllReservations',
    component: AllReservations,
    meta: { requiresAuth: true, role: 'ADMIN' }
  },
  {
    path: '/admin/reservations/pending',
    name: 'PendingReservations',
    component: ReservationAdminPanel,
    meta: { requiresAuth: true, role: 'ADMIN' }
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginForm
  },
  {
    path: '/register',
    name: 'Register',
    component: RegisterForm
  },
  {
    path: '/catalogue-notag',
    name: 'CatalogueNoTag',
    component: CatalogueNoTag
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 🛡 protection des routes
router.beforeEach((to, from, next) => {
  const user = JSON.parse(localStorage.getItem('user'))

  if (to.meta.requiresAuth && !user) {
    next('/login')
  } else if (to.meta.role && (!user || user.role !== to.meta.role)) {
    next('/')
  } else {
    next()
  }
})

export default router
