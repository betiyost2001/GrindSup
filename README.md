# 📌 Hoja de Ruta de Sprints – GrindSup

Este documento detalla los sprints de desarrollo del proyecto **GrindSup**, desde la fase de organización (Sprint 0) hasta el despliegue del mismo.

## 🟦 Sprint 0 – Preparación y Organización (3 semana)

**Objetivo:** Alinear al equipo y sentar las bases conceptuales del proyecto.

* Armado de grupos de trabajo y definición de roles (Product Owner, Scrum Master, Backend, Frontend, Documentación).
* Redacción del **Estudio Inicial**.
* Elaboración del **Plan de Proyecto** (objetivos, alcance, metodología, roles).
* Revisión y ajustes de los documentos generados.
* Definir el producto a realizar (plataforma GrindSup).
* Exposición inicial del avance y entrega de documentación.
* Capacitarse en **Scrum, MySQL, Vercel, Testing, JWT, API de Whatsapp**, en este sprint.

---

## 🟦 Sprint 1 – Desarrollo Inicial y Base de Datos (2 semanas)

**Objetivo:** Establecer la estructura del backend y frontend.

* Implementar el **Backend** con conexión a la base de datos.
* Crear la **Base de datos en MySQL**.
* Realizar **Peticiones CRUD** desde el backend (Java).
* Comenzar el **Frontend** con vistas iniciales e integración básica (React).
* Continuar con la **Documentación**: estudio inicial y plan de proyecto.

**Roles:**

* Product Owner: Azul Oyola.
* Scrum Master: Azul Oyola.
* Programación backend: Martín Gamboa, Agustina Silva, Azul Oyola.
* Programación frontend: Betina Yost, Fanny Álvarez, Dana Montesinos.

---

## 🟦 Sprint 2 –  (2 semanas)

**Objetivo:**


## 🗂️ Estructura del proyecto
```.

backend/
│
├── .mvn/                           # Configuración interna de Maven Wrapper
├── .vscode/                        # Configuración de VSCode
├── target/                         # Archivos compilados (build)
│   ├── backend-0.0.1-SNAPSHOT/     
│   ├── backend-0.0.1-SNAPSHOT.jar  
│   ├── backend-0.0.1-SNAPSHOT.jar.original
│   ├── classes/                    
│   │   └── application.properties
│   ├── generated-sources/          
│   │   └── annotations/
│   ├── generated-test-sources/     
│   │   └── test-annotations/
│   ├── maven-archiver/             
│   │   └── pom.properties
│   ├── maven-status/               
│   │   └── maven-compiler-plugin/
│   │       ├── compile/
│   │       └── testCompile/
│   ├── surefire-reports/           
│   │   ├── com.grindsup.backend.BackendApplicationTest.txt
│   │   └── TEST-com.grindsup.backend.BackendApplicationTests.xml
│   └── test-classes/               
│       └── com/grindsup/backend/
│           └── BackendApplicationTests.class
│
├── src/                            
│   ├── main/
│   │   ├── java/com/grindsup/backend/
│   │   │   ├── GrindSupBackendApplication.java   
│   │   │   ├── controller/         # Controladores REST
│   │   │   │   ├── AlumnoController.java
│   │   │   │   ├── AgendaController.java
│   │   │   │   ├── EntrenadorController.java
│   │   │   │   ├── EjercicioController.java
│   │   │   │   ├── PlanEntrenamientoController.java
│   │   │   │   ├── RutinaController.java
│   │   │   │   ├── RutinaEjercicioController.java
│   │   │   │   ├── EstadoController.java
│   │   │   │   ├── SesionEntrenadorController.java
│   │   │   │   └── TurnoController.java
│   │   │   ├── model/              # Entidades JPA (tablas)
│   │   │   │   ├── Alumno.java
│   │   │   │   ├── Agenda.java
│   │   │   │   ├── Entrenador.java
│   │   │   │   ├── Ejercicio.java
│   │   │   │   ├── PlanEntrenamiento.java
│   │   │   │   ├── Rutina.java
│   │   │   │   ├── RutinaEjercicio.java
│   │   │   │   ├── RutinaEjercicioId.java
│   │   │   │   ├── Estado.java
│   │   │   │   ├── SesionEntrenador.java
│   │   │   │   └── Turno.java
│   │   │   └── repository/         # Interfaces de acceso a datos
│   │   │       ├── AlumnoRepository.java
│   │   │       ├── AgendaRepository.java
│   │   │       ├── EntrenadorRepository.java
│   │   │       ├── EjercicioRepository.java
│   │   │       ├── PlanEntrenamientoRepository.java
│   │   │       ├── RutinaRepository.java
│   │   │       ├── RutinaEjercicioRepository.java
│   │   │       ├── EstadoRepository.java
│   │   │       ├── SesionEntrenadorRepository.java
│   │   │       └── TurnoRepository.java
│   │   └── resources/              
│   │       ├── application.properties  
│   │       └── static/             
│   │       └── templates/          
│   │
│   └── test/                       
│       └── java/com/grindsup/backend/
│           └── BackendApplicationTests.java
│
├── .gitignore                      
├── .gitattributes                  
├── mvnw                            
├── mvnw.cmd                        
└── pom.xml                         




## Para instalar
 -Compilar y empaquetar:
      ./mvnw clean package
 -Ejecutar directamente con Maven:
      ./mvnw spring-boot:run


