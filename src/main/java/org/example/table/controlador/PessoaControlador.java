package org.example.table.controlador;

import com.sun.net.httpserver.HttpExchange;
import org.example.table.servico.PessoaServico;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaControlador {

    private static final Logger logger = Logger.getLogger(PessoaControlador.class.getName());

    private final PessoaServico pessoaServico;

    public PessoaControlador(PessoaServico pessoaServico) {
        this.pessoaServico = pessoaServico;
    }

    public void handle(HttpExchange exchange) throws IOException {
        try {
            String method = exchange.getRequestMethod();
            URI requestURI = exchange.getRequestURI();
            String path = requestURI.getPath();
            if ("GET".equalsIgnoreCase(method)) {
                if ("/pessoas".equals(path)) {
                    pessoaServico.handleObterTodasPessoas(exchange);
                } else if (path.matches("/pessoas/\\d+")) { // Função 1 :Pessoa com ID
                    String parametro = path.substring("/pessoas/".length());
                    try {
                        int pessoaId = Integer.parseInt(parametro);
                        pessoaServico.handleObterPessoaPorId(exchange, pessoaId);
                    } catch (NumberFormatException e) {
                        pessoaServico.sendStatus(exchange, 400);
                    }
                } else if ("/pessoas/ordenadas-por-idade".equals(path)) { // Função 2 :Pessoas com Idade Crescente
                    pessoaServico.handleObterPessoasOrdenadasPorIdade(exchange);
                } else if (path.matches("/pessoas/com-idade-superior/\\d+")) { // Função 3 : Pessoas com idade superior
                    String parametro = path.substring("/pessoas/com-idade-superior/".length());
                    try {
                        int idadeAlvo = Integer.parseInt(parametro);
                        pessoaServico.handleObterPessoasComIdadeSuperior(exchange, idadeAlvo);
                    } catch (NumberFormatException e) {
                        pessoaServico.sendStatus(exchange, 400);
                    }
                } else if ("/pessoas/sem-cpf".equals(path)) { // Função 4 : Pessoas sem CPF
                    pessoaServico.handleObterPessoasSemCPF(exchange);
                } else if ("/pessoas/tipos-de-documentos".equals(path)) { // Função 5 : Tipos de documentos cadastrados
                    pessoaServico.handleObterTiposDeDocumentos(exchange);
                }
                return;
            }
            pessoaServico.sendStatus(exchange, 404);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ocorreu um erro", e);
            pessoaServico.sendStatus(exchange, 500);
        }
    }
}
