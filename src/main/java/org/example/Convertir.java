package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Convertir {
    public static double convertirMonedas(String origen, String destino, double cantidad) {
        final String API_KEY = System.getenv("API_KEY");

        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + origen + "/" + destino + "/" + cantidad;

        try {
            var response = ConsumoAPI.obtenerDatos(url);
            JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();

            return jsonObject.get("conversion_result").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la conversion de moneda.");
        }
    }
}
