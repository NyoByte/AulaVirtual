<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alumnos-Editar</title>
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
                        <li class="nav-item pt-3 active">
                            <a class="nav-link" href="/alumno">Alumnos</a>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="/curso">Cursos</a>
                        </li>
                        <li class="nav-item pt-3">
                            <a class="nav-link" href="/seccion">Secciones</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <!--Marco blanco...-->
    <c:choose>
        <c:when test="${alumno==null}">
            <form action="/alumno/guardar" method="post" enctype="multipart/form-data">
                <div class="main-border">
                    <div class="row">
                        <div class="col-9">
                            <div>
                                <p class="font-weight-bold">
                                <h2>Datos del Nuevo Alumno</h2>
                                </p>
                            </div>
                            <input class="invisible" name="id" value="0" readonly="true" />
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Código</p>
                                    <input class="form-control" type="number" min="10000000" max="99999999" name="cod"
                                        required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Nombres</p>
                                    <input class="form-control" type="text" maxlength="50" name="first_name" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Apellidos</p>
                                    <input class="form-control" type="text" maxlength="50" name="last_name" required />
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Correo de la Universidad</p>
                                    <input class="form-control" type="email" maxlength="50" name="email_univ" required
                                        pattern="[1-9]{1}[0-9]{7}@aloe.ulima.edu.pe" title="example: 12345678@aloe.edu.pe" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Correo Personal</p>
                                    <input class="form-control" type="email" maxlength="50" name="email_priv"
                                        required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Género</p>
                                    <select class="form-control" name="gender" required>
                                        <option value="">Choose...</option>
                                        <c:forEach var="genero" items="${listaGeneros}">
                                            <option value="${genero.id}">${genero.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">País</p>
                                    <select class="form-control" type="text" name="pais" required />
                                    <option value="">Choose...</option>
                                    <c:forEach var="pais" items="${listaPaises}">
                                        <option value="${pais.id}">${pais.name}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Usuario</p>
                                    <input class="form-control" type="text" maxlength="9" name="tv_user" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Contraseña</p>
                                    <input class="form-control" type="text" maxlength="9" name="tv_pw" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">AnyDesk Credencial</p>
                                    <input class="form-control" type="text" maxlength="6" name="ad_cred" required />
                                </div>
                            </div>
                            <div class="form-row mb-0">
                                <div class="col">
                                    <p class="mb-1">Carrera</p>
                                    <select class="form-control" name="career" required>
                                        <option value="">Choose...</option>
                                        <c:forEach var="carrera" items="${listaCarreras}">
                                            <option value="${carrera.id}">${carrera.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-row m-0">
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <button class="btn btn-primary" type="submit"><svg width="1.5em" height="1.5em"
                                                stroke="white" viewBox="0 0 16 16" class="bi bi-check2"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</button>
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <button class="btn btn-success" id="boton_selec_foto" type="button"><svg
                                                width="2em" height="1.5em" viewBox="0 0 16 16"
                                                class="bi bi-file-earmark-code" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path
                                                    d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                                <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                                <path fill-rule="evenodd"
                                                    d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                            </svg>Seleccionar Foto</button>
                                        <input type="file" id="input_foto"
                                            onchange="handleIMG(this.files), previewImage(event)" accept="image/*"
                                            style="display: none" name="image">
                                    </div>
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <button class="btn btn-warning" id="boton_subir" type="submit"><svg width="2em"
                                                height="1.5em" viewBox="0 0 16 16" class="bi bi-cloud-arrow-up-fill"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 5.146l-2-2a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L7.5 6.707V10.5a.5.5 0 0 0 1 0V6.707l1.146 1.147a.5.5 0 0 0 .708-.708z" />
                                            </svg>Subir</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <c:if test="${imagenBase64!=null}">
                                <img class="img-fluid" id="image-field" src="data:image/jpeg;base64,${imagenBase64}">
                            </c:if>
                            <c:if test="${imagenBase64==null}">
                                <img class="img-fluid" id="image-field" src="/profiles/default.jpg">
                            </c:if>
                        </div>
                    </div>
                </div>
            </form>
        </c:when>
        <c:otherwise>
            <form action="/alumno/guardar" method="post" enctype="multipart/form-data">
                <div class="main-border">
                    <div class="row">
                        <div class="col-9">
                            <div>
                                <p class="font-weight-bold">Datos del Nuevo Alumno</p>
                            </div>
                            <input class="invisible" name="id" value="${alumno.id}" readonly="true" />
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Código</p>
                                    <input class="form-control" type="number" min="10000000" max="99999999" name="cod"
                                        value="${alumno.cod}" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Nombres</p>
                                    <input class="form-control" type="text" maxlength="50" name="first_name"
                                        value="${alumno.first_name}" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Apellidos</p>
                                    <input class="form-control" type="text" maxlength="50" name="last_name"
                                        value="${alumno.last_name}" required />
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">Correo de la Universidad</p>
                                    <input class="form-control" type="email" maxlength="50" name="email_univ"
                                        value="${alumno.email_univ}" required
                                        pattern="[1-9]{1}[0-9]{7}@aloe.ulima.edu.pe" title="example: 12345678@aloe.edu.pe" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Correo Personal</p>
                                    <input class="form-control" type="email" maxlength="50" name="email_priv"
                                        value="${alumno.email_priv}" />
                                </div>
                                <div class="col">
                                    <p class="mb-1">Género</p>
                                    <select class="form-control" name="gender" required>
                                        <option value="${alumno.gender.id}">${alumno.gender.name}</option>
                                        <c:forEach var="genero" items="${listaGeneros}">
                                            <c:if test="${genero.id != alumno.gender.id}">
                                                <option value="${genero.id}">${genero.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row mb-3">
                                <div class="col">
                                    <p class="mb-1">País</p>
                                    <select class="form-control" name="pais" required>
                                        <option value="${alumno.pais.id}">${alumno.pais.name}</option>
                                        <c:forEach var="pais" items="${listaPaises}">
                                            <c:if test="${pais.id != alumno.pais.id}">
                                                <option value="${pais.id}">${pais.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Usuario</p>
                                    <input class="form-control" type="text" name="tv_user" maxlength="9"
                                        value="${alumno.tv_user}" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">TeamViewer Contraseña</p>
                                    <input class="form-control" type="text" name="tv_pw" maxlength="9"
                                        value="${alumno.tv_pw}" required />
                                </div>
                                <div class="col">
                                    <p class="mb-1">AnyDesk Credencial</p>
                                    <input class="form-control" type="text" name="ad_cred" maxlength="6"
                                        value="${alumno.ad_cred}" required />
                                </div>
                            </div>
                            <div class="form-row mb-0">
                                <div class="col">
                                    <p class="mb-1">Carrera</p>
                                    <select class="form-control" name="career" value="" required>
                                        <option value="${alumno.career.id}">${alumno.career.name}</option>
                                        <c:forEach var="carrera" items="${listaCarreras}">
                                            <c:if test="${carrera.id != alumno.career.id}">
                                                <option value="${carrera.id}">${carrera.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-row m-0">
                                    <div class="px-2">
                                        <p class="mb-1">&nbsp</p>
                                        <button class="btn btn-primary" type="submit"><svg width="1.5em" height="1.5em"
                                                viewBox="0 0 16 16" class="bi bi-check2" fill="currentColor"
                                                xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd"
                                                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
                                            </svg>Actualizar Datos</button>
                                    </div>
                                    <form action="/upload" method="post" enctype="multipart/form-data">
                                        <div class="px-2">
                                            <p class="mb-1">&nbsp</p>
                                            <button class="btn btn-success" id="boton_selec_foto" type="button"><svg
                                                    width="2em" height="1.5em" viewBox="0 0 16 16"
                                                    class="bi bi-file-earmark-code" fill="currentColor"
                                                    xmlns="http://www.w3.org/2000/svg">
                                                    <path
                                                        d="M4 0h5.5v1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h1V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z" />
                                                    <path d="M9.5 3V0L14 4.5h-3A1.5 1.5 0 0 1 9.5 3z" />
                                                    <path fill-rule="evenodd"
                                                        d="M8.646 6.646a.5.5 0 0 1 .708 0l2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 9 8.646 7.354a.5.5 0 0 1 0-.708zm-1.292 0a.5.5 0 0 0-.708 0l-2 2a.5.5 0 0 0 0 .708l2 2a.5.5 0 0 0 .708-.708L5.707 9l1.647-1.646a.5.5 0 0 0 0-.708z" />
                                                </svg>Seleccionar Foto</button>
                                            <input type="file" name="image" id="input_foto"
                                                onchange="handleIMG(this.files), previewImage(event)" accept="image/*"
                                                style="display: none">

                                        </div>
                                        <div class="px-2">
                                            <p class="mb-1">&nbsp</p>
                                            <button class="btn btn-warning" type="submit" value="Cargar"><svg
                                                    width="2em" height="1.5em" viewBox="0 0 16 16"
                                                    class="bi bi-cloud-arrow-up-fill" fill="currentColor"
                                                    xmlns="http://www.w3.org/2000/svg">
                                                    <path fill-rule="evenodd"
                                                        d="M8 2a5.53 5.53 0 0 0-3.594 1.342c-.766.66-1.321 1.52-1.464 2.383C1.266 6.095 0 7.555 0 9.318 0 11.366 1.708 13 3.781 13h8.906C14.502 13 16 11.57 16 9.773c0-1.636-1.242-2.969-2.834-3.194C12.923 3.999 10.69 2 8 2zm2.354 5.146l-2-2a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L7.5 6.707V10.5a.5.5 0 0 0 1 0V6.707l1.146 1.147a.5.5 0 0 0 .708-.708z" />
                                                </svg>Subir</button>

                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>
                        <div class="col-3">
                            <c:if test="${imagenBase64!=null}">
                                <img class="img-fluid" id="image-field" src="data:image/jpeg;base64,${imagenBase64}">
                            </c:if>
                            <c:if test="${imagenBase64==null}">
                                <img class="img-fluid" id="image-field" src="/profiles/default.jpg">
                            </c:if>
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
    <script src="/js/SeleccionarFoto.js"></script>
    <script src="/js/SubirFoto.js"></script>
</body>

</html>