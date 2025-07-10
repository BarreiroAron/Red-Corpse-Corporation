package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Company extends Carta {

	private int puntosDisminuidos;
	
	//Carta de la computadora del Lethal Company
	
	/*Reinicia por completo la partida a excepción de los puntos de cada jugador y 
	 * el tiempo de la partida. Aumenta 20 puntos al rival
	 */

	public Company() {
		super(0, 10, Habilidad.REINICIAR_PARTIDA, new Imagen(Recursos.COMPANY), false, 0, 0, 
				"Reinicia por completo la partida a excepción de los puntos de cada jugador y el tiempo de la partida. "
				+ "Aumenta 10% puntos al rival");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}