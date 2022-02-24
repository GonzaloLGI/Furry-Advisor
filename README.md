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

![html_2 drawio](https://user-images.githubusercontent.com/56488179/155422754-052b51d0-2994-48b4-8743-761bf9668a0a.png)

A continuación una breve explicación de cada página:
- Home: página de inicio de la aplicación en la que se muestran algunas de las ofertas disponibles y un espacio dedicado a las novedades.
![home](https://user-images.githubusercontent.com/56488179/155429671-5bca192a-1437-481a-8304-e4a9aad9cc86.png)
- Search: página en la que se hace la búsqueda de un lugar en concreto o de un conjunto de lugares según unos criterios. 
![searcj](https://user-images.githubusercontent.com/56488179/155429691-11cc530a-ce71-4102-9dcc-59daa80a5ab1.png)
- Login: página en la que se identifican aquellos usuarios que ya se encuentran presentes dentro del sistema.
![login](https://user-images.githubusercontent.com/56488179/155429710-f5ed7608-0fea-4e6a-a127-b567a59b3507.png)
- Sign Up: página a la que accede un usuario sin identificar para registrarse en el sistema por primera vez.
![register](https://user-images.githubusercontent.com/56488179/155429723-4667a01f-5e97-4726-9b81-5e5e5481a53d.png)
- Profile: página en la que se muestra la información del usuario identificado y las reseñas escritas por él/ella.
![profile](https://user-images.githubusercontent.com/56488179/155429736-8bc5264b-1510-4419-919e-c26a7547cc17.png)
- Place: página en la que se muestran los datos de un lugar seleccionado como resultado de la búsqueda en Search. Además se pueden consultar las reseñas de otros usuarios registrados sobre el lugar, al igual que se da la opción de escribir una reseña nueva.
![place](https://user-images.githubusercontent.com/56488179/155429745-5b90f431-d3be-4b36-84f1-883ff40d6ccc.png)
- Account Settings: página en la que un usuario registrado e identificado puede modificar elementos de su cuenta tales como la contraseña, permitiendo además borrar su cuenta.
![account_settings](https://user-images.githubusercontent.com/56488179/155429762-6ea69e47-7243-4245-933a-362a6a0c9841.png)
- Edit Profile: página en la que un usuario registrado e identificado puede modificar los elementos públicos de su perfil como el nombre o la foto de perfil.
![edit_profile](https://user-images.githubusercontent.com/56488179/155429774-cf01670f-60fc-40aa-9857-282be1c99fe2.png)
- Create Review: página en la que un usuario registrado e identificado puede escribir una reseña sobre un lugar en concreto. El usuario aporta una puntuación sobre 5 y, si quiere, un texto de reseña.
![create_review](https://user-images.githubusercontent.com/56488179/155429835-324e55ac-3612-49fd-bf62-aae964001693.png)

De todas las ellas, las páginas públicas serían: home, search, login, sign up y place. Las páginas privadas serían: profile, account settings, edit profile y create review.

Todas las paginas cuentan con una barra de navegación desde el que acceder a las páginas principales de la aplicación web (Home, Search y Login/Sign Up) y un pie de página. Además, una vez se haya identificado un usuario en la aplicación, aparece una nueva opción para acceder directamente a su página de perfil.
La presencia de la barra de navegación en una página viene marcado con un * al lado del nombre de la página en el diagrama UML de los HTML.

## Diagrama de relación entre las distintas entidades ##

![UML_Entidades drawio](https://user-images.githubusercontent.com/56488179/155424509-cb8713f6-b474-4459-8b04-77841ae28067.png)

## Diagrama de las clases del programa ##

![UML_Clases](https://user-images.githubusercontent.com/56488179/155433780-0ee9ad89-cd65-4605-a5f6-685035af72aa.png)

## Enlace a tablero Trello ##
https://trello.com/b/qQkhZRH9/furry-advisor
