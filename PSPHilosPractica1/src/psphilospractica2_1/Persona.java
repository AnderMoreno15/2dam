/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica2_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander
 */
public class Persona implements Runnable {

    private Cuenta cuenta;
    private String nombre;

    public Persona(Cuenta cuenta, String nombre) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            Cuenta.retirarDinero(cuenta, nombre);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
