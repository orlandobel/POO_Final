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
       for(int i=0; i<this.personajes.length; i++){
            if(personajes[i].bordeder+personajes[i].bordeup*mapa.getAncho()== bordeizq+bordedown*mapa.getAncho()){
                this.colision=true;
                System.out.println("hit1");
            }
            if(personajes[i].bordeizq+personajes[i].bordeup*mapa.getAncho()== bordeder+bordedown*mapa.getAncho()){
                this.colision=true;
                System.out.println("hit2");
            }
            if(personajes[i].bordeder+personajes[i].bordedown*mapa.getAncho()== bordeizq+bordeup*mapa.getAncho()){
                this.colision=true;
                System.out.println("hit3");
            }
            if(personajes[i].bordeizq+personajes[i].bordedown*mapa.getAncho()== bordeder+bordeup*mapa.getAncho()){
                this.colision=true;
                System.out.println("hit4s");
            }
       }
       return colision;
   }
}
