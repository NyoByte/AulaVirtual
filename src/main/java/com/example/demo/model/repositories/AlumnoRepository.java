package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.dao.AlumnoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
    @Query(value = "SELECT * FROM Alumnos a WHERE a.Nombres like %:keyword% or a.Apellidos like %:keyword%", nativeQuery = true)
    List<AlumnoEntity> findByKeyword(@Param("keyword") String keyword);
}
