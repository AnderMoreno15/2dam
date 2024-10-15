/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica1;

/**
 *
 * @author Ander
 */
public class PSPHilosPractica1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Hilo1 hilo = new Hilo1();

        //Hilo2 hilo = new Hilo2();
        
        System.out.println("Intruce un número: ");
        int n = Util.leerInt();
        System.out.println("Intruce el número de hilos que quieres que cuenten hasta ese número: ");
        int m = Util.leerInt();
        
        for (int i = 0; i < m; i++) {
            Hilo3 h = new Hilo3(n);
        }
    }
}
