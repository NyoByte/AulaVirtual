<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profesor-Secciones</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>

<body class="fondo">
    <div class="">
        <header class="col-md-12 px-0">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark pt-0 pb-0">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a type="button" class="nav-link" id="but_ayuda">Ayuda</a>
                        </li>
                    </ul>
                    <div class="login-on">
                        <ul class="navbar-nav mrauto">
                            <li class="nav-item dropdown">
                                <div class="nav-link">Name</div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="#">Salir</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    </div>
    <div class="">
        <header class="col-md-12 px-0">
            <nav class="navbar navbar-expand-lg navbar-dark bg-gray pt-0 pb-0">

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <div class="font-weight-bold subt navbar-brand">Aula Virtual</div>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="/">Mis Datos</a>
                        </li>
                        <li class="nav-item pt-3 active">
                            <a class="nav-link" href="/seccion">Mis Secciones</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <!--Marco blanco...-->
    <div class="main-border">
        <div class="row">
            <div class="col-12">
                <div class="form-row mb-3">
                    <div class="col-3">
                        <h3 class="mb-1">Secciones</h3>
                        <input class="form-control" type="text" name="seccion" />
                    </div>
                    <div class="px-2">
                        <h3 class="mb-1">&nbsp</h3>
                        <a class="btn btn-success" type="submit"><svg width="2em" height="1.5em" viewBox="0 0 16 16"
                                class="bi bi-search" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                    d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
                                <path fill-rule="evenodd"
                                    d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
                            </svg>Ver Alumnos</a>
                    </div>
                </div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">AnyDesk-Credencial</th>
                            <th scope="col">TeamViewer-Usuario</th>
                            <th scope="col">TeamViewer-Contraseña</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td scope="row">2020001</td>
                            <td>Jenni Iris Alabone Radbornejenni</td>
                            <td>123 123 123</td>
                            <td>123 123 123</td>
                            <td>NL82Hh</td>
                            <td class="pl-4 ope-td"><a href="#"><svg width="1.5em" height="1.5em" stroke="black" viewBox="0 0 16 16"
                                        class="bi bi-arrow-repeat" fill="currentColor"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z" />
                                        <path fill-rule="evenodd"
                                            d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z" />
                                    </svg></a></td>
                        </tr>
                    </tbody>
                </table>
                <div class="row">
                    <!--ultima linea-->
                    <div class="col text-right">
                        paginacion
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="m-3">
        <p class="text-right font-weight-bold text-muted pr-2">Universidad de Lima 2020-II</p>
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
                            <img class="w-100 h-100" src="/images/spidy.jpeg">
                        </div>
                        <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Andy Lazo</div>
                        <div class="col-3">
                            <img class="w-100 h-100" src="/images/spidy.jpeg">
                        </div>
                        <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Gabriel Carmelo</div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-3">
                            <img class="w-100 h-100" src="/images/spidy.jpeg">
                        </div>
                        <div class="col-3 modal-dialog modal-dialog-centered font-weight-bold">Dante Córdova</div>
                        <div class="col-3">
                            <img class="w-100 h-100" src="/images/spidy.jpeg">
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