/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import javax.swing.JLabel;

/**
 *
 * @author Guillermo BG
 */
public class NPC_Relleno extends Personajes{
    private String frase; //si interactuas con el solo te dice algo, es tecnicamente un cartel
    
    public NPC_Relleno(String n, JLabel b, String f) {
        super(n, 1, b);
        this.frase=f;
    }

    public String getFrase() {
        return frase;
    }
    
    //no se si esta clase tendra algun tipo de movimiento, pero si lo tienen, sera por el evento.

    public void setImagen(JLabel Imagen) {
        this.Imagen = Imagen;
    } // dentro del evento, solo cambiaremos el sprit de hacia donde ve, para que no sea un cartel...
    
    // son relleno, si ocupas más que lo que te doy codifica el propio relleno¬¬
    
    
}
