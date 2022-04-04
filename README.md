# Furry Advisor
*¿Cuál será el lugar en el que conozcas a tu próximo Woof Woof?*


## Descripción de Furry Advisor ##
Furry Advisor consiste en una pagina web de guía turística en la que se pueden consultar convenciones, restaurantes, bares y clubs de temática furry, permitiendo así a quien quiera introducirse y empaparse de la cultura furry poder visitar esos lugares y conocer a gente furry.

Al entrar a la página se muestra un tablón de anuncios en el que aparecen los lugares más visitados y frecuentados de la cultura furry, lugares nuevos y lugares que cuenten con ofertas activas para los usuarios registrados.
La gente que entre en la página puede registrarse como usuario, accediendo a servicios el uso de cupones de ofertas para dichos lugares. Además cada lugar cuenta con reseñas, escritas por los usuarios registrados, permitiendo destacar los mejores lugares que visitar. Estas reseñas pueden ser consultadas tanto por usuarios registrados como por usuarios sin registrar y los registrados pueden comentarlas y valorar su utilidad.

En resumen, un usuario registrado puede usar ofertas y escribir reseñas de los locales o eventos que visite. Por el contrario, un usario sin registrar solo podrá leer las reseñas escritas. Ambos pueden consultar el tablón de anuncios.


## Entidades principales ##
Las entidades principales de Furry Advisor son:
- Usuario: aquella persona que se registre en la página web. Para ello requiere de nombre de usuario y contraseña. Es capaz de hacer reservas, escribir reseñas, consultar lugares y usar ofertas. Consulta el tablón de anuncios para enterarse de novedades.

- Lugares: emplazamientos que puede visitar el Usuario o visitante en la vida real. Estos cuentan con varias Reseñas y, según el sitio, se puede o no hacer Reservas. Pueden ofrecer Ofertas a los Usuarios.

- Reseñas: comentarios que hace un Usuario registrado sobre el Lugar visitado para que otros Usuarios puedan leer su experiencia. Estas pueden ser comentadas por otros Usuarios y valoradas como útiles o poco útiles.

- Ofertas: descuentos y promociones del establecimiento que ofrece a los Usuarios registrados como marketing.

- Tablón de anuncios: portal de inicio de la página web en la que un Usuario o visitante consulta los Lugares de moda o más destacados, las Ofertas activas y los nuevos Lugares.


## Servicios internos ##
Los servicios que proporciona el servidor son:
- Notificaciones de Ofertas recien añadidas.
- Los usuarios con rol de Administrador podrán crear nuevas Ofertas para los establecimientos.


## Descripción y diagrama de relación y opciones disponibles en cada HTML ##
La aplicación web cuenta con 12 páginas: home, search, login, sign up, profile, place, account settings, edit profile, create review, create deal, user search y edit user. Las opciones disponibles en cada página y el salto entre ellas se muestra en la siguiente imagen:

![UML_HTMLs](https://user-images.githubusercontent.com/56488179/160238190-217801bd-4678-4643-9aec-1587ef614696.png)

A continuación una breve explicación de cada página:
- Navbar: no es una página en sí, pero se ha modificado con respecto a la anterior fase y aparece en el resto de páginas. Permite el acceso a la página principal, la búsqueda de lugares y el acceso a la cuenta de un usuario ya registrado o el registro de un nuevo usuario. Además, notificará al usuario en caso de que haya nuevas ofertas.
![navbar](https://user-images.githubusercontent.com/78224717/161607620-b905d0cc-1ea7-4f2c-bd9a-4923feb04ce0.png)


- Home: página de inicio de la aplicación en la que se muestran algunas de las ofertas disponibles y un espacio dedicado a las novedades.
![home](https://user-images.githubusercontent.com/56488179/155429671-5bca192a-1437-481a-8304-e4a9aad9cc86.png)


- Search: página en la que se hace la búsqueda de un lugar en concreto o de un conjunto de lugares según unos criterios. 
![searcj](https://user-images.githubusercontent.com/56488179/155429691-11cc530a-ce71-4102-9dcc-59daa80a5ab1.png)


- Login: página en la que se identifican aquellos usuarios que ya se encuentran presentes dentro del sistema.
![login](https://user-images.githubusercontent.com/56488179/155429710-f5ed7608-0fea-4e6a-a127-b567a59b3507.png)


- Sign Up: página a la que accede un usuario sin identificar para registrarse en el sistema por primera vez.
![register](https://user-images.githubusercontent.com/56488179/155429723-4667a01f-5e97-4726-9b81-5e5e5481a53d.png)


- Profile: página en la que se muestra la información del usuario identificado y las reseñas escritas por él/ella. Si es administrador, le aparece un opción extra para buscar a los usuarios registrados.
![profile](https://user-images.githubusercontent.com/56488179/155429736-8bc5264b-1510-4419-919e-c26a7547cc17.png)
![image](https://user-images.githubusercontent.com/56488179/160236446-8127aa14-4894-4f23-bd79-703ceef7f975.png)


- Place: página en la que se muestran los datos de un lugar seleccionado como resultado de la búsqueda en Search. Además se pueden consultar las reseñas de otros usuarios registrados sobre el lugar, al igual que se da la opción de escribir una reseña nueva. Si el usuario actual es administrador, le aparece una opción para añadir nuevas ofertas al estableciemiento.
![place](https://user-images.githubusercontent.com/56488179/155429745-5b90f431-d3be-4b36-84f1-883ff40d6ccc.png)
![image](https://user-images.githubusercontent.com/56488179/160236472-3430ba70-d094-4175-b2ec-60d5322a9a8c.png)


- Create Deal: el administrador puede añadir ofertas a un lugar concreto, tras lo cual todos los usuarios que estén actualmente en la aplicación serán notificados mediante un mensaje en el Nav Bar.
![image](https://user-images.githubusercontent.com/56488179/160236689-8c99861a-a6a9-4d78-a96e-4258e250b156.png)


- Account Settings: página en la que un usuario registrado e identificado puede modificar elementos de su cuenta tales como la contraseña, permitiendo además borrar su cuenta.
![account_settings](https://user-images.githubusercontent.com/56488179/155429762-6ea69e47-7243-4245-933a-362a6a0c9841.png)


- Edit Profile: página en la que un usuario registrado e identificado puede modificar los elementos públicos de su perfil como el nombre o la foto de perfil.
![edit_profile](https://user-images.githubusercontent.com/56488179/155429774-cf01670f-60fc-40aa-9857-282be1c99fe2.png)


- Create Review: página en la que un usuario registrado e identificado puede escribir una reseña sobre un lugar en concreto. El usuario aporta una puntuación sobre 5 y, si quiere, un texto de reseña.
![image](https://user-images.githubusercontent.com/56488179/160236739-43365db6-6e1b-43c4-94ff-0a2793786ad5.png)


- User Search: el administrador cuenta con un buscador exclusivo de usuarios, pudiendo buscar y seleccionar cualquiera de los usuarios registrados en la plataforma para realizar algunas acciones.
![image](https://user-images.githubusercontent.com/56488179/160236522-34b205aa-ac1b-4ca9-b2cf-f5bfa6572831.png)


- Edit User: el administrador, tras seleccionar a uno de los usuarios en User Search, se le da opción de borrar la foto del usuario (por si es necesario), borrar sus reviews (por si contienen material ofensivo o inadecuado) y, en última instancia, borrar la cuenta.
![image](https://user-images.githubusercontent.com/56488179/160236577-2736aa93-a91f-4bb3-ad48-d94b2a8c89c9.png)

De todas las ellas, las páginas públicas serían: home, search, login, sign up y place. Las páginas privadas serían: profile, account settings, edit profile, create review, user search, create deal y edit user.

Todas las paginas cuentan con una barra de navegación desde el que acceder a las páginas principales de la aplicación web (Home, Search y Login/Sign Up) y un pie de página. Además, una vez se haya identificado un usuario en la aplicación, aparece una nueva opción para acceder directamente a su página de perfil y otra opción para cerrar sesión.
La presencia de la barra de navegación en una página viene marcado con un * al lado del nombre de la página en el diagrama UML de los HTML.


## Diagrama de relación entre las distintas entidades ##

![UML_Entidades drawio](https://user-images.githubusercontent.com/56488179/155424509-cb8713f6-b474-4459-8b04-77841ae28067.png)


## Diagrama de las clases del programa y relación entre controladores y templates ##

![UML_Clases](https://user-images.githubusercontent.com/56488179/160241444-7ff7d7d8-b8ea-4800-9ad1-0643e2e8e94e.png)

Leyenda de colores:
- Naranja: @Configuration
- Rojo: Interface
- Amarillo: @Service
- Azul: @Entity
- Verde: @Controller
- Gris: @Component
- Fucsia: Template html
- Lila: @RestController


## Despliege de aplicación en Máquina Virtual ##

En máquina original:
- Instalar JDK version 17 o superior de Java en el sistema que vaya a compilar.
- Instalar Maven.
- Crear Variables del Entorno JAVA_HOME y modificar Path para añadir la ruta a la carpeta Bin de Maven y del JDK.
- Abrir PowerShell en la carpeta raiz del proyecto y ejecutar el comando "mvn clean package" que creará un ejecutable en la carpeta Target.
- Repetir paso anterior con el proyecto del servicio interno.
- Pasar los ejecutables creados a la máquina virtual (por ejemplo subirlo a drive y descargarlo desde la maquina virtual)
  
  

En máquina virtual:
- Ejecutar comando sudo apt update
- Instalar el JDK con comando sudo apt install openjdk-11-jre-headless
- Instalar Mysql con comando sudo apt install mysql-server-8.0
- Iniciar sesion con sudo mysql -u root (el sudo solo la primera vez) 
	- Cambiar el usuario y la contraseña de Mysql mediante ALTER USER 'root'@'locahost' IDENTIFIED WITH mysql_native_password BY 'nuevacontraseñafurry';
	- Utilizar comando FLUSH PRIVILEGES;
	- Salir de mysql para comprobar el cambio con exit;
- Iniciar sesion en mysql con el comando mysql -u root -p y la contraseña nuevacontraseñafurry.
	- Crear base de datos con el comando create database posts;  (se pueden ver las bases de datos creadas con el comando show databases)
	- Utilizar comando use posts;
	- Salir con exit; 
- Ejecutar comando java -jar "furry-advisor-internal.jar"
- Abrir otro terminal
- Ejecutar comando java -jar "furry-advisor.jar" (es posible que haya que ejecutarlo más de una vez para que no aparezca ningún error)


Una vez ejecutados ambos, podemos disfrutar de la mejor (y única) web de tursimo furry! :P



## Enlace a tablero Trello ##
https://trello.com/b/qQkhZRH9/furry-advisor
