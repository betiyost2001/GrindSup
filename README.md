# Backend rama de azul
En este espacio voy a estar subiendo mis avances de código backend.

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

