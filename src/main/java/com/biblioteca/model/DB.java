package com.biblioteca.model;

import com.biblioteca.excepciones.DBException;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;

public class DB {

    private static Map<Integer, Libro> libros;
    private static Set<Usuario> usuarios;

    static {
        libros = new HashMap<Integer, Libro>();
        libros.put(1, new Libro(1, "El Guijote", "Miguel de Cervantes", false));
        libros.put(2, new Libro(2, "La Odisea", "Homero", false));
        libros.put(3, new Libro(3, "La Divina Comedia", "Dante", true));
        libros.put(4, new Libro(4, "La vida es Sueño", "Calderón de la Barca", true));

        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("begona@gmail.com", "1234", "Begoña", "Olea"));
        usuarios.add(new Usuario("laura@gmail.com", "1234", "Laura", "Bilbao"));
    }

    private DB() {
    }

    public synchronized static Collection<Libro> getAllLibros() {
        return libros.values();
    }
    
    public static Collection<Libro> getLibrosPrestados() {
        Set<Libro> prestados = new HashSet<Libro>();
        for (Libro l : libros.values()) {
            if (!l.isDisponible()) {
                prestados.add(l);
            }
        }
        return prestados;
    }
    
    public synchronized static void alquilar(int id) {
        //MEJORAR - LANZAR UNA EXCEPCION SI ID NO EXISTE
        // SINO  libros.get(id) returna null y 
        // null.setDiponible(fale) da NullPointerExcpetion        
        libros.get(id).setDisponible(false);
    }

    public synchronized static void altaLibro(Libro libro) throws DBException {
        if (libros.containsKey(libro.getId())) {
            throw new DBException("El libro ya existe con el id " + libro.getId());
        }
        libros.put(libro.getId(), libro);
    }

    public synchronized static Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public synchronized static void altaUsuario(Usuario u) throws DBException {
        boolean seAñade = usuarios.add(u);
        if (!seAñade) {
            throw new DBException("El usuario no pudo ser añadido. El email ya existe.");
        }
    }
}
