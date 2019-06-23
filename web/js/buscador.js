function sendRequest(){
    var val = document.getElementById("search").value;
    if(val.length >= 3){
        var url = 'php/volrequest.php';
        
        // var request = new XMLHttpRequest();
        // request.open('POST', 'php/volrequest.php', true);
        // request.setRequestHeader('Content-Type', 'application/x-ww-form-urlencoded');
        // request.onreadystatechange = function () {
            
        // }
        // request.send();
        $.ajax({

            type: "GET",
            url: url,
            data: {buscar: val},

        })
        .done(function(resultado){
            $('#busqueda_resultado').html(resultado);
        })
    }
    else{
        document.getElementById("busqueda_resultado").innerHTML = "";
    }
}