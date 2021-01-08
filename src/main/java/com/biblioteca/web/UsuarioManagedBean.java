package com.biblioteca.web;

import com.biblioteca.excepciones.LoginException;
import com.biblioteca.servicios.LoginService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Named(value = "usuario")
@SessionScoped
//@ManagedBean
//@SessionScoped
public class UsuarioManagedBean implements Serializable {

    private String nombre;
    private String clave;
    
    public UsuarioManagedBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String login(){
        // BD - ir a buscar usuario y claeveç
        System.out.printf("login %s   y clave %s", nombre, clave);
        LoginService  loginService = new LoginService();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) ctx.getExternalContext().getSession(true);
 
        try {
            loginService.login(nombre, clave, sesion );
             return "index";
        } catch (LoginException ex) {
            Logger.getLogger(UsuarioManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            nombre  = "";
            clave = "";
            
            //mensaje de error
            FacesMessage msg = new FacesMessage(ex.getMessage());
            //ctx.addMessage("formLogin:pwd", msg);
            ctx.addMessage(null, msg);
            return "login";
        }
     
       
    }
    
}
