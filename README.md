¡Vamos a practicar!
Una empresa de vuelos chárter nos pide que desarrollemos un sistema para llevar la gestión de su flota.
Desean poder registrar sus aviones, tener la posibilidad de modificarlos, darlos de baja y visualizar toda la flota.

Luego del relevamiento obtuvimos la siguiente información:

Un Avión está compuesto por:

Marca
Modelo
Matrícula
Fecha de entrada en servicio
Id
Te proponemos implementar el patrón DAO, utilizando H2 como base de datos e implementar los métodos que nos permitan:

Registrar un nuevo avión.
Buscar un avión por id.
Eliminar un avión por id.
Buscar todos los aviones.
Les pedimos que creen la capa de negocio y la utilicen para testear los 4 métodos con JUnit.

¡Atención! Para ejecutar el ejercicio es necesario agregar estas librerías al proyecto.

H2
JUnit
