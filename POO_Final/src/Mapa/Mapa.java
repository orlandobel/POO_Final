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
    
    protected void SubirMapa(String ruta) {
        
    }
    
    protected void Mapear() {
        
    }
    
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
        
        int x0 = compX >> 5; // lado izquierda de la pantalla (oeste)
        int x1 = (compX+p.getAncho() + Tiles.LADO)>>5;// lado derecha de la pantal la (este)
        int y0 = compY>>5; // lado superior de la pantalla (norte)
        int y1 = (compY+p.getAlto())>>5; // lado inferior de la pantalla (sur)
        
        for(int i=y0;i<y1;i++) { //eje y
            for(int j=x0;j<x1;j++) { //eje x
                if(j<0||j>=ancho||i<0||i>=alto) {
                } else {
                    indexTiles[j+i*ancho].Mostrar(j<<5, j<<5, p);
                }
            }
        }
    }
    
    public Tiles getTile(final int x,final int y) {
        if(x<0||x>=ancho||y<0||y>=alto) {
            return Tiles.VACIO;
        }
        switch(tiles[(x+y)*ancho]) {
            case 0:
                return Tiles.TIERRA;
            case 1:
                return Tiles.CIELO1;
            case 2:
                return Tiles.CIELO2;
            case 3:
                return Tiles.CIELO3;
            case 4:
                return Tiles.TORRE_SUP_IZQ;
            case 5:
                return Tiles.TORRE_SUP_DER;
            case 6:
                return Tiles.TORRE_MID_IZQ;
            case 7:
                return Tiles.TORRE_MID_DER;
            case 8:
                return Tiles.TORRE_BASE_IZQ;
            case 9:
                return Tiles.TORRE_BASE_DER;
            case 10:
                return Tiles.TORRE_BACK_IZQ;
            case 11:
                return Tiles.TORRE_BACK_DER;
            case 12:
                return Tiles.PUENES_TORRES_IZQ;
            case 13:
                return Tiles.PUENES_TORRES_DER;
            case 14:
                return Tiles.BANDERA1_IZQ;
            case 15:
                return Tiles.BANDERA1_DER;
            case 16:
                return Tiles.SUPERIOR_VENTANA_IZQ;
            case 17:
                return Tiles.SUPERIOR_VENTANA_DER;
            case 18:
                return Tiles.VENTANA_CIRCULAR_IZQ;
            case 19:
                return Tiles.VENTANA_CIRCULAR_DER;
            case 20:
                return Tiles.BANDERA2_IZQ;
            case 21:
                return Tiles.BANDERA2_DER;
            case 22:
                return Tiles.PICO_TORRE;
            case 23:
                return Tiles.VENTANA_CENTRO;
            case 24:
                return Tiles.SUPERIOR_ENTRADA;
            case 25:
                return Tiles.ENTRADA_CASTILLO;
            default :
                return Tiles.VACIO;
        }
    }
}
