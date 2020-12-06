package com.example.demo.controllers;

import com.example.demo.forms.LoginForm;
import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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

    // HTTP Session
    private HttpSession ObtenerSesion(){
        final HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    // MAPPING:

    // MAIN
    //Principales: no logeado: Inicio, profesor: "Profesor" alumno: "Alumno", administrador: "Admin_CargaProfesores"
    @RequestMapping(value = "/", method = RequestMethod.GET)
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
            ProfesorEntity profesorSeleccionado = (ProfesorEntity) sesion.getAttribute("identificador");
            Optional<ProfesorEntity> profesorBD = profesorRep.findById(profesorSeleccionado.getId());
            if(profesorBD.isPresent()) {
                model.addAttribute("profesor", profesorBD.get());
            }
            return "Profesor";
        }else if((boolean)sesion.getAttribute("esAlumno")){
            //Si es alumno
            AlumnoEntity alumnoSeleccionado = (AlumnoEntity) sesion.getAttribute("identificador");
            //Buscar al alumno logueado
            Optional<AlumnoEntity> alumnoBD = alumnoRep.findById(alumnoSeleccionado.getId());
            if(alumnoBD.isPresent()) {
                model.addAttribute("alumno", alumnoBD.get());
            }
            return "Alumno";
        }else if((boolean)sesion.getAttribute("esAdministrador")){
            //No hay pagina principal para administrador, se le redirige a gestionar profesores
            // se envia los model en cada direccion
            return "redirect:/profesor";
        }else{
            return "redirect:/";
        }
    }

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
                model.addAttribute("usuario","profesor");
            } else if (user.equalsIgnoreCase("alumno")) {
                model.addAttribute("usuario","alumno");
            } else if (user.equalsIgnoreCase("administrador")){
                model.addAttribute("usuario","administrador");
            }else{
                return "redirect:/";
            }
            return  "Login";
        }
    }

    //ADMINISTRADOR:
    //Gestionar alumnos
    @RequestMapping(value = "/alumno", method = RequestMethod.GET)
    public String mostrarGestionAlumnos(@RequestParam(name = "edit", defaultValue = "false") String edit,
                                        @RequestParam(name = "alumno_id", required = false) Optional<String> alumnoId,
                                        @RequestParam(name = "page",defaultValue = "0") String pagina,
                                        @RequestParam(name = "kw_name", defaultValue = "") String kw_name,
                                        @RequestParam(name = "kw_cod", defaultValue = "") String kw_cod,
                                        Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
            // Se envia qué administrador es
            String administradorSeleccionado = (String) sesion.getAttribute("identificador");
            model.addAttribute("administrador",administradorSeleccionado);

            if(edit.equalsIgnoreCase("true")){
                List<PaisEntity> paises = paisRep.findAll();
                model.addAttribute("listaPaises",paises);
                List<GeneroEntity> generos = generoRep.findAll();
                model.addAttribute("listaGeneros",generos);
                List<CarreraEntity> carreras = carreraRep.findAll();
                model.addAttribute("listaCarreras",carreras);
                if(!alumnoId.isEmpty()){
                    Optional<AlumnoEntity> alumnoSeleccionado = alumnoRep.findById(Long.parseLong(alumnoId.get()));
                    if(alumnoSeleccionado.isPresent()){
                        model.addAttribute("alumno",alumnoSeleccionado.get());
                    }
                }else{
                    model.addAttribute("alumno",null);
                }
                return "Admin_CrudAlumno";
            }
            else{
                Pageable pageSizeTen = PageRequest.of(Integer.parseInt(pagina), 10);
                //Filtro
                if(kw_name.equals("") && kw_cod.equals("")){
                    //Enviar numero de paginas al modelo
                    Page<AlumnoEntity> paginaAlumnos = alumnoRep.findAll(pageSizeTen);
                    model.addAttribute("numPaginas", paginaAlumnos.getTotalPages());
                    model.addAttribute("pagActual", pagina);
                    List<AlumnoEntity> alumnos = paginaAlumnos.getContent();
                    model.addAttribute("listaAlumnos", alumnos);
                }else if(!kw_name.equals("") && !kw_cod.equals("")){
                    List<AlumnoEntity> filterAlumnos = alumnoRep.findByKeywordNameAndCode(kw_name.toUpperCase(), kw_cod);
                    PagedListHolder<AlumnoEntity> alumnos = new PagedListHolder<>(filterAlumnos);
                    alumnos.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", alumnos.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandarle ruta cuando es filtro
                    String path = "?kw_cod="+kw_cod+"&kw_name="+kw_name;
                    model.addAttribute("filtro",path);
                    //Mandar página actual del filtro
                    alumnos.setPage(Integer.parseInt(pagina));
                    model.addAttribute("listaAlumnos", alumnos.getPageList());
                }else if(kw_name.equals("")){
                    List<AlumnoEntity> filterAlumnos = alumnoRep.findByKeywordCode(kw_cod);
                    PagedListHolder<AlumnoEntity> alumnos = new PagedListHolder<>(filterAlumnos);
                    alumnos.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", alumnos.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandarle ruta cuando es filtro
                    String path = "?kw_cod="+kw_cod+"&kw_name="+kw_name;
                    model.addAttribute("filtro",path);
                    //Mandar página actual del filtro
                    alumnos.setPage(Integer.parseInt(pagina));
                    model.addAttribute("listaAlumnos", alumnos.getPageList());
                }else{
                    List<AlumnoEntity> filterAlumnos = alumnoRep.findByKeywordName(kw_name.toUpperCase());
                    PagedListHolder<AlumnoEntity> alumnos = new PagedListHolder<>(filterAlumnos);
                    alumnos.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", alumnos.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandarle ruta cuando es filtro
                    String path = "?kw_cod="+kw_cod+"&kw_name="+kw_name;
                    model.addAttribute("filtro",path);
                    //Mandar página actual del filtro
                    alumnos.setPage(Integer.parseInt(pagina));
                    model.addAttribute("listaAlumnos", alumnos.getPageList());
                }
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
                                           @RequestParam(name = "page", defaultValue = "0") String pagina,
                                           @RequestParam(name = "kw_name", defaultValue = "") String kw_name,
                                           @RequestParam(name = "kw_cod", defaultValue = "") String kw_cod,
                                           Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
            // Se envia qué administrador es
            String administradorSeleccionado = (String) sesion.getAttribute("identificador");
            model.addAttribute("administrador",administradorSeleccionado);

            if(edit.equalsIgnoreCase("true")){
                List<PaisEntity> paises = paisRep.findAll();
                model.addAttribute("listaPaises",paises);
                List<GeneroEntity> generos = generoRep.findAll();
                model.addAttribute("listaGeneros",generos);
                List<ProfesorTipoEntity> tipos = tipoRep.findAll();
                model.addAttribute("listaTipos",tipos);
                if(!profesorId.isEmpty()){
                    Optional<ProfesorEntity> profesorSeleccionado = profesorRep.findById(Long.parseLong(profesorId.get()));
                    if(profesorSeleccionado.isPresent()){
                        model.addAttribute("profesor",profesorSeleccionado.get());
                    }
                }else {
                    model.addAttribute("profesor",null);
                }
                return "Admin_CrudProfesor";
            }
            //http://localhost:8080/profesor
            else{
                Pageable pageSizeTen = PageRequest.of(Integer.parseInt(pagina), 10);
                //Filtro
                if(kw_name.equals("") && kw_cod.equals("")){
                    //Enviar numero de paginas al modelo
                    Page<ProfesorEntity> paginaProfesores = profesorRep.findAll(pageSizeTen);
                    model.addAttribute("numPaginas", paginaProfesores.getTotalPages());
                    model.addAttribute("pagActual", pagina);
                    List<ProfesorEntity> profesores = paginaProfesores.getContent();
                    model.addAttribute("listaProfesores", profesores);
                }else if(!kw_name.equals("") && !kw_cod.equals("")){
                    List<ProfesorEntity> filterProfesores = profesorRep.findByKeywordNameAndCode(kw_name.toUpperCase(), kw_cod);
                    PagedListHolder<ProfesorEntity> profesores = new PagedListHolder<>(filterProfesores);
                    profesores.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", profesores.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandarle ruta cuando es filtro
                    String path = "?kw_cod="+kw_cod+"&kw_name="+kw_name;
                    model.addAttribute("filtro",path);
                    //Mandar página actual del filtro
                    profesores.setPage(Integer.parseInt(pagina));
                    model.addAttribute("listaProfesores", profesores.getPageList());
                }else if(kw_name.equals("")){
                    List<ProfesorEntity> filterProfesores = profesorRep.findByKeywordCode(kw_cod);
                    PagedListHolder<ProfesorEntity> profesores = new PagedListHolder<>(filterProfesores);
                    profesores.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", profesores.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandarle ruta cuando es filtro
                    String path = "?kw_cod="+kw_cod+"&kw_name="+kw_name;
                    model.addAttribute("filtro",path);
                    //Mandar página actual del filtro
                    profesores.setPage(Integer.parseInt(pagina));
                    model.addAttribute("listaProfesores", profesores.getPageList());
                }else{
                    List<ProfesorEntity> filterProfesores = profesorRep.findByKeywordName(kw_name.toUpperCase());
                    PagedListHolder<ProfesorEntity> profesores = new PagedListHolder<>(filterProfesores);
                    profesores.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", profesores.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandarle ruta cuando es filtro
                    String path = "?kw_cod="+kw_cod+"&kw_name="+kw_name;
                    model.addAttribute("filtro",path);
                    //Mandar página actual del filtro
                    profesores.setPage(Integer.parseInt(pagina));
                    model.addAttribute("listaProfesores", profesores.getPageList());
                }

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
                                       @RequestParam(name = "page", defaultValue = "0") String pagina,
                                       Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
            // Se envia qué administrador es
            String administradorSeleccionado = (String) sesion.getAttribute("identificador");
            model.addAttribute("administrador",administradorSeleccionado);

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
                //Setear numero y tamaño de pagina
                Pageable pageSizeTen = PageRequest.of(Integer.parseInt(pagina), 3);
                //Obtener pagina de cursos
                Page<CursoEntity> paginaCursos = cursoRep.findAll(pageSizeTen);
                //Enviar numero de paginas y pagina actual al modelo
                model.addAttribute("numPaginas", paginaCursos.getTotalPages());
                model.addAttribute("pagActual", pagina);
                //Convertir pagina de alumnos a lista
                List<CursoEntity> listaCursos = paginaCursos.getContent();
                //Añadir lista de cursos al modelo
                model.addAttribute("listaCursos", listaCursos);

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
                                          @RequestParam(name = "page", defaultValue = "0") String pagina,
                                          Model model){
        HttpSession sesion =  ObtenerSesion();
        if(sesion.getAttribute("login")==null || !(boolean)sesion.getAttribute("login")){
            return "redirect:/";
        }
        if((boolean)sesion.getAttribute("esAdministrador")){
            // Se envia qué administrador es
            String administradorSeleccionado = (String) sesion.getAttribute("identificador");
            model.addAttribute("administrador",administradorSeleccionado);

            if(edit.equalsIgnoreCase("true")){
                List<CursoEntity> cursos = cursoRep.findAll();
                model.addAttribute("listaCursos",cursos);

                List<ProfesorEntity> profesorT1 = profesorRep.findTipoProfesor();
                model.addAttribute("listaProfesoresT1",profesorT1);

                List<ProfesorEntity> profesorT2 = profesorRep.findTipoJefeDePractica();
                model.addAttribute("listaProfesoresT2",profesorT2);

                if(!seccionId.isEmpty()){

                    Optional<SeccionEntity> seccionSeleccionado = seccionRep.findById(Long.parseLong(seccionId.get()));
                    if(seccionSeleccionado.isPresent()) {
                        model.addAttribute("seccion", seccionSeleccionado.get());
                        // Mandarle Profesores
                        List<ProfesorEntity> profes = seccionSeleccionado.get().getProfesor();
                        for (ProfesorEntity profe: profes){
                            //Solo habrá dos profes por su tipo
                            if(profe.getType().getId()==1){
                                model.addAttribute("profesorSeleccionadoT1",profe);
                            }
                            if(profe.getType().getId()==2){
                                model.addAttribute("profesorSeleccionadoT2",profe);
                            }
                        }
                        // Mandarle Alumnos
                        List<AlumnoEntity> listaAlumnos = seccionSeleccionado.get().getAlumnos();

                        PagedListHolder<AlumnoEntity> alumosP = new PagedListHolder<>(listaAlumnos);
                        alumosP.setPageSize(10);
                        //Mandar datos para las flechas
                        model.addAttribute("numPaginas", alumosP.getPageCount());
                        model.addAttribute("pagActual", pagina);
                        //Mandar página actual del filtro
                        alumosP.setPage(Integer.parseInt(pagina));
                        //Obtener la lista de alumnos y seccion buscada para el refresh
                        model.addAttribute("listaAlumnos", alumosP.getPageList());
                        model.addAttribute("seccionBuscada",seccionId.get());
                        String path  = "?edit=true&seccion_id="+seccionId.get();
                        model.addAttribute("filtro",path);
                    }

                }else{
                    model.addAttribute("seccion", null);
                }
                return "Admin_CrudSeccion";
            }else{
                Pageable pageSizeTen = PageRequest.of(Integer.parseInt(pagina),10);
                Page<SeccionEntity> paginaSecciones = seccionRep.findAll(pageSizeTen);

                model.addAttribute("numPaginas", paginaSecciones.getTotalPages());
                model.addAttribute("pagActual", pagina);

                List<SeccionEntity> secciones = paginaSecciones.getContent();
                // Se hizo este refactor debido que mueve el orden de la lista de los profes de secciones
                for (SeccionEntity seccion:secciones){
                    if(seccion.getProfesor().get(0).getType().getId()==2){
                        ProfesorEntity p1 = seccion.getProfesor().get(0);
                        ProfesorEntity p2 = seccion.getProfesor().get(1);
                        if (p1.getType().getId() == 2){
                            seccion.getProfesor().set(0,p2);
                            seccion.getProfesor().set(1,p1);
                        }
                    }
                }
                model.addAttribute("listaSecciones",secciones);
                return "Admin_CargaSecciones";
            }
        }else if((boolean)sesion.getAttribute("esProfesor")) {
            /*SI ES PROFESOR*/
            //Obtener la entidad del profesor actual
            ProfesorEntity profesorSeleccionado = (ProfesorEntity) sesion.getAttribute("identificador");
            model.addAttribute("profesor",profesorSeleccionado);
            ProfesorEntity profesor = profesorRep.findById(profesorSeleccionado.getId()).get();
            //Obtener su lista de secciones
            List<SeccionEntity> listaSecciones = profesor.getSecciones();
            model.addAttribute("listaSecciones", listaSecciones);
            //Seccion para mostrar
            if(seccionId.isPresent()){
                Optional<SeccionEntity> opSeccionSeleccionada = seccionRep.findById(Long.parseLong(seccionId.get()));
                if(opSeccionSeleccionada.isPresent()){
                    SeccionEntity seccionSeleccionada = opSeccionSeleccionada.get();
                    List<AlumnoEntity> listaAlumnos = seccionSeleccionada.getAlumnos();

                    PagedListHolder<AlumnoEntity> alumnos = new PagedListHolder<>(listaAlumnos);
                    alumnos.setPageSize(10);
                    //Mandar datos para las flechas
                    model.addAttribute("numPaginas", alumnos.getPageCount());
                    model.addAttribute("pagActual", pagina);
                    //Mandar página actual del filtro
                    alumnos.setPage(Integer.parseInt(pagina));
                    //Obtener la lista de alumnos y seccion buscada para el refresh
                    model.addAttribute("listaAlumnos", alumnos.getPageList());
                    model.addAttribute("seccionBuscada",seccionId.get());
                }
            }
            return "Profesor_Seccion";
        }else{
            return "redirect:/";
        }
    }

    /* FUNCIONES */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String testing(Model model) {
        return "testing";
    }

}
