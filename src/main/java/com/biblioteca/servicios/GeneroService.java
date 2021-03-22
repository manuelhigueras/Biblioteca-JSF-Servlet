/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.servicios;

import com.biblioteca.excepciones.DBException;
import com.biblioteca.model.DB;
import com.biblioteca.model.Genero;
import com.biblioteca.model.Usuario;
import com.biblioteca.servicios.dto.LibrosAlquiladosDTO;
import java.util.Collection;

public class GeneroService {

    public void altaGenero(Genero gen) throws DBException{
        DB.altaGenero(gen);        
    }
    
    public Collection<Genero> getAllGeneros() {
       return DB.getGeneros();
    }
    
    public Genero getGeneroPorId(Integer id) throws DBException{
        return DB.getGeneroPorId(id);
    }
    
}
