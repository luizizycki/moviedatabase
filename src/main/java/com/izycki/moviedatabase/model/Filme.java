package com.izycki.moviedatabase.model;

public class Filme {

    private int id;
    private String titulo;
    private String diretor;
    private int ano;

    Filme(int id, String titulo, String diretor, int ano){
       this.setTitulo(titulo);
       this.setId(id);
       this.setAno(ano);
       this.setDiretor(diretor);
    }
    public void setId(int id){
        this.id = id;
    }

    public void setAno(int ano){
        this.ano = ano;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setDiretor(String diretor){
        this.diretor = diretor;
    }

    public int getId(){
        return id;
    }

    public int getAno(){
       return ano;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDiretor(){
        return diretor;
    }

    @Override
    public String toString(){
        return String.format("\n-----------------------------\nFilme número: %d\nTítulo: %s\nAno de lançamento: %d\nDiretor: %s\n", id, titulo, ano, diretor);
    }
}
