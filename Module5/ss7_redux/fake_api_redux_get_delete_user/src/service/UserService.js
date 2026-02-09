import axios from 'axios';

const BASE_URL = "http://localhost:8080";

export const findAll = async () => {
    try {
        const res = await axios.get(`${BASE_URL}/users`);
        return res.data;
    } catch (error) {
        console.log(error);
        return [];
    }
}

export const addUser = async (user) => {
    try {
        const response = await axios.get(`${BASE_URL}/users`);
        const users = response.data;
        
        const maxId = users.length > 0 
            ? Math.max(...users.map(u => parseInt(u.id) || 0))
            : 0;
        const nextId = maxId + 1;
        
        const userWithId = {
            id: String(nextId),  // Convert to string
            ...user
        };
        
        await axios.post(`${BASE_URL}/users`, userWithId);
        return true;
    } catch (error) {
        console.log(error);
        return false;
    }
}

export const deleteUser = async (id) => {
    try {
        const res = await axios.delete(`${BASE_URL}/users/${id}`);
        return {
            success: true,
            status: res.status,
            statusText: res.statusText,
            data: res.data
        };
    } catch (error) {
        console.error('Delete user error:', error);
        throw error;
    }
}