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
public class Hilo3 implements Runnable {

    private int n;

    public Hilo3(int n) {
        this.n = n;
        Thread h = new Thread(this);
        h.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i + " ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
