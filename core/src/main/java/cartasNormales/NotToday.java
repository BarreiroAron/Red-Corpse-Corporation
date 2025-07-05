package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class NotToday extends Carta {

	//Carta de NotToday del Minecraft
	
	/*Bloquea el efecto de la carta del rival jugada en este momento.*/

	public NotToday(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
