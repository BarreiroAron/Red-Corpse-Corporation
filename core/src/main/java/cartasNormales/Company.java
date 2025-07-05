package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Company extends Carta {

	//Carta de la computadora del Lethal Company
	
	/*Reinicia por completo la partida a excepción de los puntos de cada jugador y 
	 * el tiempo de la partida. Aumenta 20 puntos al rival
	 */

	public Company(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}