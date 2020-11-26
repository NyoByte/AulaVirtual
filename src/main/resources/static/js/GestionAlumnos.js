var activarInputFile = function(){
    var inputFile = document.querySelector("#input_file")
    inputFile.click();
}

var seleccionarArchivoOnClick = function(){
    var boton = document.querySelector("#boton_selec_archivo");
    boton.addEventListener("click", activarInputFile);
}

var handleFiles = function (files){
    var archivoElegido = files[0];

    document.querySelector("#visor_archivo").innerHTML = archivoElegido.name
}

var leerArchivo = function(){
    //Con FileReader. TODO...
}

var activarFotoFile = function(){
    var inputFoto = document.querySelector("#input_Foto")
    inputFoto.click();
}

var seleccionarFotoOnClick = function(){
    var boton2 = document.querySelector("#boton_selec_foto");
    boton2.addEventListener("click", activarFotoFile);
}

var handleIMG = function (files){
    var fotoElegido = files[0];

    document.querySelector("#visor_foto").innerHTML = fotoElegido.name
}

var leerFoto= function(){
    //Con FileReader. TODO...
}

var main = function(){
    seleccionarArchivoOnClick();
    seleccionarFotoOnClick();
}

window.addEventListener("load", main);
