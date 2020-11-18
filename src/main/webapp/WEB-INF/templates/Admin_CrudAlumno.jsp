<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud Alumnos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/index.css" >
</head>

<body class="fondo">
    <div class="">
        <header class="col-md-12 px-0">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark pt-0 pb-0">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Inicio</a>
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
                            <a class="nav-link" href="#">Profesores</a>
                        </li>
                        <li class="nav-item pt-3 active">
                            <a class="nav-link" href="#">Alumnos</a>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="#">Cursos</a>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="#">Secciones</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <!--Marco blanco...-->
    <c:choose>
        <c:when test="${alumno==null}">
            <form action="/aula_virtual/administrador/alumnos/guardar" method="post">
                <div class="main-border">
                    <div class="row">
                        <div class="col-9">
                            <div>
                                <p class="font-weight-bold">Datos del Nuevo Alumno</p>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Código</p>
                                    <input class="form-control" type="text" name="cod" value="2020546" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Nombres</p>
                                    <input class="form-control" type="text" name="first_name" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Apellidos</p>
                                    <input class="form-control" type="text" name="last_name" />
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Correo de la Universidad</p>
                                    <input class="form-control" type="text" name="email_univ" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Correo Personal</p>
                                    <input class="form-control" type="text" name="email_priv" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Género</p>
                                    <select class="form-control" name="gender">
                                        <option>Masculino</option>
                                        <option>Femenino</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">País</p>
                                    <input class="form-control" type="text" name="pais" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Usuario</p>
                                    <input class="form-control" type="text" name="TV_user" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Contraseña</p>
                                    <input class="form-control" type="text" name="TV_pw" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">AnyDesk Credencial</p>
                                    <input class="form-control" type="text" name="AD_cred" />
                                </div>
                            </div>
                            <div class="form-row mb-0">
                                <div class="col">
                                    <p class="mb-1">Carrera</p>
                                    <select class="form-control" name="career">
                                        <option>Ingenieria</option>
                                        <option>Contabilidad</option>
                                    </select>
                                </div>
                                <div class="form-row m-0">
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-primary" type="submit"><svg width="1.5em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-check2" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</a>
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-success" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-file-earmark-code" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path
                                                    d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                                <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                                <path fill-rule="evenodd"
                                                    d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                            </svg>Seleccionar Foto</a>
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-warning" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-cloud-arrow-up-fill"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 5.146l-2-2a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L7.5 6.707V10.5a.5.5 0 0 0 1 0V6.707l1.146 1.147a.5.5 0 0 0 .708-.708z" />
                                            </svg>Subir</a>
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
        </c:when>
        <c:otherwise>
            <form action="/aula_virtual/administrador/alumnos/actualizar" method="post">
                <div class="main-border">
                    <div class="row">
                        <div class="col-9">
                            <div>
                                <p class="font-weight-bold">Datos del Nuevo Alumno</p>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Codigo</p>
                                    <input class="form-control" type="text" name="cod" value="${alumno.cod}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Nombres</p>
                                    <input class="form-control" type="text" name="first_name"
                                        value="${alumno.first_name}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Apellidos</p>
                                    <input class="form-control" type="text" name="last_name"
                                        value="${alumno.last_name}" />
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Correo de la Universidad</p>
                                    <input class="form-control" type="text" name="email_univ"
                                        value="${alumno.email_univ}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Correo Personal</p>
                                    <input class="form-control" type="text" name="email_priv"
                                        value="${alumno.email_priv}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Género</p>
                                    <select class="form-control" name="gender" value="">
                                        <option value="">----Seleccionar una género-----</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">País</p>
                                    <input class="form-control" type="text" name="pais" value="${alumno.pais}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Usuario</p>
                                    <input class="form-control" type="text" name="TV_user" value="${alumno.TV_user}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Contraseña</p>
                                    <input class="form-control" type="text" name="TV_pw" value="${alumno.TV_pw}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">AnyDesk Credencial</p>
                                    <input class="form-control" type="text" name="AD_cred" value="${alumno.AD_cred}" />
                                </div>
                            </div>
                            <div class="form-row mb-0">
                                <div class="col">
                                    <p class="mb-1">Carrera</p>
                                    <select class="form-control" name="career" value="">
                                        <option value="">----Seleccionar una carrera-----</option>
                                    </select>
                                </div>
                                <div class="form-row m-0">
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-primary" type="submit"><svg width="1.5em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-check2" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</a>
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-success" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-file-earmark-code" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path
                                                    d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                                <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                                <path fill-rule="evenodd"
                                                    d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                            </svg>Seleccionar Foto</a>
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-warning" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-cloud-arrow-up-fill"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 5.146l-2-2a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L7.5 6.707V10.5a.5.5 0 0 0 1 0V6.707l1.146 1.147a.5.5 0 0 0 .708-.708z" />
                                            </svg>Subir</a>
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
        </c:otherwise>
    </c:choose>
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
    <script src="index.js"></script>

</body>

</html>