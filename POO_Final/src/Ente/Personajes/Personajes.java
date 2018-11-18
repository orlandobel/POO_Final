/*
 * Clase padre donde naceran todos personajes, desde el principal, como los NPC
 */
package Ente.Personajes;

import Ente.Ente;
import Graficos.Pantalla;
import Graficos.Sprite;

/**
 *
 * @author Guillermo BG
 */
public abstract class Personajes extends Ente{
   protected Sprite Imagen; 
   protected int direccion= 2;
   //0 mira hacia arriba
   //1 mira hacia derecha 
   //2 mira hacia abajo
   //3 mira hacia izquierda
   
   @Override
   public void actualizar(){}
   @Override
   public void mostrar (Pantalla pantalla){}
    
   public void Movimiento(int movex, int movey){
       if( movex <0 ){ //derecha
           direccion =1;
       }
       if( movex >0 ){ //izquierda
           direccion =3;
       }
       if( movey <0 ){ // arriba
           direccion =0;
       }
       if( movey <0 ){ // abajo
           direccion =2;
       }
       
       if(!isEliminado()){
           if(!Colisionado(movex,0))
           setX(movex);
           if(!Colisionado(0,movey))
           setY(movey);
       }
    
   }
   
   private boolean Colisionado(int movex, int movey){
       boolean colision=false;
       
       int posx=x+movex;
       int posy=y+movey;
       
       int margenizq= -3;
       int margender= 4;
       int margenup= -10;
       int margendown= 10;
       
       int bordeizq= (posx+margender)/Imagen.getLado();
       int bordeder= (posx+margender+margenizq)/Imagen.getLado();
       int bordeup= (posy+margendown)/Imagen.getLado();
       int bordedown= (posx+margendown+margenup)/Imagen.getLado();
       
       
       if(mapa.getTiles(bordeizq+bordeup*mapa.getAncho()).isSolido()){
           colision=true;
       }
       if(mapa.getTiles(bordeder+bordeup*mapa.getAncho()).isSolido()){
           colision=true;
       }
       if(mapa.getTiles(bordeizq+bordedown*mapa.getAncho()).isSolido()){
           colision=true;
       }
       if(mapa.getTiles(bordeder+bordedown*mapa.getAncho()).isSolido()){
           colision=true;
       }
       
       return colision;
   }

    public Sprite getImagen() {
        return Imagen;
    }
   
}