/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Orlando
 */
public final class Teclado implements KeyListener{

    private final static int numTeclas = 120;
    private final boolean[] teclas = new boolean[numTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean salir;
    public boolean menu;
    
    /*------Controles de movimiento------*/
    public void acualizar() {
        /*a los valores se les estara asignndo u booleano*/
        arriba = teclas[KeyEvent.VK_W]; //asigna la tecla 'W' como control de movimiento 'arriba'. Lo mismo con el resto de teclas
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        salir = teclas[KeyEvent.VK_ESCAPE];
        menu = teclas[KeyEvent.VK_ENTER];
    }
    /*-----------------------------------*/
    
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true; //combierte en verdadero el booleano asignado a la tecla pulsada
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false; //combierte en falso el booleno asignado a la tecla soltada
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }
}

