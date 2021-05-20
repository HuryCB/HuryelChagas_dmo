package br.edu.ifsp.arq.dmos5_2021.controller;

import br.edu.ifsp.arq.dmos5_2021.constantes.Constantes;
import br.edu.ifsp.arq.dmos5_2021.data.UsuarioDAO;
import br.edu.ifsp.arq.dmos5_2021.model.Usuario;

public class LoginController {

    public static boolean checklogin(String username, int passwd){
        UsuarioDAO usuarioDAO;
        Usuario usuario;
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.recuperate(username);
        if(usuario!=null){
            return usuario.validate(username,passwd);
        }
        return false;
    }
}
