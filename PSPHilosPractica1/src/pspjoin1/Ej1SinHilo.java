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
public class Ej1SinHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        procesarArchivo("C:/Users/Ander/Desktop/Horario.jpg");
        procesarArchivo("C:/Users/Ander/Desktop/Maquinas Virtuales/ubuntu-22.04.4-live-server-amd64.iso");
        procesarArchivo("C:/Users/Ander/Desktop/Maquinas Virtuales/ubuntu-22.04.5-live-server-amd64.iso");
    }

    public static void procesarArchivo(String archivo) {
        double contador = 0;
        try (FileInputStream fis = new FileInputStream(archivo)) {
            System.out.println(archivo + " abierto");
            int byteLeido;

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
