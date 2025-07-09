package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class KingDice extends Carta {

	//King dice del Cuphead
	
	/*Al jugar esta carta, todo el mazo es barajado y mezclado 
	 * (las cartas con efectos negativos son puestas nuevamente en el mazo). 
	 * Tu contador pierde 7 puntos y tu rival gana 4 puntos.
	 */

	public KingDice() {
		super(4, 7, Habilidad.ROBAR_CARTA, new Imagen(Recursos.KING_DICE), true, 0, 0);
	}
}