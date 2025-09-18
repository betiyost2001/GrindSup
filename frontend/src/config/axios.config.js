import axios from 'axios';

// Crear una instancia de axios con la configuración base
const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080', // URL base de tu backend
    timeout: 5000, // tiempo máximo de espera para las peticiones
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    },
    withCredentials: false // cambiado a false para pruebas iniciales
});

// Interceptor para manejar errores globalmente
axiosInstance.interceptors.response.use(
    (response) => response,
    (error) => {
        // Aquí puedes manejar errores globalmente
        console.error('Error en la petición:', error);
        return Promise.reject(error);
    }
);

export default axiosInstance;