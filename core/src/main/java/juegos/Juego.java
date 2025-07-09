package juegos;

import java.util.ArrayList;

import Entidades.Entidad;
import cartas.Carta;

public class Juego {
	
	private int direccionRonda;
	private int cantidadCartasMazo;
	private ArrayList<Carta> Mazo;
	private ArrayList<Entidad> Jugadores;
	private int tiempo =2;
	private int rondas;

	public int getDireccionRonda() {
		return direccionRonda;
	}

	public void setDireccionRonda(int direccionRonda) {
		this.direccionRonda = direccionRonda;
	}

	public int getCantidadCartasMazo() {
		return cantidadCartasMazo;
	}

	public void setCantidadCartasMazo(int cantidadCartasMazo) {
		this.cantidadCartasMazo = cantidadCartasMazo;
	}
}
