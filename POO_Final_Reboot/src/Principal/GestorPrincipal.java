/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Principal.Graficos.SuperficieDibujo;
import Principal.Graficos.Ventana;
import Principal.MaquinaEstado.GestordeEstado;

/**
 *
 * @author Guillermo BG
 */

/*
Todas las clases que son gestoras son las encargadas de poducir
lo que ese paquete esta destinado a hacer 
*/

public class GestorPrincipal {
    private boolean enFuncionamiento=false;
    private String titulo;
    private int ancho, alto;
    
    private SuperficieDibujo sb;
    private Ventana ventana;
    private GestordeEstado ge;
    
    private GestorPrincipal(String n, int an, int al){
        this.titulo=n;
        this.ancho=an;
        this.alto=al;
    }
    
    public static void main(String args[]){
        GestorPrincipal gp= new GestorPrincipal("Vertlust",640, 360);
        gp.iniciarJuego();
        gp.iniciarLoopInicial();
    
    }

    private void iniciarJuego() {
       this.enFuncionamiento=true;
       inicializar();
    }

    private void iniciarLoopInicial() { //aparcado, mismo codigo de momento
        int aps=0;
        int fps=0;
        
        final int NS_S = 1000000000; //constante de un nanosegundo
        final byte APS_OBJETIVO = 60; //fps objetivos
        final double NS_ACTUALIZACION = NS_S / APS_OBJETIVO; //nano segundos entre cada actualizacion
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;
        
         while(this.enFuncionamiento) {
            final long INICIO_BUCLE = System.nanoTime(); 
            
            tiempoTranscurrido = INICIO_BUCLE - referenciaActualizacion;
            referenciaActualizacion = INICIO_BUCLE;
            delta += tiempoTranscurrido/NS_ACTUALIZACION;
            
            /*Actualiza la informacion a mostrar en ventana*/
            while(delta >= 1) {
                Actualizar();
                aps++;
                delta--;
            }
            /*---------------------------------------------*/
            
            Mostrar();
            fps++;
            
            /*-------------muestra aps y fps en el titulo de la ventana-------------*/
            if(System.nanoTime() - referenciaContador > NS_S) {
                ventana.setTitle(this.titulo);
                System.out.println("Fps: "+fps+" aps: "+aps);
                fps=0;
                aps=0;
                referenciaContador = System.nanoTime();
            }
            
            
            /*----------------------------------------------------------------------*/
        }
    }

    private void inicializar() {
        //inicializaremos todos los componentes del juego
        //---Temporal---//
        this.sb= new SuperficieDibujo();
        this.ventana = new Ventana(titulo, sb);
        this.ge= new GestordeEstado();
    }

    private void Actualizar() {
       // ge.actualizar();
    }

    private void Mostrar() {
       // ge.dibujar(g);
    }
    
    
}
