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
    <c:choose>
        <c:when test="${seccion==null}">

            <div class="main-border">
                <div class="row">
                    <form action="/seccion/guardar" method="post">
                        <div class="col-auto">
                            <div>
                                <div>
                                    <p class="font-weight-bold">
                                    <h3>Datos de la Nueva Sección</h3>
                                    </p>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col-auto">
                                        <p class="mb-1">Código</p>
                                        <input class="form-control" type="number" min="1" max="999999999" name="cod" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Curso</p>
                                        <select class="form-control" name="course">
                                            <c:forEach var="curso" items="${listaCursos}">
                                                <option value="${curso.id}">${curso.name}</option>
                                            </c:forEach>
                                        </select>
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
                                        <input id="codigoProfesorT1" class="form-control" type="number" min="1"
                                            max="999999999" readonly="true" value="" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Nombre</p>
                                        <select class="form-control" oninput="OnSelectProfesorT1()"
                                            id="profesorT1Seleccionado" name="profesorT1_name" required="true">
                                            <option value="0">Choose...</option>
                                            <c:forEach var="profesor" items="${listaProfesoresT1}">
                                                <option value="${profesor.cod}">${profesor.first_name}
                                                    ${profesor.last_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div>
                                    <p class="font-weight-bold">
                                    <h3>Datos Jefe de Prácticas (Opcional)</h3>
                                    </p>
                                </div>
                                <div class="form-row mb-5">
                                    <div class="col">
                                        <p class="mb-1">Código</p>
                                        <input id="codigoProfesorT2" class="form-control" type="number" min="1"
                                            max="999999999" readonly="true"/>
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Nombre</p>
                                        <select class="form-control" oninput="OnSelectProfesorT2()"
                                            id="profesorT2Seleccionado" name="profesorT2_name">
                                            <option value="0">Choose...</option>
                                            <c:forEach var="profesor" items="${listaProfesoresT2}">
                                                <option value="${profesor.cod}">${profesor.first_name}
                                                    ${profesor.last_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <button class="btn btn-primary float-left" type="submit"><svg width="1.5em"
                                                height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

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
                                    <button class="btn btn-primary" type="button"><svg width="2em" height="1.5em"
                                            viewBox="0 0 16 16" class="bi bi-file-earmark-code" fill="currentColor"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                            <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                            <path fill-rule="evenodd"
                                                d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                        </svg>Seleccionar Archivo</button>
                                </div>
                                <div class="px-2">
                                    <p class="mb-1">&nbsp</p>
                                    <form>
                                        <button class="btn btn-warning" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-cloud-arrow-up-fill"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 5.146l-2-2a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L7.5 6.707V10.5a.5.5 0 0 0 1 0V6.707l1.146 1.147a.5.5 0 0 0 .708-.708z" />
                                            </svg>Subir</button>
                                    </form>
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
                                    <th scope="col">Operaciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td scope="row"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td id="boton_borrar" class="pl-4 ope-td">
                                        <form action="/#" method="POST"><button class="btn btn-link p-0 border-0"
                                                type="submit" onclick="return confirm('¿Está seguro de eliminar?')"><svg
                                                    width="1.5em" height="1.5em" stroke="black" viewBox="0 0 16 16"
                                                    class="bi bi-x" fill="currentColor"
                                                    xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd"
                                                        d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                                </svg></button></form>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="row justify-content-between">
                            <!--ultima linea-->
                            <div class="col">
                                <a class="btn btn-primary float-left" type="submit"><svg width="1.5em" height="1.5em"
                                        stroke="white" viewBox="0 0 16 16" class="bi bi-check2" fill="currentColor"
                                        xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                    </svg>Actualizar Datos</a>
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
        </c:when>
        <c:otherwise>
            <form action="/seccion/guardar" method="POST">
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
                                    <div class="col-auto">
                                        <p class="mb-1">Código</p>
                                        <input class="form-control" type="number" min="1" max="999999999" name="cod"
                                            value="${seccion.cod}" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Curso</p>
                                        <select class="form-control" name="course">
                                            <option value="${seccion.course.id}">${seccion.course.name}</option>
                                            <c:forEach var="curso" items="${listaCursos}">
                                                <c:if test="${curso.id != seccion.course.id}">
                                                    <option value="${curso.id}">${curso.name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
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
                                        <input class="form-control" type="number" min="1" max="999999999" name="cod"
                                            id="codigoProfesorT1" value="${profesorSeleccionadoT1.cod}"
                                            readonly="true" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Nombre</p>
                                        <select class="form-control" oninput="OnSelectProfesorT1()"
                                            id="profesorT1Seleccionado" name="profesorT1_name">
                                            <c:choose>
                                                <c:when test="${profesorSeleccionadoT1 != null}">
                                                    <option value="${profesorSeleccionadoT1.cod}">
                                                        ${profesorSeleccionadoT1.first_name}
                                                        ${profesorSeleccionadoT1.last_name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>Choose...</option>
                                                </c:otherwise>
                                            </c:choose>
                                            <c:forEach var="profesor" items="${listaProfesoresT1}">
                                                <c:if test="${profesor.id != profesorSeleccionadoT1.id}">
                                                    <option value="${profesor.cod}">${profesor.first_name}
                                                        ${profesor.last_name}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div>
                                    <p class="font-weight-bold">
                                    <h3>Datos Jefe de Prácticas (Opcional)</h3>
                                    </p>
                                </div>
                                <div class="form-row mb-5">
                                    <div class="col">
                                        <p class="mb-1">Código</p>
                                        <input class="form-control" type="number" min="1" max="999999999" name="cod"
                                            id="codigoProfesorT2" value="${profesorSeleccionadoT2.cod}"
                                            readonly="true" />
                                    </div>
                                    <div class="col">
                                        <p class="mb-1">Nombre</p>
                                        <select class="form-control" oninput="OnSelectProfesorT2()"
                                            id="profesorT2Seleccionado" name="profesorT2_name">
                                            <c:choose>
                                                <c:when test="${profesorSeleccionadoT2 != null}">
                                                    <option value="${profesorSeleccionadoT2.cod}">
                                                        ${profesorSeleccionadoT2.first_name}
                                                        ${profesorSeleccionadoT2.last_name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option>Choose...</option>
                                                </c:otherwise>
                                            </c:choose>
                                            <c:forEach var="profesor" items="${listaProfesoresT2}">
                                                <c:if test="${profesor.id != profesorSeleccionadoT2.id}">
                                                    <option value="${profesor.cod}">${profesor.first_name}
                                                        ${profesor.last_name}
                                                    </option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row mb-3">
                                    <div class="col">
                                        <a class="btn btn-primary float-left" type="submit"><svg width="1.5em"
                                                height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
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
                                        <button class="btn btn-primary" type="button"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-file-earmark-code" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path
                                                    d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                                <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                                <path fill-rule="evenodd"
                                                    d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                            </svg>Seleccionar Archivo</button>
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <button class="btn btn-warning" type="submit"><svg width="2em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-cloud-arrow-up-fill"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 5.146l-2-2a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L7.5 6.707V10.5a.5.5 0 0 0 1 0V6.707l1.146 1.147a.5.5 0 0 0 .708-.708z" />
                                            </svg>Subir</button>
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
                                            <td id="boton_edit" class="pl-4 ope-td"><a
                                                    href="?edit=true&alumno_id=${alumno.id}"><svg width="1em"
                                                        height="1em" viewBox="0 0 16 16" class="bi bi-pencil-fill"
                                                        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd"
                                                            d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
                                                    </svg></a></td>
                                            <td id="boton_borrar" class="pl-4 ope-td">
                                                <form action="/alumno/eliminar/${alumno.id}" method="POST"><button
                                                        class="btn btn-link p-0 border-0" type="submit"
                                                        onclick="return confirm('¿Está seguro de eliminar?')"><svg
                                                            width="1.5em" height="1.5em" stroke="black"
                                                            viewBox="0 0 16 16" class="bi bi-x" fill="currentColor"
                                                            xmlns="http://www.w3.org/2000/svg">
                                                            <path fill-rule="evenodd"
                                                                d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                                        </svg></button></form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="row justify-content-between">
                                <!--ultima linea-->
                                <div class="col">
                                    <a class="btn btn-primary float-left" type="submit"><svg width="1.5em"
                                            height="1.5em" stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                            fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd"
                                                d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                        </svg>Actualizar Datos</a>
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