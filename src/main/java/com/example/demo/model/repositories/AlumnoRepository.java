package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.dao.AlumnoEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
    @Query(value = "SELECT * FROM Alumnos a WHERE upper(a.Nombres) like %:kw_name% or upper(a.Apellidos) like %:kw_name%", nativeQuery = true)
    List<AlumnoEntity> findByKeywordName(String kw_name);

    @Query(value = "SELECT * FROM Alumnos a WHERE to_char(a.Código,'fm99999999') like %:kw_cod%", nativeQuery = true)
    List<AlumnoEntity> findByKeywordCode(String kw_cod);

    @Query(value = "SELECT * FROM Alumnos a WHERE to_char(a.Código,'fm99999999') like %:kw_cod% AND (upper(a.Nombres) like :kw_name% or upper(a.Apellidos) like :kw_name%)", nativeQuery = true)
    List<AlumnoEntity> findByKeywordNameAndCode(String kw_name, String kw_cod);
}
