/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ente.Personajes;

import Controles.Teclado;
import Graficos.Pantalla;
import Graficos.Sprite;

/**
 *
 * @author Guillermo BG
 */
public class Principal extends Personajes { 
    
    private Teclado teclado;
    
    public Principal(Teclado teclado, Sprite imagen){
        this.teclado=teclado;
        this.Imagen=imagen;
    }
    
    public Principal(Teclado teclado, int x, int y, Sprite imagen){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.x=x;
        this.y=y;
    }
    
    @Override
    public void actualizar(){
        int movex=0;
        int movey=0;
        
        if(teclado.arriba)
            movey--;
        if(teclado.abajo) 
            movey++;
        if(teclado.izquierda) 
            movex--;
        if(teclado.derecha)
            movex++;
        if (movex !=0 || movey !=0)
            super.Movimiento(movex, movey);
    }
    
    @Override
    public void mostrar(Pantalla pantalla){
        pantalla.MostrarJugador(x, y, this);
    };
    
}