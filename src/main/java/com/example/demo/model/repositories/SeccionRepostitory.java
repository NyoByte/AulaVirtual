package com.example.demo.model.repositories;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.SeccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeccionRepostitory extends JpaRepository<SeccionEntity, Long> {
    @Query(value = "SELECT * FROM Secciones s WHERE s.Código=:cod",nativeQuery = true)
    SeccionEntity findByCod(int cod);
}
