package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;
public class ThanksForPlaying extends Carta {

	//Carta de fresa ThanksForPlaying del Celeste
	/*Tus puntos se reducen en 15.*/
	
	private int puntosDisminuidos;

	public ThanksForPlaying() {
		super(0, 15, Habilidad.ROBAR_CARTA , new Imagen(Recursos.THX_FOR_PLAYING_CARTA), false , 0,0);
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}