package org.example;

public class Funcionario {
    private String nome;
    private boolean responsavel;

    public Funcionario(String nome, boolean responsavel) {
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isResponsavel() {
        return responsavel;
    }

    public void setResponsavel(boolean responsavel) {
        this.responsavel = responsavel;
    }
}