package com.example.demo.controllers;


import com.example.demo.forms.LoginForm;
import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AulaVirtualController {
    @Autowired
    private AlumnoRepository alumnoRep;
    @Autowired
    private PaisRepository paisRep;
    @Autowired
    private GeneroRepository generoRep;
    @Autowired
    private CarreraRepository carreraRep;
    @Autowired
    private CursoRepository cursoRep;
    @Autowired
    private PeriodoRepository periodoRep;
    @Autowired
    private ProfesorRepository profesorRep;
    @Autowired
    private ProfesorTipoRepository tipoRep;
    @Autowired
    private SeccionRepostitory seccionRep;
    @Autowired
    private UsuarioRepository usuarioRep;

    // MAPPING:

    //LOGIN:
    // http://localhost:8080/login/{profesor/alumno/administrador}
    @RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
    public String mostrarLogin(Model model,@PathVariable String user, @RequestParam(name="logeado", required = false, defaultValue = "") String logeado){
        HttpSession sesion = ObtenerSesion();
        if(sesion.getAttribute("login")!=null && (boolean) sesion.getAttribute("login")){
            return "redirect:/";
        }else {
            if(logeado.equals("false")){
                model.addAttribute("loginCorrecto",false);
            }
            if (user.equalsIgnoreCase("profesor")) {
                return "Login_Profesor";
            } else if (user.equalsIgnoreCase("alumno")) {
                return "Login_Estudiante";
            } else {
                return "Login_Administrador";
            }
        }
        /*NotaNyo: Para cambiar se debe hacer Model*/
        /*NOTA: En este caso las 3 paginas son muy similares,
        asi que lo mas conveniente seria devolver un solo template y con el choose
        cambiar las partes necesarias para cada tipo de usuario. De momento lo dejo con if.*/
    }

    @RequestMapping(value="/procesar_login/{type_user}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String procesarLogin(LoginForm form, @PathVariable String type_user){
        HttpSession sesion = ObtenerSesion();
        if(type_user.equalsIgnoreCase("profesor")){
            String usuario = "";
            String password = "";
            if(form.getUsername().equals(usuario) && form.getPassword().equals(password)){
                sesion.setAttribute("login",true);
                sesion.setAttribute("profesor",true);
                return "redirect:/";
            }else{
                return "redirect:/login/profesor?logeado=false";
            }

        }else if(type_user.equalsIgnoreCase("alumno")){
            String usuario = "";
            String password = "";
            if(form.getUsername().equals(usuario) && form.getPassword().equals(password)){
                sesion.setAttribute("login",true);
                sesion.setAttribute("alumno",true);
                return "redirect:/";
            }else{
                return "redirect:/login/alumno?logeado=false";
            }
        }else{
            String usuario = "";
            String password = "";
            if(form.getUsername().equals(usuario) && form.getPassword().equals(password)){
                sesion.setAttribute("login",true);
                sesion.setAttribute("administrador",true);
                return "redirect:/";
            }else{
                return "redirect:/login/administrador?logeado=false";
            }
        }
    }

    //Principales: no logeado: Inicio, profesor: "Profesor" alumno: "Alumno", administrado: "Admin_CargaProfesores"
    @RequestMapping(value = "/", method = RequestMethod.GET) //cambié de / -> temporal porque la pagina principal es la de inicio
    public String mostrarPagPrincipal(){
        //Primero se debe verificar si el usuario esta logueado con la sesion.
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            //Si no esta logueado, se le redirige al inicio
            return "Inicio";
        }
        //Adicionalmente, se deberia verificar el tipo de usuario que es, para devolverle un template u otro.
        if(false/*(boolean)sesion.getAttribute("profesor")*/){
            //Si es profesor
            return "Profesor";
        }else if(true/*(boolean)sesion.getAttribute("alumno")*/){
            //Si es alumno
            return "Alumno";
        }else if(false/*(boolean)sesion.getAttribute("administrador")*/){
            //No hay pagina principal para administrador, se le redirige a gestionar alumnos
            return "Admin_CargaAlumnos";
        }else{
            return "redirect:/inicio";
        }
    }
    /* SE COMENTÓ PORQUE SE REALIZA MÁS ABAJO LA VALIDACIÓN
    //Profesor - Ver seccion
    @RequestMapping(value = "/seccion", method = RequestMethod.GET)
    public String mostrarProfesor_Sección(){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/inicio";
        }
        if((boolean)sesion.getAttribute("profesor")){
            return "Profesor_Sección";
        }else{
            return "redirect:/";
        }
    }
     */

    //ADMINISTRADOR:
    //Gestionar alumnos
    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public String mostrarGestionAlumnos(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                        @RequestParam(name = "alumno_id", required = false) Optional<String> alumnoId,
                                        Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/inicio";
        }
        //Verificar si esta logueado. Verificar si es cuenta de administrador.
        if((boolean)sesion.getAttribute("administrador")){
            if(edit.equalsIgnoreCase("true")){
                //Para editar
                //http://localhost:8080/alumno?edit=true (CRUD)
                List<PaisEntity> paises = paisRep.findAll();
                model.addAttribute("listaPaises",paises);
                List<GeneroEntity> generos = generoRep.findAll();
                model.addAttribute("listaGeneros",generos);
                List<CarreraEntity> carreras = carreraRep.findAll();
                model.addAttribute("listaCarreras",carreras);

                //Ahora se debe diferenciar si se ingreso a edit a traves del boton de agregar alumno o del lapiz de editar junto a cada alumno de la lista.
                if(!alumnoId.isEmpty()){
                /*Si se ingreso a traves del lapiz, es para editar un alumno ya existente, entonces se debio pasar el
                id del alumno como parametro (http://localhost:8080/alumno?edit=true&alumno_id={id}).
                En este caso se deberia buscar el id en la base de datos para llenar los datos en el template "Admin_CrudAlumno".
                Este if entonces solo se ejecuta cuando alumnoId no esta vacio y aca se hace la consulta a bd.
                Nota: Como es un opcional, para obtener el id se debe usar alumnoId.get*/
                    Optional<AlumnoEntity> alumnoSeleccionado = alumnoRep.findById(Long.parseLong(alumnoId.get()));
                    if(alumnoSeleccionado.isPresent()){
                        model.addAttribute("alumno",alumnoSeleccionado.get());
                    }
                }
                return "Admin_CrudAlumno";
            }
            //http://localhost:8080/alumno
            else{
                List<AlumnoEntity> alumnos = alumnoRep.findAll();
                model.addAttribute("listaAlumnos",alumnos);
                return "Admin_CargaAlumnos";
            }
        }else{
            return "redirect:/";
        }
    }

    //Gestionar profesores
    @RequestMapping(value = "/profesor", method = RequestMethod.GET)
    public String mostrarGestionProfesores(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                           @RequestParam(name = "prof_id", required = false) Optional<String> profesorId,
                                           Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/inicio";
        }
        if((boolean)sesion.getAttribute("administrador")){
            if(edit.equalsIgnoreCase("true")){
                List<PaisEntity> paises = paisRep.findAll();
                model.addAttribute("listaPaises",paises);
                List<GeneroEntity> generos = generoRep.findAll();
                model.addAttribute("listaGeneros",generos);
                if(!profesorId.isEmpty()){
                    Optional<ProfesorEntity> profesorSeleccionado = profesorRep.findById(Long.parseLong(profesorId.get()));
                    if(profesorSeleccionado.isPresent()){
                        model.addAttribute("profesor",profesorSeleccionado.get());
                    }
                }
                return "Admin_CrudProfesor";
            }
            //http://localhost:8080/alumno
            else{
                List<ProfesorEntity> profesores = profesorRep.findAll();
                model.addAttribute("listaProfesores",profesores);
                return "Admin_CargaProfesores";
            }
        }else{
            return "redirect:/";
        }
    }

    //Gestionar cursos
    @RequestMapping(value = "/curso", method = RequestMethod.GET)
    public String mostrarGestionCursos(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                       @RequestParam(name = "course_id", required = false) Optional<String> cursoId,
                                       Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/inicio";
        }
        if((boolean)sesion.getAttribute("administrador")){
            if(edit.equalsIgnoreCase("true")){
                List<CarreraEntity> carreras = carreraRep.findAll();
                model.addAttribute("listaCarreras",carreras);
                if(!cursoId.isEmpty()){
                    Optional<CursoEntity> cursoSeleccionado = cursoRep.findById(Long.parseLong(cursoId.get()));
                    if(cursoSeleccionado.isPresent()){
                        model.addAttribute("curso",cursoSeleccionado.get());
                    }
                }
                return "Admin_CrudCurso";
            }
            else{
                List<CursoEntity> cursos = cursoRep.findAll();
                model.addAttribute("listaCursos",cursos);
                return "Admin_CargaCursos";
            }
        }else{
            return "redirect:/";
        }
    }

    //Gestionar secciones
    @RequestMapping(value = "/secciones", method = RequestMethod.GET)
    public String mostrarGestionSecciones(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                          @RequestParam(name = "section_id", required = false) Optional<String> seccionId,
                                          Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/inicio";
        }
        if((boolean)sesion.getAttribute("administrador")){
            if(edit.equalsIgnoreCase("true")){
                List<CursoEntity> cursos = cursoRep.findAll();
                model.addAttribute("listaCursos",cursos);
                List<AlumnoEntity> alumnos = alumnoRep.findAll();
                model.addAttribute("listaAlumnos",alumnos);
                if(!seccionId.isEmpty()){
                    Optional<SeccionEntity> seccionSeleccionado = seccionRep.findById(Long.parseLong(seccionId.get()));
                    if(seccionSeleccionado.isPresent()){
                        model.addAttribute("seccion",seccionSeleccionado.get());
                    }
                }
                return "Admin_CrudSección";
            }
            else{
                List<SeccionEntity> secciones = seccionRep.findAll();
                model.addAttribute("listaSecciones",secciones);
                return "Admin_CargaSecciones";
            }
        }else if((boolean)sesion.getAttribute("profesor")) {
            return "Profesor_Sección";
        }else{
            return "redirect:/";
        }
    }

    /* FUNCIONES */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testing() {
        return "Admin_CrudAlumno"; // podría funcionar para test, pero se requiere parametros así que... zzzzz xD
    }

    private HttpSession ObtenerSesion(){
        final HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

}
