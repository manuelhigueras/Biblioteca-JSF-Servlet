package com.biblioteca.servicios;

import com.biblioteca.excepciones.DBException;
import com.biblioteca.model.DB;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.servicios.dto.LibrosAlquiladosDTO;
import java.util.Collection;

public class LibrosService {
    
    public void altaLibro(Libro libro) throws DBException{
        DB.altaLibro(libro);        
    }
    
     public Collection<Libro> getAllLibros() {
       return DB.getAllLibros();
     }
    
     public void alquilar(int id, String email){
         DB.alquilar(id, email);
     }
     
     public Collection<Usuario> getAllUsuarios(){
         return DB.getUsuarios();
     }
     
     public Collection<LibrosAlquiladosDTO> getLibrosAlquilados(String email){
         return DB.getLibrosAlquilados(email);
     }
     
     public Collection<LibrosAlquiladosDTO> getAllLibrosAlquilados(){
         return DB.getLibrosPrestados();
     }
}
