/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ente.Personajes;

import Controles.Teclado;
import Graficos.Pantalla;
import Graficos.Sprite;
import Mapa.Mapa;

/**
 *
 * @author Guillermo BG
 */
public class Principal extends Personajes { 
    
    private Teclado teclado;
    
    public Principal(Teclado teclado, Sprite imagen, Mapa mapa){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.mapa=mapa;
    }
    
    public Principal(Teclado teclado, int x, int y, Sprite imagen, Mapa mapa){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.x=x;
        this.y=y;
        this.mapa=mapa;
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