<!DOCTYPE html>
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
   <script src="js/index.js"></script>

   <script src="https://unpkg.com/leaflet@1.4.0/dist/leaflet.js"
   integrity="sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg=="
   crossorigin=""></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" ></script>
    <script src="js/buscador.js"></script>
    
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">

    
</head>
<body>
    <div class="container">
            <div class="banner">
                <header>
                    <div class="content">
                        <div class="barra">
                            <div class="logo-banner">
                                <a href="/tarea3/index.php">
                                    <img class="logo" src="img/banner-real.png" alt="banner">
                                </a>
                            </div>
                            <div class="option-banner">
                                <button class="nav-button"> <img class="menu-icon" src="img/menu.png" alt="menu-icon"></button>
                                <a href="/tarea3/addtraslado.html"  class="nav-enlace desaparece">Agregar Traslado</a>
                                <a href="/tarea3/addvoluntario.html"  class="nav-enlace desaparece">Agregar Voluntarios </a>
                                <a href="/tarea3/vertraslados.php"  class="nav-enlace desaparece">Ver Traslados  </a>
                                <a href="/tarea3/vervoluntarios.php"  class="nav-enlace desaparece">Ver Voluntarios  </a>
                                <a href="/tarea4/Galeria" class="nav-enlace desaparece">Galería</a>
                            </div>
                        </div>

                    </div>
                </header>
            </div>
        <div class="main" >
            <h1>
                El mejor servicio de transporte de mascotas, a las puertas de su casa.
            </h1>
            <div> Buscar voluntario: <div><input type="text" name="buscar" id="search" placeholder="Buscar..." onkeyup="sendRequest()"> </div>
                <div> 
                    <ul id="busqueda_resultado">

                    </ul>
                    
                </div>
            </div>
            <!-- <button onClick="mapCities()"> Ver mapa</button> -->
            <div id = "map"></div>
        </div>
    </div>
</body>
</html>