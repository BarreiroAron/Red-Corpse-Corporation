package Pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Utiles.Recursos;
import Utiles.Render;
import Utiles.Util;
import cartas.Imagen;

public class PantallaCarga implements Screen {

	Imagen fondo;
	//esto es para escribir menos, hacer referencia al render.batch
	SpriteBatch i;
	@Override
	public void show() { 
		fondo = new Imagen(Recursos.FONDO);
		i= Render.batch;
	}

	@Override
	public void render(float delta) {
		i.begin();//inicio
			fondo.dibujar(i,0,0,Util.getAnchoPantalla(),Util.getAltoPantalla());
		i.end();//fin
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
