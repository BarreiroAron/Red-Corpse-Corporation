package cartas;

import java.util.ArrayList;

import Entidades.Entidad;
import juegos.Juego;

public enum EnemigoDeterminado {
	IZQUIERDA(){
		@Override
		public Entidad devolverEnemigo(ArrayList<Entidad> jugadores,Entidad entidadJugada) {
			int siguienteIndice = (jugadores.indexOf(entidadJugada) + 1) % jugadores.size();
			System.out.println("Se va a atacar el jugador"+jugadores.get(siguienteIndice).getNombre() );
			return jugadores.get(siguienteIndice);
			}
		},DERECHA() {
		@Override
		public Entidad devolverEnemigo(ArrayList<Entidad> jugadores,Entidad entidadJugada) {
			// TODO Auto-generated method stub
			return null;
			}
		},SELECCIONAR_ENEMIGO(){
			
		@Override
		public Entidad devolverEnemigo(ArrayList<Entidad> jugadores,Entidad entidadJugada) {
			// TODO Auto-generated method stub
			return null;
			}
		};	
	public abstract Entidad devolverEnemigo(ArrayList<Entidad> jugadores, Entidad entidadJugada);
}
