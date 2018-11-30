/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Mapa.Tiles.Tiles;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author Orlando
 */
public class CargarMapa extends Mapa implements Serializable{
    
    private int[] pixeles;
    
    public CargarMapa(String ruta) {
        super(ruta);
    }
    
    protected void SubirMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(CargarMapa.class.getResource(ruta));
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            indexTiles = new Tiles[ancho*alto];
            pixeles = new int[ancho*alto];
            
            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void Mapear() {
        /*
        en el switch-case se evalua el hexadecimal del rgb de cada color de pixel del modelado del mapa para asignar al array de tiles el sprite
        correspondiente, 0x se convierte el calor que sigue en el entero a evaluar y la linea ff al inicio de cada codigo de color indica opacidad maxima,
        esto para evitar que salga una ventana en negro por las transparencias
        */
        
        for(int i=0;i<pixeles.length;i++) {
            for(int j=0;j<pixeles.length;j++) {
                switch(pixeles[i]) {
                    case 0xff66341d:
                        indexTiles[i] = Tiles.TIERRA;
                        continue;
                    case 0xffa7b5d3:
                        indexTiles[i] = Tiles.CIELO1;
                        continue;
                    case 0xffa0acc8:
                        indexTiles[i] = Tiles.CIELO2;
                        continue;
                    case 0xffabb5cb:
                        indexTiles[i] = Tiles.CIELO3;
                        continue;
                    case 0xff6a6767:
                        indexTiles[i] = Tiles.TORRE_SUP;
                        continue;
                    case 0xff6d6262:
                        indexTiles[i] = Tiles.Invertir(Tiles.TORRE_SUP.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff605c5c:
                        indexTiles[i] = Tiles.TORRE_MID;
                        continue;
                    case 0xff605656:
                        indexTiles[i] = Tiles.Invertir(Tiles.TORRE_MID.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff636262:
                        indexTiles[i] = Tiles.TORRE_BASE;
                        continue;
                    case 0xff656060:
                        indexTiles[i] = Tiles.Invertir(Tiles.TORRE_BASE.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff2c2a2a:
                        indexTiles[i] = Tiles.TORRE_BACK;
                        continue;
                    case 0xff2d2828:
                        indexTiles[i] = Tiles.Invertir(Tiles.TORRE_BACK.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff726f6f:
                        indexTiles[i] = Tiles.PUENES_TORRES;
                        continue;
                    case 0xff726a6a:
                        indexTiles[i] = Tiles.Invertir(Tiles.PUENES_TORRES.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xfff49316:
                        indexTiles[i] = Tiles.BANDERA1;
                        continue;
                    case 0xfff3951b:
                        indexTiles[i] = Tiles.Invertir(Tiles.BANDERA1.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff746d6d:
                        indexTiles[i] = Tiles.SUPERIOR_VENTANA;
                        continue;
                    case 0xff746868:
                        indexTiles[i] = Tiles.Invertir(Tiles.SUPERIOR_VENTANA.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff8b97b8:
                        indexTiles[i] = Tiles.VENTANA_CIRCULAR;
                        continue;
                    case 0xff8594ba:
                        indexTiles[i] = Tiles.Invertir(Tiles.VENTANA_CIRCULAR.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xfff4a845:
                        indexTiles[i] = Tiles.BANDERA2;
                        continue;
                    case 0xfff3ac4e:
                        indexTiles[i] = Tiles.Invertir(Tiles.BANDERA2.s);
                        indexTiles[i].setSolido(true);
                        continue;
                    case 0xff5e1616:
                        indexTiles[i] = Tiles.PICO_TORRE;
                        continue;
                    case 0xffa7b1cf:
                        indexTiles[i] = Tiles.VENTANA_CENTRO;
                        continue;
                    case 0xff4e3f3f:
                        indexTiles[i] = Tiles.SUPERIOR_ENTRADA;
                        continue;
                    case 0xff000000:
                        indexTiles[i] = Tiles.ENTRADA_CASTILLO;
                        continue;
                    default:
                        indexTiles[i] = Tiles.VACIO;
                }
            }
        }
    }
}
