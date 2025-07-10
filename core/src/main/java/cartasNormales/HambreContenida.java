package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class HambreContenida extends Carta {
	
	private int puntosDisminuidos;
	
	//Carta de Briar LOL
	
	/*Tus puntos aumentan en 30 y los del rival se reducen en 30, a cambio,
	 *  puedes escoger hasta 2 cartas del mazo que quieras a tu elección. 
	 * Si hay más de un jugador, los puntos se intercambian con el jugador siguiente en la ronda.
	 */

	public HambreContenida() {
		super(30, 30, Habilidad.HAMBRE, new Imagen(Recursos.HAMBRE_CONTENIDA), false, 0, 0, 
				"Tus puntos aumentan en 30% y los del rival se reducen en 30%, a cambio, "
				+ "puedes escoger hasta 2 cartas del mazo que quieras a tu elección. "
				+ "Si hay más de un jugador, los puntos se intercambian con el jugador siguiente en la ronda.");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
