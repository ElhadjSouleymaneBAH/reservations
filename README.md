# Projet WPWD2024 – Réservations  

Ce projet est une application web de gestion de réservations de spectacles, réalisé dans le cadre de l’évaluation WPWD2024.

## Technologies utilisées
- Backend : Spring Boot + JPA + Flyway
- Frontend : Vue.js 3 + Vite
- Base de données : MySQL  8.2.0
- Tests API : Postman

##  Structure du projet
- `/src/main/java` → code source backend
- `/src/main/resources/db/migration` → migrations Flyway
- `/frontend` → application Vue.js
- `/sql/reservations.sql` → dump SQL de la base

##  Installation

1. Importer `reservations.sql` dans PhpMyAdmin
2. Lancer `ReservationsSpringbootApplication.java`
3. Lancer le frontend via :

```bash
cd frontend
npm install
npm run dev
