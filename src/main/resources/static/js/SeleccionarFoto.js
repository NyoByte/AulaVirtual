
var activarFotoFile = function(){
    var inputFoto = document.querySelector("#input_foto")
    inputFoto.click();
}

var seleccionarFotoOnClick = function(){
    var boton = document.querySelector("#boton_selec_foto");
    console.log("llego");
    boton.addEventListener("click", activarFotoFile);
}

var handleIMG = function (files){
    var fotoElegido = files[0];
    document.querySelector("#visor_foto").innerHTML = fotoElegido.name
}

var leerFoto= function(){
    //Con FileReader. TODO...
    var fr = FileReader();
    fr.readAsText()
}

var previewImage = function (event){
    var reader = new FileReader();
    var imageField= document.getElementById("image-field")

    reader.onload = function(){
        if(reader.readyState == 2){

            imageField.src= reader.result;
        }
    }
    reader.readAsDataURL(event.target.files[0]);

}

var main = function(){
    seleccionarFotoOnClick();
}

window.addEventListener("load", main);