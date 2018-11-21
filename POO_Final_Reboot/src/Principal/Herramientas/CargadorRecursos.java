/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Herramientas;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Guillermo BG
 */
public class CargadorRecursos {
    public static BufferedImage cargarImagenCompatibleOpaca(final String ruta){
        //aqui esta todo lo puerco para que se pueda cargar en cualquier computadora
        //devuelve la imagen compatible con la compu y targeta grafica
        
        Image imagen=null;
        
        try {
            imagen= ImageIO.read(ClassLoader.class.getResource(ruta));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        GraphicsConfiguration gc= GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        //esta linea nos da la configuracion grafica de la pantalla donde se ejecuta la app
        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.OPAQUE);
        //misma imagen cargada en buffer
        
        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        //creo un grafico que dibuja la imagen en el buffer, aqui se decide si va a ram o a tarjeta grafica
        //el grafico desaparece despues de ello
        return imagenAcelerada;// retorno la imagen dibujada
    }
    
    public static BufferedImage cargarImagenCompatibleTraslusida(final String ruta){
        Image imagen=null;
        
        try {
            imagen= ImageIO.read(ClassLoader.class.getResource(ruta));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        GraphicsConfiguration gc= GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        //esta linea nos da la configuracion grafica de la pantalla donde se ejecuta la app
        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);
        //misma imagen cargada en buffer
        
        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        //creo un grafico que dibuja la imagen en el buffer, aqui se decide si va a ram o a tarjeta grafica
        //el grafico desaparece despues de ello
        return imagenAcelerada;// retorno la imagen dibujada
    }
    
    
}
