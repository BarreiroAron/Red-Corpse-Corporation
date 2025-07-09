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
	Carta imScared;
	Carta pecadoCodicia;
	Carta redento;
	Carta kingDice;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		Mesa = new Imagen(Recursos.MESA_PRINCIPAL);
		Cartel = new Imagen(Recursos.CARTEL);
		Enemigo = new Imagen(Recursos.RIVAL1);
		
		tfp = new ThanksForPlaying();
		imScared = new IMHERE();
		pecadoCodicia = new PecadoDeLaCodicia();
		redento = new Redento();
		kingDice = new KingDice();
	}
	
	@Override
	public void render(float delta) {
		Render.limpiarPantalla();
		System.out.println("Estas en juego");
		Render.batch.begin();
		
		Mesa.dibujar();
		Cartel.dibujar();
		
		
		//imScared.getTexturaCarta().dibujar();
		//tfp.getTexturaCarta().dibujar();
		//pecadoCodicia.getTexturaCarta().dibujar();
		//redento.getTexturaCarta().dibujar();
		//kingDice.getTexturaCarta().dibujar();
		
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
