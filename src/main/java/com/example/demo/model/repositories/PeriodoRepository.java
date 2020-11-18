package com.example.demo.model.repositories;

import com.example.demo.model.dao.PeriodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<PeriodoEntity, Long> {
}
