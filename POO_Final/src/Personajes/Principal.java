/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
//import java.awt.event.KeyListener;

/**
 *
 * @author Guillermo BG
 */
public class Principal extends Personajes /*implements KeyListener*/{ // HERENCIA De una clase que ya hereda herencia multiple (en caso de que no funcione:
                                           // tendremos que heredad los eventos tambien aqui, descomentar la implementacion y la linea 9
    private int sospecha;
    private boolean enBando;
    
    public Principal(String n, JLabel b) {
        super(n, b);
        this.sospecha= 50;
        this.enBando=false;
        //paramentro en 1/2 de base 100
    }

    public int getSospecha() {
        return sospecha;
    }
    // cambio directo del paramentro
    public void setSospecha(int sospecha) {
        this.sospecha = sospecha;
    }

    public boolean isEnBando() {
        return enBando;
    }

    public void setEnBando(boolean enBando) {
        this.enBando = enBando;
    }
    
    
    //si s es negativo tienes menos sospecha de un bando A que del otro B
    //si s es positivo tienes menos sospecha de un bando B que del otro A
    // mientras más te acercas a un limite (0 o 100) implicara tu interaccion con el otro bando
    public void Sospecha(int s){
        this.sospecha+=s;
        
    }
    
    //Hilo (cambio de movimiento) 
    @Override
    public void run(){
    }
    
    //Aqui puedes meter el hilo (animacion de movimiento)
    //Tal vez no se necesite...
    @Override
    public void Movimiento(){
        
    }
    
    //Evento de ataque, cuando decidas matar a un personaje
    //Puedes mandar a llamar esta acción... Tal vez no la ocupes para
    //Crear un sistema de combate, solo para ver alguna accion en pantalla
    //Tambien para cambiar el parametro de sospecha
    @Override
    public void Ataque(){    
   }
    
    //Evento de Muerte, cuando te eliminen o abandones
    //Puedes mandar a llamar esta acción... Tal vez no la ocupes para
    //Crear un sistema de combate, solo para ver alguna accion en pantalla
    //El paramentro de sospecha vuelve a 50;
    @Override
   public void Muerte(){
       
   }
    
   //ataque y muerte no son hilos porque no se repetiran infinitamente...
   
    // Eventos de movimiento
    // Aqui puedes meter directamente el hilo sobreescrito de cambio de movimiento, o movimiento en caso de tener más codigo aparte del hilo
    // aqui tambien debes programar los eventos de funciones para interactuar
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
