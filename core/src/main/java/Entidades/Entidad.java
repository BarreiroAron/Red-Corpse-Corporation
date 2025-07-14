package Entidades;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cartas.Carta;

public abstract class Entidad {
	
	protected String nombre;
	protected ArrayList<Carta> mano = new ArrayList<>();
	
	public void tirarCarta(Carta cartaSeleccionada,Entidad rival) {
		cartaSeleccionada.usar(this, rival);
	}
	
	public Entidad(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public void agregarCarta(Carta nuevaCarta) {
		mano.add(nuevaCarta);
	}
	public void removerCarta(Carta carta){
		mano.remove(carta);
	};
}
