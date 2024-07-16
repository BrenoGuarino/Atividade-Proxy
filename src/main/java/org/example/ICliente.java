package org.example;

import java.util.List;

public interface ICliente {
    List<String> obterDadosPessoais();
    List<Integer> obterContaBancaria(Funcionario funcionario);
}