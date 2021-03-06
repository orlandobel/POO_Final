/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.io.Serializable;

/**
 *
 * @author Orlando
 */

/*Extraccion de sprites*/
public final class Sprite implements Serializable{
    private final int lado; //tamanio del lado de los spites
    private int x; //cordenadas en el eje x de la hoja de srpites
    private int y; //coordenadas en el eje y de la hoa de sprites
    public int[] pixeles;
    private final HojaSprites hoja;
    
    //Sprite del jugadorPrueba
    
    public static Sprite SEC_PRUEBA = new Sprite(32,3,4,HojaSprites.personajePrueba);
    public static Sprite TER_PRUEBA = new Sprite(32,3,8,HojaSprites.personajePrueba);
    public static Sprite QUA_PRUEBA = new Sprite(32,3,5,HojaSprites.personajePrueba);
    public static Sprite PEN_PRUEBA = new Sprite(32,3,6,HojaSprites.personajePrueba);
    public static Sprite HEX_PRUEBA = new Sprite(32,3,14,HojaSprites.personajePrueba);

        
    
    
    public static Sprite JUGADOR_PRUEBA_ABAJO = new Sprite(32,3,3,HojaSprites.personajePrueba);
    
    public static Sprite JUGADOR_ABAJO1 = new Sprite(32,0,3,HojaSprites.personajePrueba);
    public static Sprite JUGADOR_ABAJO2 = new Sprite(32,1,3,HojaSprites.personajePrueba);
    public static Sprite JUGADOR_ABAJO3 = new Sprite(32,2,3,HojaSprites.personajePrueba);
      
    public static Sprite JUGADOR_PRUEBA_ARRIBA = new Sprite(32,7,3,HojaSprites.personajePrueba);
    
    public static Sprite JUGADOR_ARRIBA1 = new Sprite(32,4,3,HojaSprites.personajePrueba);
    public static Sprite JUGADOR_ARRIBA2 = new Sprite(32,5,3,HojaSprites.personajePrueba);
    public static Sprite JUGADOR_ARRIBA3 = new Sprite(32,6,3,HojaSprites.personajePrueba);
    
    public static Sprite JUGADOR_PRUEBA_LADO = new Sprite(32,9,3,HojaSprites.personajePrueba);
    public static Sprite JUGADOR_LADO1 = new Sprite(32, 8,3,HojaSprites.personajePrueba);
    public static Sprite JUGADOR_LADO2 = new Sprite(32,10,3,HojaSprites.personajePrueba);
//
    
    /*Arreglo de sprites*/
    public static Sprite VACIO = new Sprite(32,19,0,HojaSprites.Hoja1);
    public static Sprite TIERRA = new Sprite(32,0,0,HojaSprites.Hoja1);
    public static Sprite CESPED = new Sprite(32,1,0,HojaSprites.Hoja1);
    public static Sprite COPA_ARBOL = new Sprite(32,0,5,HojaSprites.Hoja1);
    public static Sprite ARBOL_MEDIO = new Sprite(32,0,6,HojaSprites.Hoja1);
    public static Sprite TRONCO = new Sprite(32,0,7,HojaSprites.Hoja1);
    public static Sprite TORRE_SUP = new Sprite(32,0,2,HojaSprites.Hoja1);
    public static Sprite TORRE_MID = new Sprite(32,0,3,HojaSprites.Hoja1);
    public static Sprite TOORE_BASE = new Sprite(32,0,4,HojaSprites.Hoja1);
    public static Sprite TORRE_BACK = new Sprite(32,1,2,HojaSprites.Hoja1);
    public static Sprite PUENTES_TORRES = new Sprite(32,1,3,HojaSprites.Hoja1);
    public static Sprite BANDERA1 = new Sprite(32,1,4,HojaSprites.Hoja1);
    public static Sprite SUPERIOR_VENTANA = new Sprite(32,2,2,HojaSprites.Hoja1);
    public static Sprite VENTANA_CIRCULAR = new Sprite(32,2,3,HojaSprites.Hoja1);
    public static Sprite BANDERA2 = new Sprite(32,2,4,HojaSprites.Hoja1);
    public static Sprite PICO_TORRE = new Sprite(32,3,1,HojaSprites.Hoja1);
    public static Sprite VENTANA_CENTRO = new Sprite(32,3,2,HojaSprites.Hoja1);
    public static Sprite SUPERIOR_ENTRADA = new Sprite(32,3,3,HojaSprites.Hoja1);
    public static Sprite ENTRAA_CASTILLO = new Sprite(32,3,4,HojaSprites.Hoja1);
    /*------------------*/
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
        this.lado = lado;
        pixeles = new int[lado*lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        
        /*-----------------------------extrae un srpite-----------------------------*/
        for(int i=0;i<lado;i++) { //eje y
            for(int j=0;j<lado;j++) { //eje x
                pixeles[j+i*lado] = hoja.pixeles[(j+x) + (i+y) * hoja.getAncho()]; //obtiene el pixel en las coordenadas daas en la hoja de sprites
            }
        }
        /*--------------------------------------------------------------------------*/
        
    }
    /*---------------------Constructor de sprites espejo-------------------------*/
    public Sprite(final int lado, final int x, final int y, final Sprite s) {
        this.lado = lado;
        pixeles = new int[lado*lado];
        this.x = x;
        this.y = y;
        this.hoja = s.getHoja();
        
        for(int i=0;i<lado;i++) { //eje y
            int jj=0;
            for(int j=(lado-1);j>=0;j--) { //eje x
                pixeles[jj+i*lado] = hoja.pixeles[(j+x) + (i+y) * hoja.getAncho()]; //obtiene el pixel en las coordenadas daas en la hoja de sprites
                jj++;
            }
        }
    }
    /*---------------------------------------------------------------------------*/
    
    public int getLado() {
        return this.lado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public HojaSprites getHoja() {
        return hoja;
    }
    public static Sprite Invertir(Sprite s) {
        Sprite tAux = new Sprite(s.getLado(),s.getX(),s.getY(),s);
        return tAux;
    }
}
