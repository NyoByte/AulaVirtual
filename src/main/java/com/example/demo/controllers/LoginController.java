package com.example.demo.controllers;

import com.example.demo.forms.LoginForm;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
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

    // HTTP Session
    private HttpSession ObtenerSesion(){
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    @RequestMapping(value="/login/entrando/{type_user}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
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

    @RequestMapping(value = "/login/saliendo", method = RequestMethod.POST)
    public String salirLogin(){
        HttpSession sesion = ObtenerSesion();
        sesion.setAttribute("login",false);
        sesion.setAttribute("esProfesor",false);
        sesion.setAttribute("esAlumno",false);
        sesion.setAttribute("esAdministrador",false);
        return "redirect:/";
    }
}
