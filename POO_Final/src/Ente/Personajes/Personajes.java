/*
 * Clase padre donde naceran todos personajes, desde el principal, como los NPC
 */
package Ente.Personajes;

import Ente.Ente;
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
   public void mostrar (){}
    
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
           setX(movex);
           setY(movey);
       }
    
   }
   
   
   private boolean choque(){return false;};
}