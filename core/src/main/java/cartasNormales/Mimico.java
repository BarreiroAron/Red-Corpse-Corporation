package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Mimico extends Carta {
	
	//Mimico de referencia al Dark Souls
	
	/*Al ser jugada esta carta, en tu siguiente turno tenes que 
	 * robar una carta del mazo si o si. Si esta carta resulta ser 
	 * otra mímica. Entonces tus puntos se reducen en 30 y los puntos del rival 
	 * aumentan en 50. Si no es un mímico, los puntos del rival son reducidos en 30 
	 * y tus puntos son aumentados en 70
	 */

	public Mimico(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
