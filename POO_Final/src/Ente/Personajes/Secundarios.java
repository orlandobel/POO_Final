/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ente.Personajes;

import Graficos.Pantalla;
import Graficos.Sprite;
import Mapa.Mapa;

/**
 *
 * @author Guillermo BG
 */
public class Secundarios extends Personajes{

    private String texto;
    public Secundarios(int x, int y, Sprite imagen, Mapa mapa, String texto){
        this.Imagen=imagen;
        this.x=x;
        this.y=y;
        this.mapa=mapa;
        this.texto=texto;
        //--Bordes de 32x32--//
        this.bordeizq  = (x)/Imagen.getLado();
        this.bordeder  = (x)/Imagen.getLado();
        this.bordeup   = (y)/Imagen.getLado();
        this.bordedown = (y)/Imagen.getLado();
       
        this.colision=true;
    }
    
    public String Hablar(){
        return this.texto;
    }
    
    @Override
    public void mostrar(Pantalla pantalla){
        pantalla.MostrarJugador(x, y, this);
    };
    
     
}
