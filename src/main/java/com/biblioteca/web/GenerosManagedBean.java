
package com.biblioteca.web;

import com.biblioteca.model.Genero;
import com.biblioteca.servicios.GenerosService;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "generosMB")
@ApplicationScoped
public class GenerosManagedBean {
    
    private Collection<Genero> collecionGeneros;
    private GenerosService servicio = new GenerosService();
            
    public GenerosManagedBean() {
        System.out.println("************** instanciando un GenerosManagedBean");
    }
    
    @PostConstruct
    public void inicializar(){
        System.out.println("............. inicializando  un GenerosManagedBean");
        this.collecionGeneros = servicio.getGeneros();
    }
    

    public Collection<Genero> getCollecionGeneros() {
        return collecionGeneros;
    }
   
    
}
