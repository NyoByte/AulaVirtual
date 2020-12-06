function OnClickAyuda(){
    $('#ayudaModal').modal({backdrop: 'static', keyboard: false})
}

function OnSelectProfesorT1(){
    var cod = document.getElementById("profesorT1Seleccionado").value
    document.getElementById("codigoProfesorT1").value=cod;
}

function OnSelectProfesorT2(){
    var cod = document.getElementById("profesorT2Seleccionado").value
    document.getElementById("codigoProfesorT2").value=cod;
}


var main = function(){
    document.getElementById("but_ayuda").onclick = OnClickAyuda;
}

window.addEventListener("load", main)