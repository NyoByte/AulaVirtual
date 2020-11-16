<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud Alumnos</title>
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
                    <p class="font-weight-bold">Datos del Nuevo Alumno</p>
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
                        <p class="mb-1">TeamViewer Usuario</p>
                        <input class="form-control" type="text" name="TW_user" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">TeamViewer Contraseña</p>
                        <input class="form-control" type="text" name="TW_pw" />
                    </div>
                    <div class="col-auto">
                        <p class="mb-1">AnyDesk Credencial</p>
                        <input class="form-control" type="text" name="AD_cred" />
                    </div>
                </div>
                <div class="form-row mb-0">
                    <div class="col-auto">
                        <p class="mb-1">Carrera</p>
                        <select class="form-control">
                            <option>Ingenieria</option>
                            <option>Contabilidad</option>
                        </select>
                    </div>
                    <div class="form-row m-0">
                        <div class="col-auto">
                            <label>&nbsp</label>
                            <button class="form-control btn btn-primary" type="submit">Actualizar</button>
                        </div>
                        <div class="col-auto">
                            <label>&nbsp</label>
                            <button class="form-control btn btn-success" type="submit">Seleccionar</button>
                        </div>
                        <div class="col-auto">
                            <label>&nbsp</label>
                            <button class="form-control btn btn-warning" type="submit">Subir</button>
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

    <!-- Modal -->
    <div class="modal fade" id="modalInstrucciones" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="myModalLabel">Integrantes del Grupo:</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row row-cols-1 row-cols-md-2">
                        <div class="card mb-3" style="max-width: 540px;">
                            <div class="row no-gutters">
                                <div class="col-md-4">
                                    <img src="..." class="card-img" alt="...">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">Integrante 1</h5>
                                        <p class="card-text">descripcion</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-3" style="max-width: 540px;">
                            <div class="row no-gutters">
                                <div class="col-md-4">
                                    <img src="..." class="card-img" alt="...">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">Integrante 2</h5>
                                        <p class="card-text">descripcion</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col mb-4">
                            <div class="card">
                                <img src="..." class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a longer card with supporting text below as a natural
                                        lead-in to additional content.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col mb-4">
                            <div class="card">
                                <img src="..." class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">This is a longer card with supporting text below as a natural
                                        lead-in to additional content. This content is a little bit longer.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/js/index.js"></script>

</body>

</html>