import axios from 'axios';

const BASE_URL = "http://localhost:8080";

export const getAllBooks = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/books`);
        return response.data;
    } catch (err) {
        console.log(err);
        return [];
    }
};

export const getBookById = async (id) => {
    try {
        const response = await axios.get(`${BASE_URL}/books/${id}`);
        return response.data;
    } catch (err) {
        console.log(err);
        throw err;
    }
};

export const addBook = async (book) => {
    try {
        await axios.post(`${BASE_URL}/books`, book);
        return true;
    } catch (err) {
        console.log(err);
        return false;
    }
}

export const deleteBook = async (id) => {
    try {
        await axios.delete(`${BASE_URL}/books/${id}`);
        return true;
    } catch (err) {
        console.log(err);
        return false;
    }
}

export const updateBook = async (id, book) => {
    try {
        await axios.patch(`${BASE_URL}/books/${id}`, book);
        return true;
    } catch (err) {
        console.log(err);
        return false;
    }
}