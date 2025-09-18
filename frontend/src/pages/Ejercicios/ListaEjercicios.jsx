import React, { useState, useEffect } from 'react';
import axiosInstance from '../../config/axios.config';

export default function ListaEjercicios() {
    const [testData, setTestData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        probarConexion();
    }, []);

    const probarConexion = async () => {
        try {
            setLoading(true);
            // Primero intentamos con la raíz
            console.log('Intentando conectar con el backend...');
            const response = await axiosInstance.get('/');
            setTestData(response.data);
            setError(null);
            console.log('Respuesta del servidor:', response.data);
        } catch (err) {
            console.error('Error al conectar:', err);
            setError('Error al conectar con el backend: ' + (err.response?.data?.message || err.message));
        } finally {
            setLoading(false);
        }
    };

    if (loading) return <div>Probando conexión con el backend...</div>;
    if (error) return <div>Error: {error}</div>;

    return (
        <div>
            <h2>Prueba de Conexión</h2>
            {testData ? (
                <div>
                    <p>Mensaje: {testData.mensaje}</p>
                    <p>Estado: {testData.estado}</p>
                    <p>Timestamp: {new Date(testData.timestamp).toLocaleString()}</p>
                </div>
            ) : (
                <p>No hay datos disponibles</p>
            )}
        </div>
    );
}
