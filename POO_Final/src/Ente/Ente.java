/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ente;

import Graficos.Pantalla;
import Mapa.Mapa;

/**
 *
 * @author Guillermo BG
 */
public class Ente {
    protected int x,y;
    protected boolean eliminado = false;
    protected Mapa mapa;
    protected boolean colision=false;
    
    public void actualizar(){}
    public void mostrar (Pantalla pantalla){}
    public void eliminar(){this.eliminado=true;}
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setX(int x) {
        this.x += x;
    }

    public void setY(int y) {
        this.y += y;
    }
    
    
}
