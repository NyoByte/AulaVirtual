var seccionesComboOnSelect = function(evt){
    var combo = evt.target
    var selected = combo.options[combo.selectedIndex].value
    console.log(selected)
    var botonBuscar = document.querySelector("#boton_buscar")
    botonBuscar.setAttribute("href", "?seccion_id="+selected)
}


var main = function(){
    document.querySelector("#seccion_combo").addEventListener("change", seccionesComboOnSelect);
}
window.addEventListener("load", main)