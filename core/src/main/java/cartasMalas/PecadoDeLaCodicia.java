package cartasMalas;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class PecadoDeLaCodicia extends Carta {
	
	//Pecado de la Codicia de la serie Hazbin Hotel
	/*Al robar esta carta, cuatro de tus cartas en la mano son destruidas. 
	 * Esta carta permanece en la mano hasta que sea jugada, 
	 * si esta carta es jugada: Tu rival aumenta 1 en su contador y tu contador se reduce en 5.
	 */

	//Esta carta aumenta tus puntos
	
	public PecadoDeLaCodicia() {
		super(0, 30, Habilidad.ROBAR_CARTA, new Imagen(Recursos.PECADO_CODICIA), true, 0, 0, "Al robar esta carta, cuatro de tus cartas en la mano son destruidas. "
				+ "Esta carta permanece en la mano hasta que sea jugada, si esta carta es jugada: "
				+ "Tu rival aumenta 1 en su contador y tu contador se reduce en 5.\r\n");
	}
}
