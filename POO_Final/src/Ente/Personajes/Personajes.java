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
   protected int bordeizq;
   protected int bordeder;
   protected int bordeup;
   protected int bordedown;
   
   protected int margenizq  = -5;
   protected int margender  =  5;
   protected int margenup   = -5;
   protected int margendown =  5;
   
   protected int direccion= 0;
   //0 mira hacia arriba
   //1 mira hacia derecha 
   //2 mira hacia abajo
   //3 mira hacia izquierda
    
   
   @Override
   public void actualizar(){}
   @Override
   public void mostrar (Pantalla pantalla){}
    
   public void Movimiento(int movex, int movey){
       if( movex > 0 ){ //derecha
           direccion = 1;
       }
       if( movex < 0 ){ //izquierda
           direccion = 3;
       }
       if( movey > 0 ){ // arriba
           direccion = 0;
       }
       if( movey < 0 ){ // abajo
           direccion = 2;
       }
       
       if(!isEliminado()){
           if(!Colisionado(movex,0)){
                setX(movex);
           }
           if(!Colisionado(0,movey)){
                setY(movey);
           }
       }
    
   }
   
   protected boolean Colisionado(int movex, int movey){
      this.colision=false;
       
       int posx=x+movex;
       int posy=y+movey;
      
       //bordes de las colisiones
       this.bordeizq= (int)((posx+4*this.margender)/Imagen.getLado());
       this.bordeder= (posx+this.margender+this.margenizq)/Imagen.getLado();
       this.bordeup= (posy+this.margendown)/Imagen.getLado();
       this.bordedown= (int)(posy*this.margendown+this.margenup)/Imagen.getLado();
       
       //System.out.println("x="+posx);
       
       if(posx < 0||posx>mapa.getAncho()*Imagen.getLado()-Imagen.getLado()||posy<0||posy>mapa.getAlto()*Imagen.getLado()-Imagen.getLado()) {
           colision = true;
       }
       try {
       if(mapa.getTiles(bordeizq+bordeup*mapa.getAncho()).isSolido()){
           colision=true;
           //System.out.println("1");
       }
       if(mapa.getTiles(bordeizq+bordedown*mapa.getAncho()).isSolido()){
           colision=true;
           //System.out.println("2");
       }
       if(mapa.getTiles(bordeder+bordeup*mapa.getAncho()).isSolido()){
           colision=true;
           //System.out.println("3");
       }
       if(mapa.getTiles(bordeder+bordedown*mapa.getAncho()).isSolido()){
           colision=true;
           //System.out.println("4");
       }
       
       
       }catch(Exception e) {
           
       }
       
       return colision;
   }

    public Sprite getImagen() {
        return Imagen;
    }
   
}