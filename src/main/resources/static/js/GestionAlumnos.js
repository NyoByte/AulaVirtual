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


var onAlumnosObtenidos = function(evt){
    var req = evt.target;
    if(req.readyState == 4){
        if(req.status == 200){
            console.log(req.responseText)
        }else{
            //Error
            console.error("Hubo un error al obtener la lista de alumnos");
        }
    }
}

var obtenerListadoAlumnos = function(){
    var req = new XMLHttpRequest();
    req.onreadystatechange = onAlumnosObtenidos;
    req.open("GET", "/resources/alumno", true);
    req.send(null);
}

var main = function(){
    seleccionarArchivoOnClick();
    obtenerListadoAlumnos();
}

window.addEventListener("load", main);