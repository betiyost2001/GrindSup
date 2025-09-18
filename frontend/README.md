## 🗂️ Estructura del proyecto
frontend/
│
├── .gitignore
├── eslint.config.js
├── index.html
├── package.json
├── README.md
├── vite.config.js
├── public/
│   └── vite.png
├── src/
│   ├── App.css
│   ├── App.jsx
│   ├── index.css
│   ├── main.jsx
│   ├── assets/
│   │   ├── react.png
│   │   └── react.svg
│   ├── components/
│   │   ├── AccionesFormulario.jsx
│   │   ├── DialogoConfirmacion.jsx
│   │   └── TablaDatos.jsx
│   ├── context/
│   │   ├── AuthContext.jsx
│   │   ├── context.md
│   │   └── SnackbarContext.jsx
│   ├── layout/
│   │   ├── layout.md
│   │   ├── MainLayout.jsx
│   │   ├── NavBar.jsx
│   │   └── SideMenu.jsx
│   ├── pages/
│   │   ├── pages.md
│   │   ├── Alumno/
│   │   │   ├── DetalleRegistrarAlumnoForm.jsx
│   │   ├── Ejercicios/
│   │   │   ├── FormularioEjercicios.jsx
│   │   │   └── ListaEjercicios.jsx
│   │   ├── Entrenadores/
│   │   │   ├── FormularioEntrenador.jsx
│   │   │   └── ListaEntrenadores.jsx
│   │   ├── Notificaciones/
│   │   │   └── CentroNotificaciones.jsx
│   │   ├── Planes/
│   │   │   ├── FormularioPlan.jsx
│   │   │   └── ListaPlanes.jsx
│   │   ├── Reportes/
│   │   │   ├── ReporteProgreso.jsx
│   │   │   └── ReporteSociosActivos.jsx
│   │   ├── Rutinas/
│   │   │   ├── ConstructorRutina.jsx
│   │   │   └── ListaRutinas.jsx
│   │   ├── Tablero/
│   │   │   └── PaginaTablero.jsx
│   │   ├── TiposEntrenamiento/
│   │   │   ├── FormularioTipoEntrenamiento.jsx
│   │   │   └── ListaTiposEntrenamiento.jsx
│   │   ├── Turnos/
│   │   │   ├── CalendarioTurnos.jsx
│   │   │   └── FormularioTurno.jsx
│   │   └── Usuarios/
│   │       ├── DetalleUsuario.jsx
│   │       ├── FormularioUsuario.jsx
│   │       └── ListaUsuarios.jsx
│   ├── routes/
│   │   └── router.jsx
│   ├── services/
│   │   ├── clienteApi.js
│   │   ├── clientes.servicio.js
│   │   ├── ejercicios.servicio.js
│   │   ├── entrenadores.servicio.js
│   │   ├── planes.servicio.js
│   │   ├── reportes.servicio.js
│   │   ├── rutinas.servicio.js
│   │   ├── service.md
│   │   ├── tipoEntrenamiento.servicio.js
│   │   ├── turnos.servicio.js
│   │   └── usuarios.servicio.js
│   ├── styles/
│   │   └── globas.css
│   └── theme/
│       ├── theme.js
│       ├── muiTheme.js
│       └── theme.md
└── (otros archivos del proyecto frontend)


## 🛠️ Dependencias principales HU1

React 18 – librería principal
Vite – bundler y dev server
Chakra UI v2 – componentes de UI
@chakra-ui/icons – íconos de Chakra
Emotion – motor de estilos requerido por Chakra
Framer Motion – animaciones de menús, modales, etc.

package.json:
{
  "dependencies": {
    "@chakra-ui/icons": "^2.0.21",
    "@chakra-ui/react": "^2.8.2",
    "@emotion/react": "^11.11.1",
    "@emotion/styled": "^11.11.0",
    "framer-motion": "^10.16.4",
    "react": "^18.2.0",
    "react-dom": "^18.2.0"
  },
  "devDependencies": {
    "@vitejs/plugin-react": "^4.2.0",
    "vite": "^5.2.0"
  }
}

# frontend disponible en: http://localhost:5173

##📑 Notas

Este proyecto está configurado para usar Chakra UI v2.

Los formularios están listos para integrarse al backend vía API REST.

En desarrollo, el front apunta por defecto a http://localhost:8080/api.
Se puede cambiar creando un archivo .env: VITE_API_BASE_URL=http://localhost:8080/api
