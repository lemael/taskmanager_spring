import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router';

// Lazy loading des vues pour optimiser les performances
const DashboardView = () => import('@/views/DashboardView.vue');
const ColisView = () => import('@/views/ColisView.vue');
const TransportsView = () => import('@/views/TransportsView.vue');
const DriversView = () => import('@/views/DriversView.vue');
const VehiclesView = () => import('@/views/VehiclesView.vue');
const KundenView = () => import('@/views/KundenView.vue');

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/dashboard',
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: DashboardView,
    meta: {
      title: 'Dashboard - ParcelManager',
      requiresAuth: true,
    },
  },
  {
    path: '/colis',
    name: 'Colis',
    component: ColisView,
    meta: {
      title: 'Gestion des Colis - ParcelManager',
      requiresAuth: true,
    },
  },
  {
    path: '/transports',
    name: 'Transports',
    component: TransportsView,
    meta: {
      title: 'Transports - ParcelManager',
      requiresAuth: true,
    },
  },
  {
    path: '/fahrer',
    name: 'Drivers',
    component: DriversView,
    meta: {
      title: 'Chauffeurs (Fahrer) - ParcelManager',
      requiresAuth: true,
    },
  },
  {
    path: '/autos',
    name: 'Vehicles',
    component: VehiclesView,
    meta: {
      title: 'Véhicules (Autos) - ParcelManager',
      requiresAuth: true,
    },
  },
  {
    path: '/kunden',
    name: 'Kunden',
    component: KundenView,
    meta: {
      title: 'Kunden - ParcelManager',
      requiresAuth: true,
    },
  },
  {
    // Capture les routes inconnues
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: () => import('@/views/NotFoundView.vue'),
    meta: {
      title: 'Page non trouvée - ParcelManager',
    },
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
  scrollBehavior(_to, _from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    }
    return { top: 0 };
  },
});

// Guard de navigation : Met à jour le document.title automatiquement
router.beforeEach((to, _from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title as string;
  }
  next();
});

export default router;