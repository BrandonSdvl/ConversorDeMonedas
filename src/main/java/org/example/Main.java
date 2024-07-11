package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        double resultado, cantidad = 0;
        String origen = "", destino = "";
        List<String> opcionesValidas = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

        while(true) {
            mostrarMenu();
            String opcion = lectura.nextLine();

            if (!opcionesValidas.contains(opcion)) {
                System.out.println("Seleccione una opción válida");
                continuar();
                continue;
            }

            if (opcion.equals("7")) {
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            cantidad = solicitarCantidad();

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
            }

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
                7.- Salir

                Seleccione una opción:\s""");
    }

    private static void continuar() {
        System.out.println("\nPresione enter para continuar...");
        Scanner lectura = new Scanner(System.in);
        lectura.nextLine();
    }

    private static double solicitarCantidad() {
        Scanner lectura = new Scanner(System.in);
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

}

