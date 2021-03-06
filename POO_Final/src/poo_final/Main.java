/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_final;

import Controles.Teclado;
import Ente.Personajes.*;
import Graficos.Pantalla;
import Graficos.Sprite;
import Mapa.CargarMapa;
import Mapa.Mapa;
import PruebaSonido.Sonido;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Orlando
 */
public class Main extends Canvas implements Runnable, Serializable{
    
    private static final long serialVersionUID = 1L; //identificador
    
    private static final int ANCHO = 420; //anco de ventana
    private static final int ALTO = 420; //alto de ventana
    private static final String NOMBRE = "Juego"; //nombre de ventana/juego
    private static String contFPS = "";
    private static String contAPS = "";
    
    /*Variables controladoras de frames y actualzaciones*/
    private static int aps = 0; //actualizaiones por segundo
    private static int fps = 0; //frames por segundo
    /*--------------------------------------------------*/
    
   
    private static Pantalla p;
    private static Mapa mapa;
    
    private Principal pepito;
    private int pepitoX;
    private int pepitoY;
    private Secundarios A, B, C, D, E, F;
    private ArrayList <Secundarios> G;
    
    private boolean hablando;
    
    /*Variables de manipulacion de pixeles del juego*/
    private static BufferedImage imagen = new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB); //crea una imagen en el buffer
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData(); //obtiene los pixeles como int y los almacena en un arreglo
    /*----------------------------------------------*/
            
    private static JFrame ventana;
    private static Menu mn;
    static Thread thread; //hilo principal
    private static Teclado teclado;
    private static volatile boolean Ejecucion = false; //variable de inizializacion/finalizacion del bucle principal
    
    Main(int i, int j) {
        init(i, j);
    }
    
    private void init(int i, int j) {
        setPreferredSize(new Dimension(ANCHO,ALTO));
        mn = new Menu();
        teclado = new Teclado();
        addKeyListener(teclado);
        
        p = new Pantalla(ANCHO,ALTO);
        mapa = new CargarMapa("/GeneradorNiveles/MapaCastillo.png");
        A= new Secundarios(96, 128, Sprite.SEC_PRUEBA, mapa, "Nosotros protegemos este castillo");
        B= new Secundarios(416, 288, Sprite.TER_PRUEBA, mapa, "Gustas... posiones?");
        C= new Secundarios(160, 320, Sprite.QUA_PRUEBA, mapa, "No se como llegué aqui");
        D= new Secundarios(320, 256, Sprite.PEN_PRUEBA, mapa, "El reino siempre ha sido un lugar seguro");
        E= new Secundarios(352, 128, Sprite.SEC_PRUEBA, mapa, "Nosotros protegemos este castillo");
        F= new Secundarios(45, 96, Sprite.HEX_PRUEBA, mapa, "Yo no estoy aqui, vete");
        G=new ArrayList();
        G.add(A);
        G.add(B);
        G.add(C);
        G.add(D);
        G.add(E);
        G.add(F);
        pepitoX=i;
        pepitoY=j;
        pepito = new Principal(teclado, pepitoX, pepitoY, Sprite.JUGADOR_PRUEBA_ABAJO, mapa, G);
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
        ventana.pack();
        ventana.setLocationRelativeTo(null); //esptablece la ventana en el centro por defecto
        ventana.setVisible(true);
        
    }
    
    public void posicinarJugador(int i, int j){
        init(i,j);
    }

    public void ActualizarPepitoX() {
        this.pepitoX = pepito.getX();
    }

    public void ActualizarPepitoY() {
        this.pepitoY = pepito.getY();
    }

    public int getPepitoX() {
        return pepitoX;
    }

    public int getPepitoY() {
        return pepitoY;
    }

    public JFrame getVentana() {
        return ventana;
    }
    
    /*--------Inizializa el hilo y su ciclo--------*/
    private synchronized void Iniciar() {
        this.Ejecucion = true;
        this.thread = new Thread(this, "Graficos"); //crea un nuevo hilo llamado graficos
        thread.start();
        Sonido.BACK.loop();
    }
    
    public synchronized void Empezar(){
        this.Iniciar();
    }
    /*---------------------------------------------*/

    @Override
    public String toString() {
        return ""+this.pepitoX+", "+this.pepitoY; //To change body of generated methods, choose Tools | Templates.
    }
    
    /*----------Detiene el juego----------*/
    private synchronized void Detener() {
        try {
            this.Ejecucion = false;
            this.thread.join(); //detiene el hilo despues de que termine el ciclo actual
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void Finalizar(){
        this.Detener();
    }
    /*------------------------------------*/
    
    /*Atualiza el contenido a mostrar*/
    private void Actualizar() {
        teclado.acualizar();
        pepito.actualizar();
        if(teclado.salir) {
            System.exit(0);
        }
        if(teclado.menu) {
            try{
                thread.sleep(100);
                mn.setJuego(this);
                mn.setVisible(true);
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        
        if(hablando){
            try {
                thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        //p.setDiferencias(pepito.getX()-p.getAncho()/2-pepito.getImagen().getLado()/2, pepito.getY()-p.getAlto()/2-pepito.getImagen().getLado()/2);
        aps++;
    }
    
    /*Muestra el contenido en la ventana*/
    private void Mostrar() {
        BufferStrategy estrategia = getBufferStrategy();
        if(estrategia==null) {
            createBufferStrategy(3);
            return;
        }
        
        //p.Limpiar();
//        p.Mostrar(X,Y);
        mapa.Mostrar(pepito.getX()-p.getAncho()/2-pepito.getImagen().getLado()/2, 
                pepito.getY()-p.getAlto()/2-pepito.getImagen().getLado()/2, p);
        pepito.mostrar(p);
        A.mostrar(p);
        B.mostrar(p);
        C.mostrar(p);
        D.mostrar(p);
        E.mostrar(p);
        F.mostrar(p);
        System.arraycopy(p.pixeles,0,this.pixeles,0,this.pixeles.length);//copia el rray de pixeles de la clase pantalla en el de esta clase para hacer el dibujado
        
        Graphics g = estrategia.getDrawGraphics(); //obtiene los graficos a dibujar
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),null); //dibuja los graficos
        g.setColor(Color.red);
        g.drawString(contAPS, 10, 20);
        g.drawString(contFPS, 10, 35);
        g.drawString("Pepito: ("+pepito.getX()+", "+pepito.getY()+")", 10, 50);
        if(teclado.accion && pepito.getSecundario()!=-1){
            
            g.setColor(Color.white);
            g.drawString(pepito.Platica(),64,320);
            this.hablando=true;
            
        }else{
            this.hablando=false;
        }
        g.dispose();
        
        estrategia.show();
        fps++;
    }
    
    /*------------------------Ejecucion del hilo------------------------*/
    @Override
    public void run() {
        final int NS_S = 1000000000; //constante de un nanosegundo
        final byte APS_OBJETIVO = 60; //fps objetivos
        final double NS_ACTUALIZACION = NS_S / APS_OBJETIVO; //nano segundos entre cada actualizacion
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;
        
        requestFocus(); //establece esta ventana como la seleccionada por defecto
        while(this.Ejecucion) {
            final long INICIO_BUCLE = System.nanoTime(); 
            
            tiempoTranscurrido = INICIO_BUCLE - referenciaActualizacion;
            referenciaActualizacion = INICIO_BUCLE;
            delta += tiempoTranscurrido/NS_ACTUALIZACION;
            
            /*Actualiza la informacion a mostrar en ventana*/
            while(delta >= 1) {
                Actualizar();
                delta--;
            }
            /*---------------------------------------------*/
            
            Mostrar();
            
            /*-------------muestra aps y fps en el titulo de la ventana-------------*/
            if(System.nanoTime() - referenciaContador > NS_S) {
                ventana.setTitle(NOMBRE + " APS: " + this.aps + " FPS: " + this.fps);
                contAPS = "APS: "+aps;
                contFPS = "FPS: "+fps;
                referenciaContador = System.nanoTime();
            }
            
            
            /*----------------------------------------------------------------------*/
        }
    }
    /*------------------------------------------------------------------*/
    
    public static void main(String args[]) {
        Main j = new Main(224,224);
       
        j.Iniciar();
        
    }
}
