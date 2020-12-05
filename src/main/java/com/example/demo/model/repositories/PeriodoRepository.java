package com.example.demo.model.repositories;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.PeriodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeriodoRepository extends JpaRepository<PeriodoEntity, Long> {
    @Query(value = "SELECT * FROM Periodos p WHERE p.Año=:year",nativeQuery = true)
    List<PeriodoEntity> findByYear(int year);
}
