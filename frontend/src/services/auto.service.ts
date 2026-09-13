import apiClient from '@/api/axios.instance';

export type AutoStatus = 'IM_DIENST' | 'VERFÜGBAR' | 'INSPEKTION' | 'DEFEKT';

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
    const response = await apiClient.get<Auto[]>('/autos');
    return response.data;
  },

  async getById(id: number): Promise<Auto> {
    const response = await apiClient.get<Auto>(`/autos/${id}`);
    return response.data;
  },

  async create(auto: Omit<Auto, 'id'>): Promise<Auto> {
    const response = await apiClient.post<Auto>('/autos', auto);
    return response.data;
  },

  async update(id: number, auto: Partial<Auto>): Promise<Auto> {
    const response = await apiClient.put<Auto>(`/autos/${id}`, auto);
    return response.data;
  },

  async delete(id: number): Promise<void> {
    await apiClient.delete(`/autos/${id}`);
  },
};