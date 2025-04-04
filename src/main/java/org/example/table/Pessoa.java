package org.example.table;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private static int counter = 0;

    private final int id;
    private String nome;
    private int idade;
    private List<Documento> documentos;

    public Pessoa(String nome, int idade) {
        this.id = ++counter;
        this.nome = nome;
        this.idade = idade;
        this.documentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("nome", nome);
        obj.put("idade", idade);
        return obj;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\''+
                ", nome='" + nome +
                ", idade=" + idade +
                ", documentos=" + documentos +
                '}';
    }
}