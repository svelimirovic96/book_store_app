import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/prodavac',
    name: 'Admin',
    component: () =>import('../views/Admin.vue')
  },
  {
    path: '/detaljiknjige/:id',
    name: 'DetaljiKnjige',
    component: () =>import('../views/DetaljiKnjige.vue'),
  },
  {
    path: '/kupac',
    name: 'Kupac',
    component: () =>import('../views/Kupac.vue')
  },
  {
    path: '/promena_podataka_1',
    name: 'PromenaPodataka',
    component: () =>import('../views/PromenaPodataka.vue')
  },
  {
    path: '/promena_podataka_2',
    name: 'PromenaPodatakaAdmin',
    component: () =>import('../views/PromenaPodatakaAdmin.vue')
  },
  {
    path: '/dodavanje_knjige',
    name: 'DodavanjeKnjige',
    component: () =>import('../views/DodavanjeKnjige.vue')
  },
  {
    path: '/preporuke',
    name: 'Preporuke',
    component: () =>import('../views/Preporuke.vue')
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
