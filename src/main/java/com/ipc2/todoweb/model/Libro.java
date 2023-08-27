package com.ipc2.todoweb.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString
@NoArgsConstructor
public class Libro {

    public Libro(int isbn, String nombre, float precio, String autor, int categoria) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.autor = autor;
    }

    private int isbn;
    private String nombre;
    private float precio;
    private int categoria;
    private String autor;

}
