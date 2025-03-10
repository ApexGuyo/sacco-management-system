import axios from 'axios';

const API_URL = 'http://localhost:8080/api'; // Change this to match your Spring Boot backend

export const getMembers = async () => {
    const response = await axios.get(`${API_URL}/members`);
    return response.data;
};

export const addMember = async (member) => {
    const response = await axios.post(`${API_URL}/members`, member);
    return response.data;
};

export const updateMember = async (id, member) => {
    const response = await axios.put(`${API_URL}/members/${id}`, member);
    return response.data;
};

export const deleteMember = async (id) => {
    await axios.delete(`${API_URL}/members/${id}`);
};
