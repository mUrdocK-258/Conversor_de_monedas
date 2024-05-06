import java.util.Scanner;

public class Menu {


    public static void mostrarMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("****************************************");
            System.out.println("|  Bienvenido al Conversor de Monedas  |");
            System.out.println("****************************************\n");

            System.out.println("Seleccione la moneda de origen: /n");

            System.out.println("1. Dólar (USD)");
            System.out.println("2. Euro (EUR)");
            System.out.println("3. Libra esterlina (GBP)");
            System.out.println("4. Yen japonés (JPY)");
            System.out.println("5. Franco suizo (CHF)");
            System.out.println("6. Peso mexicano (MXN)");
            System.out.println("7. Peso argentino (ARS)");
            System.out.println("8. Real brasileño (BRL)");
            System.out.println("9. Peso colombiano (COP)");

            System.out.print("Seleccione una opción: \n");
            int opcionOrigen = scanner.nextInt();

            System.out.println("¿Cúal es la cantidad que desea convertir?: \n");
            int cantidad = scanner.nextInt();

            System.out.println("Seleccione la moneda de destino: \n");

            System.out.println("1. Dólar (USD)");
            System.out.println("2. Euro (EUR)");
            System.out.println("3. Libra esterlina (GBP)");
            System.out.println("4. Yen japonés (JPY)");
            System.out.println("5. Franco suizo (CHF)");
            System.out.println("6. Peso mexicano (MXN)");
            System.out.println("7. Peso argentino (ARS)");
            System.out.println("8. Real brasileño (BRL)");
            System.out.println("9. Peso colombiano (COP)");

            System.out.print("Seleccione una opción: \n");

            int opcionDestino = scanner.nextInt();

            String monedaOrigen = obtenerCodigoMoneda(opcionOrigen);
            String monedaDestino = obtenerCodigoMoneda(opcionDestino);

            double tasaConversion = APIConversor.obtenerTasaConversion(monedaOrigen, monedaDestino);

            double valor = (double) (cantidad* tasaConversion);
            System.out.println("****************************************************************************************");
            System.out.println("| La tasa de conversión de "
                    + monedaOrigen + " a "
                    + monedaDestino + " es: "
                    + tasaConversion + " y el valor total del cambio es: " + valor + " |");
            System.out.println("*****************************************************************************************");
            GeneradorArchivo.generarArchivo(monedaOrigen, monedaDestino, tasaConversion, valor );

        }catch(Exception e){
            System.out.println("¡Has elegido una opcion invalida!");
        }
    }

    private static String obtenerCodigoMoneda(int opcion) {

            switch (opcion) {
                case 1:
                    return "USD";//Dólar
                case 2:
                    return "EUR";//euro
                case 3:
                    return "GBP";//libra esterlina
                case 4:
                    return "JPY";//yen japones
                case 5:
                    return "CHF";//franco suizo
                case 6:
                    return "MXN";//peso mexicano
                case 7:
                    return "ARS";//peso argentino
                case 8:
                    return "BRL";//real brasilero
                case 9:
                    return "COP";//peso colombiano
                default:
                    System.out.println("¡Has elegido una opcion invalida!");
                    return "";
            }
    }
}