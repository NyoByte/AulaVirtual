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

var crearFila = function(alumno){
    var fila = document.createElement("tr")

    var td1 = document.createElement("td")
    td1.setAttribute("scope", "row")
    td1.innerHTML = alumno.cod

    var td2 = document.createElement("td")
    td2.innerHTML = alumno.first_name + " " + alumno.last_name

    var td3 = document.createElement("td")
    td3.innerHTML = "carrera"

    var td4 = document.createElement("td")
    td4.innerHTML = "genero"

    var td5 = document.querySelector("#boton_edit").cloneNode(true)
    td5.firstChild.setAttribute("href", "/alumno?edit=true&alumno_id="+alumno.id)


    var td6 = document.querySelector("#boton_borrar").cloneNode(true)

    fila.appendChild(td1)
    fila.appendChild(td2)
    fila.appendChild(td3)
    fila.appendChild(td4)
    fila.appendChild(td5)
    fila.appendChild(td6)
    return fila
}

var mostrarAlumnos = function(listaAlumnos){
    var tabla = document.querySelector("#cuerpo_table")
    for(var al of listaAlumnos){
        var fila = crearFila(al)
        tabla.appendChild(fila)
    }
    //borrar la primera fila
    tabla.removeChild(document.querySelector("#first_row"))
}

var onAlumnosObtenidos = function(evt){
    var req = evt.target;
    if(req.readyState == 4){
        if(req.status == 200){
            mostrarAlumnos(JSON.parse(req.responseText))
            //console.log(JSON.parse(req.responseText))
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
