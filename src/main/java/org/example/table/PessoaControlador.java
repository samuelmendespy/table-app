package org.example.table;

import com.sun.net.httpserver.HttpExchange;
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

    public void handlePessoas(HttpExchange exchange) throws IOException {
        try {
            String method = exchange.getRequestMethod();
            URI requestURI = exchange.getRequestURI();
            String path = requestURI.getPath();
            if ("/api/pessoas".equals(path)) {
                if ("GET".equalsIgnoreCase(method)) {
                    pessoaServico.handleObterTodasPessoas(exchange);
                } else {
                    pessoaServico.sendStatus(exchange, 405);
                }
                return;
            }
            String[] parts = path.split("/");
            if (parts.length == 4 && "GET".equalsIgnoreCase(method)) {
                int id = Integer.parseInt(parts[3]);
                pessoaServico.handleObterPessoaPorId(exchange, id);
                return;
            }
            pessoaServico.sendStatus(exchange, 404);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Ocorreu um erro", e);
            pessoaServico.sendStatus(exchange, 500);
        }
    }
}
