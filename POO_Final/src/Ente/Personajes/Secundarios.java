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
public class Secundarios extends Personajes{
    public Secundarios(int x, int y, Sprite imagen, Mapa mapa){
        this.Imagen=imagen;
        this.x=x;
        this.y=y;
        this.mapa=mapa;
        this.bordeizq  = (int)((x+6.2*this.margender)/Imagen.getLado());
        this.bordeder  = (x+this.margender+this.margenizq)/Imagen.getLado();
        this.bordeup   = (y+this.margendown)/Imagen.getLado();
        this.bordedown = (y+this.margendown+this.margenup)/Imagen.getLado();
       
        this.colision=true;
    }
    
    @Override
    public void mostrar(Pantalla pantalla){
        pantalla.MostrarJugador(x, y, this);
    };
    
     
}
