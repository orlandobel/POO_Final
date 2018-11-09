/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

/**
 *
 * @author Orlando
 */

/*Extraccion de sprites*/
public final class Sprite {
    private final int lado; //tamanio del lado de los spites
    private int x; //cordenadas en el eje x de la hoja de srpites
    private int y; //coordenadas en el eje y de la hoa de sprites
    public int[] pixeles;
    private final HojaSprites hoja;
    
    /*Arreglo de sprites*/
    public static Sprite ejemplo1 = new Sprite(32,0,0,HojaSprites.ejemplo);
    /*------------------*/
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
        this.lado = lado;
        pixeles = new int[lado*lado];
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        
        /*-----------------------------extrae un srpite-----------------------------*/
        for(int i=0;i<lado;i++) { //se mueve en el eje y
            for(int j=0;j<lado;j++) { //se mueve en el eje x
                pixeles[(j+i)*lado] = hoja.pixeles[((j+x) + (i+y)) * hoja.getAncho()]; //obtiene el pixel en las coordenadas daas en la hoja de sprites
            }
        }
        /*--------------------------------------------------------------------------*/
        
    }
}
