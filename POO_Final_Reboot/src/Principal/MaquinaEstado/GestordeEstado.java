/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.MaquinaEstado;

import Principal.MaquinaEstado.Estados.Juego.GestordeJuego;
import java.awt.Graphics;

/**
 *
 * @author Guillermo BG
 */
public class GestordeEstado {
    private EstadoJuego[] estados; //este puede ser nuestro famoso ArrayList
    private EstadoJuego estadoActual;
    
    public GestordeEstado(){
        iniciarEstados();
        iniciarEstadoActual();
    }
//inicializacion de atributo
    private void iniciarEstados() {
        //aqui se añaden todos los estados previstos para el juego y nos dejamos
        //de jaladas con generar mapas y weas de esas
        estados = new EstadoJuego[1];
        estados[0]= new GestordeJuego();
        
        
       
    }
//inicializacion de atributo
    private void iniciarEstadoActual() {
        estadoActual= estados[0];
    }
    //metodos de estados, distintos mapas y demás, ya explicado
    public void actualizar(){
        estadoActual.actualizar();
    }
    public void dibujar(final Graphics g){
        estadoActual.dibujar(g);
    }
    
    public void cambiarEstado(int i){
        estadoActual= estados[i];
    }
    
    public EstadoJuego obtenerEstado(){
        return estadoActual;
    }
}
