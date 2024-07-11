# Conversor de Monedas

Este proyecto es una aplicación de consola que permite convertir monedas utilizando una API externa para obtener los tipos de cambio actuales. La aplicación es interactiva y ofrece varias opciones de conversión entre diferentes monedas.

## Características

- Conversión de moneda de Dólar a Peso Argentino, Real Brasileño, y Peso Colombiano, y viceversa.
- Interfaz de usuario simple en la consola.
- Validación de entrada para asegurar que el usuario ingrese valores numéricos válidos.

## Requisitos

- Java 11 o superior.
- [Gson](https://github.com/google/gson) versión 2.10.1 o superior.
- Una API-KEY de [ExchangeRate-API](https://www.exchangerate-api.com/).

## Configuración

1. **Clonar el repositorio**:

    ```sh
    git clone https://github.com/BrandonSdvl/ConversorDeMonedas.git
    cd conversor-de-monedas
    ```

2. **Configurar API-KEY**:

    Establece la API-KEY como una variable de entorno. Por ejemplo, en Linux o macOS:

    ```sh
    export API_KEY=tu_api_key
    ```

    En Windows:

    ```sh
    set API_KEY=tu_api_key
    ```
3. **Incluir la biblioteca Gson**:

    Descarga la biblioteca Gson desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1) e incluyela en el proyecto.
    
## Uso

Cuando ejecutes la aplicación, se te presentará un menú interactivo donde podrás seleccionar las opciones de conversión de moneda y proporcionar la cantidad a convertir.

```text
Bienvenido/a al conversor de monedas

1.- Dólar -> Peso Argentino
2.- Peso Argentino -> Dólar
3.- Dolar -> Real Brasileño
4.- Real Brasileño -> Dólar
5.- Dólar -> Peso Colombiano
6.- Peso Colombiano -> Dólar
7.- Salir

Seleccione una opción: 
```
Después de seleccionar una opción válida y proporcionar la cantidad a convertir, la aplicación mostrará el resultado de la conversión.

