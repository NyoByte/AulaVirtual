
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

var leerArchivo = function(file){
    var fr = new FileReader()
    var content = fr.readAsText(file)
    console.log(content)
}

var botonSubirOnClick = function(){
    var files = document.querySelector("#input_file").files
    var file = files[0]
    var reader = new FileReader()
    reader.onload = (e) => {
        var file = e.target.result
        var lines = file.split(/\r\n|\n/)

        var textArray = []
        for(var line of lines) {
            var jsonLine = '{'
           var values = line.split(",")
            for(var i=0; i<values.length; i++){
                jsonLine += '"key'+i+'": "' + values[i] + '"'
                if(i<values.length-1){
                    jsonLine+=', '
                }
            }
        jsonLine += "}"
        textArray.push(jsonLine)
        }
        console.log(textArray)

        for(var obj of textArray){
            console.log(JSON.parse(obj))
        }

    }

    reader.readAsText(file)
}

var main = function(){
    seleccionarArchivoOnClick();
    //obtenerListadoAlumnos(pag++);
    document.querySelector("#boton_subir").addEventListener("click", botonSubirOnClick)
}

window.addEventListener("load", main);