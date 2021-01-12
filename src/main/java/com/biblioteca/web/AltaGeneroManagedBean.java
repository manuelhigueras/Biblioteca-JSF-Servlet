package com.biblioteca.web;

import com.biblioteca.excepciones.DBException;
import com.biblioteca.model.Genero;
import com.biblioteca.servicios.GenerosService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "altaGeneroMB")
@RequestScoped
public class AltaGeneroManagedBean {

    private Genero generoNuevo;
    private GenerosService genService = new GenerosService();
    @Inject
    private GenerosManagedBean generosMB;
  
    public AltaGeneroManagedBean() {
        this.generoNuevo = new Genero();
    }

    public Genero getGeneroNuevo() {
        return generoNuevo;
    }

    public void setGeneroNuevo(Genero generoNuevo) {
        this.generoNuevo = generoNuevo;
    }
    
    public String altaGenero(){
        
        try {
            //grabar en bd
            genService.altaGenero(generoNuevo);
            //refrescar
            generosMB.inicializar();            
            return "lista-generos";
        } catch (DBException ex) {
             System.out.println("... no grabo genro " + ex.getMessage());
             return "alta-genero";
        }
    }
    
}
