import { defineStore } from 'pinia';
import { ref } from 'vue';

export type ParcelStatus = 'AUSSTEHEND' | 'IN_ARBEIT' | 'GELIEFERT' | 'ANOMALIE';

export interface Parcel {
  id: string;
  sender: string;
  recipient: string;
  formatAndWeight: string;
  status: ParcelStatus;
  transportId: string;
}

export interface ParcelSummaryMetric {
  label: string;
  value: number;
}

export const useParcelStore = defineStore('parcels', () => {
  const metrics = ref<ParcelSummaryMetric[]>([
    { label: 'Gesamtzahl der Pakete', value: 450 },
    { label: 'Wartet auf Zuweisung', value: 18 },
    { label: 'Wird gerade geliefert', value: 382 },
    { label: 'Anomalien / Verzögerungen', value: 3 },
  ]);

  const parcels = ref<Parcel[]>([
    {
      id: 'PKG-8821',
      sender: 'BMW Group AG',
      recipient: 'München (80331)',
      formatAndWeight: '1.2 kg (S)',
      status: 'AUSSTEHEND',
      transportId: '-',
    },
    {
      id: 'PKG-8822',
      sender: 'Bosch Logistics',
      recipient: 'Dortmund (44135)',
      formatAndWeight: '4.5 kg (M)',
      status: 'IN_ARBEIT',
      transportId: 'TR-1023',
    },
    {
      id: 'PKG-8823',
      sender: 'Siemens AG',
      recipient: 'Essen (45127)',
      formatAndWeight: '12.0 kg (L)',
      status: 'GELIEFERT',
      transportId: 'TR-1020',
    },
  ]);

  return {
    metrics,
    parcels,
  };
});