<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AulaVirtual-Alumno</title>
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
                                <div class="nav-link">${alumno.first_name} ${alumno.last_name}</div>
                            </li>
                            <li class="nav-item dropdown">
                                <form action="/login/saliendo" method="POST">
                                    <button class="nav-link btn btn-link" type="submit">Salir</button>
                                </form>
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
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <!--Marco blanco...-->
    <form action="/alumno/update" method="post">
        <div class="main-border">
            <div class="row">
                <div class="col-9">
                    <div>
                        <p class="font-weight-bold">Datos del Alumno</p>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col">
                            <p class="mb-1">Código</p>
                            <input class="form-control" type="number" name="cod" value="${alumno.cod}"
                                readonly="true" />
                        </div>
                        <div class="col">
                            <p class="mb-1">Nombres</p>
                            <input class="form-control" type="text" name="first_name" value="${alumno.first_name}"
                                readonly="true" />
                        </div>
                        <div class="col">
                            <p class="mb-1">Apellidos</p>
                            <input class="form-control" type="text" name="last_name" value="${alumno.last_name}"
                                readonly="true" />
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col">
                            <p class="mb-1">Correo de la Universidad</p>
                            <input class="form-control" type="text" name="email_univ" value="${alumno.email_univ}"
                                readonly="true" />
                        </div>
                        <div class="col">
                            <p class="mb-1">Correo Personal</p>
                            <input class="form-control" type="text" name="email_priv"
                                value="${alumno.email_priv}" required/>
                        </div>
                        <div class="col">
                            <p class="mb-1">Género</p>
                            <input class="form-control" type="text" name="gender" value="${alumno.gender.name}" readonly="true" />
                        </div>
                    </div>
                    <div class="form-row mb-3">
                        <div class="col">
                            <p class="mb-1">País</p>
                            <input class="form-control" type="text" name="pais" value="${alumno.pais.name}" readonly="true" />
                        </div>
                        <div class="col">
                            <p class="mb-1">TeamViewer Usuario</p>
                            <input class="form-control" type="text" name="tv_user" value="${alumno.tv_user}" required/>
                        </div>
                        <div class="col">
                            <p class="mb-1">TeamViewer Contraseña</p>
                            <input class="form-control" type="text" name="tv_pw" value="${alumno.tv_pw}" required/>
                        </div>
                        <div class="col">
                            <p class="mb-1">AnyDesk Credencial</p>
                            <input class="form-control" type="text" name="ad_cred" value="${alumno.ad_cred}" required/>
                        </div>
                    </div>
                    <div class="form-row mb-0">
                        <div class="col">
                            <p class="mb-1">Carrera</p>
                            <input class="form-control" type="text" name="career" value="${alumno.career.name}" readonly="true"/>
                        </div>
                        <div class="col">
                            <div class="px-2">
                                <p class="mb-1">&nbsp</p>
                                <button class="btn btn-primary float-right" type="submit"><svg
                                        width="1.5em" height="1.5em" stroke="white" viewBox="0 0 16 16"
                                        class="bi bi-check2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                    </svg>Actualizar Datos</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <img class="img-fluid" alt="Imagen responsive" src="/images/default_profile_image.jpg">
                </div>
            </div>
        </div>
    </form>
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