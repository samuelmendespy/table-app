package org.example.table.repositorio;

import org.example.table.modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepositorio {

    // Criar a lista de pessoas
    private final List<Pessoa> pessoas = new ArrayList<>();

    // Obter a lista de todas as pessoas :
    public List<Pessoa> encontrarTodas() {
        return pessoas;
    }

    // Obter primeira pessoa com id igual ao pessoaId recebido como parâmetro, se não, retorna null.
    public Pessoa encontrarPorId(int id) {
        return pessoas.stream().filter(pessoa -> pessoa.getId() == id).findFirst().orElse(null);
    }

    // Adicionar nova pessoa
    public void salvar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

}
