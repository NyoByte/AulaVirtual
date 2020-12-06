package com.example.demo.model.repositories;

import com.example.demo.model.dao.AlumnoEntity;
import com.example.demo.model.dao.ProfesorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Long> {
    @Query(value = "SELECT * FROM Profesores p WHERE upper(p.Nombres) like :kw_name% or upper(p.Apellidos) like :kw_name%", nativeQuery = true)
    List<ProfesorEntity> findByKeywordName(String kw_name);

    @Query(value = "SELECT * FROM Profesores p WHERE to_char(p.Código,'fm99999999') like :kw_cod%", nativeQuery = true)
    List<ProfesorEntity> findByKeywordCode(String kw_cod);

    @Query(value = "SELECT * FROM Profesores p WHERE to_char(p.Código,'fm99999999') like :kw_cod% AND (upper(p.Nombres) like :kw_name% or upper(p.Apellidos) like :kw_name%)", nativeQuery = true)
    List<ProfesorEntity> findByKeywordNameAndCode(String kw_name, String kw_cod);

    @Query(value = "SELECT * FROM Profesores p WHERE p.type_id=1", nativeQuery = true)
    List<ProfesorEntity> findTipoProfesor();

    @Query(value = "SELECT * FROM Profesores p WHERE p.type_id=2", nativeQuery = true)
    List<ProfesorEntity> findTipoJefeDePractica();

    @Query(value = "SELECT * FROM Profesores p WHERE p.Código=:cod",nativeQuery = true)
    ProfesorEntity findByCod(int cod);

    @Query(value = "SELECT * FROM Profesores p WHERE to_char(p.Código,'fm99999999') like :kw_cod%", nativeQuery = true)
    Page<ProfesorEntity> findByKeywordCodeR(String kw_cod, Pageable pag);

    //Page<T> findAll(Pageable var1);
}
