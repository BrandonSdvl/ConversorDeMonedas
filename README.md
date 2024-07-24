# Conversor de Monedas

Este proyecto es un conversor de divisas basado en Java que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio obtenidas de la API de ExchangeRate-API. El proyecto utiliza la biblioteca Gson para leer y parsear un archivo JSON con los códigos de las divisas y sus detalles.

## Características

- Conversión de divisas entre varias monedas utilizando una API externa.
- Mostrar una lista de códigos de divisas disponibles.
- Interfaz de consola simple y fácil de usar.
- Lectura de archivos JSON utilizando Gson.

## Requisitos

- Java 11 o superior.
- [Gson](https://github.com/google/gson) versión 2.10.1 o superior.
- Una API-KEY de [ExchangeRate-API](https://www.exchangerate-api.com/).

## Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

1. **ConsumoAPI**: Clase para consumir la API externa y obtener datos.
2. **Convertir**: Clase que contiene la lógica para convertir entre diferentes monedas utilizando una API externa.
3. **JsonLoader**: Clase para cargar el archivo JSON con los códigos de las divisas.
4. **Main**: Clase principal que inicializa el programa y maneja el menú principal.
5. **Menu**: Clase que maneja la interacción del usuario y las opciones del menú.
6. **Utils**: Clase con métodos auxiliares para mostrar mensajes, solicitar entradas del usuario y mostrar la lista de divisas.

## Configuración

1. **Clonar el repositorio**:

    ```sh
    git clone https://github.com/BrandonSdvl/ConversorDeMonedas.git
    cd ConversorDeMonedas
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
7.- Mostrar codigos de divisas
8.- Seleccionar otra divisa
9.- Salir

Seleccione una opción:
```
Después de seleccionar una opción válida y proporcionar la cantidad a convertir, la aplicación mostrará el resultado de la conversión.

