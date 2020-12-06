package com.example.demo;

import com.example.demo.model.dao.*;
import com.example.demo.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

        /*

        // PAISES:
        PaisEntity pais1 = new PaisEntity(null,"Perú");         paisRep.save(pais1);
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
        PeriodoEntity periodo9 = new PeriodoEntity(null,"2021-I",2021);     periodoRep.save(periodo9);
        PeriodoEntity periodo10 = new PeriodoEntity(null,"2021-II",2021);    periodoRep.save(periodo10);

        // TIPOS PROFESORES:
        ProfesorTipoEntity tipo1 = new ProfesorTipoEntity(null,"Profesor");             tiposRep.save(tipo1);
        ProfesorTipoEntity tipo2 = new ProfesorTipoEntity(null,"Jefe de Prácticas");    tiposRep.save(tipo2);

        // ALUMNOS:
        AlumnoEntity alumno1 = new AlumnoEntity(null,20173527,"Andy","Lazo Hilario",
                "20173527@aloe.ulima.edu.pe","andyLazo@hotmail.com",
                "10TV01","andyl","ADC001","fotito.jpe",genero1,carrera12,pais1);

        AlumnoEntity alumno2 = new AlumnoEntity(null,20173240,"Dante","Cordova Molina",
                "20173240@aloe.ulima.edu.pe","danteCordova@hotmail.com",
                "10TV02","danteC","ADC002","fotito.jpe",genero1,carrera6,pais1);

        AlumnoEntity alumno3 = new AlumnoEntity(null,20173828,"Edgar","Rodriguez Rojas",
                "20173828@aloe.ulima.edu.pe","edgarRodriguez@hotmail.com",
                "10TV03","edgarR","ADC003","fotito.jpe",genero1,carrera7,pais3);

        AlumnoEntity alumno4 = new AlumnoEntity(null,20170284,"Gabriel","Carmelo Villaverde",
                "20170284@aloe.ulima.edu.pe","gabrielCarmelo@hotmail.com",
                "10TV04","gabrielC","ADC004","fotito.jpe",genero1,carrera12,pais2);

        AlumnoEntity alumno5 = new AlumnoEntity(null,20170005,"Nombre5","Apellido5",
                "20170005@aloe.ulima.edu.pe","correo5@hotmail.com",
                "user5","pw5","cred05","fotito.jpe",genero2,carrera7,pais4);

        alumnoRep.save(alumno1);
        alumnoRep.save(alumno2);
        alumnoRep.save(alumno3);
        alumnoRep.save(alumno4);
        alumnoRep.save(alumno5);

        // SECCIONES:
        SeccionEntity seccion1 = new SeccionEntity(null,101,c3_Curso2,periodo8);    seccionRep.save(seccion1);
        SeccionEntity seccion2 = new SeccionEntity(null,102,c7_Curso8,periodo7);    seccionRep.save(seccion2);
        SeccionEntity seccion3 = new SeccionEntity(null,103,c6_Curso5,periodo8);    seccionRep.save(seccion3);
        SeccionEntity seccion4 = new SeccionEntity(null,104,c6_Curso2,periodo7);    seccionRep.save(seccion4);
        SeccionEntity seccion5 = new SeccionEntity(null,105,c8_Curso5,periodo7);    seccionRep.save(seccion5);
        SeccionEntity seccion6 = new SeccionEntity(null,106,c11_Curso7,periodo8);    seccionRep.save(seccion6);
        SeccionEntity seccion7 = new SeccionEntity(null,107,c9_Curso3,periodo8);    seccionRep.save(seccion7);

        // PROFESORES:
        ProfesorEntity profesor1 = new ProfesorEntity(null,20140147,"Hernan","Quintana Cruz",
                "hquintana@aloe.ulima.edu.pe","hernan@jsatch.com","fotito.jpe",genero1,pais1,tipo1);
        ProfesorEntity profesor2 = new ProfesorEntity(null,20152145,"Julio","Padilla Solis",
                "jpadilla@aloe.ulima.edu.pe","julioPadilla@hotmail.com","fotito.jpe",genero1,pais2,tipo1);
        ProfesorEntity profesor3 = new ProfesorEntity(null,20120478,"Andrea","Matuk Chijner",
                "amatuk@aloe.ulima.edu.pe","andreMatuk@hotmail.com","fotito.jpe",genero1,pais2,tipo1);
        ProfesorEntity profesor4 = new ProfesorEntity(null,20140157,"Julia","Agueda Valencia",
                "jagueda@aloe.ulima.edu.pe","juliaAgueda@hotmail.com","fotito.jpe",genero2,pais3,tipo1);
        //Jefes de prácticas:
        ProfesorEntity profesor5 = new ProfesorEntity(null,20152187,"Billy","Grados Licham",
                "bgrados@aloe.ulima.edu.pe","billyGrados@hotmail.com","fotito.jpe",genero1,pais4,tipo2);
        ProfesorEntity profesor6 = new ProfesorEntity(null,20135487,"Pepe","Valvidia",
                "pvalvidia@aloe.ulima.edu.pe","pepeValvidia@hotmail.com","fotito.jpe",genero1,pais1,tipo2);
        ProfesorEntity profesor7 = new ProfesorEntity(null,20152317,"Jenny","FLores Díaz",
                "jflores@aloe.ulima.edu.pe","jennyFlores@hotmail.com","fotito.jpe",genero2,pais3,tipo2);

        profesoresRep.save(profesor1);
        profesoresRep.save(profesor2);
        profesoresRep.save(profesor3);
        profesoresRep.save(profesor4);
        profesoresRep.save(profesor5);
        profesoresRep.save(profesor6);
        profesoresRep.save(profesor7);

        // RELACIONES:
        List<AlumnoEntity> listaAlumno1 = new ArrayList<>();
        listaAlumno1.add(alumno1);
        listaAlumno1.add(alumno2);
        listaAlumno1.add(alumno3);
        listaAlumno1.add(alumno4);


        List<AlumnoEntity> listaAlumno2 = new ArrayList<>();
        listaAlumno2.add(alumno2);
        listaAlumno2.add(alumno5);
        listaAlumno2.add(alumno4);

        List<AlumnoEntity> listaAlumno3 = new ArrayList<>();
        listaAlumno3.add(alumno1);
        listaAlumno3.add(alumno4);
        listaAlumno3.add(alumno2);

        List<AlumnoEntity> listaAlumno4 = new ArrayList<>();
        listaAlumno4.add(alumno2);
        listaAlumno4.add(alumno5);
        listaAlumno4.add(alumno3);

        List<AlumnoEntity> listaAlumno5 = new ArrayList<>();
        listaAlumno5.add(alumno3);
        listaAlumno5.add(alumno1);
        listaAlumno5.add(alumno2);

        List<AlumnoEntity> listaAlumno6 = new ArrayList<>();
        listaAlumno6.add(alumno5);
        listaAlumno6.add(alumno3);

        List<AlumnoEntity> listaAlumno7 = new ArrayList<>();
        listaAlumno7.add(alumno1);
        listaAlumno7.add(alumno4);

        seccion1.setAlumnos(listaAlumno1);  seccionRep.save(seccion1);
        seccion2.setAlumnos(listaAlumno2);  seccionRep.save(seccion2);
        seccion3.setAlumnos(listaAlumno3);  seccionRep.save(seccion3);
        seccion4.setAlumnos(listaAlumno4);  seccionRep.save(seccion4);
        seccion5.setAlumnos(listaAlumno5);  seccionRep.save(seccion5);
        seccion6.setAlumnos(listaAlumno6);  seccionRep.save(seccion6);
        seccion7.setAlumnos(listaAlumno7);  seccionRep.save(seccion7);


        List<ProfesorEntity> listaProfe1 = new ArrayList<>();
        listaProfe1.add(profesor1);
        listaProfe1.add(profesor5);

        List<ProfesorEntity> listaProfe2 = new ArrayList<>();
        listaProfe2.add(profesor2);
        listaProfe2.add(profesor1);

        List<ProfesorEntity> listaProfe3 = new ArrayList<>();
        listaProfe3.add(profesor1);
        listaProfe1.add(profesor6);

        List<ProfesorEntity> listaProfe4 = new ArrayList<>();
        listaProfe4.add(profesor2);

        List<ProfesorEntity> listaProfe5 = new ArrayList<>();
        listaProfe5.add(profesor3);
        listaProfe5.add(profesor6);

        List<ProfesorEntity> listaProfe6 = new ArrayList<>();
        listaProfe6.add(profesor4);

        List<ProfesorEntity> listaProfe7 = new ArrayList<>();
        listaProfe7.add(profesor2);
        listaProfe7.add(profesor7);

        seccion1.setProfesor(listaProfe1);    seccionRep.save(seccion1);
        seccion2.setProfesor(listaProfe2);    seccionRep.save(seccion2);
        seccion3.setProfesor(listaProfe3);    seccionRep.save(seccion3);
        seccion4.setProfesor(listaProfe4);    seccionRep.save(seccion4);
        seccion5.setProfesor(listaProfe5);    seccionRep.save(seccion5);
        seccion6.setProfesor(listaProfe6);    seccionRep.save(seccion6);
        seccion7.setProfesor(listaProfe7);    seccionRep.save(seccion7);

        UsuarioAlumnoEntity userAlum1 = new UsuarioAlumnoEntity(null,"20173527@aloe.ulima.edu.pe","20173527",alumno1);  usuarioRep.save(userAlum1);
        UsuarioAlumnoEntity userAlum2 = new UsuarioAlumnoEntity(null,"20173240@aloe.ulima.edu.pe","20173240",alumno2);  usuarioRep.save(userAlum2);
        UsuarioAlumnoEntity userAlum3 = new UsuarioAlumnoEntity(null,"20173828@aloe.ulima.edu.pe","20173828",alumno3);  usuarioRep.save(userAlum3);
        UsuarioAlumnoEntity userAlum4 = new UsuarioAlumnoEntity(null,"20170284@aloe.ulima.edu.pe","20170284",alumno4);  usuarioRep.save(userAlum4);
        UsuarioAlumnoEntity userAlum5 = new UsuarioAlumnoEntity(null,"20170005@aloe.ulima.edu.pe","20170005",alumno5);  usuarioRep.save(userAlum5);

        UsuarioProfesorEntity userProf1 = new UsuarioProfesorEntity(null,"hquintana@aloe.ulima.edu.pe","20140147",profesor1);   usuarioRep.save(userProf1);
        UsuarioProfesorEntity userProf2 = new UsuarioProfesorEntity(null,"jpadilla@aloe.ulima.edu.pe","20152145",profesor2);    usuarioRep.save(userProf2);
        UsuarioProfesorEntity userProf3 = new UsuarioProfesorEntity(null,"amatuk@aloe.ulima.edu.pe","20120478",profesor3);      usuarioRep.save(userProf3);
        UsuarioProfesorEntity userProf4 = new UsuarioProfesorEntity(null,"jaqueda@aloe.ulima.edu.pe","20140157",profesor4);     usuarioRep.save(userProf4);
        UsuarioProfesorEntity userProf5 = new UsuarioProfesorEntity(null,"bgrados@aloe.ulima.edu.pe","20152184",profesor5);     usuarioRep.save(userProf5);
        UsuarioProfesorEntity userProf6 = new UsuarioProfesorEntity(null,"pvalvidia@aloe.ulima.edu.pe","20135487",profesor6);  usuarioRep.save(userProf6);
        UsuarioProfesorEntity userProf7 = new UsuarioProfesorEntity(null,"jflores@aloe.ulima.edu.pe","20152317",profesor7);     usuarioRep.save(userProf7);

        UsuarioAdministradorEntity userAdm1 = new UsuarioAdministradorEntity(null,"Nyo","Byte");            usuarioRep.save(userAdm1);
        UsuarioAdministradorEntity userAdm2 = new UsuarioAdministradorEntity(null,"Gabu","Gato");           usuarioRep.save(userAdm2);
        UsuarioAdministradorEntity userAdm3 = new UsuarioAdministradorEntity(null,"Jsatch","HernanWeb");    usuarioRep.save(userAdm3);
        UsuarioAdministradorEntity userAdm4 = new UsuarioAdministradorEntity(null,"Beater","Zuko");         usuarioRep.save(userAdm4);

         */


        /*
        int id = 20250000;
        int ad = 888888880;
        for(int i=6; i<30; i++){
            String idString = String.valueOf(i);
            AlumnoEntity alumno = new AlumnoEntity(null,id+i,"Nombre"+idString,"Apellido5"+idString,
                    String.valueOf(id+i)+"@aloe.ulima.edu.pe","correo"+idString+"@hotmail.com",
                    "user"+idString,"pw"+idString,String.valueOf(ad+i),"fotito.jpe",genero2,carrera7,pais1);
            alumnoRep.save(alumno);
        }

        /*int cod = 104;
        Optional<CursoEntity> cursox = cursoRep.findById(Long.valueOf(98));
        Optional<PeriodoEntity> periodox = periodoRep.findById(Long.valueOf(7));
        for(int i=0; i<27; i++) {
            SeccionEntity sec1 = new SeccionEntity(null, cod+i, cursox.get(), periodox.get());
            seccionRep.save(sec1);
        }*/

        /*int cod = 2080000;
        for(int i=0; i<27; i++) {
            ProfesorEntity profesor1 = new ProfesorEntity(null, cod+i, "XXXX", "YYYY",
                    String.valueOf(cod+i)+"@aloe.ulima.edu.pe", String.valueOf(cod+i)+"@hotmail.com", "fotito.jpe");
            profesoresRep.save(profesor1);
        }*/
    }
}
