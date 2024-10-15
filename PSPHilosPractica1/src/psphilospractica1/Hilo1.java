/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander
 */
public class Hilo1 implements Runnable {
    
    /**
     * Cuenta 50 numeros con un intervalo de 100 milisegundos
     */
    @Override
    public void run() {
      
        System.out.println("Contando: ");
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
