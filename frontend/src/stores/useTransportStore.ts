import { defineStore } from 'pinia';
import { ref } from 'vue';

export type TransportStatus = 'IN_TRANSIT' | 'PICKED_UP' | 'DELIVERED' | 'DELAYED';

export interface TransportTour {
  id: string;
  driver: string;
  vehicle: string;
  zone: string;
  parcelsCount: number;
  deliveredCount: number;
  status: TransportStatus;
}

export interface TransportTourStats {
  todayTours: number;
  inTransit: number;
  completed: number;
  delayWarnings: number;
}

export const useTransportStore = defineStore('transports', () => {
  const stats = ref<TransportTourStats>({
    todayTours: 28,
    inTransit: 12,
    completed: 14,
    delayWarnings: 2,
  });

  const tours = ref<TransportTour[]>([
    {
      id: 'TR-1023',
      driver: 'Müller, T.',
      vehicle: 'DO-PM 102',
      zone: 'Dortmund-Nord',
      parcelsCount: 14,
      deliveredCount: 8,
      status: 'IN_TRANSIT',
    },
    {
      id: 'TR-1024',
      driver: 'Schmidt, K.',
      vehicle: 'DO-PM 105',
      zone: 'Bochum-Mitte',
      parcelsCount: 22,
      deliveredCount: 0,
      status: 'PICKED_UP',
    },
    {
      id: 'TR-1025',
      driver: 'Weber, H.',
      vehicle: 'DO-PM 101',
      zone: 'Hagen-Süd',
      parcelsCount: 14,
      deliveredCount: 14,
      status: 'DELIVERED',
    },
  ]);

  return {
    stats,
    tours,
  };
});