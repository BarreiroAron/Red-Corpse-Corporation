package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class OjoQueTodoLoVe extends Carta {

	//Carta en referencia de Bill Clave de Gravity Falls
	
	/* Al jugar esta carta, durante este turno puedes ver las siguentes 3
	 *  cartas que siguen en el mazo (el orden es de izquierda a derecha,
	 *   siendo así la izquierda, la primera que se roba, 
	 * la de en medio la segunda y la de la derecha la última). 
	 * Los puntos del rival aumentan en 10
	 */

	public OjoQueTodoLoVe(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}
}
