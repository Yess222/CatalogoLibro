package com.miniproyecto.catalogolibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<String> idiomas;
    private Integer descargas;

    // Un libro tiene varios autores
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;


    public Libro() {
    }
    public Libro(DatosLibro datoslibro){
        this.titulo = datoslibro.titulo();
        this.idiomas = datoslibro.idiomas();
        this.descargas = datoslibro.descargas();
    }

    @Override
    public String toString() {
        String autorNombre = autor.stream()
                .map(Autor::getNombre)
                .collect(Collectors.joining(", "));

        return """
                ------ LIBRO -------
                Titulo: %s
                Autor: %s
                Idiomas: %s
                Numero de descargas: %d
                --------------------
                """.formatted(titulo,autorNombre, idiomas, descargas);
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {

        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }
}
