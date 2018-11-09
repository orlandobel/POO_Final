/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

/**
 *
 * @author Orlando
 */
public final class Pantalla {
    private final int alto;
    private final int ancho;
    
    public final int[] pixeles;
    
    /*Temporal*/
    private final static int LADOSPRITE = 32;
    private final static int MASCARASPRITE = LADOSPRITE - 1;
    /*--------*/
    
    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new int[ancho*alto];
    }
    
    public void Limpiar() {
        for(int i=0;i<pixeles.length;i++) {
            pixeles[i] = 0;
        }
    }
    
    public void Mostrar(final int compX, final int compY) { //comp se refiere al movimiento del personaje en el eje
        for(int i=0;i<alto;i++) {
            int posY = i+compY; //coordenada en y
            
            /*Evita que nos salgamos de la pantalla en el eje y*/
            if(posY<0 || posY>=alto) {
                continue;
            }
            /*-------------------------------------------------*/
            
            for(int j=0;j<ancho;j++) {
                int posX = j+compX; //coordenada en y;
                
                /*Evita que nos salgamos de la pantalla en el eje x*/
                if(posX<0||posX>=ancho) {
                    continue;
                }
                /*-------------------------------------------------*/
                
                /*temporal*/
                pixeles[posX+posY*ancho] = Sprite.ejemplo1.pixeles[(j & MASCARASPRITE) + (i & MASCARASPRITE) * LADOSPRITE];
                /*temporal*/
            }
        }
    }
}
