package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Saltamontes extends Carta {

	//Saltamontes (carta sin referencia)
	
	//Saltee el próximo turno del rival.

	public Saltamontes(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
