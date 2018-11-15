/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import Mapa.Tiles.Tiles;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Orlando
 */
public class CargarMapa extends Mapa{
    
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
                    case 0xff743115:
                        indexTiles[i] = Tiles.TIERRA;
                        continue;
                    case 0xffa3b6d5:
                        indexTiles[i] = Tiles.CIELO1;
                        continue;
                    case 0xff9caeca:
                        indexTiles[i] = Tiles.CIELO2;
                        continue;
                    case 0xffa8b6cd:
                        indexTiles[i] = Tiles.CIELO3;
                        continue;
                    case 0xff6c6767:
                        indexTiles[i] = Tiles.TORRE_SUP_IZQ;
                        continue;
                    case 0xff726262:
                        indexTiles[i] = Tiles.TORRE_SUP_DER;
                        continue;
                    case 0xff615c5c:
                        indexTiles[i] = Tiles.TORRE_MID_IZQ;
                        continue;
                    case 0xff645555:
                        indexTiles[i] = Tiles.TORRE_MID_DER;
                        continue;
                    case 0xff636262:
                        indexTiles[i] = Tiles.TORRE_BASE_IZQ;
                        continue;
                    case 0xff676060:
                        indexTiles[i] = Tiles.TORRE_BASE_DER;
                        continue;
                    case 0xff292626:
                        indexTiles[i] = Tiles.TORRE_BACK_IZQ;
                        continue;
                    case 0xff2b2323:
                        indexTiles[i] = Tiles.TORRE_BACK_DER;
                        continue;
                    case 0xff747070:
                        indexTiles[i] = Tiles.PUENES_TORRES_IZQ;
                        continue;
                    case 0xff766a6a:
                        indexTiles[i] = Tiles.PUENES_TORRES_DER;
                        continue;
                    case 0xffff9400:
                        indexTiles[i] = Tiles.BANDERA1_IZQ;
                        continue;
                    case 0xffff9600:
                        indexTiles[i] = Tiles.BANDERA1_DER;
                        continue;
                    case 0xff776d6d:
                        indexTiles[i] = Tiles.SUPERIOR_VENTANA_IZQ;
                        continue;
                    case 0xff796868:
                        indexTiles[i] = Tiles.SUPERIOR_VENTANA_DER;
                        continue;
                    case 0xff8798bb:
                        indexTiles[i] = Tiles.VENTANA_CIRCULAR_IZQ;
                        continue;
                    case 0xff7f95bd:
                        indexTiles[i] = Tiles.VENTANA_CIRCULAR_DER;
                        continue;
                    case 0xffffa93a:
                        indexTiles[i] = Tiles.BANDERA2_IZQ;
                        continue;
                    case 0xffffad45:
                        indexTiles[i] = Tiles.BANDERA2_DER;
                        continue;
                    case 0xff6d0e0e:
                        indexTiles[i] = Tiles.PICO_TORRE;
                        continue;
                    case 0xffa4b3d1:
                        indexTiles[i] = Tiles.VENTANA_CENTRO;
                        continue;
                    case 0xff523d3d:
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
