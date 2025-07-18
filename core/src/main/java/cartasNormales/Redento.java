package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Redento extends Carta {

	//Redento del Blasphemus
	/*Cuando esta carta es jugada, tu rival pierde la posibilidad de robar 
	 * del mazo durante cuatro turnos (este efecto no aplica si es que tiene una carta en la
	 *  mano y la juega y que
	 *   diga algo como “Robar del mazo”). Tu contador pierde 8 puntos.
	 */

	public Redento() {
		super(0, 8, Habilidad.BLOQUEAR_ROBO, new Imagen(Recursos.REDENTO), false, 0, 0, 
				"Cuando esta carta es jugada, tu rival pierde la posibilidad de robar del mazo durante cuatro turnos "
				+ "(este efecto no aplica si es que tiene una carta en la mano y la juega y que diga algo como “Robar del mazo”)."
				+ " Tu contador pierde 8% de puntos.\n");
	}
}