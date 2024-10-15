/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica2_1;

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
        Cuenta.retirarDinero(cuenta, nombre);
    }
}
