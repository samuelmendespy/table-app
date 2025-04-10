package org.example.table;

public class Main {
    public static void main(String[] args) {

        // Inicializa o repositório
        PessoaRepositorio pessoaRepositorio = new PessoaRepositorio();

        // Incializa o serviço
        PessoaServico pessoaServico = new PessoaServico(pessoaRepositorio);

        // Instanciando o objeto Pessoa atribuído para variável pessoa1
        Pessoa pessoa1 = new Pessoa("Luiz Roberto", 33);

        // Instanciando Documento CNH e adicionando à pessoa1
        pessoa1.addDocumento(new Documento(TipoDocumento.CNH, "48848830020"));
        // Instanciando Documento RG e adicionando à pessoa1
        pessoa1.addDocumento(new Documento(TipoDocumento.RG, "5004002"));
        // Instanciando Documento CTPS e adicionando à pessoa1
        pessoa1.addDocumento(new Documento(TipoDocumento.CTPS, "4567898"));

        // Instanciando o objeto Pessoa atribuído para variável pessoa2
        Pessoa pessoa2 = new Pessoa("Raimundo Soares", 51);

        // Instanciando Documento CNH e adicionando à pessoa2
        pessoa2.addDocumento(new Documento(TipoDocumento.CNH, "45963548565789"));
        // Instanciando Documento RG e adicionando à pessoa2
        pessoa2.addDocumento(new Documento(TipoDocumento.RG, "5200785"));
        // Instanciando Documento CTPS e adicionando à pessoa2
        pessoa2.addDocumento(new Documento(TipoDocumento.CTPS, "7891237"));

        // Instanciando o objeto Pessoa atribuído para variável pessoa3
        Pessoa pessoa3 = new Pessoa("Ana Tavares", 24);

        // Instanciando Documento CNH e adicionando à pessoa3
        pessoa3.addDocumento(new Documento(TipoDocumento.CNH, "65236525662159"));
        // Instanciando Documento CPF e adicionando à pessoa3
        pessoa3.addDocumento(new Documento(TipoDocumento.CPF, "41254125147"));

        // Instanciando o objeto Pessoa atribuído para variável pessoa4
        Pessoa pessoa4 = new Pessoa("Janete Niehues", 28);

        // Instanciando Documento CPF e adicionando à pessoa4
        pessoa4.addDocumento(new Documento(TipoDocumento.CPF, "65236525662"));
        // Instanciando Documento RG e adicionando à pessoa4
        pessoa4.addDocumento(new Documento(TipoDocumento.RG, "3300785"));
        // Instanciando Documento SUS e adicionando à pessoa4
        pessoa4.addDocumento(new Documento(TipoDocumento.SUS, "784512"));

        // Instanciando o objeto Pessoa atribuído para variável pessoa5
        Pessoa pessoa5 = new Pessoa("Paulo da Rosa", 74);

        // Instanciando Documento RG e adicionando à pessoa5
        pessoa5.addDocumento(new Documento(TipoDocumento.RG, "5200785"));
        // Instanciando Documento CPF e adicionando à pessoa5
        pessoa5.addDocumento(new Documento(TipoDocumento.CPF, "45621581254 1"));

        // Instanciando o objeto Pessoa atribuído para variável pessoa6
        Pessoa pessoa6 = new Pessoa("Wesley Soares", 60);

        // Instanciando Documento CNH e adicionando à pessoa6
        pessoa6.addDocumento(new Documento(TipoDocumento.CNH, "91035698445963"));
        // Instanciando Documento RG e adicionando à pessoa6
        pessoa6.addDocumento(new Documento(TipoDocumento.RG, "7415595"));
        // Instanciando Documento CPF e adicionando à pessoa6
        pessoa6.addDocumento(new Documento(TipoDocumento.CPF, "45618452136"));
        // Instanciando Documento SUS e adicionando à pessoa6
        pessoa6.addDocumento(new Documento(TipoDocumento.SUS, "2200789"));

        // Instanciando o objeto Pessoa atribuído para variável pessoa7
        Pessoa pessoa7 = new Pessoa("Tamires Souza", 12);

        // Instanciando Documento CTPS e adicionando à pessoa7
        pessoa7.addDocumento(new Documento(TipoDocumento.CTPS, "7852123"));

        // Salvando instâncias de Pessoa com serviço
        pessoaServico.salvarPessoa(pessoa1);
        pessoaServico.salvarPessoa(pessoa2);
        pessoaServico.salvarPessoa(pessoa3);
        pessoaServico.salvarPessoa(pessoa4);
        pessoaServico.salvarPessoa(pessoa5);
        pessoaServico.salvarPessoa(pessoa6);
        pessoaServico.salvarPessoa(pessoa7);

        System.out.println("\n>>1 - LISTAR PESSOA COM ID 2.");
        System.out.println(pessoaServico.listarPessoaPorId(2));
        System.out.println("\n>> 2 - LISTAGEM DE PESSOAS EM ORDEM CRESCENTE DE IDADE");
        System.out.println(pessoaServico.listarPessoasOrdenadasPorIdade());
        System.out.println("\n>> 3 - LISTAGEM DE PESSOAS COM IDADE SUPERIOR A 50 ANOS.");
        System.out.println(pessoaServico.listarPessoasComIdadeSuperior(50));
        System.out.println("\n>> 4 - LISTAGEM DE PESSOAS QUE NÃO POSSUEM CPF.");
        System.out.println(pessoaServico.listarPessoasSemCPF());
        System.out.println("\n>> 5 - LISTAGEM DE TIPOS DE DOCUMENTOS.");
        System.out.println(pessoaServico.listarTiposDeDocumentos());

    }

}