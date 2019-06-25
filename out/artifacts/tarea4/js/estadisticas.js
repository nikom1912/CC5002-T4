function cargarXDia(){
    var url = 'XDia';
    var request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Content-Type', 'application/x-ww-form-urlencoded');
    request.onload = function (e){
        if(this.status == 200)
        {
            console.log(request.responseText);
        }

    };
    request.send();
}