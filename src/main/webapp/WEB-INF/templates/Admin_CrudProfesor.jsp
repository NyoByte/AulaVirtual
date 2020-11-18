<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud Profesor</title>
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
                                <a class="nav-link" href="#">Name</a>
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
    <div class="main-border">
        <div class="row">
            <div class="col-9">
                <div>
                    <p class="font-weight-bold">Datos del Nuevo Profesor</p>
                </div>
                <div class="form-row mb-3">
                    <div class="col-auto">
                        <p class="mb-1">Codigo</p>
                        <input class="form-control" type="text" name="codigo" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">Nombres</p>
                        <input class="form-control" type="text" name="nombres" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">Apellidos</p>
                        <input class="form-control" type="text" name="apellidos" />
                    </div>
                </div>
                <div class="form-row mb-3">
                    <div class="col-auto">
                        <p class="mb-1">Correo de la Universidad</p>
                        <input class="form-control" type="text" name="correo_univ" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">Correo Personal</p>
                        <input class="form-control" type="text" name="correo_personal" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">Género</p>
                        <select class="form-control" id="carrera">
                            <option>Masculino</option>
                            <option>Femenino</option>
                        </select>
                    </div>
                </div>
                <div class="form-row mb-3">
                    <div class="col-auto">
                        <p class="mb-1">País</p>
                        <input class="form-control" type="text" name="país" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">Tipo de Docente</p>
                        <select class="form-control">
                            <option></option>

                        </select>
                    </div>
                </div>
                <div class="form-row mb-0 pl-5">
                    <div class="form-row m-2">
                        <div class="px-2">
                            <p class="mb-1">&nbsp</p>
                            <a class="btn btn-primary" type="submit"><svg width="2em" height="2em" viewBox="0 0 16 16"
                                    class="bi bi-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z" />
                                </svg>Actualizar Datos</a>
                        </div>
                        <div class="px-2">
                            <p class="mb-1">&nbsp</p>
                            <a class="btn btn-success" type="submit"><svg width="2em" height="1.5em" viewBox="0 0 16 16"
                                    class="bi bi-file-earmark-code" fill="currentColor"
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
                            <a class="btn btn-warning" type="submit"><svg width="2em" height="1.5em" viewBox="0 0 16 16"
                                    class="bi bi-cloud-arrow-up-fill" fill="currentColor"
                                    xmlns="http://www.w3.org/2000/svg">
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
    <div class="m-3">
        <p class="text-right font-weight-bold text-muted pr-2">Universidad de Lima 2020-II</p>
    </div>

    <script src="/js/index.js"></script>

</body>

</html>