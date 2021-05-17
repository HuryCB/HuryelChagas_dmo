package br.edu.ifsp.arq.dmos5_2021.controller;

import br.edu.ifsp.arq.dmos5_2021.constantes.Constantes;
import br.edu.ifsp.arq.dmos5_2021.model.Usuario;

public class LoginController {

    public static boolean checklogin(String username, int passwd){
        Usuario usuario;
        usuario = new Usuario(username, passwd);
        return usuario.validate(Constantes.USER, Constantes.PASSWORD);
    }
}
