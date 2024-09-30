package com.mycompany.listadetarefas;

public class Tarefa {
    private String titulo;
    private boolean finalizada;

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.finalizada = false;
    }
       
    public String getTitulo() {
        return titulo;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
    
}
