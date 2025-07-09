package juegos;

import java.util.ArrayList;
import java.util.Collections;

import Entidades.Entidad;
import cartas.Carta;
import cartasEspeciales.IMHERE;
import cartasEspeciales.Inanicion;
import cartasMalas.PecadoDeLaCodicia;
import cartasMalas.Sonambulo;
import cartasNormales.Chester;
import cartasNormales.Colera;
import cartasNormales.KingDice;
import cartasNormales.Mimico;
import cartasNormales.OjoQueTodoLoVe;
import cartasNormales.Redento;
import cartasNormales.Saltamontes;
import cartasNormales.Snake;
import cartasNormales.ThanksForPlaying;

public class Juego {
	
	private int direccionRonda=0;
	private int turno;
	private int cantidadCartasMazo;
	private ArrayList<Carta> mazo;
	private int indiceMazo=0;
	private ArrayList<Entidad> jugadores;
	private int indiceJugadores=0;
	private int tiempo =2;
	private int rondas;
	
	public Juego(int rondas, ArrayList<Entidad> Jugadores){
		this.rondas=rondas;
		this.jugadores= Jugadores;
		iniciarMazo();
		repartirCartas();
	}

	private void iniciarMazo() {
		System.out.println("Se creo mazo");
		mazo = new ArrayList<>();
		
		mazo.add(new KingDice());
		mazo.add(new Redento());
		mazo.add(new ThanksForPlaying());

		// Cartas malas
		mazo.add(new PecadoDeLaCodicia());
		mazo.add(new Sonambulo());

		// Cartas especiales
		mazo.add(new IMHERE());
		mazo.add(new Inanicion());
		
		cantidadCartasMazo = mazo.size();
		
	    Collections.shuffle(mazo);
	}
	
	private void repartirCartas() {
		System.out.println("Se reparten cartas");
		for (Entidad jugador : jugadores) {
	        for (int i = 0; i < 3; i++) {
	            if (!mazo.isEmpty()) {
	                Carta carta = mazo.remove(0);
	                jugador.agregarCarta(carta); 
	            }
	        }
	    }
		
	}
	
	
	
	public Entidad getJugadores(int indice) {
		return jugadores.get(indice);
	}

	public void partida() {
		
	}
	
	public void actualizar(){
		
	}

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
