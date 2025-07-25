package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Saltamontes extends Carta {

	private int puntosDisminuidos;
	
	//Saltamontes (carta sin referencia)
	
	//Saltee el próximo turno del rival.
	
	public Saltamontes() {
		super(0, 0, Habilidad.SALTEAR_TURNO, new Imagen(Recursos.SALTAMONTES), false, 0, 0, 
				"Saltee el próximo turno del rival.");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
