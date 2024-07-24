package org.example;

public class Main {
    public static void main(String[] args) {
        JsonLoader jsonLoader = new JsonLoader("codes.json");
        jsonLoader.cargarJson();

        Menu menu = new Menu(jsonLoader.getJsonObject());
        menu.mostrarMenuPrincipal();
    }
}

