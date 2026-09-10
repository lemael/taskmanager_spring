<script setup lang="ts">
import type { ContractType } from '@/stores/useKundenStore';

const props = defineProps<{
  contract: ContractType;
}>();

const badgeStyles: Record<ContractType, string> = {
  'VIP Express': 'bg-purple-50 text-purple-700 border-purple-200',
  'Standard Pro': 'bg-blue-50 text-blue-700 border-blue-200',
  Basic: 'bg-gray-100 text-gray-700 border-gray-200',
};
</script>

<template>
  <span
    class="inline-block px-2.5 py-0.5 rounded-full text-xs font-medium border"
    :class="badgeStyles[props.contract]"
  >
    {{ props.contract }}
  </span>
</template>