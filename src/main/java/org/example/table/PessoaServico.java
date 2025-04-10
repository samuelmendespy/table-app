package org.example.table;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class PessoaServico {

    private final PessoaRepositorio repositorioPessoa;

    public PessoaServico(PessoaRepositorio repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    public Pessoa obterPessoaPorId(int id) {
        return repositorioPessoa.encontrarPorId(id);
    }

    public void salvarPessoa(Pessoa pessoa) {
        repositorioPessoa.salvar(pessoa);
    }

    /*
     listarPessoaPorId: Recebe um id como parâmetro para listar uma pessoa obtida do Repositorio com o mesmo id.
     Imprime informações da pessoa obtida do repositório, se for null imprime a string "Pessoa não encontrada".
    */
    public String listarPessoaPorId(int id) {
        StringBuilder sb = new StringBuilder();

        Pessoa p = obterPessoaPorId(id);

        if ( p == null) {
            System.out.println("Pessoa não encontrada");
        } else {
            sb.append("\nID:").append(p.getId())
                    .append(", Nome: ").append(p.getNome())
                    .append(", Idade: ").append(p.getIdade())
                    .append("\n Documentos: ");

            for (Documento doc : p.getDocumentos()) {
                sb.append("\n- Tipo: ").append(doc.getTipo().getSigla())
                        .append(", Número: ").append(doc.getNumero())
                        .append(", Descrição: ").append(doc.getTipo().getDescricao());
            }
        }

        return sb.toString();
    }

    /*
     listarPessoasOrdenadasPorIdade: Recebe a lista de pessoas como parâmetro, ordena por idade em ordem crescente e imprime cada item da lista.
    */
    public String listarPessoasOrdenadasPorIdade() {
        return repositorioPessoa.encontrarTodas().stream()
                .sorted(Comparator.comparingInt(Pessoa::getIdade))
                .map(p -> {
                    StringBuilder sb = new StringBuilder();

                    sb.append("\nID: ").append(p.getId())
                            .append(", Nome: ").append(p.getNome())
                            .append(", Idade: ").append(p.getIdade())
                            .append("\n Documentos: ");

                    p.getDocumentos().forEach(doc ->
                            sb.append("\n- Sigla: ").append(doc.getTipo().getSigla())
                                    .append(", Número: ").append(doc.getNumero())
                                    .append(", Descrição: ").append(doc.getClass())
                    );

                    return sb.toString();

                }).collect(Collectors.joining("\n\n"));
    }

    /*
    listarPessoasComIdadeSuperior: Recebe uma idade alvo como parâmetro.
    Busca no Repositorio pessoas acima da idade alvo e retorna String com informações sobre elas.
   */
    public String listarPessoasComIdadeSuperior(int idade) {
        return repositorioPessoa.encontrarTodas().stream()
                .filter(p -> p.getIdade() > idade)
                .map(p -> {
                    StringBuilder sb = new StringBuilder();

                    sb.append("\nID: ").append(p.getId())
                            .append(", Nome: ").append(p.getNome())
                            .append(", Idade: ").append(p.getIdade())
                            .append("\n Documentos: ");

                    p.getDocumentos().forEach(doc ->
                            sb.append("\n- Sigla: ").append(doc.getTipo().getSigla())
                                    .append(", Número: ").append(doc.getNumero())
                                    .append(", Descrição: ").append(doc.getClass())
                    );

                    return sb.toString();

                }).collect(Collectors.joining("\n\n"));
    }

    /*
    listarPessoasSemCPF: Busca pessoas do Repositorio sem CPF e retorna String listando informações sobre elas.
   */
    public String listarPessoasSemCPF() {
        return repositorioPessoa.encontrarTodas().stream()
                .filter(pessoa -> pessoa.getDocumentos().stream().noneMatch(documento -> documento.getTipo().getSigla().equals("CPF")))
                .map(p -> {
                    StringBuilder sb = new StringBuilder();

                    sb.append("\nID: ").append(p.getId())
                            .append(", Nome: ").append(p.getNome())
                            .append(", Idade: ").append(p.getIdade())
                            .append("\n Documentos: ");

                    p.getDocumentos().forEach(doc ->
                            sb.append("\n- Tipo: ").append(doc.getTipo().getSigla())
                                    .append(", Número: ").append(doc.getNumero())
                                    .append(", Descrição: ").append(doc.getClass())
                    );

                    return sb.toString();

                }).collect(Collectors.joining("\n\n"));
    }

    /*
    listarTiposDeDocumentos: Cria um HashSet com Strings contendo informações sobre o tipo de documento e imprime os elementos, sendo únicos.
   */
    public String listarTiposDeDocumentos() {

        Set<String> tiposDeDocumentos = repositorioPessoa.encontrarTodas().stream().
                flatMap(p -> p.getDocumentos().stream())
                .map(Documento::getTipo)
                .map(TipoDocumento::getSigla)
                .collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder("- Tipos de Documentos:");
        tiposDeDocumentos.forEach(sigla -> sb.append("\n").append(sigla));

        return sb.toString();
    }
}
