/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.web;

import com.biblioteca.model.Genero;
import com.biblioteca.model.Libro;
import com.biblioteca.servicios.GeneroService;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "generoMB")
//@RequestScoped
@ApplicationScoped
public class GeneroManagedBean {

    //BIEN
    private Collection<Genero> coleccionGenero;
    private GeneroService g = new GeneroService();
    private String generoSeleccionado;
    
    public GeneroManagedBean() {
        this.coleccionGenero = g.getAllGeneros();
//        inicializar();
    }
    
//    @PostConstruct
//    public void inicializar(){
//        this.coleccionGenero = g.getAllGeneros();
//    }
    
    //bien
    public Collection<Genero> getColeccionGenero() {
        return coleccionGenero;
    }

    public String getGeneroSeleccionado() {
        return generoSeleccionado;
    }

    public void setEmailSeleccionado(String generoSeleccionado) {
        this.generoSeleccionado = generoSeleccionado;
    }
    
    public String altaGenero(){
        //crear un obj Genero con el id y descripcion
        int id = coleccionGenero.size() + 1;
        Genero gen = new Genero(id, generoSeleccionado);
        //graba en bd
        GeneroService serv = new GeneroService();
        //refrescar otra vez la lista
        return "lista-genero";
    }
    
}
