/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspjoin1;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Ander
 */
public class Ej1ConHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creas dos hilos, uno para cada archivo

        Thread hilo1 = new Thread(() -> procesarArchivo("C:/Users/Ander/Desktop/Maquinas Virtuales/ubuntu-22.04.4-live-server-amd64.iso"));

        Thread hilo2 = new Thread(() -> procesarArchivo("C:/Users/Ander/Desktop/Maquinas Virtuales/ubuntu-22.04.5-live-server-amd64.iso"));
        // Inicias los hilos
        hilo1.start();
        hilo2.start();

        /**
        try {
            // Esperamos a que ambos hilos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.err.println("Error al esperar la finalización de los hilos: " + e.getMessage());
        }
        * **/
        System.out.println("Fin ");
    }

    public static void procesarArchivo(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo)) {
            int byteLeido;
            int contador = 0;
            System.out.println(archivo + " abierto");
            // Lee el archivo byte a byte
            while ((byteLeido = fis.read()) != -1) {
                contador++;

            }

            System.out.println("Archivo " + archivo + " tiene " + contador + " bytes.");
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }

    }

}
