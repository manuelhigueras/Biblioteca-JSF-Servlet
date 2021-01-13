package com.biblioteca.web;

import com.biblioteca.excepciones.LoginException;
import com.biblioteca.servicios.LoginService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Named(value = "usuario")
@SessionScoped
//@ManagedBean(name="usuario")
//@SessionScoped
public class UsuarioManagedBean implements Serializable {

    private String nombre; //email
    private String clave;
    
    private Date fecha = new Date();

    LoginService loginService = new LoginService();

    public UsuarioManagedBean() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String login() {
        // BD - ir a buscar usuario y claeveç
        System.out.printf("login %s   y clave %s", nombre, clave);

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) ctx.getExternalContext().getSession(true);

        try {
            loginService.login(nombre, clave, sesion);
            return "index";
        } catch (LoginException ex) {
            Logger.getLogger(UsuarioManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            nombre = "";
            clave = "";

            //mensaje de error
            FacesMessage msg = new FacesMessage(ex.getMessage());
            //ctx.addMessage("formLogin:pwd", msg);
            ctx.addMessage(null, msg);
            return "login";
        }

    }

    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) ctx.getExternalContext().getSession(true);
        loginService.logout(sesion);
        
        return "login?faces-redirect=true";
    }

}
