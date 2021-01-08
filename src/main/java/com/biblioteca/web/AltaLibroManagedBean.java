package com.biblioteca.web;

import com.biblioteca.excepciones.DBException;
import com.biblioteca.model.Libro;
import com.biblioteca.servicios.LibrosService;

import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
//import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;


@ManagedBean(name = "altaLibro")
@RequestScoped
public class AltaLibroManagedBean {
    //atributos
    private Libro libroNuevo;
    
    //Logger
    private Logger log = Logger.getLogger("AltaLibroManagedBean");
  
    public AltaLibroManagedBean() {
        this.libroNuevo = new Libro();        
    }
    
    //getters y setters
    public Libro getLibroNuevo() {
        return libroNuevo;
    }

    public void setLibroNuevo(Libro libroNuevo) {
        this.libroNuevo = libroNuevo;
    }
    
    //acciones 
    public String altaLibro(){
        //libroNuevo ya tiene datos
        LibrosService s = new LibrosService();
        libroNuevo.setDisponible(true);
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            s.altaLibro(libroNuevo);
            log.info("****Alta libro ok");
            
            FacesMessage msg = new FacesMessage("Alta libro ok");
            ctx.addMessage(null, msg);
            return "lista-libros";
        } catch (DBException ex) {
            log.severe("***No dio de alta libro. " + ex.getMessage());
            FacesMessage msg = new FacesMessage("Falló alta libro. " + ex.getMessage());
            ctx.addMessage(null, msg);
            return "alta-libro";
        }
    }
    
}
