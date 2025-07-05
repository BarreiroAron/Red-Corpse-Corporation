package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Snake extends Carta {

	//Snake del metal gear solid
	
	/* Permite ver los puntos del rival durante un turno. Baja 8 puntos de tu contador*/

	public Snake(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
