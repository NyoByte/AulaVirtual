package com.example.demo.model.repositories;

import com.example.demo.model.dao.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {
}
