#   Instalación App Andriod
#   Reserva Museo Gustavo Orcés
---
## Requisitos Mínimos:
Se recomienda instalar la aplicación con: 
- Andriod Studio 3.0.1
- CPU: i7
- RAM 8GB
- SS: 120 GB
- S.O: Windows 10 Education
- JDK: 1.8.0_152
- MAMP: 3.3.1

---
## Procedimiento:

### 1. Instalar Android Studio.
Si está iniciando a programar, le recomendamos el siguiente enlace
[How To Android Studio 3.0.1](https://www.youtube.com/watch?v=ho-6QaVf6CU)

### 2. Instalar MAMP y correr los servicios Apache y MySQL server.
Para instalar MAMP y correr el servicio puede seguir el siguiente tuto:
[Install MAMP server 3.3.0 (Windows 7)](https://www.youtube.com/watch?v=1SO0-F4wqyY)
<br /> <br />
![mamp](https://user-images.githubusercontent.com/25153762/36508017-6b5b100e-1729-11e8-87d4-15f47c567b5c.PNG)

### 3. Clonar el proyecto 
Ahora vamos a clonar el proyecto, para ello puede seguir el siguiente tutorial
[How to Clone Android Project from Github](https://www.youtube.com/watch?v=Qeub1fKRAkw)

Para nuestro proyecto seguimos los siguientes pasos:
#### 3.1 Descargar el proyecto en ZIP
Descargamos el proyecto .zip como se muestra en la imagen
<br /> <br />
<img src=https://user-images.githubusercontent.com/25153762/36462677-c7ffb2fc-1692-11e8-9c3a-813fc3a65e33.png >

#### 3.2 Descomprimir el archivo en nuestro directorio
Descomprimir el archivo zip en un directorio favorito
<br /> <br />
![descomprimirzip](https://user-images.githubusercontent.com/25153762/36452308-fb97162c-1661-11e8-95ac-0f101c0bd107.png)

#### 3.3 Abrir proyecto desde andriod
Ahora abrimos el proyecto desde nuestro Andriod Studio.
- Click sobre Open an Existing Android Studio Project.
- Buscamos el directorio donde descomprimimos el proyecto.
<br /> <br />
![open](https://user-images.githubusercontent.com/25153762/36503270-863cb166-171a-11e8-92c1-736173623903.png)


#### 3.1 Corregir errores
Es probable que al construir el proyecto aparezca los siguientes errores
<br /> <br />
![errores](https://user-images.githubusercontent.com/25153762/36503759-2bfa6c1e-171c-11e8-8cd1-a7b0e215d637.PNG)

- Cannot load 2 modules: para resolver este error basta con removerlos del proyecto
<br /> <br />
![errores_carga](https://user-images.githubusercontent.com/25153762/36503534-691a312a-171b-11e8-8de7-703f76a81db2.PNG)

- Invalid VCS root mapping: para resolver este problema basta con eliminar el git (VCS) como se muestra en la imagen
<br /> <br />
![errores_gitroot](https://user-images.githubusercontent.com/25153762/36503517-61f5f370-171b-11e8-83e7-388f75bd132d.PNG)


### 4. Agregar los archivos .php a MAMP\htdocs
Agregue todos los archivos de la ruta
https://github.com/Buhobit/ProyectoAppMoviles/tree/master/app/src/main/res/mamp-htdocs-conexion
a la carpeta C:\MAMP\htdocs.
![htdocs](https://user-images.githubusercontent.com/25153762/36508499-e4575a20-172a-11e8-9c7a-72080fd7d0b6.PNG)

##### Nota: la letra de C puede cambiar por la ruta donde ha instalado MAMP.

### 5. Crear base de datos local
- Cree la base de datos registrovisitasdb 
<br /> <br />
![crear-db-resgistro-visitas](https://user-images.githubusercontent.com/25153762/36508045-80b040dc-1729-11e8-9f11-87a1b7ec17be.PNG)

- Importar el script de la base de datos \MAMP\htdocs\registroVisitasDB.sql
![importar-registrovisitasdb sql](https://user-images.githubusercontent.com/25153762/36508212-1054a412-172a-11e8-86a9-2c1e1c52e4ea.PNG)

### 6. Ejecute el proyecto.
===
---
# Manuales de usuario y técnico
[Manual de Usuario] (https://raw.githubusercontent.com/Buhobit/ProyectoAppMoviles/master/app/src/main/res/manuales/Manual%20de%20Usuario%20AppM%C3%B3vil-Gustavo%20Orces.doc)
<br /> <br />
[Manual técnico] (https://raw.githubusercontent.com/Buhobit/ProyectoAppMoviles/master/app/src/main/res/manuales/Manual%20Tecnico%20AppM%C3%B3vil-Gustavo%20Orces.docx)
---
===
## Autores:
- Byron López
- Adan Guzman
- Nelson Chicaiza
---
© Buhobit
