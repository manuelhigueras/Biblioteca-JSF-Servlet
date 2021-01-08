package com.biblioteca.servicios;

import com.biblioteca.excepciones.LoginException;
import com.biblioteca.model.DB;
import com.biblioteca.model.Usuario;
import java.util.Collection;
import javax.servlet.http.HttpSession;

public class LoginService {

    public void login(String email, String clave, HttpSession sesion) throws LoginException {
        //DB ver si existe y coincide email y clave

        Collection<Usuario> usuarios = DB.getUsuarios();
        Usuario usrEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                usrEncontrado = u;
                break;
            }
        }
        //sino existe lanzo excepcion 
        if (usrEncontrado == null) {
            throw new LoginException("El usuario no existe. Debe registrarse.");
        }else{
            //ver si clave ok
            if(usrEncontrado.getPassword().equals(clave)){
                //añadir a sesion
                sesion.setAttribute("usuario", usrEncontrado);
            }else{
                throw new LoginException("Clave no válida");
            }
        }
        
    }//fin login

    public void logout(HttpSession sesion) {
        sesion.invalidate();
    }//fin logout

}
