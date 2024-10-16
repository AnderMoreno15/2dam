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
public class Taquilla {
    
    private int boleto;

    public Taquilla(int boleto) {
        this.boleto = boleto;
    }
    public static synchronized void retirarDinero(Taquilla taquilla, String nombre) {
        while (taquilla.getBoleto() > 0) {
            taquilla.setBoleto(taquilla.getBoleto() - 1);
            System.out.println(nombre + " ha vendido un boleto. Boletos restantes: " + taquilla.getBoleto());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(psphilospractica2_2.Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(nombre + " ha intentado vender un boleto pero no quedan");
    }
    public int getBoleto() {
        return boleto;
    }

    public void setBoleto(int boleto) {
        this.boleto = boleto;
    }
    
}
