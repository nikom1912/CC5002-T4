window.onload = mapCities;
function mapCities(){
    var data;
    var coordenadas;
    var map = L.map('map').setView([-33.437, -70.6506], 8);
    var request_coordenadas = new XMLHttpRequest();
    request_coordenadas.open('GET', 'js/chile_with_regions.json', false);
    request_coordenadas.onload = function(){
        coordenadas = JSON.parse(request_coordenadas.responseText);
        console.log(coordenadas);
    };
    request_coordenadas.send();
    L.tileLayer('https://api.maptiler.com/maps/streets/{z}/{x}/{y}.png?key=e5JrAd6MujUZ0xj87DUJ', {
        attribution:'<a href="https://www.maptiler.com/copyright/" target="_blank">© MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">© OpenStreetMap contributors</a>'
        }).addTo(map);
    var url = 'php/ciudadesInfo.php';
    $.ajax({
        url: url
    })
    .done(function(resultado){
        data = JSON.parse(resultado);
        for(var comuna in data){
            var lat = 0;
            var lng = 0;
            var region = data[comuna][0]['region'];
            console.log(eliminarDiacriticos(region));
            for(var r in coordenadas){
                var regex = new RegExp(eliminarDiacriticos(r.toLowerCase()));
                console.log(r);
                if(regex.test(eliminarDiacriticos(region.toLowerCase()))){
                    region = r;
                    break;
                }
            }
            console.log(region);
            for(var c in coordenadas[region]){
                console.log(coordenadas[region][c]["name"]);
                console.log(comuna);
                if(eliminarDiacriticos(comuna.toLowerCase()) == eliminarDiacriticos(coordenadas[region][c]["name"].toLowerCase())){
                    lat = coordenadas[region][c]["lat"];
                    lng = coordenadas[region][c]["lng"];
                    break;
                }
            }
            var html = "<table style='border-collapse: collapse;'>";
            var i = 0;
            for(var d in data[comuna]){
                datos = data[comuna][d];
                var todo_html = "<tr style='border: 1px solid rgb(0, 0, 0);'>";
                var datos_html = "<td><table style='border-collapse: collapse;'>";
                var imagen_html = "<td><ul>";
                var fecha = datos["fecha"];
                var tipo = datos["tipo"];
                var nombre = datos["nombre"];
                var imagenes = datos["imagenes"];
                var id = datos["id"];
                for (var img in imagenes){
                    imagen_html += "<li style='list-style:none;'><img src='" + imagenes[img] + "' width='160' hwight='120'></li>"; 
                    i++;
                }

                imagen_html += "</ul></td>";
                datos_html += "<tr><td style='border: 1px solid rgb(0, 0, 0);'> Nombre de Contacto: " + nombre + "</td></tr>";
                datos_html += "<tr><td style='border: 1px solid rgb(0, 0, 0);'> Tipo de mascota: " + tipo + "</td></tr>";
                datos_html += "<tr><td style='border: 1px solid rgb(0, 0, 0);'> Fecha: " + fecha + "</td></tr>";
                datos_html += "<tr><td style='border: 1px solid rgb(0, 0, 0);'> Fecha: " + fecha + "</td></tr>";
                datos_html += "<tr><td style='border: 1px solid rgb(0, 0, 0);'> <a href='ver_fotos.php?id="+ id +"'> <button> Ver fotografias </button></a></td></tr>";
                datos_html += "</table>";
                todo_html += imagen_html + datos_html + "</tr>";
                html += todo_html;
                
            }
            html += "</table>";
            marker = new L.marker([lat, lng],
                {     
                    title: i + " imagenes",     // Add a title 
                })
                .bindPopup(html)
                .addTo(map);
        }  
    });         
}
function eliminarDiacriticos(texto) {
    return texto.normalize('NFD').replace(/[\u0300-\u036f]/g,"");
}