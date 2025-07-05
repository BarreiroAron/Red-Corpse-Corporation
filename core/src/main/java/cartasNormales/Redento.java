package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Redento extends Carta {

	//Redento del Blasphemus
	/*Cuando esta carta es jugada, tu rival pierde la posibilidad de robar 
	 * del mazo durante cuatro turnos (este efecto no aplica si es que tiene una carta en la
	 *  mano y la juega y que
	 *   diga algo como “Robar del mazo”). Tu contador pierde 8 puntos.
	 */

	public Redento(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
