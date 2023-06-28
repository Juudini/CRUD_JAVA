# CRUD Java

Este proyecto es un ejemplo de una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) en Java utilizando una base de datos MySQL. La aplicación permite gestionar datos de estudiantes, como su nombre y apellido, a través de una interfaz gráfica de usuario.

## Funcionalidades

La aplicación proporciona las siguientes funcionalidades:

- Insertar un nuevo estudiante en la base de datos.
- Mostrar la lista de todos los estudiantes.
- Seleccionar un estudiante de la lista para visualizar sus datos.
- Modificar los datos de un estudiante existente.
- Eliminar un estudiante de la base de datos.

## Requisitos

Antes de ejecutar la aplicación, asegúrate de tener lo siguiente:

- Java Development Kit (JDK) instalado.
- MySQL Server instalado y en ejecución.
- Conexión a una base de datos MySQL existente con los permisos necesarios.

## Configuración

Antes de ejecutar la aplicación, debes realizar las siguientes configuraciones:

1. Abre el archivo `CConnection.java` ubicado en el paquete `com.mycompany.crud_java`.
2. Modifica las siguientes variables de acuerdo a tu configuración de base de datos:
   - `user`: Usuario de la base de datos.
   - `password`: Contraseña del usuario de la base de datos.
   - `bd`: Nombre de la base de datos.
   - `ip`: Dirección IP o nombre del host donde se encuentra la base de datos.
   - `puerto`: Puerto de conexión a la base de datos.

## Ejecución

Sigue los pasos a continuación para ejecutar la aplicación:

1. Compila los archivos fuente del proyecto utilizando tu entorno de desarrollo o ejecutando el comando `javac` en la terminal.
2. Ejecuta la clase `StudentForm` que contiene el punto de entrada del programa.


3. Configura la base de datos:

- Crea una base de datos MySQL en tu servidor local.

``` 
CREATE DATABASE IF NOT EXISTS bdschool;

USE bdschool;

DROP TABLE IF EXISTS student;

CREATE TABLE student (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  last_name VARCHAR(50)
);

```