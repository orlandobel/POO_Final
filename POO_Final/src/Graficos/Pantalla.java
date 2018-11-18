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
    
    /*Control de desplazamento en el mapa del ppersonaje, esto para redibujar la pantalla segun se nesecite*/
    private int difX; 
    private int difY; 
    /*-----------------------------------------------------------------------------------------------------*/
    
    public final int[] pixeles;
    
    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho*alto];
    }
    
    /*Recorre los arreglos de pixeles de cada tile para dibujarlos en la pantalla*/
    public void MostrarTiles(int compX,int compY,Tiles t) {
        /*las compensaciones x,y representan el desplazamiento del personaje en el mapa*/
        compX-= difX;
        compY-= difY;
        
        for(int i=0;i<t.s.getLado();i++) { //eje y
            int posY = i+compY;
            for(int j=0;j<t.s.getLado();j++) { //eje x
                int posX = j+compX;
                if(posX<-t.s.getLado()||posX>=ancho||posY<0||posY>=alto) {
                    break;
                }
                if(posX<0) {
                    posX = 0;
                }
               
               pixeles[posX+posY*ancho] = t.s.pixeles[j+i*t.s.getLado()];
           } 
        }
    }
    /*---------------------------------------------------------------------------*/
    
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
