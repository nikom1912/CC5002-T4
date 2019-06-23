<?php
//    $mysql = new mysqli("localhost", 'cc500221_u', 'nissimnullaD','cc500221_db');
    $mysql = new mysqli("localhost", 'root', '','tarea2');
?>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Ver traslados | Tarea 1</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="js/regiones.js"></script>
<script src="js/script-vert.js"></script>
<script src="js/val-traslados.js"></script>
<script src="js/script-aaddt.js"></script>

<link type="text/css" rel="stylesheet" href="css/addt-styles.css">
<link type="text/css" rel="stylesheet" href="css/banner-styles.css">
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
<link rel="stylesheet" href="css/boostrap v4 w3c fix.css">
<link type="text/css" rel="stylesheet" href="css/verT.css">




</head>
<body>
<div class="container">
    <div class="banner">
        <header>
            <div class="content">
                <div class="barra">
                    <div class="logo-banner">
                        <a href="index.php">
                                <img class="logo" src="img/banner-real.png" alt="banner">
                        </a>
                    </div>
                    <div class="option-banner">
                        <button class="nav-button" > <img  class="menu-icon" src="img/menu.png" alt="menu-icon"></button>
                        <a href="addtraslado.html"  class="nav-enlace desaparece">Agregar Traslado</a>
                        <a href="addvoluntario.html"  class="nav-enlace desaparece">Agregar Voluntarios </a>
                        <a href="vertraslados.php"  class="nav-enlace desaparece">Ver Traslados  </a>
                        <a href="vervoluntarios.php"  class="nav-enlace desaparece">Ver Voluntarios  </a>
                        <a href="galeria.jsp" class="nav-enlace desaparece">Galería</a>

                    </div>
                </div>
            
            </div>
        </header>
    </div>
    <div class="main">
        <?php
        if(!$_GET){
            header("Location: index.php");
        }
        $traslado_id = $_GET['id'];
        $query = "SELECT ruta_archivo as ruta, nombre_archivo as nombre FROM foto_mascota WHERE traslado_id = '$traslado_id'"; 
        $result = $mysql->query($query);
        ?>
        <div class="caja">

            <?php if($result){ 
                echo "<ul width='90%'>";
                while($datos = $result->fetch_array()){
                    $ruta = $datos['ruta'];
                    $nombre = $datos['nombre'];
                    $archivo = $ruta . "/" . $nombre;
                    // echo "<td colspan='5' >";

                    echo "<li><img src='$archivo' width='320' height='240' <li>";
                    // echo "<td class= 'dato$i' style='display:none'> "
            }
            echo "</ul>";
        } 
            ?>
        </div>
        </div>
    </div>
    
</body>
</html>