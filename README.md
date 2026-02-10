# CRUD MVC con Thymeleaf — RA3

## 1) Datos del alumno/a
- Entidad elegida : Colección de mangas

## 2) Repositorio (fork) y gestión de versiones
- Repositorio base: NINGUNO
- Enlace a MI fork: [https://github.com/Alejandro1703/LaCasaDelLibro]
- Nº de commits realizados: 5 commits

## 3) Arquitectura
Explica brevemente cómo has organizado:
- Controller: gestiona las peticiones HTTP, devuelve las vistas de Thymeleaf y comunica la UI con el servicio.
- Service: contiene la lógica de negocio y hace de intermediario entre el controlador y el repositorio.
- Repository: extiende de JpaRepository para realizar las operaciones CRUD automáticas en la base de datos.
- Entity: representa la tabla en la base de datos con atributos como título, autor, ISBN y precio.

## 4) Base de datos elegida (marca una)
- [ ] H2
- [X] MySQL
- [ ] PostgreSQL

## 5) Configuración de la base de datos
### 5.1 Dependencias añadidas
(Indica la dependencia del driver que has usado)
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
### 5.2 application.properties / application.yml
(Pega aquí tu configuración SIN contraseñas reales si es necesario)

    spring.application.name=GestionEmpresa
    spring.datasource.url=jdbc:mysql://localhost:3306/GestionLibros
    spring.datasource.username=root
    spring.datasource.password=****
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.security.user.name=admin
    spring.security.user.password=admin
### 5.3 Pasos para crear la BD (si aplica)
    CREATE DATABASE GestionLibros;

## 6) Cómo ejecutar el proyecto
1. Requisitos Java 21, Maven, MySQL Server funcionando
2. Comando de arranque: 
   - ./mvnw spring-boot:run
3. URL de acceso:
   - http://localhost:8070/libros (Requiere login: admin / admin)

## 7) Pantallas / Rutas MVC
    GET /libros: Listado general de la colección con paginación.

    GET /libros/nuevo: Formulario para dar de alta un nuevo manga.

    POST /libros/guardar: Procesa el guardado (creación o actualización).

    GET /libros/editar/{id}: Carga el formulario con los datos de un manga existente.

    GET /libros/eliminar/{id}: Elimina un registro de la base de datos.

    POST /logout: Cierra la sesión del usuario.


## 8) Mejoras extra (opcional)
- Validaciones
- Estilos Bootstrap : Interfaz moderna mediante el uso de tarjetas (cards) y tablas de Bootstrap 5 instalado de forma
local.
- Búsqueda
- Pruebas
- Paginación
