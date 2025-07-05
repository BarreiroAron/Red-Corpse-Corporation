package Utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Render {
	//para evitar pasar todo el timepo la imagen de un lugar a otra
	
	public static SpriteBatch batch;
	
	public static void limpiarPantalla() {
		//Limpia la pantalla a blanco
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
