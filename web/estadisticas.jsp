<%--
  Created by IntelliJ IDEA.
  User: nikom
  Date: 25-06-2019
  Time: 6:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tarea 1</title>
    <link type="text/css" rel="stylesheet" href="css/landing-styles.css">
    <link type="text/css" rel="stylesheet" href="css/banner-styles.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.4.0/dist/leaflet.css"
          integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
          crossorigin=""/>
    <link rel="stylesheet" href="css/boostrapv4w3cfix.css">
    <link rel="stylesheet" href="css/galeria.css">
    <script src="js/estadisticas.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" ></script>
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
</head>
<body>
<div class="banner">
    <header>
        <div class="content">
            <div class="barra">
                <div class="logo-banner">
                    <a href="http://localhost/tarea4/web/index.php">
                        <img class="logo" src="img/banner-real.png" alt="banner">
                    </a>
                </div>
                <div class="option-banner">
                    <button class="nav-button"> <img class="menu-icon" src="img/menu.png" alt="menu-icon"></button>
                    <a href="http://localhost/tarea4/web/addtraslado.html"  class="nav-enlace desaparece">Agregar Traslado</a>
                    <a href="http://localhost/tarea4/web/addvoluntario.html"  class="nav-enlace desaparece">Agregar Voluntarios </a>
                    <a href="http://localhost/tarea4/web/vertraslados.php"  class="nav-enlace desaparece">Ver Traslados  </a>
                    <a href="http://localhost/tarea4/web/vervoluntarios.php"  class="nav-enlace desaparece">Ver Voluntarios  </a>
                    <a href="http://localhost:8080/tarea4/Galeria" class="nav-enlace desaparece">Galería</a>
                </div>
            </div>
        </div>
    </header>
</div>
<div class="main">
    <div class="caja">
            <h2> Estadisticas por día </h2>
        <div id="xdia">
            <button onclick="cargarXDia()"> holi </button>
        </div>

    </div>
</div>


</body>


</html>
