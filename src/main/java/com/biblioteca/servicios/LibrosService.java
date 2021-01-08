package com.biblioteca.servicios;

import com.biblioteca.excepciones.DBException;
import com.biblioteca.model.DB;
import com.biblioteca.model.Libro;
import java.util.Collection;

public class LibrosService {
    
    public void altaLibro(Libro libro) throws DBException{
        DB.altaLibro(libro);        
    }
    
     public Collection<Libro> getAllLibros() {
       return DB.getAllLibros();
     }
    
}
