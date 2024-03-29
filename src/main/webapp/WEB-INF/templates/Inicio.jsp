<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aula Virtual</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>

</head>

<body class="fondo">
    <div class="">
        <header class="col-md-12 px-0">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark pt-0 pb-0">
                <div class="navbar-collapse">
                    <ul class="navbar-nav flex-row">
                        <li class="nav-item mr-3">
                            <a class="nav-link" href="/">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a type="button" class="nav-link" id="but_ayuda">Ayuda</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <div class="container">
        <div class="row justify-content-center mt-5">
            <form class="col-6 justify-content-center main-container">
                <h1 class="form-group text-center">
                    Bienvenido al Aula Virtual
                </h1>
                <div class="btn-group-vertical col">
                    <a type="button" class="btn btn-outline-success mb-2" href="/login/administrador">Administrador</a>
                    <a type="button" class="btn btn-outline-primary mb-2" href="/login/profesor">Profesor</a>
                    <a type="button" class="btn btn-outline-secondary mb-2" href="/login/alumno">Alumno</a>
                </div>
            </form>
        </div>
    </div>
    <div class="m-3">
        <p class="text-center font-weight-bold text-muted pr-2">Universidad de Lima 2020-II</p>
    </div>
<!-- Modal -->
<div id="ayudaModal" class="modal fade " tabindex="-1">
    <div class="modal-dialog modal-dialog-centered ">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title font-weight-bold">Integrantes del Grupo:</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row mb-3">
                    <div class="col-3">
                        <img class="w-100 h-100" src="/profiles/nyo.jpg">
                    </div>
                    <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Andy Lazo</div>
                    <div class="col-3">
                        <img class="w-100 h-100" src="/profiles/gabu.jpg">
                    </div>
                    <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Gabriel Carmelo</div>
                </div>
                <div class="row mb-3">
                    <div class="col-3">
                        <img class="w-100 h-100" src="/profiles/dante.jpg">
                    </div>
                    <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Dante Córdova</div>
                    <div class="col-3">
                        <img class="w-100 h-100" src="/profiles/edgar.jpg">
                    </div>
                    <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Edgar Rodriguez</div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
    <script src="/js/index.js"></script>
</body>

</html>