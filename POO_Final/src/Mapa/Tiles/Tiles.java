/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa.Tiles;

import Graficos.Pantalla;
import Graficos.Sprite;

/**
 *
 * @author Orlando
 */
public class Tiles {
    public static final int LADO = 32;
    public int x;
    public int y;
    public boolean solido;
    public Sprite s;
    
    /*Coleccion de tiles*/
    public static final Tiles VACIO = new Tiles(Sprite.VACIO,true);
    public static final Tiles TIERRA = new Tiles(Sprite.TIERRA,false);
    public static final Tiles CIELO1 = new Tiles(Sprite.CIELO1,true);
    public static final Tiles CIELO2 = new Tiles(Sprite.CIELO2,true);
    public static final Tiles CIELO3 = new Tiles(Sprite.CIELO3,true);
    public static final Tiles TORRE_SUP_IZQ = new Tiles(Sprite.TORRE_SUP_IZQ,true);
    public static final Tiles TORRE_SUP_DER = new Tiles(Sprite.TORRE_SUP_DER,true);
    public static final Tiles TORRE_MID_IZQ = new Tiles(Sprite.TORRE_MID_IZQ,true);
    public static final Tiles TORRE_MID_DER = new Tiles(Sprite.TORRE_MID_DER,true);
    public static final Tiles TORRE_BASE_IZQ = new Tiles(Sprite.TOORE_BASE_IZQ,true);
    public static final Tiles TORRE_BASE_DER = new Tiles(Sprite.TOORE_BASE_DER,true);
    public static final Tiles TORRE_BACK_IZQ = new Tiles(Sprite.TORRE_BACK_IZQ,true);
    public static final Tiles TORRE_BACK_DER = new Tiles(Sprite.TORRE_BACK_DER,true);
    public static final Tiles PUENES_TORRES_IZQ = new Tiles(Sprite.PUENTES_TORRES_IZQ,true);
    public static final Tiles PUENES_TORRES_DER = new Tiles(Sprite.PUENTES_TORRES_DER,true);
    public static final Tiles BANDERA1_IZQ = new Tiles(Sprite.BANDERA1_IZQ,true);
    public static final Tiles BANDERA1_DER = new Tiles(Sprite.BANDERA1_DER,true);
    public static final Tiles SUPERIOR_VENTANA_IZQ = new Tiles(Sprite.SUPERIOR_VENTANA_IZQ,true);
    public static final Tiles SUPERIOR_VENTANA_DER = new Tiles(Sprite.SUPERIOR_VENTANA_DER,true);
    public static final Tiles VENTANA_CIRCULAR_IZQ = new Tiles(Sprite.VENTANA_CIRCULAR_IZQ,true);
    public static final Tiles VENTANA_CIRCULAR_DER = new Tiles(Sprite.VENTANA_CIRCULAR_DER,true);
    public static final Tiles BANDERA2_IZQ = new Tiles(Sprite.BANDERA2_IZQ,true);
    public static final Tiles BANDERA2_DER = new Tiles(Sprite.BANDERA2_DER,true);
    public static final Tiles PICO_TORRE = new Tiles(Sprite.PICO_TORRE,true);
    public static final Tiles VENTANA_CENTRO = new Tiles(Sprite.VENTANA_CENTRO,true);
    public static final Tiles SUPERIOR_ENTRADA = new Tiles(Sprite.SUPERIOR_ENTRADA,true);
    public static final Tiles ENTRADA_CASTILLO = new Tiles(Sprite.ENTRAA_CASTILLO,false);
    /*------------------*/
    
    public Tiles(Sprite s,boolean solido) {
        this.s = s;
        this.solido = solido;
    }
    
    public void Mostrar(int x,int y,Pantalla p) {
        p.MostrarTiles(x, y, this);
    }
    
    public boolean hitBox() {
        return false;
    }
}
