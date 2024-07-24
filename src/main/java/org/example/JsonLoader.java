package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonLoader {
    private JsonObject jsonObject;

    private String archivo;

    public JsonLoader(String archivo) {
        this.archivo = archivo;
    }

    public void cargarJson() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(archivo)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Archivo " + archivo + " no encontrado");
            }
            jsonObject = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo JSON", e);
        }
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }
}
