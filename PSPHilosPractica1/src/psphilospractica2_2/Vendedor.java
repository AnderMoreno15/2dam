/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica2_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander
 */
public class Vendedor implements Runnable {
    private Taquilla taquilla;
    private String nombre;

    public Vendedor(Taquilla taquilla, String nombre) {
        this.nombre = nombre;
        this.taquilla = taquilla;
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            Taquilla.retirarDinero(taquilla, nombre);
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
