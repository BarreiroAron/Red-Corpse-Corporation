package cartasEspeciales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class IMHERE extends Carta {
	
	public IMHERE() {
		super(0, 0, Habilidad.APARICION_ALEATORIA, new Imagen(Recursos.IM_SCARED), false, 12, 20);
	}
}