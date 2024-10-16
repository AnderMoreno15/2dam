/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psphilospractica2_2;

/**
 *
 * @author Ander
 */
public class Principal {
    public static void main(String[] args) {
        Taquilla taquilla = new Taquilla(100);
        Vendedor v = new Vendedor(taquilla, "Carlos");
        Vendedor v2 = new Vendedor(taquilla, "Laura");
        
    }
}
