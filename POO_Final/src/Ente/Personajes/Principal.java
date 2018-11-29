/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ente.Personajes;

import Controles.Teclado;
import Graficos.Pantalla;
import Graficos.Sprite;
import Mapa.Mapa;
import java.util.ArrayList;

/**
 *
 * @author Guillermo BG
 */
public class Principal extends Personajes { 
    private ArrayList<Secundarios> personajes;
    private Teclado teclado;
    private boolean animacion;
    private int animar;
    protected boolean Solido = true;
    int secundario;
    
    public Principal(Teclado teclado, Sprite imagen, Mapa mapa, ArrayList<Secundarios>personajes){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.mapa=mapa;
        this.animar=0;
        this.Solido = true;
    }
    
    public Principal(Teclado teclado, int x, int y, Sprite imagen, Mapa mapa, ArrayList<Secundarios>personajes){
        this.teclado=teclado;
        this.Imagen=imagen;
        this.x=x;
        this.y=y;
        this.mapa=mapa;
        this.animar=0;
        this.personajes=personajes;
    }

    public int getSecundario() {
        return secundario;
    }
    
    
    
    @Override
    public void actualizar(){
        int movex=0;
        int movey=0;
        int velocidad;
        
        if(teclado.correr){
            velocidad=2;
        }else{
            velocidad=1;
        }
        if(this.animar<32767){
            this.animar++;
        }else{
            this.animar=0;
        }
            
        if(teclado.arriba)
            movey-=velocidad;
        if(teclado.abajo) 
            movey+=velocidad;
        if(teclado.izquierda) 
            movex-=velocidad;
        if(teclado.derecha)
            movex+=velocidad;
        if (movex !=0 || movey !=0){
            super.Movimiento(movex, movey);
            this.animacion=true;
        }else{
            this.animacion=false;
        }
            if(direccion == 0){
                Imagen=Sprite.JUGADOR_PRUEBA_ABAJO;
                if(this.animacion){
                    if(this.animar%(52/velocidad)<13/velocidad){
                        this.Imagen=Sprite.JUGADOR_ABAJO1;
                    }else if(this.animar%(52/velocidad)>26/velocidad && this.animar%(52/velocidad)<39/velocidad){
                        this.Imagen=Sprite.JUGADOR_ABAJO3;
                    }else{
                        this.Imagen=Sprite.JUGADOR_ABAJO2;
                    }
                }
            }
            if(direccion == 1){
                Imagen=Sprite.JUGADOR_PRUEBA_LADO;
                if(this.animacion){
                    if(this.animar%(40/velocidad)<10/velocidad){
                        this.Imagen=Sprite.JUGADOR_LADO1;
                    }else if(this.animar%(40/velocidad)>20/velocidad && this.animar%(40/velocidad)<30/velocidad){
                        this.Imagen=Sprite.JUGADOR_PRUEBA_LADO;
                    }else{
                        this.Imagen=Sprite.JUGADOR_LADO2;
                    }
                }
            }
            if(direccion == 2){
                Imagen=Sprite.JUGADOR_PRUEBA_ARRIBA;
                if(this.animacion){
                    if(this.animar%(60/velocidad)<15/velocidad){
                        this.Imagen=Sprite.JUGADOR_ARRIBA1;
                    }else if(this.animar%(60/velocidad)>30/velocidad && this.animar%(60/velocidad)<45/velocidad){
                        this.Imagen=Sprite.JUGADOR_ARRIBA3;
                    }else{
                        this.Imagen=Sprite.JUGADOR_ARRIBA2;
                    }
                }
            }
            
            if(direccion == 3){
                Imagen= Sprite.Invertir(Sprite.JUGADOR_PRUEBA_LADO);
                if(this.animacion){
                    if(this.animar%(40/velocidad)<10/velocidad){
                        this.Imagen= Sprite.Invertir(Sprite.JUGADOR_LADO1);
                    }else if(this.animar%(40/velocidad)>20/velocidad && this.animar%(40/velocidad)<30/velocidad){
                        this.Imagen= Sprite.Invertir(Sprite.JUGADOR_PRUEBA_LADO);
                    }else{
                        this.Imagen= Sprite.Invertir(Sprite.JUGADOR_LADO2);
                    }
                }
            }
    }
    
    @Override
    public void mostrar(Pantalla pantalla){
        pantalla.MostrarJugador(x, y, this);
    };
    
    
    @Override
    protected boolean Colisionado(int movex, int movey){
      super.Colisionado(movex, movey);
      boolean colisionNPJ=false;
       for(int i=0; i<this.personajes.size(); i++){
            if(personajes.get(i).bordeder+personajes.get(i).bordeup*mapa.getAncho()== bordeizq+bordeup*mapa.getAncho()){
                this.colision=true;
                colisionNPJ=true;
                this.secundario=i;
                if(teclado.accion){
                    System.out.println(personajes.get(i).Hablar());
                }
            }
            if(personajes.get(i).bordeizq+personajes.get(i).bordeup*mapa.getAncho()== bordeder+bordeup*mapa.getAncho()){
                this.colision=true;
                colisionNPJ=true;
                this.secundario=i;
                if(teclado.accion){
                    System.out.println(personajes.get(i).Hablar());
                }
            }
            if(personajes.get(i).bordeder+personajes.get(i).bordedown*mapa.getAncho()== bordeizq+bordedown*mapa.getAncho()){
                this.colision=true;
                colisionNPJ=true;
                this.secundario=i;
                if(teclado.accion){
                    System.out.println(personajes.get(i).Hablar());
                }
            }
            if(personajes.get(i).bordeizq+personajes.get(i).bordedown*mapa.getAncho()== bordeder+bordedown*mapa.getAncho()){
                this.colision=true;
                colisionNPJ=true;
                this.secundario=i;
                if(teclado.accion){
                    System.out.println(personajes.get(i).Hablar());
                }
            }
            if(!colision){
                this.secundario=-1;
            }
       }
       return colision;
   }
}
