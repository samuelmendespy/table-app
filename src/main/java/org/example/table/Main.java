package org.example.table;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Criar lista de pessoas
        List<Pessoa> pessoas = new ArrayList<>();

        // Criar Pesosa 1
        Pessoa pessoa1 = new Pessoa("Luiz Roberto", 33);

        // Adicionar documentos da Pessoa 1
        pessoa1.addDocumento(new Documento(TipoDocumento.CNH, "48848830020"));
        pessoa1.addDocumento(new Documento(TipoDocumento.RG, "5004002"));
        pessoa1.addDocumento(new Documento(TipoDocumento.CTPS, "4567898"));

        // Criar Pessoa 2
        Pessoa pessoa2 = new Pessoa("Raimundo Soares", 51);

        // Adicionar Documentos da Pessoa 2
        pessoa2.addDocumento(new Documento(TipoDocumento.CNH, "45963548565789"));
        pessoa2.addDocumento(new Documento(TipoDocumento.RG, "5200785"));
        pessoa2.addDocumento(new Documento(TipoDocumento.CTPS, "7891237"));

        // Criar Pessoa 3
        Pessoa pessoa3 = new Pessoa("Ana Tavares", 24);

        // Adicionar Documentos da Pesosa 3
        pessoa3.addDocumento(new Documento(TipoDocumento.CNH, "65236525662159"));
        pessoa3.addDocumento(new Documento(TipoDocumento.CPF, "41254125147"));

        // Criar Pessoa 4
        Pessoa pessoa4 = new Pessoa("Janete Niehues", 28);

        // Adicionar Documentos da Pessoa 4
        pessoa4.addDocumento(new Documento(TipoDocumento.CPF, "65236525662"));
        pessoa4.addDocumento(new Documento(TipoDocumento.RG, "3300785"));
        pessoa4.addDocumento(new Documento(TipoDocumento.SUS, "784512"));


        // Criar Pessoa 5
        Pessoa pessoa5 = new Pessoa("Paulo da Rosa", 74);

        // Adicionar Documentos da Pessoa 5
        pessoa5.addDocumento(new Documento(TipoDocumento.RG, "5200785"));
        pessoa5.addDocumento(new Documento(TipoDocumento.CPF, "45621581254 1"));

        // Criar Pessoa 6
        Pessoa pessoa6 = new Pessoa("Wesley Soares", 60);

        // Adicionar Documentos da Pesosa 6
        pessoa6.addDocumento(new Documento(TipoDocumento.CNH, "91035698445963"));
        pessoa6.addDocumento(new Documento(TipoDocumento.RG, "7415595"));
        pessoa6.addDocumento(new Documento(TipoDocumento.CPF, "45618452136"));
        pessoa6.addDocumento(new Documento(TipoDocumento.SUS, "2200789"));

        // Criar Pessoa 7
        Pessoa pessoa7 = new Pessoa("Tamires Souza", 12);

        // Adicioanr Documentos da Pessoa 7
        pessoa7.addDocumento(new Documento(TipoDocumento.CTPS, "7852123"));

        // Inserir entradas na lista de pessoas
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa5);
        pessoas.add(pessoa6);
        pessoas.add(pessoa7);

        System.out.println("\n>>1 - LISTAR PESSOA COM ID 2.");
        listarPessoaPorId(pessoas,2);
        System.out.println("\n>> 2 - LISTAGEM DE PESSOAS EM ORDEM CRESCENTE DE IDADE");
        listarPessoasOrdenadasPorIdade(pessoas);
        System.out.println("\n>> 3 - LISTAGEM DE PESSOAS COM IDADE SUPERIOR A 50 ANOS.");
        listarPessoasComIdadeSuperior(pessoas, 50);
        System.out.println("\n>> 4 - LISTAGEM DE PESSOAS QUE NÃO POSSUEM CPF.");
        listarPessoasSemCPF(pessoas);
        System.out.println("\n>> 5 - LISTAGEM DE TIPOS DE DOCUMENTOS.");
        listarTiposDeDocumentos(pessoas);

    }

    /*
     Função 1 - Recebe a lista de pessoas e o id da pessoa a ser encontrada como parâmetros.
     Imprime a informações da pessoa ou a string "Pessoa não encontrada".
    */
    public static void listarPessoaPorId(List<Pessoa> pessoas, int pessoaId) {
        Pessoa pessoaEncontrada = pessoas.stream().filter(pessoa -> pessoa.getId() == pessoaId).findFirst().orElse(null);
        if ( pessoaEncontrada != null) {
            listarPessoa(pessoaEncontrada); ;
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }

    /*
     Função 2 - Recebe a lista de pessoas como parâmetro, ordena por idade em ordem crescente e imprime cada item da lista.
    */
    public static void listarPessoasOrdenadasPorIdade(List<Pessoa> pessoas) {
        pessoas.stream()
                .sorted(Comparator.comparingInt(Pessoa::getIdade))
                .forEach(Main::listarPessoa);
    }

    /*
    Função 3 - Recebe a lista de pessoas e uma idade alvo como parâmetros.
    Filtra cada pessoa da lista de pessoas com idade superior à idade alvo e imprime cada pessoa filtrada.
   */
    public static void listarPessoasComIdadeSuperior(List<Pessoa> pessoas, int idade) {
        pessoas.stream().filter(pessoa -> pessoa.getIdade() > idade).forEach(Main::listarPessoa);
    }

    /*
    Função 4 - Recebe a lista de pessoas como parâmetro.
    Filtra cada pessoa da lista e imprime pessoas sem o documento CPF.
   */
    public static void listarPessoasSemCPF(List<Pessoa> pessoas) {
        pessoas.stream().
                filter(pessoa -> pessoa.getDocumentos().stream()
                        .noneMatch(documento -> documento.getTipo().getSigla().equals("CPF")))
                .forEach(Main::listarPessoa);
    }

    /*
    Função 5 - Recebe a lista de pessoas como parâmetro.
    Filtra cada documento de cada pessoa da lista, cria um HashSet e coleta siglas de documentos nele, posteiormente é impresso cada elemento do Set.
   */
    public static void listarTiposDeDocumentos(List<Pessoa> pessoas) {
        Set<String> tiposDeDocumentos = pessoas.stream().
                flatMap(pessoa -> pessoa.getDocumentos().stream())
                .map(Documento::getTipo)
                .map(TipoDocumento::getSigla)
                .collect(Collectors.toSet());

        System.out.println("- Tipos de Documentos:");
        tiposDeDocumentos.forEach(System.out::println);
    }

    /*
    Função utilitária que recebe uma pessoa como parâmetro.
    Imprime informações da pessoa recebida como parâmetro em uma estrutura personalizada com StringBuilder.
   */
    public static void listarPessoa(Pessoa pessoa) {

        StringBuilder sb = new StringBuilder();
        sb.append("\nID:").append(pessoa.getId())
                .append(", Nome: ").append(pessoa.getNome())
                .append(", Idade: ").append(pessoa.getIdade())
                .append("\n Documentos: ");

        for (Documento doc : pessoa.getDocumentos()) {
            sb.append("\n- Tipo: ").append(doc.getTipo().getSigla())
                    .append(", Número: ").append(doc.getNumero())
                    .append(", Descrição: ").append(doc.getTipo().getDescricao());
        }

        System.out.println(sb.toString());
    }
}