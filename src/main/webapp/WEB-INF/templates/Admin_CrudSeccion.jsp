<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Secciones-Editar</title>
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
                            <a class="nav-link" href="/profesor">Profesores</a>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="/alumno">Alumnos</a>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="/curso">Cursos</a>
                        </li>
                        <li class="nav-item pt-3 active">
                            <a class="nav-link" href="/seccion">Secciones</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <!--Marco blanco...-->
    <c:choose>
        <c:when test="${seccion==null}">
            <form action="/seccion/guardar" method="post">
                <div class="main-border">
                    <div class="row">
                        <div class="col-auto">
                            <div>
                                <div>
                                    <p class="font-weight-bold">
                                    <h3>Datos de la Nueva Sección</h3>
                                    </p>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <p class="mb-1">Código</p>
                                        <input class="form-control" type="text" name="codigo" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Curso</p>
                                        <select class="form-control" name="curso" value="">
                                            <option value="">----Seleccionar un curso-----</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <a class="btn btn-primary float-right" type="submit"><svg width="1.5em"
                                                height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</a>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div>
                                    <p class="font-weight-bold">
                                    <h3>Datos del Profesor</h3>
                                    </p>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <p class="mb-1">Código</p>
                                        <input class="form-control" type="text" name="codigo" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Nombre</p>
                                        <input class="form-control" type="text" name="nombre" />
                                    </div>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <a class="btn btn-primary float-right" type="submit"><svg width="1.5em"
                                                height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Registrar Profesor</a>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div>
                                    <p class="font-weight-bold">
                                    <h3>Datos Jefe de Prácticas (Opcional)</h3>
                                    </p>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <p class="mb-1">Código</p>
                                        <input class="form-control" type="text" name="codigo" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Nombre</p>
                                        <input class="form-control" type="text" name="nombre" />
                                    </div>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <a class="btn btn-primary float-left" type="submit"><svg width="1.5em"
                                                height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Registrar Jefe de Prácticas</a>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-danger float-right" type="submit"><svg width="1.5em"
                                                height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-x"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                            </svg>Actualizar Datos</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <p class="font-weight-bold">
                                <h3>Alumnos de la Sección</h3>
                                </p>
                            </div>
                            <div class="form-row mb-3">
                                <div class="btn-group col pl-3">
                                    <div class="px-2">
                                        <p class="mb-1">Carga Masiva</p>
                                        <a class="btn btn-primary" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-file-earmark-code" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path
                                                    d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                                <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                                <path fill-rule="evenodd"
                                                    d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                            </svg>Seleccionar Archivo</a>
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
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <a class="btn btn-primary" type="submit"><svg width="1.5em" height="1.5em"
                                                stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</a>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">Código</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Carrera</th>
                                        <th scope="col">Género</th>
                                        <th scope="col" colspan=2>Operaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="alumno" items="${listaAlumnos}">
                                        <tr>
                                            <td scope="row">${alumno.cod}</td>
                                            <td>${alumno.first_name} ${alumno.last_name}</td>
                                            <td>${alumno.career.name}</td>
                                            <td>${alumno.gender.name}</td>
                                            <td class="pl-4 ope-td"><a
                                                    href="/alumno?edit=true&alumno_id=${alumno.id}"><svg width="1em"
                                                        height="1em" viewBox="0 0 16 16" class="bi bi-pencil-fill"
                                                        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd"
                                                            d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
                                                    </svg></a></td>
                                            <td class="pl-4 ope-td"><a href="#"
                                                    onclick="return confirm('¿Está seguro de eliminar?')"><svg
                                                        width="2em" height="1.5em" stroke="black" viewBox="0 0 16 16"
                                                        class="bi bi-x" fill="currentColor"
                                                        xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd"
                                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                                    </svg></a></td>
                                        </tr>
                                    </c:forEach>
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
            </form>
        </c:when>
        <c:otherwise>
            <form action="/seccion/guardar" method="post"></form>
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
    <script src="/js/index.js"></script>
</body>

</html>