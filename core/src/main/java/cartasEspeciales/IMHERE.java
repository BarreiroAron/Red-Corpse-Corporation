package cartasEspeciales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class IMHERE extends Carta {
	
	public IMHERE() {
		super(0, 0, Habilidad.APARICION_ALEATORIA, new Imagen(Recursos.IM_SCARED), false, 12, 20, "Esta carta no puede ser robada y no puede ser obtenida de forma común. "
				+ "Si tu personaje se queda sin cartas en la mano, aparece esta carta llamada “inaniciòn”. "
				+ "Al tener esta carta en la mano, según vayan pasando los turnos, tus puntos van a ir aumentando "
				+ "(esto va a ser progresivamente, el primer turno x1, el segundo x2, el tercero x3 y así susecivamente).");
	}
}