package cartasEspeciales;

import cartas.Carta;
import cartas.Habilidad;

public class IMHERE extends Carta {
	//Carta de referencia al IM SCARED
	
	/*Esta carta aparece de manera aleatoria con 1% 
	 * al tirar una carta, afecta a los dos jugadores de diferentes maneras, 
	 * robando cartas de la mano, cambiando sus cartas, o minimizando el juego.
	 */
	
	public IMHERE(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
