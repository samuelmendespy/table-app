package org.example.table.modelo;

import org.json.simple.JSONObject;

public class Documento {
    private TipoDocumento tipo;
    private String numero;

    public Documento(TipoDocumento tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        obj.put("tipo", tipo.getSigla());
        obj.put("numero", numero);
        obj.put("descricao", tipo.getDescricao());
        return obj;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "tipo=" + tipo.getSigla() +
                ", numero=" + numero +
                ", descricao='" + tipo.getDescricao() + '\'' +
                '}';
    }
}

