package com.example.demo.model.repositories;

import com.example.demo.model.dao.UsuarioAdministradorEntity;
import com.example.demo.model.dao.UsuarioAlumnoEntity;
import com.example.demo.model.dao.UsuarioEntity;
import com.example.demo.model.dao.UsuarioProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = "SELECT * FROM Usuarios_Administradores",nativeQuery = true)
    List<UsuarioAdministradorEntity> findUsuarioAdministrador();

    @Query(value = "SELECT * FROM Usuarios_Alumnos",nativeQuery = true)
    List<UsuarioAlumnoEntity> findUsuarioAlumno();

    @Query(value = "SELECT * FROM Usuarios_Profesores",nativeQuery = true)
    List<UsuarioProfesorEntity> findUsuarioProfesor();
}
