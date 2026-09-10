<script setup lang="ts">
import type { ParcelStatus } from '@/stores/useParcelStore';

const props = defineProps<{
  status: ParcelStatus;
}>();

const badgeStyles: Record<ParcelStatus, string> = {
  AUSSTEHEND: 'bg-gray-100 text-gray-700 border-gray-200',
  IN_ARBEIT: 'bg-blue-50 text-blue-700 border-blue-200',
  GELIEFERT: 'bg-emerald-50 text-emerald-800 border-emerald-200',
  ANOMALIE: 'bg-red-50 text-red-700 border-red-200',
};

const labels: Record<ParcelStatus, string> = {
  AUSSTEHEND: 'ausstehend',
  IN_ARBEIT: 'In Arbeit',
  GELIEFERT: 'Geliefert',
  ANOMALIE: 'Anomalie',
};
</script>

<template>
  <span
    class="inline-block px-2.5 py-0.5 rounded-full text-xs font-medium border"
    :class="badgeStyles[props.status]"
  >
    {{ labels[props.status] || props.status }}
  </span>
</template>