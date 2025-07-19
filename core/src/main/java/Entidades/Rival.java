package Entidades;

public class Rival extends Entidad {

	public Rival(String nombre, int puntos) {
		super(nombre, puntos);
	}
	
	public void agregarPuntos(int puntos) {
		this.puntos = puntos;
	}
	
}
