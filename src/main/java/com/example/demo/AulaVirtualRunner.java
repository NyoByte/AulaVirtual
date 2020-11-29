package com.example.demo;

import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private PeriodoRepository periodoRep;
    @Autowired
    private ProfesorRepository profesoresRep;
    @Autowired
    private ProfesorTipoRepository tiposRep;
    @Autowired
    private SeccionRepostitory seccionRep;
    @Autowired
    private UsuarioRepository usuarioRep;



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



        // PAISES:
       /* PaisEntity pais1 = new PaisEntity(null,"Perú");         paisRep.save(pais1);
        PaisEntity pais2 = new PaisEntity(null,"Argentina");    paisRep.save(pais2);
        PaisEntity pais3 = new PaisEntity(null,"Chile");        paisRep.save(pais3);
        PaisEntity pais4 = new PaisEntity(null,"Bolivia");      paisRep.save(pais4);
        PaisEntity pais5 = new PaisEntity(null,"España");       paisRep.save(pais5);

        // GENEROS:
        GeneroEntity genero1 = new GeneroEntity(null,"Masculino");      generoRep.save(genero1);
        GeneroEntity genero2 = new GeneroEntity(null,"Femenino");       generoRep.save(genero2);
        GeneroEntity genero3 = new GeneroEntity(null,"No especificar"); generoRep.save(genero3);

        // CARRERAS:
        CarreraEntity carrera1 = new CarreraEntity(null,"Estudios Generales");          carreraRep.save(carrera1);
        CarreraEntity carrera2 = new CarreraEntity(null,"Administración");              carreraRep.save(carrera2);
        CarreraEntity carrera3 = new CarreraEntity(null,"Contabilidad");                carreraRep.save(carrera3);
        CarreraEntity carrera4 = new CarreraEntity(null,"Economía");                    carreraRep.save(carrera4);
        CarreraEntity carrera5 = new CarreraEntity(null,"Marketing");                   carreraRep.save(carrera5);
        CarreraEntity carrera6 = new CarreraEntity(null,"Negocios Internacionales");    carreraRep.save(carrera6);
        CarreraEntity carrera7 = new CarreraEntity(null,"Comunicación");                carreraRep.save(carrera7);
        CarreraEntity carrera8 = new CarreraEntity(null,"Derecho");                     carreraRep.save(carrera8);
        CarreraEntity carrera9 = new CarreraEntity(null,"Arquitectura");                carreraRep.save(carrera9);
        CarreraEntity carrera10 = new CarreraEntity(null,"Ingeniería Civil");           carreraRep.save(carrera10);
        CarreraEntity carrera11 = new CarreraEntity(null,"Ingeniería Industrial");      carreraRep.save(carrera11);
        CarreraEntity carrera12 = new CarreraEntity(null,"Ingeniería de Sistemas");     carreraRep.save(carrera12);
        CarreraEntity carrera13 = new CarreraEntity(null,"Psicología");                 carreraRep.save(carrera13);

        // CURSOS:
        CursoEntity c1_Curso1 = new CursoEntity(null,1001,"Globalización y Realidad Nacional",carrera1); cursoRep.save(c1_Curso1);
        CursoEntity c1_Curso2 = new CursoEntity(null,1002,"Lenguaje y Comunicación",carrera1);           cursoRep.save(c1_Curso2);
        CursoEntity c1_Curso3 = new CursoEntity(null,1003,"Metodologías de Investigación",carrera1);     cursoRep.save(c1_Curso3);
        CursoEntity c1_Curso4 = new CursoEntity(null,1004,"Desarrollo Personal y Social",carrera1);      cursoRep.save(c1_Curso4);
        CursoEntity c1_Curso5 = new CursoEntity(null,1005,"Matemática Básica",carrera1);                 cursoRep.save(c1_Curso5);
        CursoEntity c1_Curso6 = new CursoEntity(null,1006,"Temas de Filosofía",carrera1);                cursoRep.save(c1_Curso6);
        CursoEntity c1_Curso7 = new CursoEntity(null,1007,"Economía y Empresa",carrera1);                cursoRep.save(c1_Curso7);
        CursoEntity c1_Curso8 = new CursoEntity(null,1008,"Procesos Sociales y Políticos",carrera1);     cursoRep.save(c1_Curso8);

        CursoEntity c2_Curso1 = new CursoEntity(null,2001,"Fundamentos de Administración",carrera2);         cursoRep.save(c2_Curso1);
        CursoEntity c2_Curso2 = new CursoEntity(null,2002,"Gerencia de Proyectos",carrera2);                 cursoRep.save(c2_Curso2);
        CursoEntity c2_Curso3 = new CursoEntity(null,2003,"Gestión Financiera",carrera2);                    cursoRep.save(c2_Curso3);
        CursoEntity c2_Curso4 = new CursoEntity(null,2004,"Comportamiento Organizacional",carrera2);         cursoRep.save(c2_Curso4);
        CursoEntity c2_Curso5 = new CursoEntity(null,2005,"Gerencia de Ventas",carrera2);                    cursoRep.save(c2_Curso5);
        CursoEntity c2_Curso6 = new CursoEntity(null,2006,"Gerencia de Personas",carrera2);                  cursoRep.save(c2_Curso6);
        CursoEntity c2_Curso7 = new CursoEntity(null,2007,"Gestión del Comercio Internacional",carrera2);    cursoRep.save(c2_Curso7);
        CursoEntity c2_Curso8 = new CursoEntity(null,2008,"Modelos para la Toma de Decisiones",carrera2);    cursoRep.save(c2_Curso8);

        CursoEntity c3_Curso1 = new CursoEntity(null,3001,"Auditoría Interna y Gestión de Riesgos",carrera3);        cursoRep.save(c3_Curso1);
        CursoEntity c3_Curso2 = new CursoEntity(null,3002,"Auditoría Financiera I",carrera3);                        cursoRep.save(c3_Curso2);
        CursoEntity c3_Curso3 = new CursoEntity(null,3003,"Auditoría Financiera II",carrera3);                       cursoRep.save(c3_Curso3);
        CursoEntity c3_Curso4 = new CursoEntity(null,3004,"Contabilidad General",carrera3);                          cursoRep.save(c3_Curso4);
        CursoEntity c3_Curso5 = new CursoEntity(null,3005,"Contabilidad Financiera Avanzada",carrera3);              cursoRep.save(c3_Curso5);
        CursoEntity c3_Curso6 = new CursoEntity(null,3006,"Contabilidad Financiera de Grupos Económicos",carrera3);  cursoRep.save(c3_Curso6);
        CursoEntity c3_Curso7 = new CursoEntity(null,3007,"Mercado de Valores",carrera3);                            cursoRep.save(c3_Curso7);
        CursoEntity c3_Curso8 = new CursoEntity(null,3008,"Estadística Empresarial",carrera3);                       cursoRep.save(c3_Curso8);

        CursoEntity c4_Curso1 = new CursoEntity(null,4001,"Economía del Desarrollo",carrera4);                   cursoRep.save(c4_Curso1);
        CursoEntity c4_Curso2 = new CursoEntity(null,4002,"Economía Peruana",carrera4);                          cursoRep.save(c4_Curso2);
        CursoEntity c4_Curso3 = new CursoEntity(null,4003,"Teoría de Juegos",carrera4);                          cursoRep.save(c4_Curso3);
        CursoEntity c4_Curso4 = new CursoEntity(null,4004,"Economía Internacional",carrera4);                    cursoRep.save(c4_Curso4);
        CursoEntity c4_Curso5 = new CursoEntity(null,4005,"Banca",carrera4);                                     cursoRep.save(c4_Curso5);
        CursoEntity c4_Curso6 = new CursoEntity(null,4006,"Econometría",carrera4);                               cursoRep.save(c4_Curso6);
        CursoEntity c4_Curso7 = new CursoEntity(null,4007,"Tópicos Especiales en Economía Aplicada",carrera4);   cursoRep.save(c4_Curso7);
        CursoEntity c4_Curso8 = new CursoEntity(null,4008,"Teoría y Política Monetaria",carrera4);               cursoRep.save(c4_Curso8);

        CursoEntity c5_Curso1 = new CursoEntity(null,5001,"Antropología del Consumidor",carrera5);              cursoRep.save(c5_Curso1);
        CursoEntity c5_Curso2 = new CursoEntity(null,5002,"Investigación Cualitativa de Mercados",carrera5);    cursoRep.save(c5_Curso2);
        CursoEntity c5_Curso3 = new CursoEntity(null,5003,"Investigación Cuantitativa de Mercados",carrera5);   cursoRep.save(c5_Curso3);
        CursoEntity c5_Curso4 = new CursoEntity(null,5004,"Branding",carrera5);                                 cursoRep.save(c5_Curso4);
        CursoEntity c5_Curso5 = new CursoEntity(null,5005,"Gerencia de Marketing",carrera5);                    cursoRep.save(c5_Curso5);
        CursoEntity c5_Curso6 = new CursoEntity(null,5006,"Estrategias de Marketing",carrera5);                 cursoRep.save(c5_Curso6);
        CursoEntity c5_Curso7 = new CursoEntity(null,5007,"Marketing Internacional",carrera5);                  cursoRep.save(c5_Curso7);
        CursoEntity c5_Curso8 = new CursoEntity(null,5008,"Neuromarketing",carrera5);                           cursoRep.save(c5_Curso8);

        CursoEntity c6_Curso1 = new CursoEntity(null,6001,"International Relations",carrera6);              cursoRep.save(c6_Curso1);
        CursoEntity c6_Curso2 = new CursoEntity(null,6002,"Exportación, Importación y Aduanas",carrera6);   cursoRep.save(c6_Curso2);
        CursoEntity c6_Curso3 = new CursoEntity(null,6003,"Negocios Digitales",carrera6);                   cursoRep.save(c6_Curso3);
        CursoEntity c6_Curso4 = new CursoEntity(null,6004,"Interculturalidad en los Negocios",carrera6);    cursoRep.save(c6_Curso4);
        CursoEntity c6_Curso5 = new CursoEntity(null,6005,"Global Human Resources",carrera6);               cursoRep.save(c6_Curso5);
        CursoEntity c6_Curso6 = new CursoEntity(null,6006,"Muiltimodalidad Internacional",carrera6);        cursoRep.save(c6_Curso6);
        CursoEntity c6_Curso7 = new CursoEntity(null,6007,"Strategic Alliances",carrera6);                  cursoRep.save(c6_Curso7);
        CursoEntity c6_Curso8 = new CursoEntity(null,6008,"Dirección Logística Global",carrera6);           cursoRep.save(c6_Curso8);

        CursoEntity c7_Curso1 = new CursoEntity(null,7001,"Storytelling",carrera7);                 cursoRep.save(c7_Curso1);
        CursoEntity c7_Curso2 = new CursoEntity(null,7002,"Lenguaje Audiovisual",carrera7);         cursoRep.save(c7_Curso2);
        CursoEntity c7_Curso3 = new CursoEntity(null,7003,"Técnica Fotográfica",carrera7);          cursoRep.save(c7_Curso3);
        CursoEntity c7_Curso4 = new CursoEntity(null,7004,"Medios y Opinión Pública",carrera7);     cursoRep.save(c7_Curso4);
        CursoEntity c7_Curso5 = new CursoEntity(null,7005,"Creatividad Publicitaria",carrera7);     cursoRep.save(c7_Curso5);
        CursoEntity c7_Curso6 = new CursoEntity(null,7006,"Periodismo de Investigación",carrera7);  cursoRep.save(c7_Curso6);
        CursoEntity c7_Curso7 = new CursoEntity(null,7007,"Taller de Animación Digital",carrera7);  cursoRep.save(c7_Curso7);
        CursoEntity c7_Curso8 = new CursoEntity(null,7008,"Taller de Cine",carrera7);               cursoRep.save(c7_Curso8);

        CursoEntity c8_Curso1 = new CursoEntity(null,8001,"Introducción a la Ciencia Política",carrera8);   cursoRep.save(c8_Curso1);
        CursoEntity c8_Curso2 = new CursoEntity(null,8002,"Derecho Romano",carrera8);                       cursoRep.save(c8_Curso2);
        CursoEntity c8_Curso3 = new CursoEntity(null,8003,"Derecho Penal",carrera8);                        cursoRep.save(c8_Curso3);
        CursoEntity c8_Curso4 = new CursoEntity(null,8004,"Derecho Constitucional",carrera8);               cursoRep.save(c8_Curso4);
        CursoEntity c8_Curso5 = new CursoEntity(null,8005,"Derecho Comercial",carrera8);                    cursoRep.save(c8_Curso5);
        CursoEntity c8_Curso6 = new CursoEntity(null,8006,"Derecho Laboral",carrera8);                      cursoRep.save(c8_Curso6);
        CursoEntity c8_Curso7 = new CursoEntity(null,8007,"Derecho Internacional Público",carrera8);        cursoRep.save(c8_Curso7);
        CursoEntity c8_Curso8 = new CursoEntity(null,8008,"Derecho Bancario",carrera8);                     cursoRep.save(c8_Curso8);

        CursoEntity c9_Curso1 = new CursoEntity(null,9001,"Gráfica Digital",carrera9);                      cursoRep.save(c9_Curso1);
        CursoEntity c9_Curso2 = new CursoEntity(null,9002,"Dibujo y Presentación de Proyectos",carrera9);   cursoRep.save(c9_Curso2);
        CursoEntity c9_Curso3 = new CursoEntity(null,9003,"Orientación Estructural",carrera9);              cursoRep.save(c9_Curso3);
        CursoEntity c9_Curso4 = new CursoEntity(null,9004,"Urbanismo",carrera9);                            cursoRep.save(c9_Curso4);
        CursoEntity c9_Curso5 = new CursoEntity(null,9005,"Historia de la Arquitectura Peruana",carrera9);  cursoRep.save(c9_Curso5);
        CursoEntity c9_Curso6 = new CursoEntity(null,9006,"Diseño de la Vivienda",carrera9);                cursoRep.save(c9_Curso6);
        CursoEntity c9_Curso7 = new CursoEntity(null,9007,"Instalaciones",carrera9);                        cursoRep.save(c9_Curso7);
        CursoEntity c9_Curso8 = new CursoEntity(null,9008,"Diseño Lumínico Aritectónico",carrera9);         cursoRep.save(c9_Curso8);

        CursoEntity c10_Curso1 = new CursoEntity(null,10001,"Geología",carrera10);                          cursoRep.save(c10_Curso1);
        CursoEntity c10_Curso2 = new CursoEntity(null,10002,"Topografía",carrera10);                        cursoRep.save(c10_Curso2);
        CursoEntity c10_Curso3 = new CursoEntity(null,10003,"Mecánica de Suelos",carrera10);                cursoRep.save(c10_Curso3);
        CursoEntity c10_Curso4 = new CursoEntity(null,10004,"Resistencia de Materiales",carrera10);         cursoRep.save(c10_Curso4);
        CursoEntity c10_Curso5 = new CursoEntity(null,10005,"Mecánica de Fluidos",carrera10);               cursoRep.save(c10_Curso5);
        CursoEntity c10_Curso6 = new CursoEntity(null,10006,"Hidráulica",carrera10);                        cursoRep.save(c10_Curso6);
        CursoEntity c10_Curso7 = new CursoEntity(null,10007,"Ingeniería Sismorresistente",carrera10);       cursoRep.save(c10_Curso7);
        CursoEntity c10_Curso8 = new CursoEntity(null,10008,"Estructuras Metalicas y de Madera",carrera10); cursoRep.save(c10_Curso8);

        CursoEntity c11_Curso1 = new CursoEntity(null,11001,"Introducción al Análisis de Procesos",carrera11);  cursoRep.save(c11_Curso1);
        CursoEntity c11_Curso2 = new CursoEntity(null,11002,"Quimica Industrial",carrera11);                    cursoRep.save(c11_Curso2);
        CursoEntity c11_Curso3 = new CursoEntity(null,11003,"Termodinámica",carrera11);                         cursoRep.save(c11_Curso3);
        CursoEntity c11_Curso4 = new CursoEntity(null,11004,"Operaciones y Procesos Unitarios",carrera11);      cursoRep.save(c11_Curso4);
        CursoEntity c11_Curso5 = new CursoEntity(null,11005,"Tecnología Industrial",carrera11);                 cursoRep.save(c11_Curso5);
        CursoEntity c11_Curso6 = new CursoEntity(null,11006,"Automatización Industrial",carrera11);             cursoRep.save(c11_Curso6);
        CursoEntity c11_Curso7 = new CursoEntity(null,11007,"Gestión de Mantenimiento",carrera11);              cursoRep.save(c11_Curso7);
        CursoEntity c11_Curso8 = new CursoEntity(null,11008,"Materiales Industriales",carrera11);               cursoRep.save(c11_Curso8);

        CursoEntity c12_Curso1 = new CursoEntity(null,12001,"Introducción a la Programación",carrera12);                        cursoRep.save(c12_Curso1);
        CursoEntity c12_Curso2 = new CursoEntity(null,12002,"Programación Orientada a Objetos",carrera12);                      cursoRep.save(c12_Curso2);
        CursoEntity c12_Curso3 = new CursoEntity(null,12003,"Estructura de Datos y Algoritmos",carrera12);                      cursoRep.save(c12_Curso3);
        CursoEntity c12_Curso4 = new CursoEntity(null,12004,"Redes de Computadoras",carrera12);                                 cursoRep.save(c12_Curso4);
        CursoEntity c12_Curso5 = new CursoEntity(null,12005,"Ingeniería de Software",carrera12);                                cursoRep.save(c12_Curso5);
        CursoEntity c12_Curso6 = new CursoEntity(null,12006,"Sistemas ERP",carrera12);                                          cursoRep.save(c12_Curso6);
        CursoEntity c12_Curso7 = new CursoEntity(null,12007,"Gestión de Servicios de Tecnología de Información",carrera12);     cursoRep.save(c12_Curso7);
        CursoEntity c12_Curso8 = new CursoEntity(null,12008,"Seguridad de Sistemas de Tecnología de Información",carrera12);    cursoRep.save(c12_Curso8);

        CursoEntity c13_Curso1 = new CursoEntity(null,13001,"Psicobiologia Humana",carrera13);                  cursoRep.save(c13_Curso1);
        CursoEntity c13_Curso2 = new CursoEntity(null,13002,"Sexualidad Humana",carrera13);                     cursoRep.save(c13_Curso2);
        CursoEntity c13_Curso3 = new CursoEntity(null,13003,"Técnicas de Entrevista y Observación",carrera13);  cursoRep.save(c13_Curso3);
        CursoEntity c13_Curso4 = new CursoEntity(null,13004,"Psicopatologia",carrera13);                        cursoRep.save(c13_Curso4);
        CursoEntity c13_Curso5 = new CursoEntity(null,13005,"Psicologia Educativa",carrera13);                  cursoRep.save(c13_Curso5);
        CursoEntity c13_Curso6 = new CursoEntity(null,13006,"Evaluación Psicopedagógica",carrera13);            cursoRep.save(c13_Curso6);
        CursoEntity c13_Curso7 = new CursoEntity(null,13007,"Psicologia Instruccional",carrera13);              cursoRep.save(c13_Curso7);
        CursoEntity c13_Curso8 = new CursoEntity(null,13008,"Orientación Vocacional y Ocupacional",carrera13);  cursoRep.save(c13_Curso8);

        // PERIODOS:
        PeriodoEntity periodo1 = new PeriodoEntity(null,"2017-I",2017);     periodoRep.save(periodo1);
        PeriodoEntity periodo2 = new PeriodoEntity(null,"2017-II",2017);    periodoRep.save(periodo2);
        PeriodoEntity periodo3 = new PeriodoEntity(null,"2018-I",2018);     periodoRep.save(periodo3);
        PeriodoEntity periodo4 = new PeriodoEntity(null,"2018-II",2018);    periodoRep.save(periodo4);
        PeriodoEntity periodo5 = new PeriodoEntity(null,"2019-I",2019);     periodoRep.save(periodo5);
        PeriodoEntity periodo6 = new PeriodoEntity(null,"2019-II",2019);    periodoRep.save(periodo6);
        PeriodoEntity periodo7 = new PeriodoEntity(null,"2020-I",2020);     periodoRep.save(periodo7);
        PeriodoEntity periodo8 = new PeriodoEntity(null,"2020-II",2020);    periodoRep.save(periodo8);

        // TIPOS PROFESORES:
        ProfesorTipoEntity tipo1 = new ProfesorTipoEntity(null,"Profesor");             tiposRep.save(tipo1);
        ProfesorTipoEntity tipo2 = new ProfesorTipoEntity(null,"Jefe de Prácticas");    tiposRep.save(tipo2);

        // ALUMNOS:
        AlumnoEntity alumno1 = new AlumnoEntity(null,20173527,"Andy","Lazo",
                "20173527@aloe.ulima.edu.pe","andyLazo@hotmail.com",
                "andy","andyl","154165171","fotito.jpe",genero1,carrera12,pais1);

        AlumnoEntity alumno2 = new AlumnoEntity(null,20173240,"Dante","Cordova",
                "20173240@aloe.ulima.edu.pe","DanteCordova@hotmail.com",
                "dante","danteC","154165184","fotito.jpe",genero1,carrera6,pais1);

        AlumnoEntity alumno3 = new AlumnoEntity(null,20170001,"Nombre3","Apellido3",
                "20170001@aloe.ulima.edu.pe","correo3@hotmail.com",
                "user3","pw3","1541985171","fotito.jpe",genero1,carrera7,pais3);

        AlumnoEntity alumno4 = new AlumnoEntity(null,20170002,"Nombre4","Apellido4",
                "20170002@aloe.ulima.edu.pe","correo4@hotmail.com",
                "user4","pw4","151005171","fotito.jpe",genero2,carrera12,pais2);

        AlumnoEntity alumno5 = new AlumnoEntity(null,20170003,"Nombre5","Apellido5",
                "20170003@aloe.ulima.edu.pe","correo5@hotmail.com",
                "user5","pw4","154163571","fotito.jpe",genero2,carrera7,pais1);

        alumnoRep.save(alumno1);
        alumnoRep.save(alumno2);
        alumnoRep.save(alumno3);
        alumnoRep.save(alumno4);
        alumnoRep.save(alumno5);

        // SECCIONES:
        SeccionEntity seccion1 = new SeccionEntity(null,101,c3_Curso2,periodo8);    seccionRep.save(seccion1);
        SeccionEntity seccion2 = new SeccionEntity(null,102,c7_Curso8,periodo7);    seccionRep.save(seccion2);
        SeccionEntity seccion3 = new SeccionEntity(null,103,c6_Curso5,periodo8);    seccionRep.save(seccion3);

        // PROFESORES:
        ProfesorEntity profesor1 = new ProfesorEntity(null,2015065,"Hernan","Quintana",
                "2015065@aloe.ulima.edu.pe","HQuintana@hotmail.com","fotito.jpe",genero1,pais1,tipo1);
        ProfesorEntity profesor2 = new ProfesorEntity(null,2015066,"Hernan2","Quintana2",
                "2015066@aloe.ulima.edu.pe","HQuintana2@hotmail.com","fotito.jpe",genero1,pais2,tipo1);

        profesoresRep.save(profesor1);
        profesoresRep.save(profesor2);

        // RELACIONES:
        List<AlumnoEntity> listaAlumno1 = new ArrayList<>();
        listaAlumno1.add(alumno1);
        listaAlumno1.add(alumno2);
        listaAlumno1.add(alumno3);

        List<AlumnoEntity> listaAlumno2 = new ArrayList<>();
        listaAlumno2.add(alumno2);
        listaAlumno2.add(alumno5);

        List<AlumnoEntity> listaAlumno3 = new ArrayList<>();
        listaAlumno3.add(alumno1);
        listaAlumno3.add(alumno4);

        seccion1.setAlumnos(listaAlumno1);  seccionRep.save(seccion1);
        seccion2.setAlumnos(listaAlumno2);  seccionRep.save(seccion2);
        seccion3.setAlumnos(listaAlumno3);  seccionRep.save(seccion3);

        List<ProfesorEntity> profe1 = new ArrayList<>();
        profe1.add(profesor1);

        List<ProfesorEntity> profe2 = new ArrayList<>();
        profe2.add(profesor2);

        seccion1.setProfesor(profe1);    seccionRep.save(seccion1);
        seccion2.setProfesor(profe2);    seccionRep.save(seccion2);
        seccion3.setProfesor(profe1);    seccionRep.save(seccion3);

        UsuarioAlumnoEntity userAlum1 = new UsuarioAlumnoEntity(null,"User1","Pass1",alumno2);  usuarioRep.save(userAlum1);
        UsuarioAlumnoEntity userAlum2 = new UsuarioAlumnoEntity(null,"User2","Pass2",alumno3);  usuarioRep.save(userAlum2);

        UsuarioProfesorEntity userProf1 = new UsuarioProfesorEntity(null,"User3","Pass3",profesor1);    usuarioRep.save(userProf1);
        UsuarioProfesorEntity userProf2 = new UsuarioProfesorEntity(null,"User4","Pass4",profesor2);    usuarioRep.save(userProf2);

        UsuarioAdministradorEntity userAdm1 = new UsuarioAdministradorEntity(null,"Nyo","Byte");        usuarioRep.save(userAdm1);
        UsuarioAdministradorEntity userAdm2 = new UsuarioAdministradorEntity(null,"Admin2","Pass6");    usuarioRep.save(userAdm2);
        UsuarioAdministradorEntity userAdm3 = new UsuarioAdministradorEntity(null,"Admin3","Pass7");    usuarioRep.save(userAdm3);


        int id = 20250000;
        int ad = 888888880;
        for(int i=6; i<30; i++){
            String idString = String.valueOf(i);
            AlumnoEntity alumno = new AlumnoEntity(null,id+i,"Nombre"+idString,"Apellido5"+idString,
                    String.valueOf(id+i)+"@aloe.ulima.edu.pe","correo"+idString+"@hotmail.com",
                    "user"+idString,"pw"+idString,String.valueOf(ad+i),"fotito.jpe",genero2,carrera7,pais1);
            alumnoRep.save(alumno);
        }*/
    }
}
