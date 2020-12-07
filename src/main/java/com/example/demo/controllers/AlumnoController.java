package com.example.demo.controllers;

import com.example.demo.forms.GuardarAlumnosForm;
import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AlumnoController {
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

    @RequestMapping(value = "/alumno/guardar", method = RequestMethod.POST)
    public String guardarAlumno(GuardarAlumnosForm form, @RequestParam MultipartFile image) throws IOException {
        //Si el alumno es  un nuevo alumno
        int cod = Integer.parseInt(form.getCod());
        String first_name = form.getFirst_name();
        String last_name = form.getLast_name();
        String email_univ = form.getEmail_univ();
        String email_priv = form.getEmail_priv();
        String tv_user =  form.getTv_user();
        String tv_pw = form.getTv_pw();
        String ad_cred = form.getAd_cred();
        //Procesamiento de imagen
        InputStream inputStream = image.getInputStream();
        byte[] bytesImg = new byte[inputStream.available()];
        inputStream.read(bytesImg);
        byte[] photo= bytesImg;

        Long idCarrera = Long.parseLong(form.getCareer());
        Long idPais = Long.parseLong(form.getPais());
        Long idGenero = Long.parseLong(form.getGender());

        Optional<AlumnoEntity> opAlumno = alumnoRep.findById(Long.parseLong(form.getId()));
        if(opAlumno.isPresent()){
            AlumnoEntity alumno = opAlumno.get();
            // Editar un alumno existe
            alumno.setCod(cod);
            alumno.setFirst_name(first_name);
            alumno.setLast_name(last_name);
            alumno.setEmail_univ(email_univ);
            alumno.setEmail_priv(email_univ);
            alumno.setTv_user(tv_user);
            alumno.setTv_pw(tv_pw);
            alumno.setAd_cred(ad_cred);
            alumno.setImagen(photo);

            alumno.setCareer(carreraRep.findById(idCarrera).get()); alumnoRep.save(alumno);
            alumno.setPais(paisRep.findById(idPais).get());         alumnoRep.save(alumno);
            alumno.setGender(generoRep.findById(idGenero).get());   alumnoRep.save(alumno);

        }else{
            AlumnoEntity newAlumno = new AlumnoEntity(null, cod, first_name, last_name, email_univ, email_priv, tv_user, tv_pw, ad_cred, photo);

            Optional<CarreraEntity> opCarrera = carreraRep.findById(idCarrera);
            if (opCarrera.isPresent()) {
                newAlumno.setCareer(opCarrera.get());
                alumnoRep.save(newAlumno);
            }

            Optional<PaisEntity> opPais = paisRep.findById(idPais);
            if (opPais.isPresent()) {
                newAlumno.setPais(opPais.get());
                alumnoRep.save(newAlumno);
            }

            Optional<GeneroEntity> opGenero = generoRep.findById(idGenero);
            if (opGenero.isPresent()) {
                newAlumno.setGender(opGenero.get());
                alumnoRep.save(newAlumno);
            }
            //Crear su usuario
            String user = newAlumno.getEmail_univ();
            String pw = String.valueOf(newAlumno.getCod());
            UsuarioAlumnoEntity usuario = new UsuarioAlumnoEntity(null,user,pw,newAlumno);
            usuarioRep.save(usuario);
        }
        return "redirect:/alumno";

    }

    @RequestMapping(value = "/alumno/eliminar/{id}", method = RequestMethod.POST)
    public String eliminarAlumno(@PathVariable String id){
        Optional<AlumnoEntity> alumnoSeleccionado = alumnoRep.findById(Long.parseLong(id));
        if(alumnoSeleccionado.isPresent()){
            //Eliminar su usuario
            UsuarioAlumnoEntity kUser = alumnoSeleccionado.get().getUsuarioAlumno();
            usuarioRep.delete(kUser);
            
            List<SeccionEntity> secciones = alumnoSeleccionado.get().getSecciones();
            for(SeccionEntity seccion:secciones){
                List<AlumnoEntity> alumnos = seccion.getAlumnos();
                List<AlumnoEntity> newAlumnos = new ArrayList<>();
                for(AlumnoEntity alumno:alumnos){
                    if(alumno.getId()!=Long.parseLong(id)){
                        newAlumnos.add(alumno);
                    }
                }
                seccion.setAlumnos(newAlumnos);
                seccionRep.save(seccion);
            }
            alumnoRep.delete(alumnoSeleccionado.get());

        }
        return  "redirect:/alumno";
    }

    @RequestMapping(value = "/alumno/guardar_masivo", method = RequestMethod.POST)
    public String guardarCSV(@RequestParam MultipartFile file) throws IOException{
        //Leer el archivo
        InputStream inputStream = file.getInputStream();
        byte[] bArray = new byte[inputStream.available()];
        inputStream.read(bArray);

        //Transformar bytes a String
        String data = new String(bArray);
        inputStream.close();

        //Remover espacios en blanco
        data = data.replaceAll(" ","");

        //Dividir lineas
        String[] alumnos = data.split("\n");

        //Tratar linea x linea
        for(String alumno: alumnos){
            alumno = alumno.trim();
            String[] alDatos = alumno.split(",");
            //Crear nuevo alumno
            //public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred)
            AlumnoEntity newAl = new AlumnoEntity(null, Integer.parseInt(alDatos[0]),alDatos[1],alDatos[2], alDatos[3], alDatos[4],alDatos[5],alDatos[6],alDatos[7]);

            //Distinguir si es con fk o sin
            if(alDatos.length == 11){
                //public AlumnoEntity(Long id, int cod, String first_name, String last_name, String email_univ, String email_priv, String tv_user, String tv_pw, String ad_cred, GeneroEntity gender, CarreraEntity career, PaisEntity pais)
                Optional<GeneroEntity> opGenero = generoRep.findById(Long.valueOf(alDatos[8]));
                Optional<CarreraEntity> opCarrera = carreraRep.findById(Long.valueOf(alDatos[9]));
                Optional<PaisEntity> opPais = paisRep.findById(Long.valueOf(alDatos[10]));
                if(opGenero.isPresent()){
                    newAl.setGender(opGenero.get());
                }
                if(opCarrera.isPresent()){
                    newAl.setCareer(opCarrera.get());

                }
                if(opPais.isPresent()){
                    newAl.setPais(opPais.get());
                }
            }

            alumnoRep.save(newAl);
        }
        return "redirect:/alumno";

    }

    @RequestMapping(value = "/alumno/update", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String actualizarDatosAlumno(GuardarAlumnosForm alumnosForm){
        String nuevoCorreoPriv = alumnosForm.getEmail_priv();
        String nuevoTvUser = alumnosForm.getTv_user();
        String nuevaTvPw = alumnosForm.getTv_pw();
        String nuevaAnyDeskCred = alumnosForm.getAd_cred();

        //Obtener representacion del alumno que esta logueado actualmente
        HttpSession sesion = ObtenerSesion();
        AlumnoEntity alumnoLogueado = (AlumnoEntity) sesion.getAttribute("identificador");
        System.out.println("identificador obtenido correctamente");

        //Obtener el alumno de la BD
        Optional<AlumnoEntity> alumnoOP = alumnoRep.findById(alumnoLogueado.getId());

        if(alumnoOP.isPresent()) {
            AlumnoEntity alumnoActual = alumnoOP.get();
            System.out.println("Alumno obtenido de la BD");
            //Actualizar datos
            alumnoActual.setEmail_priv(nuevoCorreoPriv);
            alumnoActual.setTv_user(nuevoTvUser);
            alumnoActual.setTv_pw(nuevaTvPw);
            alumnoActual.setAd_cred(nuevaAnyDeskCred);
            System.out.println("Datos actualizados correctamente");
            alumnoRep.save(alumnoActual);
            System.out.println("Alumno actualizado en la bd");
        }
        return "redirect:/";
    }

    // HTTP Session
    private HttpSession ObtenerSesion(){
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }
}
