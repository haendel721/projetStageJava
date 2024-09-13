package Controller;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetToApi {
    public String reponse;
    public void connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    reponse = response.body();
                    System.out.println(reponse);
                } else {
                    System.out.println("Erreur : " + response.statusCode());
                }
        } catch (IOException | InterruptedException e) {
                e.printStackTrace();
        }
    }
}
