package Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Entidades.Entidad;
import Entidades.Jugador;
import Entidades.Rival;
import Utiles.Recursos;
import Utiles.Render;
import Utiles.Util;
import cartas.Imagen;
import juegos.Juego;

public class PantallaCarga implements Screen {
	
	Imagen fondo;
	final float sumaDeTransparencia = 0.1f;
	//esto es para escribir menos, hacer referencia al render.batch
	SpriteBatch i;
	float f =0;
	float contadorTiempo =0, tiempoEsperado=1.5f;
	boolean procesoFadeTerminado=false;
	
	ArrayList<Entidad> jugadores = new ArrayList<>();
	Entidad entidad1 = new Jugador("Entidad 1");
	Entidad entidad2 = new Rival("Entidad 2");

	 
	Juego juego = new Juego(jugadores);
	
	@Override
	public void show() { 
		fondo = new Imagen(Recursos.FONDO);
		i= Render.batch;
		fondo.setTransparencia(f);
		
		jugadores.add(entidad1);
		jugadores.add(entidad2);
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla();
		i.begin();//inicio
			fondo.dibujar(i,0,0,Util.getAnchoPantalla(),Util.getAltoPantalla());
		i.end();//fin
		
		procesarFade();
	}

	private void procesarFade() {
		//toda la animacion aparicion y desaparicion
		if(!procesoFadeTerminado) {
			f+= sumaDeTransparencia;
			if(f>1) {
				f=1;
				procesoFadeTerminado=true;
			}
		}else {
			contadorTiempo += sumaDeTransparencia;
			if(contadorTiempo>tiempoEsperado) {
				f-=0.01f;
				if(f<0) {
					
					f=0;
					
					Render.inicio.setScreen(new JuegoPantalla(juego));
					juego= new Juego(jugadores);
					
				}
			}
		}
		fondo.setTransparencia(f);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
}
