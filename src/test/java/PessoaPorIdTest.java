import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PessoaPorIdTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            int pessoaId = 2;
            String baseUrl = "http://localhost:8080/pessoas/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + pessoaId))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("--- Obtendo resposta de /pessoas/"+ pessoaId + " ---");
            System.out.println("Código de Status HTTP: " + response.statusCode());
            System.out.println("Headers: " + response.headers());
            System.out.println("Body:\n" + response.body());

        } catch (IOException e) {
            System.err.println("Ocorreu um erro durante a requisição HTTP: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Requisição interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}