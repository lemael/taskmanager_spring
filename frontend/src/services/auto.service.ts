import apiClient from '@/api/axios.instance';

export type AutoStatus = 'IM_DIENST' | 'VERFÜGBAR' | 'INSPEKTION' | 'DEFECKT';

export interface Auto {
  id?: number;
  plateNumber: string;
  model: string;
  maxCapacity: string;
  mileage: string;
  tuvInspection: string;
  status: AutoStatus;
}

export const autoService = {
  async getAll(): Promise<Auto[]> {
    const response = await apiClient.get<Auto[]>('/vehicles');
    return response.data;
  },

  async getById(id: number): Promise<Auto> {
    const response = await apiClient.get<Auto>(`/vehicles/${id}`);
    return response.data;
  },

  async create(auto: Omit<Auto, 'id'>): Promise<Auto> {
    const response = await apiClient.post<Auto>('/vehicles', auto);
    return response.data;
  },

  async update(id: number, auto: Partial<Auto>): Promise<Auto> {
    const response = await apiClient.put<Auto>(`/vehicles/${id}`, auto);
    return response.data;
  },

  async delete(id: number): Promise<void> {
    await apiClient.delete(`/vehicles/${id}`);
  },
};