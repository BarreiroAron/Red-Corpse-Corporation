package juegos;

import java.util.ArrayList;
import java.util.Collections;

import Entidades.Entidad;
import cartas.Carta;
import cartasEspeciales.IMHERE;
import cartasEspeciales.Inanicion;
import cartasMalas.PecadoDeLaCodicia;
import cartasMalas.Sonambulo;
import cartasNormales.CambioDeRonda;
import cartasNormales.Chester;
import cartasNormales.Colera;
import cartasNormales.Company;
import cartasNormales.Estrenimiento;
import cartasNormales.HambreContenida;
import cartasNormales.KingDice;
import cartasNormales.Mimico;
import cartasNormales.NotToday;
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
	private ArrayList<Carta> mesa = new ArrayList<>();;
	private ArrayList<Entidad> jugadores;
	
	private int indiceMesa=0;
	private int indiceMazo=0;
	private int indiceJugadores=0;
	private int tiempo =2;
	private int rondas=0;
	
	public Juego( ArrayList<Entidad> Jugadores){
		this.jugadores= Jugadores;
		iniciarMazo();
		repartirCartas();
	}

	private void iniciarMazo() {
		System.out.println("Se creo mazo");
		mazo = new ArrayList<>();
		
		// Cartas normales
		mazo.add(new CambioDeRonda());
		mazo.add(new Chester());
		mazo.add(new Colera());
		mazo.add(new Company());
		mazo.add(new Estrenimiento());
		mazo.add(new HambreContenida());
		mazo.add(new KingDice());
		mazo.add(new Mimico());
		mazo.add(new NotToday());
		mazo.add(new OjoQueTodoLoVe());
		mazo.add(new Redento());
		mazo.add(new Saltamontes());
		mazo.add(new Snake());
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
	
	public void agregarCartaMesa(Carta  carta) {
		mesa.add(carta);
		aumentarIndiceMesa();
	}
	
	public void sumarRonda() {
		this.rondas++;
	}
	
	public Entidad getJugadores(int indice) {
		return jugadores.get(indice);
	}
	
	public ArrayList<Carta> getMesa() {
		return mesa;
	}
	
	public int getIndiceMesa() {
		return indiceMesa;
	}
	
	public void aumentarIndiceMesa() {
		indiceMesa++;
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