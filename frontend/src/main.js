import { createApp } from 'vue';
import App from './components/App.vue';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

const app = createApp(App);
app.config.globalProperties.$axios = axios;
app.mount('#app');
