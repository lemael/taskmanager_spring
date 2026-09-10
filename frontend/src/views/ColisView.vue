<script setup lang="ts">
import AppLayout from '@/layouts/AppLayout.vue';
import ParcelStatusBadge from '@/components/colis/ColisStatusBadge.vue';
import { useParcelStore } from '@/stores/useParcelStore';

const parcelStore = useParcelStore();
</script>

<template>
  
    <!-- Page Header -->
    <div class="mb-8">
      <h1 class="text-gray-900 text-2xl md:text-[28px] font-bold leading-9 tracking-tight">
        Paketverwaltung
      </h1>
    </div>

    <!-- Summary Metrics Card -->
    <div class="bg-white border border-gray-200 rounded-lg overflow-hidden mb-10 shadow-sm">
      <!-- Card Header -->
      <div class="grid grid-cols-2 border-b border-gray-200 bg-gray-50/50">
        <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider">
          LABEL
        </div>
        <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider">
          VALUE
        </div>
      </div>

      <!-- Card Metrics Rows -->
      <div class="divide-y divide-gray-200">
        <div
          v-for="item in parcelStore.metrics"
          :key="item.label"
          class="grid grid-cols-2 hover:bg-gray-50/30 transition-colors"
        >
          <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
            {{ item.label }}
          </div>
          <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
            {{ item.value }}
          </div>
        </div>
      </div>
    </div>

    <!-- Data Table Header Title -->
    <div class="mb-5">
      <h2 class="text-gray-900 text-base font-bold leading-6">
        Struktur der Tabelle (ColisTable)
      </h2>
    </div>

    <!-- Data Table Container -->
    <div class="bg-white border border-gray-200 rounded-lg overflow-hidden shadow-sm">
      <div class="overflow-x-auto">
        <div class="min-w-[700px]">
          <!-- Table Header Grid -->
          <div class="grid grid-cols-6 border-b border-gray-200 bg-white">
            <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider">
              COLIS-ID
            </div>
            <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider">
              KUNDE / ABSENDER
            </div>
            <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider">
              EMPFÄNGER
            </div>
            <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider leading-4">
              FORMAT UND GEWICHT
            </div>
            <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider">
              STATUS
            </div>
            <div class="px-6 py-3.5 text-xs font-bold text-gray-900 uppercase tracking-wider leading-4">
              VERBUNDENER TRANSPORT
            </div>
          </div>

          <!-- Table Body Rows Grid -->
          <div
            v-for="(parcel, index) in parcelStore.parcels"
            :key="parcel.id"
            class="grid grid-cols-6 items-center hover:bg-gray-50/50 transition-colors"
            :class="{ 'border-b border-gray-200': index !== parcelStore.parcels.length - 1 }"
          >
            <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
              {{ parcel.id }}
            </div>
            <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
              {{ parcel.sender }}
            </div>
            <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
              {{ parcel.recipient }}
            </div>
            <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
              {{ parcel.formatAndWeight }}
            </div>
            <div class="px-6 py-4.5">
              <ParcelStatusBadge :status="parcel.status" />
            </div>
            <div class="px-6 py-4.5 text-sm font-normal text-gray-700">
              {{ parcel.transportId }}
            </div>
          </div>
        </div>
      </div>
    </div>
 
</template>