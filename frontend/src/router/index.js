import { createRouter, createWebHistory } from 'vue-router';
import ReservationList from '../components/ReservationList.vue';
import ShowDetail from '../components/ShowDetail.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: ReservationList,
  },
  {
    path: '/shows/:id',
    name: 'ShowDetail',
    component: ShowDetail,
    props: true
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
