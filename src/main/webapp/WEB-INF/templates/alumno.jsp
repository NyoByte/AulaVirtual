<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/css/index.css">
    </head>
    <body class="container-fluid" style="background-color: beige">
    <div class="row">
        <header class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark pt-0 pb-0">
                <div class="collapse navbar-collapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Ayuda</a>
                        </li>
                    </ul>
                    <div class="login-off">
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
    <div class="row">
        <header class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <div class="font-weight-bold subt navbar-brand">Aula Virtual</div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Profesores</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Alumnos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Cursos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Secciones</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>

    <div class="row main-container">
        <div class="row">Datos del alumno</div>
        <div class="w-100"></div>
        <div class="col-9">
            <div class="row">
                <div class="col">Código</div>
                <div class="col">Nombres</div>
                <div class="col">Apellidos</div>
                <div class="w-100"></div>
                <div class="col">
                    <input type="text" disabled>
                </div>
                <div class="col">
                    <input type="text" disabled>
                </div>
                <div class="col">
                    <input type="text" disabled>
                </div>
                <div class="w-100"></div>
                <div class="col">Correo de la universidad</div>
                <div class="col">Correo personal</div>
                <div class="col">Género</div>
                <div class="w-100"></div>
                <div class="col">
                    <select disabled name="" id="" class="form-control"></select>
                </div>
                <div class="col">
                    <input type="text">
                </div>
                <div class="col">
                    <select disabled name="" id="" class="form-control"></select>
                </div>
                <div class="w-100"></div>
                <div class="col">País</div>
                <div class="col">Team Viewer User</div>
                <div class="col">TeamViewer Password</div>
                <div class="col">Anydesk Credentials</div>
                <div class="w-100"></div>
                <div class="col">
                    <select disabled name="" id="" class="form-control"></select>
                </div>
                <div class="col">
                    <input type="text">
                </div>
                <div class="col">
                    <input type="text">
                </div>
                <div class="col">
                    <input type="text">
                </div>
                <div class="w-100"></div>
                <div class="col">Carrera</div>
                <div class="w-100"></div>
                <div class="col-3">
                    <select disabled name="" id="" class="form-control"></select>
                </div>
                <div class="col-6"></div>
                <div class="col-3">
                    <button type="button" class="btn btn-primary">Actualizar datos</button>
                </div>
            </div>
        </div>
        <div class="col-3">
            <img class="img-fluid" alt="Imagen responsive" src="/images/default_profile_image.jpg">
        </div>
    </div>

    </body>
</html>