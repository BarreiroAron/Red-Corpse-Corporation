package Pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import cartas.Carta;
import Utiles.Recursos;
import Utiles.Render;
import cartas.Imagen;
import cartasEspeciales.IMHERE;
import cartasMalas.PecadoDeLaCodicia;
import cartasNormales.KingDice;
import cartasNormales.Redento;
import cartasNormales.ThanksForPlaying;

public class JuegoPantalla implements Screen{

	Imagen Mesa;
	Imagen Cartel;
	Imagen Enemigo;
	
	Carta tfp;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		Mesa = new Imagen(Recursos.MESA_PRINCIPAL);
		Cartel = new Imagen(Recursos.CARTEL);
		Enemigo = new Imagen(Recursos.RIVAL1);
		
		tfp = new ThanksForPlaying();
	}
	
	@Override
	public void render(float delta) {
		Render.limpiarPantalla();
		
		System.out.println("Estas en juego");
		
		Render.batch.begin();
		
		Mesa.dibujar();
		Cartel.dibujar();
		
		tfp.getTexturaCarta().dibujar();
		
		Render.batch.end();
		
		
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
