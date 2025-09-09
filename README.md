# Backend rama de azul
En este espacio voy a estar subiendo mis avances de código backend.

## 🗂️ Estructura del proyecto
```.

backend/
│
├── .mvn/                           # Configuración interna de Maven Wrapper
├── .vscode/                        # Configuración de VSCode
├── target/                         # Archivos compilados (build)
│   ├── backend-0.0.1-SNAPSHOT/     # Resultado empaquetado de la app
│   ├── backend-0.0.1-SNAPSHOT.jar  # JAR ejecutable generado
│   ├── backend-0.0.1-SNAPSHOT.jar.original
│   ├── classes/                    # Clases compiladas de main/
│   │   └── application.properties
│   ├── generated-sources/          # Código generado automáticamente
│   │   └── annotations/
│   ├── generated-test-sources/     # Código generado para tests
│   │   └── test-annotations/
│   ├── maven-archiver/             # Metadatos del build
│   │   └── pom.properties
│   ├── maven-status/               # Estado de compilación (plugins)
│   │   └── maven-compiler-plugin/
│   │       ├── compile/
│   │       └── testCompile/
│   ├── surefire-reports/           # Reportes de pruebas unitarias
│   │   ├── com.grindsup.backend.BackendApplicationTest.txt
│   │   └── TEST-com.grindsup.backend.BackendApplicationTests.xml
│   └── test-classes/               # Clases compiladas de test/
│       └── com/grindsup/backend/
│           └── BackendApplicationTests.class
│
├── src/                            # Código fuente principal
│   ├── main/
│   │   ├── java/com/grindsup/backend/
│   │   │   ├── GrindSupBackendApplication.java   # Clase principal (Spring Boot app)
│   │   │   ├── controller/         # Controladores REST
│   │   │   │   └── EntrenadorController.java
│   │   │   ├── model/              # Entidades JPA (tablas)
│   │   │   │   └── Entrenador.java
│   │   │   └── repository/         # Interfaces de acceso a datos
│   │   │       └── EntrenadorRepository.java
│   │   └── resources/              # Configuración de la app
│   │       ├── application.properties  # Config principal de Spring Boot
│   │       └── static/             # Archivos estáticos (HTML, JS, CSS)
│   │       └── templates/          # Vistas (Thymeleaf/Freemarker si se usa)
│   │
│   └── test/                       # Tests unitarios e integración
│       └── java/com/grindsup/backend/
│           └── BackendApplicationTests.java
│
├── .gitignore                      # Archivos/carpetas ignorados por Git
├── .gitattributes                  # Normalización de saltos de línea, etc.
├── mvnw                            # Script Linux/Mac para ejecutar Maven Wrapper
├── mvnw.cmd                        # Script Windows para ejecutar Maven Wrapper
├── pom.xml                         # Configuración y dependencias del proyecto



## Para instalar
 -Compilar y empaquetar:
      ./mvnw clean package
 -Ejecutar directamente con Maven:
      ./mvnw spring-boot:run
