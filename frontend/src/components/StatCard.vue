<script setup lang="ts">
defineProps<{
  value: number | string;
  label: string;
}>();
</script>

<template>
  <div class="bg-white rounded-xl border border-gray-200 flex flex-col items-center justify-center py-8 px-4 shadow-sm">
    <span class="text-[36px] leading-[44px] font-bold text-gray-900">{{ value }}</span>
    <span class="text-sm font-normal text-gray-400 mt-2">{{ label }}</span>
  </div>
</template>