package org.example;

import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente{

    private String nome;
    private Integer id;
    private String cidade;
    private Integer saldo;

    private Integer divida;

    public Cliente(Integer id) {
        this.id = id;
        Cliente objeto = BancoDeDados.getCliente(id);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.saldo = objeto.saldo;
        this.divida = objeto.divida;
    }

    public Cliente(Integer id, String nome, String cidade, Integer saldo, Integer divida) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.saldo = saldo;
        this.divida = divida;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Integer> obterContaBancaria(Funcionario funcionario) {
        return Arrays.asList(this.saldo, this.divida);
    }
}