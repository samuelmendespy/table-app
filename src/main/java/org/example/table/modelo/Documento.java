package org.example.table.modelo;

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

    @Override
    public String toString() {
        return "Documento{" +
                "tipo=" + tipo.getSigla() +
                ", numero=" + numero +
                ", descricao='" + tipo.getDescricao() + '\'' +
                '}';
    }
}

