/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ander
 */
public class Cuenta {

    private int saldo;

    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    public static synchronized void retirarDinero(Cuenta cuenta, String nombre) {
        while (cuenta.getSaldo() > 0) {
            cuenta.setSaldo(cuenta.getSaldo() - 10);
            System.out.println(nombre + " ha sacado 10€ de la cuenta. Dinero restante: " + cuenta.getSaldo());
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(nombre + " ha intentado sacar dinero de la cuenta pero se ha gastao");
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
