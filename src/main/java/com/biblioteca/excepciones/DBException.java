package com.biblioteca.excepciones;

public class DBException extends Exception{
    public DBException(String mensaje) {
        super(mensaje);
    }        
}