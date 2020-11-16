package com.example.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.dao.AlumnoEntity;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
}
