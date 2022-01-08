# Challenge_Meli
Challenge Meli Op Quasar Fuego Juan Pablo Chicaiza

## Construido con 🛠️
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
  
  
  ## Inicializacion Proyecto de Manera local
  Se debe tener instalado maven
  Entrar a la carpeta del proyecto y ejecutar:
  ```
  mvn spring-boot:run
  ```   
  
  ## Generacion de Jar
  Dirigirse a la carpeta principal del proyecto y ejecutar el siguiente comando:
  ```
  mvn clean package
  ```
  ## Despliegue 📦
  Para le despliegue se utlizo una Instancia EC2 Ubuntu en AWS.
    Se creo una carpeta en la ruta /home/ubuntu/jar/
    ```
    mkdir /home/ubuntu/jar/
    ```
    Se copia el archivo Jar Generado en la carpeta creada.
    Se ejecuta la siguiente instruccion.
    ```
    nohup java -jar {{nombre_proyecto}}.jar &
    ```
  Verificar que el servicio este funcionando entrando a:
  http://{ip_donde_se_aloja_la_aplicacion}:8080/
  Ej:
  http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/
  
  ![image](https://user-images.githubusercontent.com/52248909/148662859-b95c914d-55fe-42b1-b046-1dee5c778b3a.png)
  
  
  # Ejecucion
  
  La siguiente es la URL del servicio:
  
  http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/
  
  ## Rutas del Servicio:
  
  URL:http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/api/v1/satelites
  METODO: GET
  ACCION: Retorna la lista de satelites conocidos utilizados para triangular
  RESPONSE: STATUS 200 y JSON de los satelites con el siguiente formato
  ```
  [
    {
        "id": 1,
        "nombre": "kenobi",
        "posX": -500,
        "posY": -200,
        "activo": true
    },
    {
        "id": 2,
        "nombre": "skywalker",
        "posX": 100,
        "posY": -100,
        "activo": true
    },
    {
        "id": 3,
        "nombre": "sato",
        "posX": 500,
        "posY": 100,
        "activo": true
    }
  ]
  ```
  
  ![image](https://user-images.githubusercontent.com/52248909/148663150-b6fdeaf1-44f3-4145-8fce-2ff70e62ff0a.png)
  

  URL:http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/api/v1/satelites
  METODO: POST
  REQUEST BODY: JSON con el siguiente Formato    
  ```
  {
    "id": 1,
    "nombre": "kenobi",
    "posX": -500,
    "posY": -200,
    "activo": true
  }
  ```
  ACCION: Actualiza la posicion del satelite.
  RESPUESTA: SATUS 200 y JSON con la informacion Actualizada del Satelite
  ```
  {
    "id": 1,
    "nombre": "kenobi",
    "posX": -500,
    "posY": -200,
    "activo": true
  }
  ```
  
  ![image](https://user-images.githubusercontent.com/52248909/148663217-c0fe593d-924b-442a-82af-156a5ab83272.png)
  

  URL: http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/api/v1/topsecret
  METODO: POST
  REQUEST BODY: JSON con el siguiente Formato
  ```
  {
    "satellites": [
            {
                "name": "kenobi",
                "distance": 100.0,
                "message": ["este", "", "", "mensaje", ""]
            },
            {
                "name": "skywalker",
                "distance": 115.5,
                "message": ["", "es", "", "", "secreto"]
            },
            {
                "name": "sato",
                "distance": 142.7,
                "message": ["este", "", "un", "", ""]
            }
    ]
  }
  ```
  ACCION: Calcula las coordenadas del emisor del mensaje(Nave) y Determina el Mensaje Enviado
  RESPUESTA: STATUS 200 y JSON con las coordenadas y el mensaje con el siguiente formato
  ```
  {
    "position": {
        "x": -58.315252587138595,
        "y": -69.55141837312165
    },
    "message": "este es un mensaje secreto"
  }
  ```
  Nota: Es importante realizar la peticion con el nombre de los satelites que tenemos registrados
  
  ![image](https://user-images.githubusercontent.com/52248909/148663380-b6d630ef-0786-4747-9cd2-698268ae62dc.png)
  
  Nota 2: Si falta informacion para obtener el mensaje o calcular la posicion, retorna STATUS 404 y un JSON con el siguiente formato
  ```
  {
    "timestamp": "2022-01-08T23:32:28.620+00:00",
    "status": 404,
    "error": "Not Found",
    "path": "/api/v1/topsecret"
  }
  ```
  ![image](https://user-images.githubusercontent.com/52248909/148663513-e42d3a2c-97de-4594-bc75-6fd7073036e6.png)


  URL: http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/api/v1/topsecret_split
  METODO: GET
  ACCION: Retorna la posicion y el mensaje si es posible determinarlos con los datos almacenados(Base de Datos)
  RESPONSE: STATUS 200 y JSON con la posicion y mensaje con el siguiente Formato
  ```
  {
    "position": {
        "x": -2.453264573005852,
        "y": -47.767461631659536
    },
    "message": "este es un mensaje secreto"
  }
  ```
  
  ![image](https://user-images.githubusercontent.com/52248909/148663599-ee7f8746-481c-4f53-bf7b-853fe96c7bae.png)
  
  URL: http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/api/v1/topsecret_split/{satelite_name}
  METODO: POST
  REQUEST BODY: JSON con el siguiente formato
  ```
  {    
      "distance": 150.65,
      "message": ["este", "", "un", "", ""]
  }
  ```
  ACCION: Almacena los datos de distancia y mensaje del satelite para poder usarlos luego  
  RESPONSE STATUS 200 y JSON con la informacion actualizada en el siguiente formato
  ```
  {
    "name": "sato",
    "distance": 150.65,
    "message": [
        "este",
        "",
        "un",
        "",
        ""
    ]
  }
  ```
  
  ![image](https://user-images.githubusercontent.com/52248909/148663687-67eefc44-7ba3-4536-9dd9-c2037b4b0c3d.png)

  URL: http://ec2-3-145-44-84.us-east-2.compute.amazonaws.com:8080/api/v1/topsecret_split/satelites
  METODO: GET
  ACCION: Retorna la lista de satelites almacenados
  RESPONSE: STATUS 200 y JSON con la posicion y mensaje con el siguiente Formato
  ```
  [
    {
        "name": "sato",
        "distance": 150.65,
        "message": [
            "este",
            "",
            "un",
            "",
            ""
        ]
    },
    {
        "name": "skywalker",
        "distance": 252.0,
        "message": [
            "",
            "es",
            "",
            "",
            "secreto"
        ]
    },
    {
        "name": "kenobi",
        "distance": 150.0,
        "message": [
            "este",
            "",
            "",
            "mensaje",
            ""
        ]
    }
  ]
  ```
  
  ![image](https://user-images.githubusercontent.com/52248909/148663702-c70f486d-ecb3-425a-999f-9fb5cefcf7ec.png)



# Autor ✒️

- **Juan Pablo Chicaiza Muñoz ** [GitHub](https://github.com/JuanChicaiza) [linkedin](https://www.linkedin.com/in/juan-pablo-chicaiza-mu%C3%B1oz-2a0584216/)
  
  
  
  
