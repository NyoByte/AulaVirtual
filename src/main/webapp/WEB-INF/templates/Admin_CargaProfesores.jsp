<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>

<body class="fondo">
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
    <div class="row">
        <div>
            <!--Marco blanco...-->
            <div class="col-auto">
                <div>
                    <p>Datos del Nuevo Profesor</p>
                </div>
                <div class="row">
                    <div class="col-auto">
                        <p>Codigo</p>
                        <input class="d-block" type="text" name="codigo" id="" />
                    </div>
                    <div class="col-auto">
                        <p>Nombre</p>
                        <input class="d-block" type="text" name="codigo" id="" />
                    </div>
                    <div class="col-auto">
                        <label>&nbsp</label>
                        <button class="d-block btn btn-success" type="submit">Buscar</button>
                    </div>
                    <div class="col-auto">
                        <label>Carga Masiva</label>
                        <button class="d-block btn btn-primary" type="submit">Seleccionar Archivo</button>
                    </div>
                    <div class="col-auto">
                        <label>&nbsp</label>
                        <button class="d-block btn btn-warning" type="submit">Subir</button>
                    </div>

                </div>
                <table class="table">
                    <thead>
                        <th scope="col">Código</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Género</th>
                        <th scope="col">Operaciones</th>
                    </thead>
                    <tbody id="">
                        <tr>
                            <td scope="row">2020001</td>
                            <td>Jenni Iris Alabone Radbornejenni</td>
                            <td>Profesor</td>
                            <td>Female</td>
                            <td>A B</td>
                        </tr>
                        <tr>
                            <td scope="row">2020001</td>
                            <td>Jenni Iris Alabone Radbornejenni</td>
                            <td>Profesor</td>
                            <td>Female</td>
                            <td>A B</td>
                        </tr>
                        <tr>
                            <td scope="row">2020001</td>
                            <td>Jenni Iris Alabone Radbornejenni</td>
                            <td>Profesor</td>
                            <td>Female</td>
                            <td>A B</td>
                        </tr>
                    </tbody>
                </table>
                <div class="row">
                    <!--ultima linea-->
                    <div class="col">
                        boton
                    </div>
                    <div class="col">
                        paginacion
                    </div>
                </div>
            </div>
            <div>
                pie de página
            </div>
</body>

</html>