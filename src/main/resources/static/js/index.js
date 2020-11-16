function OnClickAyuda(){
    $('#ayudaModal').modal({backdrop: 'static', keyboard: false})
}

var main = function(){
    console.log("aea")
    document.getElementById("but_ayuda").onclick = OnClickAyuda;
}

window.addEventListener("load", main)