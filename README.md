# Furry Advisor
*Woof Woof*

## Descripción de Furry Advisor ##
Furry Advisor consiste en una pagina web de guía turística en la que se pueden consultar convenciones, restaurantes, bares y clubs de temática furry, permitiendo así a quien quiera introducirse y empaparse de la cultura furry poder visitar esos lugares y conocer a gente furry.

Al entrar a la página se muestra un tablón de anuncios en el que aparecen los lugares más visitados y frecuentados de la cultura furry, lugares nuevos y lugares que cuenten con ofertas activas para los usuarios registrados.
La gente que entre en la página puede registrarse como usuario, accediendo a servicios como la solicitud de reservas en bares, restaurantes y clubs y el uso de cupones de ofertas para dichos lugares. Además cada lugar cuenta con reseñas, escritas por los usuarios registrados, permitiendo destacar los mejores lugares que visitar. Estas reseñas pueden ser consultadas tanto por usuarios registrados como por usuarios sin registrar.

En resumen, un usuario registrado puede hacer reservas en lugares, usar ofertas y escribir reseñas de los locales o eventos que visite. Por el contrario, un usario sin registrar solo podrá leer las reseñas escritas. Ambos pueden consultar el tablón de anuncios.

## Entidades principales ##
Las entidades principales de Furry Advisor son:
- Usuario: aquella persona que se registre en la página web. Para ello requiere de nombre de usuario y contraseña. Es capaz de hacer reservas, escribir reseñas, consultar lugares y usar ofertas. Consulta el tablón de anuncios para enterarse de novedades.
- Lugares: emplazamientos que puede visitar el Usuario o visitante en la vida real. Estos cuentan con varias Reseñas y, según el sitio, se puede o no hacer Reservas. Pueden ofrecer Ofertas a los Usuarios.
- Reseñas: comentarios que hace un Usuario registrado sobre el Lugar visitado para que otros Usuarios puedan leer su experiencia.
- Ofertas: descuentos y promociones del establecimiento que ofrece a los Usuarios registrados como marketing.
- Reservas: selección de fecha y hora de visita de un lugar en el que el Usuario confirma su asistencia al Lugar. Según el Lugar las reservas estarán o no habilitadas.
- Tablón de anuncios: portal de inicio de la página web en la que un Usuario o visitante consulta los Lugares de moda o más destacados, las Ofertas activas y los nuevos Lugares.

## Servicios internos (REMODELAR) ##
Los servicios que proporciona el servidor son:
- Para la lectura de las Reseñas del Lugar, se accede a la BD de los lugares y se cargan todas las reseñas guardadas y asociadas al lugar.
- Para la escritura de las Reseñas del Lugar, se pasa al servidor la Reseña y el Lugar asociado y crea una entrada en la tabla de la BD.
- Recibir datos sobre el Lugar a buscar y consultar la base de datos para encontrar la entrada asignada al Lugar especificado.
- El servidor accede a la BD de los Lugares y, usando las URL de los Lugares, se comunica con el servidor externo para recibir las Ofertas del Lugar y así mostrarlas en el Tablón de anuncios.
- Se consulta al servidor externo del Lugar para comprobar disponibilidad para hacer Reservas. Esta información se recibe y se muestra al Usuario.
- Se consulta la BD y, según unos criterios, se recogen datos de entradas existentes para mostrarlos en el Tablón de Anuncios.

## Enlace a tablero Trello ##
https://trello.com/b/qQkhZRH9/furry-advisor
