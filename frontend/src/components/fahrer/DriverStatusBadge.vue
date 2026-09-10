<script setup lang="ts">
import type { DriverStatus } from '@/stores/useDriverStore';

const props = defineProps<{
  status: DriverStatus;
}>();

const badgeStyles: Record<DriverStatus, string> = {
  IN_AUSLIEFERUNG: 'bg-blue-50 text-blue-700 border-blue-200',
  PAUSIERT: 'bg-amber-50 text-amber-800 border-amber-200',
  VERFÜGBAR: 'bg-emerald-50 text-emerald-800 border-emerald-200',
  URLAUB: 'bg-gray-100 text-gray-600 border-gray-200',
};
</script>

<template>
  <span
    class="inline-block px-2.5 py-1 rounded-full text-xs font-semibold border"
    :class="badgeStyles[props.status]"
  >
    {{ props.status }}
  </span>
</template>