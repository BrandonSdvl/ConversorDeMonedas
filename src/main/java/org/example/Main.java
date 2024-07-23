package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.*;

public class Main {
    static JsonObject jsonObject;
    static Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) {
        double resultado, cantidad = 0;
        String origen = "", destino = "";

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("codes.json")) {
            jsonObject = JsonParser.parseReader(new InputStreamReader(Objects.requireNonNull(inputStream))).getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            mostrarMenu();
            String opcion = lectura.nextLine();

            switch (opcion) {
                case "1":
                    origen = "USD";
                    destino = "ARS";
                    break;
                case "2":
                    origen = "ARS";
                    destino = "USD";
                    break;
                case "3":
                    origen = "USD";
                    destino = "BRL";
                    break;
                case "4":
                    origen = "BRL";
                    destino = "USD";
                    break;
                case "5":
                    origen = "USD";
                    destino = "COP";
                    break;
                case "6":
                    origen = "COP";
                    destino = "USD";
                    break;
                case "7":
                    mostrarDivisas();
                    continue;
                case "9":
                    return;
                default:
                    System.out.println("\nSeleccione una opción válida");
                    continuar();
                    continue;
            }

            cantidad = solicitarCantidad();

            resultado = Convertir.convertirMonedas(origen, destino, cantidad);
            System.out.println("El resultado es: " + resultado);
            continuar();
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                
                Bienvenido/a al conversor de monedas

                1.- Dólar -> Peso Argentino
                2.- Peso Argentino -> Dólar
                3.- Dolar -> Real Brasileño
                4.- Real Brasileño -> Dólar
                5.- Dólar -> Peso Colombiano
                6.- Peso Colombiano -> Dólar
                7.- Mostrar codigos de divisas
                8.- Seleccionar otra divisa
                9.- Salir

                Seleccione una opción:\s""");
    }

    private static void continuar() {
        System.out.print("\nPresione enter para continuar...");
        lectura.nextLine();
    }

    private static double solicitarCantidad() {
        while (true) {
            System.out.print("Ingrese la cantidad a convertir: ");
            String input = lectura.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un valor numérico válido.");
            }
        }
    }

    private static void mostrarDivisas() {
        System.out.println(" _____________________________________________________________________________________");
        System.out.printf("| %-7s | %-30s | %-40s | %n", "Código", "Nombre", "País");
        System.out.println("|---------|--------------------------------|------------------------------------------|");

        jsonObject.entrySet().forEach(entry -> {
            String key = entry.getKey();
            JsonObject value = entry.getValue().getAsJsonObject();
            System.out.printf("|   %-5s | %-30s | %-40s |%n", key, value.get("Currency Name").getAsString(), value.get("Country").getAsString());
        });

        System.out.println("|_________|________________________________|__________________________________________|");
    }
}

