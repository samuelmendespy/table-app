package org.example.table.modelo;

public enum TipoDocumento {
    CPF("CPF", "Cadastro Pessoa Física"),
    RG("RG", "Carteira de Identidade"),
    SUS("SUS", "Sistema Único de Saúde"),
    CNH("CNH", "Carteira de Motorista"),
    CTPS("CTPS", "Carteira de Trabalho");

    private final String sigla;
    private final String descricao;

    TipoDocumento(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}
