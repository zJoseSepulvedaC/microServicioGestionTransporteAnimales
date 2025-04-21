-- Microservicio: Gestión de Transporte de Animales

Este microservicio forma parte de un sistema distribuido diseñado para gestionar el transporte internacional de animales. Permite registrar, consultar, actualizar y eliminar información relacionada con los usuarios que gestionan estos transportes.

---

-- Tecnologías utilizadas

- Java 18
- Spring Boot 3.4.4
- Spring Data JPA
- Oracle Autonomous DB (con wallet)
- Maven
- Postman (para pruebas)
- GitHub

- EndPoints

GET	/usuarios	Obtener todos los usuarios
GET	/usuarios/{id}	Obtener usuario por ID
POST	/usuarios/registrar	Registrar un nuevo usuario
PUT	/usuarios/{id}	Actualizar datos de un usuario
DELETE	/usuarios/{id}	Eliminar un usuario