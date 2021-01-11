package com.biblioteca.web;

import com.biblioteca.servicios.LibrosService;
import com.biblioteca.servicios.dto.LibrosAlquiladosDTO;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "librosAlquiladosMB")
@RequestScoped
public class LibrosAlquiladosManagedBean {

   //ATRIBUTOS 
   private String emailLogeado = "begona@gmail.com";
   private Collection<LibrosAlquiladosDTO> collectionAlquilados;
   private LibrosService servicio = new LibrosService();
   private boolean todos;   
   
   //INYECTO el Managed Bean de Session UsuarioManaged Bean
   @Inject
   private UsuarioManagedBean usuario;
 
    public LibrosAlquiladosManagedBean() {
        System.out.println("... construyendo LibrosAlquiladosManagedBean");       
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println(".... iniciando LibrosAlquiladosManagedBean");
        if (usuario.getNombre() != null){
            System.out.println(".... mostrar libros alquilados para usuario logeado");
            this.emailLogeado = usuario.getNombre();
            this.collectionAlquilados = servicio.getLibrosAlquilados(emailLogeado);
            todos = false;
        }else{
            System.out.println("... mostra todos los libros alquilados");
            this.collectionAlquilados = servicio.getAllLibrosAlquilados();
            todos = true;
        }
    }
    
    
    public boolean isTodos() {
        return todos;
    }

    public Collection<LibrosAlquiladosDTO> getCollectionAlquilados() {
        return collectionAlquilados;
    }

}
