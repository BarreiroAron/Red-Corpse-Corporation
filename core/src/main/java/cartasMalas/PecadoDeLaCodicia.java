package cartasMalas;

import cartas.Carta;
import cartas.Habilidad;

public class PecadoDeLaCodicia extends Carta {
	
	//Pecado de la Codicia de la serie Hazbin Hotel
	/*Al robar esta carta, cuatro de tus cartas en la mano son destruidas. 
	 * Esta carta permanece en la mano hasta que sea jugada, 
	 * si esta carta es jugada: Tu rival aumenta 1 en su contador y tu contador se reduce en 5.
	 */

	public PecadoDeLaCodicia(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}

}
