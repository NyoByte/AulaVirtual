var botonSeleccionarArchivoOnClick = function(){
    document.querySelector("#input_file").click()
}

var handleFiles = function(files){
    document.querySelector("#nombre_archivo").innerHTML = files[0].name
}


var main = function(){
    document.querySelector("#boton_selec_archivo").addEventListener("click", botonSeleccionarArchivoOnClick)
}

window.addEventListener("load", main)