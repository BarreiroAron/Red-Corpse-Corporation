package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Chester extends Carta {

	private int puntosDisminuidos;
	
	//Carta de Shaco LOL
	
	/*Al jugar esta carta, los puntos del rival son intercambiados con otro obligatoriamente, 
	 * de ser más de un jugador, los puntos se cambian al siguiente jugador en la ronda.
	 */

	public Chester() {
		super(0, 0, Habilidad.INTERCAMBIO_PUNTOS, new Imagen(Recursos.CHESTER), false, 0, 0, 
				"Al jugar esta carta, los puntos del rival son intercambiados con otro obligatoriamente, "
				+ "de ser más de un jugador, los puntos se cambian al siguiente jugador en la ronda.");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
	
}
