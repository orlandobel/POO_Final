/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_final;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author Guillermo BG
 */
public class Secundarios extends Personajes /*implements KeyListener*/{
    private boolean enBando;
    private boolean Following;
    private String frase;
    
    public Secundarios(String n, int v, boolean ag, JLabel b, boolean band, String f) {
        super(n, v, ag, b);
        this.enBando=band; // un caballero estara al lado del rey, pero un ciudadano puede o no entrar a la rebelion
        this.frase=f;// en caso de que hables con un secundario.
    }

    public boolean isEnBando() {
        return enBando;
    }

    public void setEnBando(boolean enBando) {
        this.enBando = enBando;
    }

    public boolean isFollowing() {
        return Following;
    }

    public void setFollowing(boolean Following) {
        this.Following = Following;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
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
    
    //Evento de ataque, cuando esten en medio del combate
    //Puedes mandar a llamar esta acción... Tal vez no la ocupes para
    //Crear un sistema de combate, solo para ver alguna accion en pantalla
    @Override
    public void Ataque(){    
   }
    
    //Evento de Muerte, cuando son eliminados (vida =0)
    //Puedes mandar a llamar esta acción... Tal vez no la ocupes para
    //Crear un sistema de combate, solo para ver alguna accion en pantalla
    @Override
   public void Muerte(){
       
   }
    //ataque y muerte pueden tener hilos, seria crearlos aparte para la forma en que se visualiza 
   
   // Eventos de movimiento
    // Aqui puedes meter directamente el hilo sobreescrito de cambio de movimiento, o movimiento en caso de tener más codigo aparte del hilo
    // Solo tendras movimiento si Following es verdad.
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
