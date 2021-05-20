package br.edu.ifsp.arq.dmos5_2021.data;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.dmos5_2021.model.Usuario;

public class UsuarioDAO {

    private List<Usuario> usuarioList;

    public UsuarioDAO(){
        this.usuarioList = new ArrayList<>(10);
        usuarioList.add(new Usuario("huryel.bertolaia@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia1@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia2@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia3@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia4@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia5@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia6@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia7@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia8@ifsp.edu.br",12345));
        usuarioList.add(new Usuario("huryel.bertolaia9@ifsp.edu.br",12345));
    }

    public Usuario recuperate(String username){
        for(Usuario u: usuarioList){
            if(u.getUsername().equalsIgnoreCase(username)){
                return u;
            }
        }
        return null;
    }
}
