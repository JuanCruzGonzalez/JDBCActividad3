# Proyecto CRUD de Instrumentos 🎸

Este proyecto es una aplicación Java que implementa como crear objetos para la gestión de instrumentos musicales usando una arquitectura en capas (DAO, Service) y conexión a base de datos MySQL.

## Requisitos

- Java 8 o superior
- MySQL Server
- Maven o NetBeans/IDE compatible
- Conector JDBC de MySQL

## Estructura del Proyecto
src/ └── main/ ├── java/ │ ├── com.mycompany.proyectocrud.v2/ 

# Main y launcher 
│ ├── dao/ 

# DAOs y sus implementaciones 

│ ├── model/ 

# Entidades (Instrumento) 

│ ├── service/ 

# Servicios 

│ └── config/ 

# Configuración de base de datos 

└── resources/

## Configuración de la Base de Datos

1. **Crea la base de datos y la tabla:**

```sql
CREATE DATABASE IF NOT EXISTS instrumentosdb;
USE instrumentosdb;

CREATE TABLE IF NOT EXISTS instrumento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DOUBLE NOT NULL,
    cantidad INT NOT NULL
);

2. Configura la conexión en config/DatabaseConnection.java:

static final String URL = "jdbc:mysql://localhost:3306/instrumentosdb";
static final String USER = "tu_usuario";
static final String PASSWORD = "tu_contraseña";

Clona o descarga el repositorio.

Abre el proyecto en tu IDE favorito (NetBeans, VS Code, IntelliJ, etc).

Asegúrate de tener el conector JDBC de MySQL en tu classpath o dependencias.

Configura el archivo de conexión a la base de datos como se indicó arriba.

Ejecuta la clase principal:

com.mycompany.proyectocrud.v2.ProyectoCrudV2
Verifica la salida en consola:

Se mostrará si el producto fue guardado y el listado de instrumentos.
Funcionalidades
Agregar instrumento: Crea y guarda un nuevo instrumento en la base de datos.
Listar instrumentos: Muestra todos los instrumentos almacenados.
Validaciones: No permite guardar instrumentos sin nombre o con cantidad negativa.
Gestión de transacciones: Uso de TransactionManager para operaciones seguras.
Personalización
Puedes modificar la clase Instrumento para agregar más atributos.
Puedes extender los servicios y DAOs para agregar métodos de actualización y eliminación.
Notas
Si tienes problemas de conexión, revisa usuario, contraseña y URL de la base de datos.
Si tu usuario de MySQL no tiene contraseña, ajusta la validación en DatabaseConnection.