import apiClient from '@/api/axios.instance';

export type TransportStatus = 'IN_TRANSIT' | 'PICKED_UP' | 'DELIVERED' | 'DELAYED';
export interface Transport {
  id: string;
  fahrer: string;
  vehicle: string;
  zone: string;
  colisCount: number;
  deliveredCount: number;
  status: TransportStatus;
}

export const transportService = {
  async getAll(): Promise<Transport[]> {
    const response = await apiClient.get<Transport[]>('/transports');
    return response.data;
  },

  async getById(id: string): Promise<Transport> {
    const response = await apiClient.get<Transport>(`/transports/${id}`);
    return response.data;
  },

  async create(transport: Transport): Promise<Transport> {
    const response = await apiClient.post<Transport>('/transports', transport);
    return response.data;
  },

  async update(id: string, transport: Partial<Transport>): Promise<Transport> {
    const response = await apiClient.put<Transport>(`/transports/${id}`, transport);
    return response.data;
  },

  async delete(id: string): Promise<void> {
    await apiClient.delete(`/transports/${id}`);
  },
};