package Entidades;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cartas.Carta;
import juegos.Juego;

public abstract class Entidad {
	
	public String nombre;
	public int puntos;
	protected ArrayList<Carta> mano = new ArrayList<>();
	
	public Entidad(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public void modificarPuntos(int puntosCambiados, boolean porcentual) {
		if(porcentual) {
			puntosCambiados= puntos *(puntosCambiados/100);
		}
		
		if(puntosCambiados<0){
			this.puntos-=puntosCambiados;
			System.out.println("Se restaron");
		}else if(puntosCambiados>0) {
			this.puntos+=puntosCambiados;
			System.out.println("Se Sumaron");
		}
		System.out.println(" "+ puntosCambiados); 
	}
	
	public void modificarPuntos(int puntos, double modificarPuntos) {
		System.out.println("Se modificaron " + puntos + " Puntos");
	}
	
	public ArrayList<Carta> getMano() {
		return this.mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public void agregarCarta(Carta nuevaCarta) {
		this.mano.add(nuevaCarta);
	}
	public void removerCarta(Carta carta){
		this.mano.remove(carta);
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	};
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public void setPuntos(int puntosModificados) {
		this.puntos += puntosModificados;
	}
}
