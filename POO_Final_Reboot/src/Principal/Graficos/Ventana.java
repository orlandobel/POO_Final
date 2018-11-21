/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Graficos;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Guillermo BG
 */
public class Ventana extends JFrame {
    //simplemente esto es la ventana que se va a mostrar
    private String titulo;
    
    public Ventana (final String titulo, final SuperficieDibujo sd){
        this.titulo=titulo;
        
        configurarVentana(sd);
    }

    private void configurarVentana(SuperficieDibujo sd) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setIconImage();
        setLayout(new BorderLayout());
        add(sd, BorderLayout.CENTER);
        //setUndecorated();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
