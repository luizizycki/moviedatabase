package com.izycki.moviedatabase.model;

public class tipo_usuario {
    private int id;
    private String tipo;
    private String descricao;

    tipo_usuario(int id, String tipo, String descricao){
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "\nId: " + id + "\nTipo: " + tipo + "\nDescricao: " + descricao + "\n";
    }


    public void setId(int id){
        this.id = id;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getId(){
        return id;
    }
    public String getDescricao(){
        return descricao;
    }
    public String getTipo(){
        return tipo;
    }
}


