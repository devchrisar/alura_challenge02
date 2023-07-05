import javax.swing.JOptionPane;

public class Conversor {
    public static final int OPCION_CONVERSION_MONEDA = 0;
    public static final int OPCION_CONVERSION_TEMPERATURA = 1;
    public static final int OPCION_CONVERSION_DISTANCIA = 2;
    public static final int OPCION_SALIR = 3;

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = mostrarMenu();

            switch (opcion) {
                case OPCION_CONVERSION_MONEDA:
                    convertirMoneda();
                    break;
                case OPCION_CONVERSION_TEMPERATURA:
                    convertirTemperatura();
                    break;
                case OPCION_CONVERSION_DISTANCIA:
                    convertirDistancia();
                    break;
                case OPCION_SALIR:
                    mostrarMensaje("Hecho con ❤️ por @devchrisar - Gracias por usar el Conversor. ¡Hasta luego!");
                    break;
                default:
                    mostrarMensaje("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != OPCION_SALIR);
    }

    public static int mostrarMenu() {
        String[] opciones = {"Conversión de Moneda", "Conversión de Temperatura", "Conversión de Distancia", "Salir"};
        return obtenerOpcion(opciones, "Selecciona una opción:", "Conversor - Alura ONE LATAM");
    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static int obtenerOpcion(String[] opciones, String mensaje, String titulo) {
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

    public static double obtenerCantidad(String mensaje, String titulo) {
        String cantidadTexto = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        try {
            return Double.parseDouble(cantidadTexto);
        } catch (NumberFormatException e) {
            mostrarMensaje("La cantidad ingresada no es válida. Por favor, intenta nuevamente.");
            return obtenerCantidad(mensaje, titulo);
        }
    }

    public static void convertirMoneda() {
        String[] opcionesMoneda = {"Dólar", "Euro", "Libra", "Yen", "Won"};
        int opcionMonedaOrigen = obtenerOpcion(opcionesMoneda, "Selecciona la moneda de origen:", "Conversión de Moneda");
        int opcionMonedaDestino = obtenerOpcion(opcionesMoneda, "Selecciona la moneda de destino:", "Conversión de Moneda");

        double cantidad = obtenerCantidad("Introduce la cantidad a convertir:", "Conversión de Moneda");

        double resultado = 0;

        if (opcionMonedaOrigen == opcionMonedaDestino) {
            mostrarMensaje("Las monedas de origen y destino son iguales. No se requiere conversión.");
        } else {
            switch (opcionMonedaOrigen) {
                case 0: // Dólar
                    resultado = convertirDolar(opcionMonedaDestino, cantidad);
                    break;
                case 1: // Euro
                    resultado = convertirEuro(opcionMonedaDestino, cantidad);
                    break;
                case 2: // Libra
                    resultado = convertirLibra(opcionMonedaDestino, cantidad);
                    break;
                case 3: // Yen
                    resultado = convertirYen(opcionMonedaDestino, cantidad);
                    break;
                case 4: // Won
                    resultado = convertirWon(opcionMonedaDestino, cantidad);
                    break;
            }

            mostrarMensaje(cantidad + " " + opcionesMoneda[opcionMonedaOrigen] + " equivale a " + resultado + " " + opcionesMoneda[opcionMonedaDestino]);
        }
    }

    public static double convertirDolar(int opcionMonedaDestino, double cantidad) {
        switch (opcionMonedaDestino) {
            case 1: // Euro
                return cantidad * 0.85;
            case 2: // Libra
                return cantidad * 0.74;
            case 3: // Yen
                return cantidad * 111.23;
            case 4: // Won
                return cantidad * 1130.35;
            default:
                return cantidad;
        }
    }

    public static double convertirEuro(int opcionMonedaDestino, double cantidad) {
        switch (opcionMonedaDestino) {
            case 0: // Dólar
                return cantidad * 1.18;
            case 2: // Libra
                return cantidad * 0.87;
            case 3: // Yen
                return cantidad * 130.82;
            case 4: // Won
                return cantidad * 1331.77;
            default:
                return cantidad;
        }
    }

    public static double convertirLibra(int opcionMonedaDestino, double cantidad) {
        switch (opcionMonedaDestino) {
            case 0: // Dólar
                return cantidad * 1.36;
            case 1: // Euro
                return cantidad * 1.15;
            case 3: // Yen
                return cantidad * 149.45;
            case 4: // Won
                return cantidad * 1523.88;
            default:
                return cantidad;
        }
    }

    public static double convertirYen(int opcionMonedaDestino, double cantidad) {
        switch (opcionMonedaDestino) {
            case 0: // Dólar
                return cantidad * 0.0091;
            case 1: // Euro
                return cantidad * 0.0078;
            case 2: // Libra
                return cantidad * 0.0068;
            case 4: // Won
                return cantidad * 10.29;
            default:
                return cantidad;
        }
    }

    public static double convertirWon(int opcionMonedaDestino, double cantidad) {
        switch (opcionMonedaDestino) {
            case 0: // Dólar
                return cantidad * 0.00088;
            case 1: // Euro
                return cantidad * 0.00076;
            case 2: // Libra
                return cantidad * 0.00066;
            case 3: // Yen
                return cantidad * 0.097;
            default:
                return cantidad;
        }
    }

    public static void convertirTemperatura() {
        String[] opcionesTemperatura = {"Celsius", "Fahrenheit", "Kelvin"};
        int opcionTemperaturaOrigen = obtenerOpcion(opcionesTemperatura, "Selecciona la temperatura de origen:", "Conversión de Temperatura");
        int opcionTemperaturaDestino = obtenerOpcion(opcionesTemperatura, "Selecciona la temperatura de destino:", "Conversión de Temperatura");

        double cantidad = obtenerCantidad("Introduce la cantidad a convertir:", "Conversión de Temperatura");

        double resultado = 0;

        if (opcionTemperaturaOrigen == opcionTemperaturaDestino) {
            mostrarMensaje("Las temperaturas de origen y destino son iguales. No se requiere conversión.");
        } else {
            switch (opcionTemperaturaOrigen) {
                case 0: // Celsius
                    resultado = convertirCelsius(opcionTemperaturaDestino, cantidad);
                    break;
                case 1: // Fahrenheit
                    resultado = convertirFahrenheit(opcionTemperaturaDestino, cantidad);
                    break;
                case 2: // Kelvin
                    resultado = convertirKelvin(opcionTemperaturaDestino, cantidad);
                    break;
            }

            mostrarMensaje(cantidad + " " + opcionesTemperatura[opcionTemperaturaOrigen] + " equivale a " + resultado + " " + opcionesTemperatura[opcionTemperaturaDestino]);
        }
    }

    public static double convertirCelsius(int opcionTemperaturaDestino, double cantidad) {
        switch (opcionTemperaturaDestino) {
            case 1: // Fahrenheit
                return (cantidad * 9 / 5) + 32;
            case 2: // Kelvin
                return cantidad + 273.15;
            default:
                return cantidad;
        }
    }

    public static double convertirFahrenheit(int opcionTemperaturaDestino, double cantidad) {
        switch (opcionTemperaturaDestino) {
            case 0: // Celsius
                return (cantidad - 32) * 5 / 9;
            case 2: // Kelvin
                return (cantidad + 459.67) * 5 / 9;
            default:
                return cantidad;
        }
    }

    public static double convertirKelvin(int opcionTemperaturaDestino, double cantidad) {
        switch (opcionTemperaturaDestino) {
            case 0: // Celsius
                return cantidad - 273.15;
            case 1: // Fahrenheit
                return (cantidad * 9 / 5) - 459.67;
            default:
                return cantidad;
        }
    }

    public static void convertirDistancia() {
        String[] opcionesDistancia = {"Metros", "Kilómetros", "Millas", "Pulgadas", "Pies", "Yardas"};
        int opcionDistanciaOrigen = obtenerOpcion(opcionesDistancia, "Selecciona la unidad de distancia de origen:", "Conversión de Distancia");
        int opcionDistanciaDestino = obtenerOpcion(opcionesDistancia, "Selecciona la unidad de distancia de destino:", "Conversión de Distancia");

        double cantidad = obtenerCantidad("Introduce la cantidad a convertir:", "Conversión de Distancia");

        double resultado = 0;

        if (opcionDistanciaOrigen == opcionDistanciaDestino) {
            mostrarMensaje("Las unidades de distancia de origen y destino son iguales. No se requiere conversión.");
        } else {
            switch (opcionDistanciaOrigen) {
                case 0: // Metros
                    resultado = convertirMetros(opcionDistanciaDestino, cantidad);
                    break;
                case 1: // Kilómetros
                    resultado = convertirKilometros(opcionDistanciaDestino, cantidad);
                    break;
                case 2: // Millas
                    resultado = convertirMillas(opcionDistanciaDestino, cantidad);
                    break;
                case 3: // Pulgadas
                    resultado = convertirPulgadas(opcionDistanciaDestino, cantidad);
                    break;
                case 4: // Pies
                    resultado = convertirPies(opcionDistanciaDestino, cantidad);
                    break;
                case 5: // Yardas
                    resultado = convertirYardas(opcionDistanciaDestino, cantidad);
                    break;
            }

            mostrarMensaje(cantidad + " " + opcionesDistancia[opcionDistanciaOrigen] + " equivale a " + resultado + " " + opcionesDistancia[opcionDistanciaDestino]);
        }
    }

    public static double convertirMetros(int opcionDistanciaDestino, double cantidad) {
        switch (opcionDistanciaDestino) {
            case 1: // Kilómetros
                return cantidad / 1000;
            case 2: // Millas
                return cantidad * 0.000621371;
            default:
                return cantidad;
        }
    }

    public static double convertirKilometros(int opcionDistanciaDestino, double cantidad) {
        switch (opcionDistanciaDestino) {
            case 0: // Metros
                return cantidad * 1000;
            case 2: // Millas
                return cantidad * 0.621371;
            default:
                return cantidad;
        }
    }

    public static double convertirMillas(int opcionDistanciaDestino, double cantidad) {
        switch (opcionDistanciaDestino) {
            case 0: // Metros
                return cantidad / 0.000621371;
            case 1: // Kilómetros
                return cantidad / 0.621371;
            default:
                return cantidad;
        }
    }
    public static double convertirPulgadas(int opcionDistanciaDestino, double cantidad) {
        switch (opcionDistanciaDestino) {
            case 0: // Metros
                return cantidad / 39.3701;
            case 1: // Kilómetros
                return cantidad / 39370.1;
            default:
                return cantidad;
        }
    }
    public static double convertirPies(int opcionDistanciaDestino, double cantidad) {
        switch (opcionDistanciaDestino) {
            case 0: // Metros
                return cantidad / 3.28084;
            case 1: // Kilómetros
                return cantidad / 3280.84;
            default:
                return cantidad;
        }
    }
    public static double convertirYardas(int opcionDistanciaDestino, double cantidad) {
        switch (opcionDistanciaDestino) {
            case 0: // Metros
                return cantidad / 1.09361;
            case 1: // Kilómetros
                return cantidad / 1093.61;
            default:
                return cantidad;
        }
    }
}
