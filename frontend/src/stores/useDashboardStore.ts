import { defineStore } from 'pinia';
import { ref } from 'vue';

export type TransportStatus = 'IN_TRANSIT' | 'PICKED_UP' | 'DELIVERED' | 'PENDING';

export interface Transport {
  id: string;
  driver: string;
  status: TransportStatus;
}

export interface DashboardStats {
  total: number;
  inProgress: number;
  delivered: number;
  pending: number;
}

export const useDashboardStore = defineStore('dashboard', () => {
  // State
  const user = ref({ name: 'Thomas Müller', role: 'Dispatcher' });

  const stats = ref<DashboardStats>({
    total: 124,
    inProgress: 32,
    delivered: 87,
    pending: 5,
  });

  const recentTransports = ref<Transport[]>([
    { id: 'TR-1023', driver: 'Müller', status: 'IN_TRANSIT' },
    { id: 'TR-1024', driver: 'Schmidt', status: 'PICKED_UP' },
    { id: 'TR-1025', driver: 'Weber', status: 'DELIVERED' },
  ]);

  // Actions
  function setTransports(transports: Transport[]) {
    recentTransports.value = transports;
  }

  return {
    user,
    stats,
    recentTransports,
    setTransports,
  };
});