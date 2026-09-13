<script setup lang="ts">
import type { TransportStatus } from '@/services/transport.service';

const props = defineProps<{
  status: TransportStatus;
}>();

const badgeStyles: Record<TransportStatus, string> = {
  IN_TRANSIT: 'bg-blue-50 text-blue-700',
  PICKED_UP: 'bg-amber-50 text-amber-800',
  DELIVERED: 'bg-emerald-50 text-emerald-800',
  DELAYED: 'bg-red-50 text-red-700',
};
</script>

<template>
  <span
    class="inline-block px-2.5 py-1 rounded-full text-xs font-medium"
    :class="badgeStyles[props.status]"
  >
    {{ props.status }}
  </span>
</template>