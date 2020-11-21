package com.example.demo.controllers;


import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AulaVirtualController {
    @Autowired
    private AlumnoRepository alumnoRep;

    // Si se sube a la nube "localhost:8080" -> "aula_virtual"

    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String mostrarInicio() {
        return "Inicio";
    }

    //LOGIN:
    // http://localhost:8080/login/{profesor/alumno/administrador}
    @RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
    public String mostrarLogin(@PathVariable String user){
        if(user.equalsIgnoreCase("profesor")){
            return "Login_Profesor";
        }else if(user.equalsIgnoreCase("alumno")){
            return "Login_Estudiante";
        }else{
            return "Login_Administrador";
        }
        /*NOTA: En este caso las 3 paginas son muy similares,
        asi que lo mas conveniente seria devolver un solo template y con el choose
        cambiar las partes necesarias para cada tipo de usuario. De momento lo dejo con if.*/
    }

    /*
    @RequestMapping(value = "/aula_virtual/alumno", method = RequestMethod.GET)
    public String mostrar(){
        if(){
            //profesor
            return "";
        }else if (){
            //alumno
            return "";
        }else{
            //administrador
            return "";
        }
    }

    */

    //DATOS profesor/alumno
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPagPrincipal(){
        //Primero se debe verificar si el usuario esta logueado con la sesion.
        /*HttpSession sesion = obtenerSesion();
        if(!(boolean)sesion.getAttribute("login")){
            //Si no esta logueado, se le redirige al login
            return "redirect:/login";
        }*/
        //Adicionalmente, se deberia verificar el tipo de usuario que es, para devolverle un template u otro.
        if(false/*(boolean)sesion.getAttribute("profesor")*/){
            //Si es profesor
            return "Profesor";
        }else if(true/*(boolean)sesion.getAttribute("alumno")*/){
            //Si es alumno
            return "Alumno";
        }else if(false/*(boolean)sesion.getAttribute("administrador")*/){
            //No hay pagina principal para administrador, se le redirige a gestionar alumnos
            return "redirect:/alumno";
        }else{
            return "redirect:/login";
        }
    }

    //Profesor - Ver seccion
    @RequestMapping(value = "/seccion", method = RequestMethod.GET)
    public String mostrarProfesor_Sección(){
        //Se deberia verificar tambien si esta logueado. Y verificar que sea profesor.
        return "Profesor_Sección";
    }

    //ADMINISTRADOR:
    //Gestionar alumnos
    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public String mostrarGestionAlumnos(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                        @RequestParam(name = "student_id", required = false) Optional<String> studentId,
                                        Model model){
        //Verificar si esta logueado. Verificar si es cuenta de administrador.
        if(edit.equalsIgnoreCase("true")){
            //Para editar
            //http://localhost:8080/alumno?edit=true (CRUD)

            //Ahora se debe diferenciar si se ingreso a edit a traves del boton de agregar alumno o del lapiz de editar junto a cada alumno de la lista.
            if(!studentId.isEmpty()){
                /*Si se ingreso a traves del lapiz, es para editar un alumno ya existente, entonces se debio pasar el
                id del alumno como parametro (http://localhost:8080/alumno?edit=true&student_id={id}).
                En este caso se deberia buscar el id en la base de datos para llenar los datos en el template "Admin_CrudAlumno".
                Este if entonces solo se ejecuta cuando studentId no esta vacio y aca se hace la consulta a bd.
                Nota: Como es un opcional, para obtener el id se debe usar studentId.get*/
            }
            return "Admin_CrudAlumno";
        }
        //http://localhost:8080/alumno
        else return "Admin_CargaAlumnos";
    }

    //Gestionar profesores
    @RequestMapping(value = "/profesor", method = RequestMethod.GET)
    public String mostrarGestionProfesores(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                           @RequestParam(name = "prof_id", required = false) Optional<String> profID,
                                           Model model){
        //Verificar que este logueado y que sea administrador.
        if(edit.equalsIgnoreCase("true")){
            //http://localhost:8080/profesor?edit=true (CRUD)

            //De igual manera se debe saber si se ingreso a travez del lapiz o del boton de agregar profesor
            if(!profID.isEmpty()){
                //http://localhost:8080/profesor?edit=true&prof_id={id}
                //Si profID no esta vacio, hacer las consultas necesarias en la base de datos con el id del profesor y agregarlas al modelo.
            }

            return "Admin_CrudProfesor";
        }
        //http://localhost:8080/profesor
        else return "Admin_CargaProfesores";
    }

    //Gestionar cursos
    @RequestMapping(value = "/curso", method = RequestMethod.GET)
    public String mostrarGestionCursos(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                       @RequestParam(name = "course_id", required = false) Optional<String> courseID,
                                       Model model){
        //Verificar que este logueado y que sea administrador.
        if(edit.equalsIgnoreCase("true")){
            //http://localhost:8080/curso?edit=true (CRUD)

            if(!courseID.isEmpty()){
                //http://localhost:8080/curso?edit=true&course_id={id}
                /*Hacer consultas a bd y agregar al modelo*/
            }
            return "Admin_CrudCurso";
        }
        //http://localhost:8080/curso
        else return "Admin_CargaCursos";
    }

    //Gestionar secciones
    @RequestMapping(value = "/seccion", method = RequestMethod.GET)
    public String mostrarGestionSecciones(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                          @RequestParam(name = "section_id", required = false) Optional<String> sectionID,
                                          Model model){
        //Verificar que este logueado -> Verificar que sea administrador. Si es otro tipo de usuario se le podria redireccionar a la pagina principal.
        if(edit.equalsIgnoreCase("true")){
            //http://localhost:8080/seccion?edit=true (CRUD)

            if(!sectionID.isEmpty()){
                //http://localhost:8080/seccion?edit=true&section_id={id}
                //Hacer las consultas necesarias a bd usando el id de seccion y agregar al modelo
            }

            return "Admin_CrudSección";
        }
        //http://localhost:8080/seccion
        else return "Admin_CargaSecciones";
    }

    //TESTER
    // http://localhost:8080/test
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mostrarTest(){
        //Copia tu código en el archivo test.jsp
        return "test";
    }


    /* FUNCIONES */
    @RequestMapping(value = "/aula_virtual/administrador/alumnos/edit/{cod}", method = RequestMethod.GET)
    public String editarAlumno(Model model, @PathVariable String cod) {
        Optional<AlumnoEntity> tempAlumno = alumnoRep.findById(Long.parseLong(cod));
        if (tempAlumno.isPresent()){
            model.addAttribute("alumno", tempAlumno.get());
        }
        return "Admin_CrudAlumno";
    }

    public HttpSession obtenerSesion(){
        final HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

}
