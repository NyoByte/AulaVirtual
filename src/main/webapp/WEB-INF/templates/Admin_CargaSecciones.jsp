<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AulaVirtual-Secciones</title>
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
                                <div class="nav-link">${administrador}</div>
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
    <div class="main-border">
        <div class="row">
            <div class="col-12">
                <div>
                    <p class="font-weight-bold">
                    <h2>Gestión de Secciones</h2>
                    </p>
                </div>

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Curso</th>
                            <th scope="col">Código de Curso</th>
                            <th scope="col">Carrera</th>
                            <th scope="col">Ciclo</th>
                            <th scope="col">Profesor</th>
                            <th scope="col">Jefe de Práctica</th>
                            <th scope="col" colspan=2>Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="seccion" items="${listaSecciones}">
                            <tr>
                                <td scope="row">${seccion.cod}</td>
                                <td>${seccion.course.name}</td>
                                <td>${seccion.course.cod}</td>
                                <td>${seccion.course.career.name}</td>
                                <td>${seccion.periodo.name}</td>
                                <td>${seccion.profesor[0].first_name} ${seccion.profesor[0].last_name}</td>
                                <td>${seccion.profesor[1].first_name} ${seccion.profesor[1].last_name}</td>
                                <td class="pl-4 ope-td"><a href="/seccion?edit=true&seccion_id=${seccion.id}"><svg
                                            width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-fill"
                                            fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd"
                                                d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
                                        </svg></a></td>
                                <td class="pl-4 ope-td">
                                    <form action="/seccion/eliminar/${seccion.id}" method="POST"><button
                                            class="btn btn-link p-0 border-0" type="submit"
                                            onclick="return confirm('¿Está seguro de eliminar?')"><svg width="1.5em"
                                                height="1.5em" stroke="black" viewBox="0 0 16 16" class="bi bi-x"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                            </svg></button></form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="row">
                    <!--ultima linea-->
                    <div class="col">
                        <a class="btn btn-primary" type="button" href="/seccion?edit=true"><svg width="2em" height="2em"
                                stroke="white" viewBox="0 0 16 16" class="bi bi-plus" fill="currentColor"
                                xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd"
                                    d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
                            </svg>Agregar Sección</a>
                    </div>
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