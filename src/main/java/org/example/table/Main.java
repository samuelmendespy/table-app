package org.example.table;

import java.util.ArrayList;
import java.util.List;

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

        // Exibição de informações das pessoas e seus documentos
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}