package com.miniproyecto.catalogolibros.repository;

import com.miniproyecto.catalogolibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    @Query("SELECT a FROM Autor a WHERE a.fechaMuerte >= :fechaMuerte")
    List<Autor> autoresVivos(String fechaMuerte);
}
