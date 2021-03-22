/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.servicios;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

@Named(value = "appMB")
@ApplicationScoped
public class AppManagedBean {

    private String formatoFecha = "";
    private int numMinDec = 2;

    public AppManagedBean() {
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public int getNumMinDec() {
        return numMinDec;
    }

    public void setNumMinDec(int numMinDec) {
        this.numMinDec = numMinDec;
    }
    
}
