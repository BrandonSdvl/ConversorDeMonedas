package org.example;

import com.google.gson.JsonObject;

import java.util.Scanner;

public class Menu {
    private final JsonObject jsonObject;
    private final Scanner lectura = new Scanner(System.in);

    public Menu(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            mostrarMenu();
            String opcion = lectura.nextLine();
            manejarOpcionMenu(opcion);
        }
    }

    private void mostrarMenu() {
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

    private void manejarOpcionMenu(String opcion) {
        String origen, destino;
        double cantidad, resultado;

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
                Utils.mostrarDivisas(jsonObject);
                return;
            case "8":
                origen = Utils.solicitarCodigo("origen", jsonObject, lectura);
                destino = Utils.solicitarCodigo("destino", jsonObject, lectura);
                break;
            case "9":
                System.exit(0);
            default:
                System.out.println("\nSeleccione una opción válida");
                return;
        }

        cantidad = Utils.solicitarCantidad(lectura);
        resultado = Convertir.convertirMonedas(origen, destino, cantidad);
        System.out.println("\n" + cantidad + " " + origen + " -> " + resultado + " " + destino);
        Utils.continuar(lectura);
    }
}
