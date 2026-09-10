import { defineStore } from 'pinia';
import { ref } from 'vue';

export type ContractType = 'VIP Express' | 'Standard Pro' | 'Basic';

export interface Customer {
  id: string;
  name: string;
  mainContact: string;
  city: string;
  contract: ContractType;
  monthlyVolume: string;
}

export interface CustomerStats {
  activeCustomers: number;
  monthlyDeliveries: number;
  vipCustomers: number;
}

export const useCustomerStore = defineStore('customers', () => {
  const stats = ref<CustomerStats>({
    activeCustomers: 48,
    monthlyDeliveries: 1240,
    vipCustomers: 12,
  });

  const customers = ref<Customer[]>([
    {
      id: 'CUST-001',
      name: 'BMW Group AG',
      mainContact: 'Weber',
      city: 'München',
      contract: 'VIP Express',
      monthlyVolume: '10 colis/monat',
    },
    {
      id: 'CUST-002',
      name: 'Bosch Logistics',
      mainContact: 'Schneider',
      city: 'Dortmund',
      contract: 'Standard Pro',
      monthlyVolume: '80 colis/monat',
    },
  ]);

  return {
    stats,
    customers,
  };
});