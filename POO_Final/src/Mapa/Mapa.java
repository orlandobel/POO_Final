/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Graficos.Pantalla;
import Mapa.Tiles.Tiles;

/**
 *
 * @author Orlando
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
    protected int[] tiles;
    protected Tiles[] indexTiles;
    
    public Mapa(String ruta) {
        SubirMapa(ruta);
        Mapear();
    }
    
    protected void SubirMapa(String ruta) {}
    
    protected void Mapear() {}
    
    public void Actualizar() {
        
    }
    
    public void Mostrar(int compX,int compY, Pantalla p) {
        /*Bit shifting, esto es una forma de simplificar una divicion o multiplicación
            moviendose en potencias binarias n veces
        Ejemplo:
            128 64 32 16 8 4 2 1 0
        
            128/32 = 4
        
            32=2^5 --- n=5
            128>>5 = 128->64->32->16->8->4 = 4
   Desplazamientos    0   1   2   3   4  5
        Esto mejora el rendimiento de esta aplicacion
        */
        p.setDiferencias(compX,compY);
        
        int x0 = compX >> 5; // lado izquierda de la pantalla (oeste)
        int x1 = (compX+p.getAncho()+Tiles.LADO)>>5;// lado derecha de la pantal la (este)
        int y0 = compY>>5; // lado superior de la pantalla (norte)
        int y1 = (compY+p.getAlto()+Tiles.LADO)>>5; // lado inferior de la pantalla (sur)
        
        for(int i=y0;i<y1;i++) { //eje y
            for(int j=x0;j<x1;j++) { //eje x
                if(j<0||j>=ancho||i<0||i>=alto) {
                    Tiles.VACIO.Mostrar(j, i, p);
                } else {
                    indexTiles[j+i*ancho].Mostrar(j, i, p);
                }
            }
        }
    }
}
