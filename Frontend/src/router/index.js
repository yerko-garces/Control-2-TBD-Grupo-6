import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    { 
      path: '/crear-tarea',
      name: 'crear-tarea', 
      component: () => import('../views/Crear-tareaView.vue')
    },
    { 
      path: '/registrar-usuario',
      name: 'registrar-usuario', 
      component: () => import('../views/registrar-usuario.vue')
    }
  ]
})

export default router
