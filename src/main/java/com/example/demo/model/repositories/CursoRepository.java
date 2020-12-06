package com.example.demo.model.repositories;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    @Query(value = "SELECT * FROM Cursos c WHERE c.Código=:cod",nativeQuery = true)
    CursoEntity findByCod(int cod);
}
