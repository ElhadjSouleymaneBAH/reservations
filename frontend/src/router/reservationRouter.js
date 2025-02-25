import { createRouter, createWebHistory } from 'vue-router';
import ReservationList from '../views/ReservationList.vue';

const routes = [
  { path: '/reservations', name: 'Reservations', component: ReservationList }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
