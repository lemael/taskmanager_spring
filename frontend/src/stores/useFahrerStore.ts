import { defineStore } from 'pinia';
import { ref } from 'vue';
import { fahrerService} from '@/services/fahrer.service';
import type { Fahrer } from '@/services/fahrer.service';


export interface FahrerStats {
  totalStaff: number;
  active: number;
  onBreak: number;
  onLeave: number;
}

export const useFahrerStore = defineStore('fahrer', () => {
  const loading = ref<boolean>(false);
  const error = ref<string | null>(null);
  const fahrers = ref<Fahrer[]>([]);
  const stats = ref<FahrerStats>({
    totalStaff: 28,
    active: 12,
    onBreak: 14,
    onLeave: 2,
  });

  const fetchFahrer = async () => {
    loading.value = true;
    error.value = null;
    try {
      const data = await fahrerService.getAll();
      fahrers.value = data;
    } catch (err: any) {
      error.value = err.message || 'Fehler beim Laden der Fahrer.';
      console.error('Error fetching fahrers:', err);
    } finally {
      loading.value = false;
    }
  };

  return {
    stats,
    fahrers,
    loading,
    error,
    fetchFahrer,
  };
});