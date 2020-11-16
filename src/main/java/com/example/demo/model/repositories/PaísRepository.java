package com.example.demo.model.repositories;

import com.example.demo.model.dao.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaísRepository extends JpaRepository<PaisEntity, Long> {
}
