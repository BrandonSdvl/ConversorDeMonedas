package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Convertir {
    public static double convertirMonedas(String origen, String destino, double cantidad) {
        final String API_KEY = System.getenv("API_KEY");

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + origen + "/" + destino + "/" + cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            return jsonObject.get("conversion_result").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la conversion de moneda.");
        }
    }
}
