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
public class Principal {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(40);
        Persona p = new Persona(cuenta, "Ana");
        Persona p2 = new Persona(cuenta, "Mikel");
        
    }
}
