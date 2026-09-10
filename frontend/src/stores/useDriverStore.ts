import { defineStore } from 'pinia';
import { ref } from 'vue';

export type DriverStatus = 'IN_AUSLIEFERUNG' | 'PAUSIERT' | 'VERFÜGBAR' | 'URLAUB';

export interface Driver {
  id: string;
  name: string;
  phone: string;
  vehicle: string;
  activeTour: string;
  status: DriverStatus;
}

export interface DriverStats {
  totalStaff: number;
  active: number;
  onBreak: number;
  onLeave: number;
}

export const useDriverStore = defineStore('drivers', () => {
  const stats = ref<DriverStats>({
    totalStaff: 28,
    active: 12,
    onBreak: 14,
    onLeave: 2,
  });

  const drivers = ref<Driver[]>([
    {
      id: 'DRV-001',
      name: 'Müller, T.',
      phone: '+49 151 1234567',
      vehicle: 'DO-PM 102 (Sprinter)',
      activeTour: 'TR-1023',
      status: 'IN_AUSLIEFERUNG',
    },
    {
      id: 'DRV-002',
      name: 'Schmidt, K.',
      phone: '+49 152 9876543',
      vehicle: 'DO-PM 105 (Vito)',
      activeTour: 'TR-1024',
      status: 'PAUSIERT',
    },
    {
      id: 'DRV-003',
      name: 'Weber, H.',
      phone: '+49 170 5554433',
      vehicle: 'DO-PM 101 (Crafter)',
      activeTour: '-',
      status: 'VERFÜGBAR',
    },
  ]);

  return {
    stats,
    drivers,
  };
});