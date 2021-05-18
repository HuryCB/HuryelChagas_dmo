package br.edu.ifsp.arq.dmos5_2021.model;

public class Usuario {
    private String username;
    private int password;

    public Usuario(String username, int password){
        if(username != null && !username.isEmpty()){
            this.username = username;
            this.password = password;
        }else{
            this.username = "default";
            this.password = 0;
        }
    }

    public boolean validate(String username, int passwd){
        if(username != null){
            return this.username.equalsIgnoreCase(username) && password == passwd;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }
}
