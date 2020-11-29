
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
    var fr = FileReader();
    fr.readAsText()
}


var main = function(){
    seleccionarArchivoOnClick();
    //obtenerListadoAlumnos(pag++);
}

window.addEventListener("load", main);