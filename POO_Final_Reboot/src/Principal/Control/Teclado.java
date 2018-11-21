/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Guillermo BG
 */
public final class Teclado implements KeyListener{ //aparcado

    private final static int NUM_TECLAS = 256;
    private final boolean[] teclas = new boolean[NUM_TECLAS];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean salir;
    
    /*------Controles de movimiento------*/
    public void acualizar() {
        /*a los valores se les estara asignndo u booleano*/
        arriba = teclas[KeyEvent.VK_W]; //asigna la tecla 'W' como control de movimiento 'arriba'. Lo mismo con el resto de teclas
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        salir = teclas[KeyEvent.VK_ESCAPE];
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
        
    }

}

