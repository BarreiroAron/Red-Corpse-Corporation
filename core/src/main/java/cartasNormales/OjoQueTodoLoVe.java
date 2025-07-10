package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class OjoQueTodoLoVe extends Carta {

	private int puntosDisminuidos;
	
	//Carta en referencia de Bill Clave de Gravity Falls
	
	/* Al jugar esta carta, durante este turno puedes ver las siguentes 3
	 *  cartas que siguen en el mazo (el orden es de izquierda a derecha,
	 *   siendo así la izquierda, la primera que se roba, 
	 * la de en medio la segunda y la de la derecha la última). 
	 * Los puntos del rival aumentan en 10
	 */

	public OjoQueTodoLoVe() {
		super(10, 0, Habilidad.VER_CARTAS_SIGUIENTES, new Imagen(Recursos.OJO_QUE_TODO_LO_VE), false, 0, 0, 
				"Al jugar esta carta, durante este turno puedes ver las siguentes 3 cartas que siguen en el mazo "
				+ "(el orden es de izquierda a derecha, siendo así la izquierda, la primera que se roba, la de en medio la segunda y la de la derecha la última). "
				+ "Los puntos del rival aumentan en 10%");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
