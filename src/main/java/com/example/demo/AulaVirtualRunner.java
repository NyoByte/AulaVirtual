package com.example.demo;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.CarreraEntity;
import com.example.demo.model.dao.GeneroEntity;
import com.example.demo.model.dao.PaisEntity;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AulaVirtualRunner implements CommandLineRunner {
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

    @Override
    public void run(String... args) throws Exception{
        /*Optional<AlumnoEntity> temp = alumnoRep.findById(Long.parseLong("1"));
        Optional<GeneroEntity> gen = generoRep.findById(Long.parseLong("1"));
        temp.get().setGender(gen.get());
        alumnoRep.save(temp.get());
         */
        /*

        PARA ELIMINAR

        alumnoRep.deleteById(Long.parseLong("1"));

         */


        /*
        PaisEntity pais1 = new PaisEntity(null,"Perú");         paisRep.save(pais1);
        PaisEntity pais2 = new PaisEntity(null,"Argentina");    paisRep.save(pais2);
        PaisEntity pais3 = new PaisEntity(null,"Chile");        paisRep.save(pais3);
        PaisEntity pais4 = new PaisEntity(null,"Bolivia");      paisRep.save(pais4);
        PaisEntity pais5 = new PaisEntity(null,"España");       paisRep.save(pais5);

        GeneroEntity genero1 = new GeneroEntity(null,"Masculino");      generoRep.save(genero1);
        GeneroEntity genero2 = new GeneroEntity(null,"Femenino");       generoRep.save(genero2);
        GeneroEntity genero3 = new GeneroEntity(null,"No especificar"); generoRep.save(genero3);

        CarreraEntity carrera0 = new CarreraEntity(null,"Estudios Generales");          carreraRep.save(carrera0);
        CarreraEntity carrera1 = new CarreraEntity(null,"Administración");              carreraRep.save(carrera1);
        CarreraEntity carrera2 = new CarreraEntity(null,"Arquitectura");                carreraRep.save(carrera2);
        CarreraEntity carrera3 = new CarreraEntity(null,"Comunicación");                carreraRep.save(carrera3);
        CarreraEntity carrera4 = new CarreraEntity(null,"Contabilidad");                carreraRep.save(carrera4);
        CarreraEntity carrera5 = new CarreraEntity(null,"Derecho");                     carreraRep.save(carrera5);
        CarreraEntity carrera6 = new CarreraEntity(null,"Economía");                    carreraRep.save(carrera6);
        CarreraEntity carrera7 = new CarreraEntity(null,"Ingeniería Civil");            carreraRep.save(carrera7);
        CarreraEntity carrera8 = new CarreraEntity(null,"Ingeniería Industrial");       carreraRep.save(carrera8);
        CarreraEntity carrera9 = new CarreraEntity(null,"Ingeniería de Sistemas");      carreraRep.save(carrera9);
        CarreraEntity carrera10 = new CarreraEntity(null,"Marketing");                  carreraRep.save(carrera10);
        CarreraEntity carrera11 = new CarreraEntity(null,"Negocios Internacionales");   carreraRep.save(carrera11);
        CarreraEntity carrera12 = new CarreraEntity(null,"Psicología");                 carreraRep.save(carrera12);

        AlumnoEntity alumno1 = new AlumnoEntity(null,20173527,"Andy","Lazo",
                "20173527@aloe.ulima.edu.pe","andyLazo@hotmail.com",
                "andy","andyl","154165171","fotito.jpe",genero1,carrera9,pais1);

        alumnoRep.save(alumno1);
         */


        //CursoEntity curso1 = new CursoEntity(null,)
    }
}
