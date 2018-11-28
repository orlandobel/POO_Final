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
    private Secundarios personajes[];
    private Teclado teclado;
    protected boolean Solido = true;
    
    public Principal(Teclado teclado, Sprite imagen, Mapa mapa, Secundarios personajes[]){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.mapa=mapa;
        this.Solido = true;
    }
    
    public Principal(Teclado teclado, int x, int y, Sprite imagen, Mapa mapa, Secundarios personajes[]){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.x=x;
        this.y=y;
        this.mapa=mapa;
        this.personajes=personajes;
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
    
    
    @Override
    protected boolean Colisionado(int movex, int movey){
      super.Colisionado(movex, movey);
      try {
       for(int i=0; i<this.personajes.length; i++){
           for(int j=0;j<this.personajes.length;j++) {
            if(personajes[i+j].bordeizq == this.bordeder){
                this.colision=true;
            }
            if(personajes[i+j].bordeder == this.bordeizq){
                this.colision=true;
            }
            if(personajes[i+j].bordeup == this.bordedown){
                this.colision=true;
            }
            if(personajes[i+j].bordedown == this.bordeup){
                this.colision=true;
            }
           }
       }
      } catch(Exception e) {
          
      }
       return colision;
   }
}
