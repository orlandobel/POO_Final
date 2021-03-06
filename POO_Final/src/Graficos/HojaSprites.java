/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author Orlando
 */
/*Manejara los sprites usados en el juego*/
public class HojaSprites implements Serializable{
    private final int alto; //alto de la hoja de sprites
    private final int ancho; //ancho de la hoja de spites
    public final int[] pixeles; //hoja de sprites
    
    /*Coleccion de hojas de sprites*/
    public static HojaSprites Hoja1 = new HojaSprites("/Texturas/HojaMapeado.png",640,512);
    public static HojaSprites personajePrueba= new HojaSprites("/Texturas/RPGCharacterSprites32x32.png",384,672);
    /*Coleccion de hojas de sprites*/
    
    public HojaSprites(final String ruta, final int ancho, final int alto) {
        this.alto = alto;
        this.ancho = ancho;
        pixeles = new int[ancho*alto];
        
        try {
            BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta)); //lee la imagen de la ruta dada
            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho); //obtiene los pixeles de la hoja y los alamcena en el arreglo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int getAncho() {
        return this.ancho;
    }
    
    public int getAlto() {
        return this.alto;
    }
}
