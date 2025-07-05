package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Estrenimiento extends Carta {

	//Estreñimiento (carta sin referencia)
	
	/*Cuando es tirada esta carta, el rival (en su turno) es obligado 
a tirar una carta que si o si modifique de alguna manera tus puntos 
o los de el (Shaco no cuenta), de no poder tirar nada o no poder 
modificar los puntos. Roba dos cartas del mazo, esas cartas robadas si o si son malas.*/
	
	public Estrenimiento(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
