import { defineStore } from 'pinia';
import { ref } from 'vue';

export type VehicleStatus = 'IM_DIENST' | 'VERFÜGBAR' | 'INSPEKTION' | 'DEFECKT';

export interface Vehicle {
  id: string;
  plateNumber: string;
  model: string;
  maxCapacity: string;
  mileage: string;
  tuvInspection: string;
  status: VehicleStatus;
}

export interface VehicleStats {
  totalFleet: number;
  inService: number;
  available: number;
  inspection: number;
}

export const useVehicleStore = defineStore('vehicles', () => {
  const stats = ref<VehicleStats>({
    totalFleet: 12,
    inService: 9,
    available: 1,
    inspection: 2,
  });

  const vehicles = ref<Vehicle[]>([
    {
      id: 'VEH-001',
      plateNumber: 'DO-PM 102',
      model: 'MB Sprinter 316',
      maxCapacity: '1 200 kg / 10 m³',
      mileage: '4 500 km',
      tuvInspection: '10/2026',
      status: 'IM_DIENST',
    },
    {
      id: 'VEH-002',
      plateNumber: 'DO-PM 105',
      model: 'VW Vito 114',
      maxCapacity: '900 kg / 6 m³',
      mileage: '42 100 km',
      tuvInspection: '04/2027',
      status: 'IM_DIENST',
    },
    {
      id: 'VEH-003',
      plateNumber: 'DO-PM 108',
      model: 'Ford Transit',
      maxCapacity: '1 400 kg / 12 m³',
      mileage: '20 300 km',
      tuvInspection: '09/2026',
      status: 'INSPEKTION',
    },
  ]);

  return {
    stats,
    vehicles,
  };
});