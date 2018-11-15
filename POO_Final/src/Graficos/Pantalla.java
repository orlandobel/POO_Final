/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Mapa.Tiles.Tiles;

/**
 *
 * @author Orlando
 */
public final class Pantalla {
    private final int alto;
    private final int ancho;
    
    private int difX;
    private int difY;
    
    public final int[] pixeles;
    
    /*Temporal*/
    private final static int LADOSPRITE = 32;
    private final static int MASCARASPRITE = LADOSPRITE - 1;
    /*--------*/
    
    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho*alto];
    }
    
    public void Limpiar() {
        for(int i=0;i<pixeles.length;i++) {
            pixeles[i] = 0;
        }
    }
    /*Temporal*/
    public void Mostrar(final int compX, final int compY) { //comp se refiere al movimiento del personaje en el eje
        for(int i=0;i<alto;i++) {
            int posY = i+compY; //coordenada en y
            
            /*Evita que nos salgamos de la pantalla en el eje y*/
            if(posY<0 || posY>=alto) {
                continue;
            }
            /*-------------------------------------------------*/
            
            for(int j=0;j<ancho;j++) {
                int posX = j+compX; //coordenada en y;
                
                /*Evita que nos salgamos de la pantalla en el eje x*/
                if(posX<0||posX>=ancho) {
                    continue;
                }
                /*-------------------------------------------------*/
                
                /*temporal*/
                pixeles[posX+posY*ancho] = Sprite.TIERRA.pixeles[(j & MASCARASPRITE) + (i & MASCARASPRITE) * LADOSPRITE];
                /*temporal*/
            }
        }
    }
    /*--------*/
    
    public void MostrarTiles(int compX,int compY,Tiles t) {
        /*las compensaciones x,y representan el desplazamiento del personaje en el mapa*/
        compX-= difX;
        compY-= difY;
        
        for(int i=0;i<t.s.getLado();i++) { //eje y
            int posY = i+compY;
            for(int j=0;j<t.s.getLado();j++) { //eje x
                int posX = j+compX;
                if(posX<=0||posX>ancho||posY<0||posY>alto) {
                    break;
                }
                if(posX<0) {
                    posX = 0;
                }
               
               pixeles[posX+posY*ancho] = t.s.pixeles[i+j*t.s.getLado()];
           } 
        }
    }
    
    public int getAncho() {
        return this.ancho;
    }
    
    public int getAlto() {
        return this.alto;
    }
    
    public void setDiferencias(final int difX,final int difY) {
        this.difX = difX;
        this.difY = difY;
    }
}
