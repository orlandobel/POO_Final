/*
 * Clase padre donde naceran todos personajes, desde el principal, como los NPC
 */
package poo_final;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

/**
 *
 * @author Guillermo BG
 */
public class Personajes extends Thread implements KeyListener{
    public static int MAXVIDA=3;
    protected String nombre;
    protected int vida;
    protected JLabel Imagen; //Si se necesita, lo puedes cambiar
    protected boolean agresivo;
    //si es verdad, puede tener faccion
    
    
    Personajes(String n, int v, JLabel b){
        this.nombre=n;
        this.vida=v;
        this.agresivo=false;
        this.Imagen=b;
    }//aqui puedes generar personajes npcs, sin relevancia al juego. no se podran atacar
    
    
    Personajes(String n, int v, boolean ag, JLabel b){
        this.nombre=n;
        this.vida=v;
        this.agresivo=ag;
        this.Imagen=b;
    }// aqui podras crear personajes secundarios que sí afecten a la historia, que en algun momento estaran en algun bando.
    
    Personajes(String n, JLabel b){
        this.nombre=n;
        this.Imagen=b;
        this.vida=MAXVIDA;
        this.agresivo=true;
    }// generador del personaje principal.

    //getters y setters de los personajes en general, en caso de ocuparlos
    //con estos mismos puedes hacer reduccion de vida
    //o en caso de que la historia te deje, eliminarlo directamente.
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public boolean isAgresivo() {
        return agresivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAgresivo(boolean agresivo) {
        this.agresivo = agresivo;
    }
   
   public void Movimiento(){
   }
   
   public void Ataque(){    
   }
   
   public void Muerte(){
       
   }
// Eventos de teclado, que la implementacion este aqui nos permite mover a otros personajes secundarios
// Simulando que estos sigan al personaje principal, en caso de que no lo quieras hace borrar la implementacion y usarla solo en el principal
// En caso de usarla hay que definir los controles y no poner la opcion del cambio del propio
// example: W, A, S, D  para movimiento
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
 