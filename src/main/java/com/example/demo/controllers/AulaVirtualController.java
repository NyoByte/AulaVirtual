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
                model.addAttribute("usuario","esProfesor");
            } else if (user.equalsIgnoreCase("alumno")) {
                model.addAttribute("usuario","esAlumno");
            } else if (user.equalsIgnoreCase("administrador")){
                model.addAttribute("usuario","esAdministrador");
            }else{
                return "redirect:/";
            }
            return  "Login_Administrador";
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
            String usuario = "test";
            String password = "profe";
            if(form.getUsername().equals(usuario) && form.getPassword().equals(password)){
                sesion.setAttribute("login",true);
                sesion.setAttribute("esProfesor",true);
                sesion.setAttribute("esAlumno",false);
                sesion.setAttribute("esAdministrador",false);
                return "redirect:/";
            }else{
                return "redirect:/login/profesor?logeado=false";
            }

        }else if(type_user.equalsIgnoreCase("alumno")){
            String usuario = "test";
            String password = "alumno";
            if(form.getUsername().equals(usuario) && form.getPassword().equals(password)){
                sesion.setAttribute("login",true);
                sesion.setAttribute("esProfesor",false);
                sesion.setAttribute("esAlumno",true);
                sesion.setAttribute("esAdministrador",false);
                return "redirect:/";
            }else{
                return "redirect:/login/alumno?logeado=false";
            }
        }else{
            String usuario = "test";
            String password = "administrador";
            if(form.getUsername().equals(usuario) && form.getPassword().equals(password)){
                sesion.setAttribute("login",true);
                sesion.setAttribute("esProfesor",false);
                sesion.setAttribute("esAlumno",false);
                sesion.setAttribute("esAdministrador",true);
                return "redirect:/";
            }else{
                return "redirect:/login/administrador?logeado=false";
            }
        }
    }

    //Principales: no logeado: Inicio, profesor: "Profesor" alumno: "Alumno", administrado: "Admin_CargaProfesores"
    @RequestMapping(value = "/", method = RequestMethod.GET) //cambié de / -> temporal porque la pagina principal es la de inicio
    public String mostrarPagPrincipal(Model model){
        //Primero se debe verificar si el usuario esta logueado con la sesion.
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            //Si no esta logueado, se le redirige al inicio
            return "Inicio";
        }
        //Adicionalmente, se deberia verificar el tipo de usuario que es, para devolverle un template u otro.
        if((boolean)sesion.getAttribute("esProfesor")){
            //Si es profesor
            ProfesorEntity tempProf = new ProfesorEntity();
            model.addAttribute("profesor",tempProf);
            return "Profesor";
        }else if((boolean)sesion.getAttribute("esAlumno")){
            //Si es alumno se debe enviar el alumno que se logeó
            AlumnoEntity newAlumno = new AlumnoEntity();
            model.addAttribute("alumno",newAlumno);
            return "Alumno";
        }else if((boolean)sesion.getAttribute("esAdministrador")){
            //No hay pagina principal para administrador, se le redirige a gestionar profesores
            return "redirect:/profesor";
        }else{
            return "redirect:/";
        }
    }

    //ADMINISTRADOR:
    //Gestionar alumnos
    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public String mostrarGestionAlumnos(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                        @RequestParam(name = "alumno_id", required = false) Optional<String> alumnoId,
                                        Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
            if(edit.equalsIgnoreCase("true")){
                List<PaisEntity> paises = paisRep.findAll();
                model.addAttribute("listaPaises",paises);
                List<GeneroEntity> generos = generoRep.findAll();
                model.addAttribute("listaGeneros",generos);
                List<CarreraEntity> carreras = carreraRep.findAll();
                model.addAttribute("listaCarreras",carreras);
                System.out.println(alumnoId);
                if(!alumnoId.isEmpty()){
                    System.out.println("====NO NULL");
                    Optional<AlumnoEntity> alumnoSeleccionado = alumnoRep.findById(Long.parseLong(alumnoId.get()));
                    if(alumnoSeleccionado.isPresent()){
                        model.addAttribute("alumno",alumnoSeleccionado.get());
                    }
                }else{
                    System.out.println("====NULL");
                    model.addAttribute("alumno",null);
                }
                return "Admin_CrudAlumno";
            }
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
                                           @RequestParam(name = "profesor_id", required = false) Optional<String> profesorId,
                                           Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
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
                                       @RequestParam(name = "curso_id", required = false) Optional<String> cursoId,
                                       Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
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
    @RequestMapping(value = "/seccion", method = RequestMethod.GET)
    public String mostrarGestionSecciones(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                          @RequestParam(name = "seccion_id", required = false) Optional<String> seccionId,
                                          Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
            if(edit.equalsIgnoreCase("true")){
                List<CursoEntity> cursos = cursoRep.findAll();
                model.addAttribute("listaCursos",cursos);
                List<AlumnoEntity> alumnos = alumnoRep.findAll();
                model.addAttribute("listaAlumnos",alumnos);
                List<ProfesorEntity> profesor = profesorRep.findAll();
                model.addAttribute("listaProfesores",profesor);
                if(!seccionId.isEmpty()){
                    Optional<SeccionEntity> seccionSeleccionado = seccionRep.findById(Long.parseLong(seccionId.get()));
                    if(seccionSeleccionado.isPresent()){
                        model.addAttribute("seccion",seccionSeleccionado.get());
                    }
                }
                return "Admin_CrudSeccion";
            }
            else{
                List<SeccionEntity> secciones = seccionRep.findAll();
                model.addAttribute("listaSecciones",secciones);
                return "Admin_CargaSecciones";
            }
        }else if((boolean)sesion.getAttribute("esProfesor")) {
            return "Profesor_Seccion";
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
