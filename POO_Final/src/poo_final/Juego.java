/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_final;

import Controles.Teclado;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Orlando
 */
public class Juego extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1L; //identificador
    
    private static final int ANCHO = 800; //anco de ventana
    private static final int ALTO = 600; //alto de ventana
    private static final String NOMBRE = "Juego"; //nombre de ventana/juego
    
    private static int aps = 0; //actualizaiones por segundo
    private static int fps = 0; //frames por segundo
    
    private static JFrame ventana;
    private static Thread thread; //hilo principal
    private static Teclado teclado;
    
    private static volatile boolean Ejecucion = false; //variable de inizializacion/finalizacion del bucle principal
    
    private Juego() {
        init();
    }
    
    private void init() {
        setPreferredSize(new Dimension(ANCHO,ALTO));
        teclado = new Teclado();
        addKeyListener(teclado);
        
        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null); //esptablece la ventana en el centro por defecto
        ventana.setVisible(true);
    }
    
    /*--------Inizializa el hilo y su ciclo--------*/
    private synchronized void Iniciar() {
        this.Ejecucion = true;
        this.thread = new Thread(this, "Graficos"); //crea un nuevo hilo llamado graficos
        thread.start(); //empieza el hilo
    }
    /*---------------------------------------------*/
    
    /*----------Detiene el juego----------*/
    private synchronized void Detener() {
        try {
            this.Ejecucion = false;
            this.thread.join(); //detiene el hilo despues de que termine el ciclo actual
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*------------------------------------*/
    
    /*Atualiza el contenido a mostrar*/
    private void Actualizar() {
        teclado.acualizar();
        
        if(teclado.arriba==true) {
            System.out.println("Arriba");
        } 
        if(teclado.abajo==true) {
            System.out.println("Abajo");
        } 
        if(teclado.izquierda==true) {
            System.out.println("Izquierda");
        } 
        if(teclado.derecha==true) {
            System.out.println("Derecha");
        }
        aps++;
    }
    
    /*Muestra el contenido en la ventana*/
    public void Mostrar() {
        fps++;
    }
    
    /*------------------------Ejecucion del hilo------------------------*/
    @Override
    public void run() {
        final int NS_S = 1000000000; //constante de un nanosegundo
        final byte ATS_OBJETIVO = 60; //fps objetivos
        final double NS_ACTUALIZACION = NS_S / ATS_OBJETIVO; //nano segundos entre cada actualizacion
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta = 0;
        
        requestFocus(); //establece esta ventana como la seleccionada por defecto
        System.out.println("Hola");
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
                this.aps = 0;
                this.fps = 0;
                referenciaContador = System.nanoTime();
            }
            /*----------------------------------------------------------------------*/
        }
    }
    /*------------------------------------------------------------------*/
    
    public static void main(String args[]) {
        Juego j = new Juego();
        j.Iniciar();
    }
}
