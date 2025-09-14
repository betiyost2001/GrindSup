# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend using TypeScript with type-aware lint rules enabled. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) for information on how to integrate TypeScript and [`typescript-eslint`](https://typescript-eslint.io) in your project.


## 🗂️ Estructura del proyecto
```.

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
│   │   ├── Clientes/
│   │   │   ├── DetalleCliente.jsx
│   │   │   ├── FormularioCliente.jsx
│   │   │   └── ListaClientes.jsx
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
│       ├── chakraTheme.js
│       ├── muiTheme.js
│       └── theme.md
└── (otros archivos del proyecto frontend)
