package Entidades;

import java.util.ArrayList;

import cartas.Carta;

public class Jugador extends Entidad {
	
	private String nombre;
	
	public Jugador(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public void agregarCarta(Carta nuevaCarta) {
		this.mano.add(nuevaCarta);
	}
	
	public void modificarPuntos(int puntos) {
		System.out.println("Se modificaron " + puntos + " Puntos");
	}
	
	public void robarCarta(boolean robar) {
		
	}
	
	public void bloquearRobo() {
		
	}
}
