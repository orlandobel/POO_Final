package PruebaSonido;

import java.applet.Applet; //Paqueteria para usar funciones en internet, y multimedia (aunque no llevemos el juego a la red)
import java.applet.AudioClip; //Paqueteria de Applet utilizada para leer archivos de audio

public class Sonido {
	public static final AudioClip BACK = Applet.newAudioClip(Sonido.class.getResource("TotheTop.wav"));
}


