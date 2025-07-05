package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class KingDice extends Carta {

	//King dice del Cuphead
	
	/*Al jugar esta carta, todo el mazo es barajado y mezclado 
	 * (las cartas con efectos negativos son puestas nuevamente en el mazo). 
	 * Tu contador pierde 7 puntos y tu rival gana 4 puntos.
	 */

	public KingDice(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
