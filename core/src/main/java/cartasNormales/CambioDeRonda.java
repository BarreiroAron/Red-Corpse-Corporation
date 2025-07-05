package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class CambioDeRonda extends Carta {

	//Cartas de cambio de ronda del UNO!
	//Cambia el ciruclo de la ronda
	
	public CambioDeRonda(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
