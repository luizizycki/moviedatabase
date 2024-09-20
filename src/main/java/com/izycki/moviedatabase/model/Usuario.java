package com.izycki.moviedatabase.model;

public class Usuario {

    private int id;
    private String username;
    private String senha;
    private int tipo_user_id;


    Usuario(int id, String username, String senha, int tipo_user_id){
        this.setId(id);
        this.setSenha(senha);
        this.setTipoUserId(tipo_user_id);
        this.setUsername(username);
    }

    @Override
    public String toString(){
        return "\n----------------------------\nID: " + id + "\nUsername: " + username + "\nSenha: " + senha + "\ntipo_user_id: " + tipo_user_id + "\n";
    }

    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String username){
       this.username = username;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setTipoUserId(int tipo_user_id){
        this.tipo_user_id = tipo_user_id;
    }

    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getSenha(){
        return senha;
    }
    public int getTipo_user_id(){
        return tipo_user_id;
    }
}
