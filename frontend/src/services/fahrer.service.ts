import apiClient from '@/api/axios.instance';

export type FahrerStatus = 'IN_AUSLIEFERUNG' | 'PAUSIERT' | 'VERFÜGBAR' | 'URLAUB';

export interface Fahrer {
  id?: number;
  name: string;
  licenseClass: string;
  phoneNumber: string;
  status: FahrerStatus;
}

export const fahrerService = {
  async getAll(): Promise<Fahrer[]> {
    const response = await apiClient.get<Fahrer[]>('/fahrers');
    return response.data;
  },

  async getById(id: number): Promise<Fahrer> {
    const response = await apiClient.get<Fahrer>(`/fahrers/${id}`);
    return response.data;
  },

  async create(fahrer: Omit<Fahrer, 'id'>): Promise<Fahrer> {
    const response = await apiClient.post<Fahrer>('/fahrers', fahrer);
    return response.data;
  },

  async update(id: number, fahrer: Partial<Fahrer>): Promise<Fahrer> {
    const response = await apiClient.put<Fahrer>(`/fahrers/${id}`, fahrer);
    return response.data;
  },

  async delete(id: number): Promise<void> {
    await apiClient.delete(`/fahrers/${id}`);
  },
};