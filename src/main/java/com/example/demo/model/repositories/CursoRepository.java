package com.example.demo.model.repositories;

import com.example.demo.model.dao.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
}
