package com.miniproyecto.catalogolibros.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fechaNacimiento;
    private String fechaMuerte;

    // Un autor puede tener varios libros
    @ManyToOne
    private Libro libro;

    // Constructor por defecto
    public Autor() {
    }

    // Constructor personalizado
    public Autor(List<DatosAutor> autor) {
        autor.forEach(a -> {
            this.nombre = a.nombre();
            this.fechaNacimiento = a.fechaNacimiento();
            this.fechaMuerte = a.fechaMuerte();
        });
    }

    @Override
    public String toString() {
        return """
                ------ AUTOR -------
                Nombre: %s
                Fecha de nacimiento: %s
                Fecha de muerte: %s
                Libros: %s
                --------------------
                """.formatted(nombre, fechaNacimiento, fechaMuerte, libro.getTitulo());
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
