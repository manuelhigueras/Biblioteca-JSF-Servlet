
package com.biblioteca.servicios.dto;

import java.io.Serializable;

public class LibrosAlquiladosDTO implements Serializable{

    private Integer id;
    private String titulo;
    private String autor;
    private String usuarioAlquila;

    public LibrosAlquiladosDTO(Integer id, String titulo, String autor, String usuarioAlquila) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.usuarioAlquila = usuarioAlquila;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUsuarioAlquila() {
        return usuarioAlquila;
    }

    public void setUsuarioAlquila(String usuarioAlquila) {
        this.usuarioAlquila = usuarioAlquila;
    }
    
    
    
}
