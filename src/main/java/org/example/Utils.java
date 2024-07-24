package org.example;

import com.google.gson.JsonObject;

import java.util.Scanner;

public class Utils {
    public static void continuar(Scanner lectura) {
        System.out.print("\nPresione enter para continuar...");
        lectura.nextLine();
    }

    public static double solicitarCantidad(Scanner lectura) {
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

    public static String solicitarCodigo(String tipo, JsonObject jsonObject, Scanner lectura) {
        while (true) {
            System.out.print("Ingrese el codigo de la divisa de " + tipo + ": ");
            String input = lectura.nextLine().toUpperCase();
            if (jsonObject.get(input) != null) {
                return input;
            } else {
                System.out.println("Este codigo de divisa no existe");
            }
        }
    }

    public static void mostrarDivisas(JsonObject jsonObject) {
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
