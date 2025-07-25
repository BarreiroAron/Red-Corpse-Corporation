package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class NotToday extends Carta {

	private int puntosDisminuidos;
	
	//Carta de NotToday del Minecraft
	
	/*Bloquea el efecto de la carta del rival jugada en este momento.*/

	public NotToday() {
		super(0, 0, Habilidad.BLOQUEAR_EFECTO, new Imagen(Recursos.NOT_TODAY), false, 0, 0, 
				"Bloquea el efecto de la carta del rival jugada en este momento.");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
