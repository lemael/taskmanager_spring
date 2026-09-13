<script setup lang="ts">
import type { TransportStatus } from '@/services/transport.service';
const props = defineProps<{
  status: TransportStatus;
}>();

const statusStyles: Record<TransportStatus, string> = {
  IN_TRANSIT: 'bg-blue-50 text-blue-700 border-blue-200',
  PICKED_UP: 'bg-amber-50 text-amber-700 border-amber-200',
  DELIVERED: 'bg-emerald-50 text-emerald-700 border-emerald-200',
  DELAYED: 'bg-gray-50 text-gray-600 border-gray-200',
};
</script>

<template>
  <span
    class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-semibold border"
    :class="statusStyles[props.status]"
  >
    {{ props.status }}
  </span>
</template>