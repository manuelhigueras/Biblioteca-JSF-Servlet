package com.biblioteca.web;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.servicios.LibrosService;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "librosMB")
@RequestScoped
public class LibrosManagedBean {

    private Collection<Libro>  coleccionLibros;
    private Collection<Usuario>  coleccionUsuarios;
    
    private LibrosService servicio = new LibrosService();    
    private String emailSeleccionado ;
    
    public LibrosManagedBean() {
        this.coleccionLibros = servicio.getAllLibros();
        this.coleccionUsuarios = servicio.getAllUsuarios();
    }

    public Collection<Libro> getColeccionLibros() {
        return coleccionLibros;
    }

    public Collection<Usuario> getColeccionUsuarios() {
        return coleccionUsuarios;
    }
    
    public String getEmailSeleccionado() {
        return emailSeleccionado;
    }

    public void setEmailSeleccionado(String emailSeleccionado) {
        this.emailSeleccionado = emailSeleccionado;
    }

    //action
    public String alquilar(int id){
        servicio.alquilar(id, emailSeleccionado);
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage("Alquiló el libro a " + this.emailSeleccionado);
        ctx.addMessage(null, msg);
        return "lista-libros-alquilados";
    }
}
