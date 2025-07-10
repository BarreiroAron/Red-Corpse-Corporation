package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Colera extends Carta {

	private int puntosDisminuidos;
	
	//Colera (esta es una carta sin referencia
	
	/*
Al jugar esta carta, te ves obligado
 en los siguientes 3 turnos a solo robar del mazo. 
 Si en las 3 robadas no sale ninguna carta mala: Tus puntos se reducen en 20.*/

	public Colera() {
		super(0, 15, Habilidad.ROBAR_CARTA , new Imagen(Recursos.COLERA), true , 0,0, 
				"Al jugar esta carta, te ves obligado en los siguientes 3 turnos a solo robar del mazo."
				+ " Si en las 3 robadas no sale ninguna carta mala: Tus puntos se reducen en 15%.");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
	
}
