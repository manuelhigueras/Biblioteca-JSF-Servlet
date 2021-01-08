package com.biblioteca.web;

import com.biblioteca.model.Libro;
import com.biblioteca.servicios.LibrosService;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "librosAlquiladosMB")
@RequestScoped
public class LibrosAlquiladosManagedBean {

    private String emailLogeado = "begona@gmail.com";
    private Collection<Libro> collectionAlquilados;
   private LibrosService servicio = new LibrosService();    
    
    public LibrosAlquiladosManagedBean() {
        this.collectionAlquilados = servicio.getLibrosAlquilados(emailLogeado);
    }

    public Collection<Libro> getCollectionAlquilados() {
        return collectionAlquilados;
    }

}
