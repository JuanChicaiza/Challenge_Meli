# Challenge_Meli
Challenge Meli Op Quasar Fuego Juan Pablo Chicaiza

## Herramientas Utilizadas
- Framework spring boot
- AWS RDS (Postgresql10)
- ASW EC2 (Despliegue)

## Paquetes
Para el desarrollo de la aplicacion se definieron los siguientes paquetes.
- controllers: Todas las clases donde se reciben las peticiones HTTP a los end-point.
- exceptions: Todas las exepciones para el manejo de errores.
- models: Todas las clases que representan los elementos de la aplicacion.
- repositories: Todas las clases que se encargan de la gestion del acceso a los datos.
- services: Todas las clases que se encargan de la logica de la aplicacion.

### Controllers:
 En este paquete se encuentran las siguientes clases:
- InformacionSateliteController: Recibe las peticiones: - GET para consultar las posiciones actuales de los satelites. - POST actualizar una posicion del satelite.
- NaveController: Recibe la peticion tipo POST para consultar la posicion y el mensaje de la nave, adicionalmente se guarda la peticion y la respuesta en base de datos.
- NaveAlmacenadaController: Recibe las petitiones: - GET para consultar la posicion y el mensaje de la nave con datos almacenados. -POST Envia la distancia y el mensaje de la nave hacia un satelite y este se guarda. 

### Services:
 En este paquete se encuentran las siguientes clases:
- InformacionSateliteService: Permite Consultar la posicion actual de los satelites, actualizar la posicion de os satelites.
- LocalizacionService: Permite el calculo de la posicion actual de la nave usando Trilateracion.
- MensajeService: Permite Obtener el mensaje completo de la nave.
- PeticionesSateliteService: Permite Registrar en Base de Datos las peticiones hechas.
- RespuestaSateliteService: Permite Registrar en Base de Datos las respuestas entregadas.
- SateliteService: Permite Registrar y Consultar en Base de Datos, las distancias y mensajes almacenados.

### Exceptions:
 En este paquete se encuentran las siguientes clases:
 - LocalizacionException: Lanza las Exepciones para LocalizacionService
 - MensajeException: Lanza las Exepciones para MensajeService
 
 ### Models:
  En este paquete se encuentran las siguientes clases:
  - InformacionSateliteModel: Representa a los satelites usados para la triangulacion
  - NumeroPeticionModel: Representa el numero de Peticiones realizadas a la aplicacion
  - PeticionesDBModel: Representa la tabla en donde se guardan las peticiones realizadas
  - NaveModel: Representa a la Nave.
  - NaveAlmacenadaModel: Representa a la Informacion Almacenada de La Nave.
  - PosicionModel: Representa la posicion de la nave;
  - RespuestasDBModel: Representa la tabla en donde se guardan las respuestas que da la aplicacion.
  - UbicacionModel: Representa la ubicacion y el mensaje de la nave.
  
  ### Repositorys:
   En este paquete se encuentran las siguientes clases:
   - InformacionSateliteRepository
   - NaveRepository
   - NumeroRepository
   - PeticionesRepository
   - RespuestasRepository
   
  ## Modelo de Base de Datos:
  ![modeloBD](https://i.ibb.co/mvXZNgs/modelo-1.jpg)
  
  
  
  
