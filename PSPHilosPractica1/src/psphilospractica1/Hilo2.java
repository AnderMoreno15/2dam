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
public class Hilo2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Intruce un número: ");
        int num = Util.leerInt();
        for (int i = 1; i <= num; i++) {
            System.out.println(i + " ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
