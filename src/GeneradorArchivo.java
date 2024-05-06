import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

    public class GeneradorArchivo {
        public static void generarArchivo(String monedaOrigen, String monedaDestino, double tasaConversion, double valor) {
            try (FileWriter fileWriter = new FileWriter("conversion.txt")) {
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println("Tasa de conversión de " + monedaOrigen + " a " + monedaDestino + ": "
                        + tasaConversion + "y su valor total es: " + valor);
                printWriter.close();
                System.out.println("Archivo generado exitosamente: conversion.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

