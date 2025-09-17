package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;
import cartas.TipoDeCarta;
public class ThanksForPlaying extends Carta {

	//Carta de fresa ThanksForPlaying del Celeste
	/*Tus puntos se reducen en 15.*/
	
	private int puntosDisminuidos;

	public ThanksForPlaying() {
		super(0, 50, Habilidad.MODIFICAR_PUNTOS, new Imagen(Recursos.THX_FOR_PLAYING_CARTA), false , 0,0, "Reduce tus puntos en un 50%",TipoDeCarta.NORMAL);
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}