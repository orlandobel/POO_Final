/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa.Tiles;

import Graficos.Pantalla;
import Graficos.Sprite;
import java.io.Serializable;

/**
 *
 * @author Orlando
 */
public class Tiles implements Serializable{
    public static final int LADO = 32;
    protected int x;
    protected int y;
    protected boolean solido=false;
    public Sprite s;
    
    /*Coleccion de tiles*/
    public static final Tiles VACIO = new Tiles(Sprite.VACIO,true);
    public static final Tiles TIERRA = new Tiles(Sprite.TIERRA,false);
    public static final Tiles CESPED = new Tiles(Sprite.CESPED,false);
    public static final Tiles COPA_ARBOL = new Tiles(Sprite.COPA_ARBOL,true);
    public static final Tiles ARBOL_MEDIO = new Tiles(Sprite.ARBOL_MEDIO,true);
    public static final Tiles TRONCO = new Tiles(Sprite.TRONCO,true);
    public static final Tiles TORRE_SUP = new Tiles(Sprite.TORRE_SUP,true);
    public static final Tiles TORRE_MID = new Tiles(Sprite.TORRE_MID,true);
    public static final Tiles TORRE_BASE = new Tiles(Sprite.TOORE_BASE,true);
    public static final Tiles TORRE_BACK = new Tiles(Sprite.TORRE_BACK,true);
    public static final Tiles PUENES_TORRES = new Tiles(Sprite.PUENTES_TORRES,true);
    public static final Tiles BANDERA1 = new Tiles(Sprite.BANDERA1,true);
    public static final Tiles SUPERIOR_VENTANA = new Tiles(Sprite.SUPERIOR_VENTANA,true);
    public static final Tiles VENTANA_CIRCULAR = new Tiles(Sprite.VENTANA_CIRCULAR,true);
    public static final Tiles BANDERA2 = new Tiles(Sprite.BANDERA2,true);
    public static final Tiles PICO_TORRE = new Tiles(Sprite.PICO_TORRE,true);
    public static final Tiles VENTANA_CENTRO = new Tiles(Sprite.VENTANA_CENTRO,true);
    public static final Tiles SUPERIOR_ENTRADA = new Tiles(Sprite.SUPERIOR_ENTRADA,true);
    public static final Tiles ENTRADA_CASTILLO = new Tiles(Sprite.ENTRAA_CASTILLO);
    /*------------------*/
    
    public Tiles(Sprite s,boolean solido) {
        this.s = s;
        this.solido = solido;
    }
    
    public Tiles(Sprite s) {
        this.s = s;
        this.solido=false;
    }
    
    public void Mostrar(int x,int y,Pantalla p) {
        p.MostrarTiles(x<<5,y<<5,this);
    }
    
    public static Tiles Invertir(Sprite s) {
        Sprite sAux = new Sprite(s.getLado(),s.getX(),s.getY(),s);
        Tiles tAux = new Tiles(sAux);
        return tAux;
    }
    
    public boolean hitBox() {
        return false;
    }

    public boolean isSolido() {
        return solido;
    }
    
    
    public void setSolido(boolean solido) {
        this.solido = solido;
    }
}
