<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AulaVirtual-Profesor-Secciones</title>
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
                                <div class="nav-link">${profesor.first_name} ${profesor.last_name}</div>
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
                        <select class="form-control" name="seccion" id="seccion_combo">
                            <option value="0">Choose...</option>
                            <c:forEach var="seccion" items="${listaSecciones}">
                                <option value="${seccion.id}">${seccion.cod}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="px-2">
                        <h3 class="mb-1">&nbsp</h3>
                        <a class="btn btn-success" id="boton_buscar"><svg width="2em" height="1.5em" viewBox="0 0 16 16"
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
                        <c:forEach var="alumno" items="${listaAlumnos}">
                            <tr>
                                <td scope="row">${alumno.cod}</td>
                                <td>${alumno.first_name} ${alumno.last_name}</td>
                                <td>${alumno.ad_cred}</td>
                                <td>${alumno.tv_user}</td>
                                <td>${alumno.tv_pw}</td>
                                <td class="pl-4 ope-td"><a href="/seccion?seccion_id=${seccionBuscada}"><svg width="1.5em" height="1.5em"
                                            stroke="black" viewBox="0 0 16 16" class="bi bi-arrow-repeat"
                                            fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z" />
                                            <path fill-rule="evenodd"
                                                d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z" />
                                        </svg></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="row justify-content-between">
                    <!--ultima linea-->
                    <div class="col"></div>
                    <div class="col-3">
                        <div class="row justify-content-around">
                            <c:if test="${pagActual>0}">
                                <a href="?page=0" id="boton_primera_pag">
                                    <svg width="1em" height="1em" stroke="black" viewBox="0 0 16 16"
                                        class="bi bi-chevron-double-left" fill="currentColor"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
                                        <path fill-rule="evenodd"
                                            d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
                                    </svg>
                                </a>
                                <a href="?page=${pagActual-1}" id="boton_pag_anterior">
                                    <svg width="1em" height="1em" stroke="black" viewBox="0 0 16 16"
                                        class="bi bi-chevron-left" fill="currentColor"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z" />
                                    </svg>
                                </a>
                            </c:if>

                            <p class="font-weight-bold">${pagActual+1}/${numPaginas}</p>

                            <c:if test="${pagActual<numPaginas-1}">
                                <a href="?page=${pagActual+1}" type="button" id="boton_sgte_pag">
                                    <svg width="1em" height="1em" stroke="black" viewBox="0 0 16 16"
                                        class="bi bi-chevron-right" fill="currentColor"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z" />
                                    </svg>
                                </a>
                                <a href="?page=${numPaginas-1}" id="boton_ultima_pag">
                                    <svg width="1em" height="1em" stroke="black" viewBox="0 0 16 16"
                                        class="bi bi-chevron-double-right" fill="currentColor"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z" />
                                        <path fill-rule="evenodd"
                                            d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z" />
                                    </svg>
                                </a>
                            </c:if>
                        </div>
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
    <script src="/js/profesor_seccion.js"></script>
</body>

</html>