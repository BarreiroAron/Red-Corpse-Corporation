package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Chester extends Carta {

	//Carta de Shaco LOL
	
	/*Al jugar esta carta, los puntos del rival son intercambiados con otro obligatoriamente, 
	 * de ser más de un jugador, los puntos se cambian al siguiente jugador en la ronda.
	 */

	public Chester(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
