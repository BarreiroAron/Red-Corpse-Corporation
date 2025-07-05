package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class HambreContenida extends Carta {
	//Carta de Briar LOL
	
	/*Tus puntos aumentan en 30 y los del rival se reducen en 30, a cambio,
	 *  puedes escoger hasta 2 cartas del mazo que quieras a tu elección. 
	 * Si hay más de un jugador, los puntos se intercambian con el jugador siguiente en la ronda.
	 */

	public HambreContenida(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
