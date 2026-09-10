<script setup lang="ts">
import AppLayout from '@/layouts/AppLayout.vue';
import DriverStatusBadge from '@/components/fahrer/DriverStatusBadge.vue';
import { useDriverStore } from '@/stores/useDriverStore';
const driverStore = useDriverStore();
</script>

<template>
 
    <!-- Title -->
    <h1 class="text-gray-900 text-2xl md:text-[32px] font-bold leading-10 mb-10">
      Fahrermanagement
    </h1>

    <!-- KPI Summary Grid Container -->
    <div class="bg-white rounded-xl border border-gray-200 overflow-hidden mb-12 shadow-sm">
      <!-- Headers -->
      <div class="grid grid-cols-2 md:grid-cols-4 border-b border-gray-200">
        <div class="p-5 md:px-8 border-r border-b md:border-b-0 border-gray-200">
          <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
            Gesamtbelegschaft
          </span>
        </div>
        <div class="p-5 md:px-8 border-b md:border-b-0 md:border-r border-gray-200">
          <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
            Aktiv
          </span>
        </div>
        <div class="p-5 md:px-8 border-r border-gray-200">
          <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
            Pause
          </span>
        </div>
        <div class="p-5 md:px-8">
          <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
            Urlaub
          </span>
        </div>
      </div>

      <!-- Values -->
      <div class="grid grid-cols-2 md:grid-cols-4">
        <div class="p-5 md:px-8 border-r border-b md:border-b-0 border-gray-200">
          <span class="text-2xl font-semibold text-gray-900">
            {{ driverStore.stats.totalStaff }}
          </span>
        </div>
        <div class="p-5 md:px-8 border-b md:border-b-0 md:border-r border-gray-200">
          <span class="text-2xl font-semibold text-gray-900">
            {{ driverStore.stats.active }}
          </span>
        </div>
        <div class="p-5 md:px-8 border-r border-gray-200">
          <span class="text-2xl font-semibold text-gray-900">
            {{ driverStore.stats.onBreak }}
          </span>
        </div>
        <div class="p-5 md:px-8">
          <span class="text-2xl font-semibold text-amber-500">
            {{ driverStore.stats.onLeave }}
          </span>
        </div>
      </div>
    </div>

    <!-- Data Table Container -->
    <div class="bg-white rounded-xl border border-gray-200 overflow-hidden shadow-sm">
      <div class="px-8 py-5 border-b border-gray-200">
        <h2 class="text-gray-900 text-base font-semibold">
          Fahrer Table
        </h2>
      </div>

      <div class="overflow-x-auto">
        <div class="min-w-[600px]">
          <!-- Table Header -->
          <div class="grid grid-cols-5 px-8 py-3 bg-gray-50 border-b border-gray-200">
            <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
              Fahrer
            </span>
            <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
              Kontakt
            </span>
            <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
              Zugewiesenes
            </span>
            <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
              Laufende Tour
            </span>
            <span class="text-xs font-semibold text-gray-500 uppercase tracking-wider">
              Status
            </span>
          </div>

          <!-- Table Rows -->
          <div
            v-for="(driver, index) in driverStore.drivers"
            :key="driver.id"
            class="grid grid-cols-5 px-8 py-4 items-center hover:bg-gray-50/50 transition-colors"
            :class="{ 'border-b border-gray-200': index !== driverStore.drivers.length - 1 }"
          >
            <span class="text-sm font-normal text-gray-900">{{ driver.name }}</span>
            <span class="text-sm font-normal text-gray-900">{{ driver.phone }}</span>
            <span class="text-sm font-normal text-gray-900">{{ driver.vehicle }}</span>
            <span class="text-sm font-normal text-gray-900">{{ driver.activeTour }}</span>
            <div>
              <DriverStatusBadge :status="driver.status" />
            </div>
          </div>
        </div>
      </div>
    </div>
 s
</template>