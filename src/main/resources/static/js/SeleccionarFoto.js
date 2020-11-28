var activarFotoFile = function(){
    var inputFoto = document.querySelector("#input_foto")
    inputFoto.click();
}

var seleccionarFotoOnClick = function(){
    var boton = document.querySelector("#boton_selec_foto");
    boton.addEventListener("click", activarFotoFile);
}

var handleIMG = function (files){
    var fotoElegido = files[0];
    document.querySelector("#visor_foto").innerHTML = fotoElegido.name
}

var leerFoto= function(){
    //Con FileReader. TODO...
}

var main = function(){
    seleccionarFotoOnClick();
}

window.addEventListener("load", main);