<script setup lang="ts">
import AppLayout from '@/layouts/AppLayout.vue';
import KundenBadge from '@/components/kunden/KundenBadge.vue';
import { useCustomerStore } from '@/stores/useCustomerStore';

const customerStore = useCustomerStore();
</script>

<template>
  
    <!-- Page Title -->
    <div class="mb-8">
      <h1 class="text-gray-900 text-2xl md:text-[32px] font-bold leading-10 tracking-tight">
        Kundenverzeichnis
      </h1>
    </div>

    <!-- Summary Metrics Card -->
    <div class="bg-white border border-gray-200 rounded-xl overflow-hidden mb-8 shadow-sm">
      <div class="grid grid-cols-1 md:grid-cols-3">
        <!-- Metric 1 -->
        <div class="p-5 md:px-6 md:py-5 border-b md:border-b-0 md:border-r border-gray-200">
          <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider mb-2">
            Aktive Kunden
          </div>
          <div class="text-2xl font-semibold text-gray-900">
            {{ customerStore.stats.activeCustomers }}
          </div>
        </div>

        <!-- Metric 2 -->
        <div class="p-5 md:px-6 md:py-5 border-b md:border-b-0 md:border-r border-gray-200">
          <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider mb-2">
            Lieferung in diesem Monat
          </div>
          <div class="text-2xl font-semibold text-gray-900">
            {{ customerStore.stats.monthlyDeliveries }}
          </div>
        </div>

        <!-- Metric 3 -->
        <div class="p-5 md:px-6 md:py-5">
          <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider mb-2">
            Key-Account-Kunden (VIP)
          </div>
          <div class="text-2xl font-semibold text-gray-900">
            {{ customerStore.stats.vipCustomers }}
          </div>
        </div>
      </div>
    </div>

    <!-- Data Table Container -->
    <div class="bg-white border border-gray-200 rounded-xl overflow-hidden shadow-sm">
      <div class="px-6 py-4 border-b border-gray-200">
        <h2 class="text-gray-900 text-base font-semibold">
          Kunden Table
        </h2>
      </div>

      <div class="overflow-x-auto">
        <div class="min-w-[600px]">
          <!-- Table Header Grid -->
          <div class="grid grid-cols-[2fr_1.5fr_1.5fr_1.5fr_1.5fr_1fr] px-6 py-3 bg-gray-50 border-b border-gray-200">
            <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider">
              Name / Unternehmen
            </div>
            <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider">
              Hauptkontakt
            </div>
            <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider">
              Stadt
            </div>
            <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider">
              Vertrag
            </div>
            <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider">
              Volumen
            </div>
            <div class="text-[11px] font-semibold text-gray-500 uppercase tracking-wider">
              Aktionen
            </div>
          </div>

          <!-- Table Body Rows Grid -->
          <div
            v-for="(customer, index) in customerStore.customers"
            :key="customer.id"
            class="grid grid-cols-[2fr_1.5fr_1.5fr_1.5fr_1.5fr_1fr] px-6 py-4 items-center hover:bg-gray-50/50 transition-colors"
            :class="{ 'border-b border-gray-200': index !== customerStore.customers.length - 1 }"
          >
            <div class="text-sm font-medium text-gray-900">
              {{ customer.name }}
            </div>
            <div class="text-sm font-normal text-gray-700">
              {{ customer.mainContact }}
            </div>
            <div class="text-sm font-normal text-gray-700">
              {{ customer.city }}
            </div>
            <div>
              <KundenBadge :contract="customer.contract" />
            </div>
            <div class="text-sm font-normal text-gray-700">
              {{ customer.monthlyVolume }}
            </div>
            <div class="flex items-center gap-2">
              <button class="p-1 text-gray-400 hover:text-brand-500 transition-colors" title="Détails">
                <i class="ti ti-eye text-lg"></i>
              </button>
              <button class="p-1 text-gray-400 hover:text-amber-500 transition-colors" title="Éditer">
                <i class="ti ti-edit text-lg"></i>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  
</template>