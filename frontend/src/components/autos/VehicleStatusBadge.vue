<script setup lang="ts">
import type { VehicleStatus } from '@/stores/useVehicleStore';

const props = defineProps<{
  status: VehicleStatus;
}>();

const badgeStyles: Record<VehicleStatus, string> = {
  IM_DIENST: 'bg-blue-50 text-blue-700 border-blue-200',
  VERFÜGBAR: 'bg-emerald-50 text-emerald-800 border-emerald-200',
  INSPEKTION: 'bg-amber-50 text-amber-800 border-amber-200',
  DEFECKT: 'bg-red-50 text-red-700 border-red-200',
};

const labels: Record<VehicleStatus, string> = {
  IM_DIENST: 'Im Dienst',
  VERFÜGBAR: 'Verfügbar',
  INSPEKTION: 'Inspektion',
  DEFECKT: 'Defekt',
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