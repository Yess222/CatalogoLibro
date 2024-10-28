package com.miniproyecto.catalogolibros.repository;

import com.miniproyecto.catalogolibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    @Query("SELECT l FROM Libro l WHERE :idioma MEMBER OF l.idiomas")
    List<Libro> findByIdioma(@Param("idioma") String idioma);
}
