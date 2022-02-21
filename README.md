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
- Notificaciones de Ofertas y eventos recien sacados.
- Avisar de interacciones de otros Usuarios con tus Reseñas: valoración de utilidad, comentarios, etc.

## Descripción y diagrama de relación y opciones disponibles en cada HTML ##
La aplicación web cuenta con 9 páginas: home, search, login, sign up, profile, place, account settings, edit profile y create review. Las opciones disponibles en cada página y el salto entre ellas se muestra en la siguiente imagen:

A continuación una breve explicación de cada página:
- Home: página de inicio de la aplicación en la que se muestran algunos de los lugares que actualmente cuentan con ofertas disponibles y un espacio dedicado a las novedades.
- Search: página en la que se hace la búsqueda de un lugar en concreto o de un conjunto de lugares según unos criterios. Se permite la ordenación de los resultados según unos parámetros.
- Login: página en la que se identifican aquellos usuarios que ya se encuentran presentes dentro del sistema.
- Sign Up: página a la que accede un usuario sin identificar para registrarse en el sistema por primera vez.
- Profile: página en la que se muestra la información del usuario identificado y las reseñas escritas por él/ella.
- Place: página en la que se muestran los datos de un lugar seleccionado como resultado de la búsqueda en Search. Además se pueden consultar las reseñas de otros usuarios registrados sobre el lugar, al igual que se da la opción de escribir una reseña nueva.
- Account Settings: página en la que un usuario registrado e identificado puede modificar elementos de su cuenta tales como el email o la contraseña, permitiendo además borrar su cuenta.
- Edit Profile: página en la que un usuario registrado e identificado puede modificar los elementos públicos de su perfil como el nombre o la foto de perfil.
- Create Review: página en la que un usuario registrado e identificado puede escribir una reseña sobre un lugar en concreto. El usuario aporta una puntuación sobre 5 y, si quiere, un texto de reseña.

De todas las ellas, las páginas públicas serían: home, search, login, sign up y place. Las páginas privadas serían: profile, account settings, edit profile y create review.

Todas las paginas cuentan con una barra de navegación desde el que acceder a las páginas principales de la aplicación web (Home, Search y Login/Sign Up) y un pie de página.
La presencia de la barra de navegación en una página viene marcado con un * al lado del nombre de la página en el diagrama UML de los HTML.

## Diagrama de relación entre las distintas entidades ##
![UML_Entidades](https://user-images.githubusercontent.com/56488179/154815264-b4cf74f8-5ea5-4f94-ba0f-b8d12e0013a5.png)


## Diagrama de las clases del programa ##

## Enlace a tablero Trello ##
https://trello.com/b/qQkhZRH9/furry-advisor
