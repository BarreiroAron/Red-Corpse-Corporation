package cartasEspeciales;

import cartas.Carta;
import cartas.Habilidad;

public class Inanicion extends Carta {
	//Carta de Inscrypthion inanicion
	/*Esta carta no puede ser robada y no puede ser obtenida de forma común. 
	 * Si tu personaje se queda sin cartas en la mano, aparece esta carta llamada 
	 * “inaniciòn”. Al tener esta carta en la mano, según vayan pasando los turnos,
	 *  tus puntos van a ir aumentando (esto va a ser progresivamente, el primer turno x1, 
	 *  el segundo x2, el tercero x3 y así susecivamente).
	 * Referencia a Inscryption (Carta de Inanición) */

	public Inanicion(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}

}
