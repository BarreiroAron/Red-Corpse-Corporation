package Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import Entidades.Entidad;
import cartas.Carta;
import Utiles.Recursos;
import Utiles.Render;
import cartas.Imagen;
import cartasEspeciales.IMHERE;
import cartasMalas.PecadoDeLaCodicia;
import cartasNormales.KingDice;
import cartasNormales.Redento;
import cartasNormales.ThanksForPlaying;
import juegos.Juego;


public class JuegoPantalla implements Screen{

	Imagen Mesa;
	Imagen Cartel;
	Imagen Enemigo;
	
	Carta tfp;
	
	private long cooldownMs = 500; 
	private long ultimoClickTime = 0;
	
	Juego juego;
	
	//variables para detectar el mouse
	float mouseX = Gdx.input.getX();
	float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

	
	public JuegoPantalla(Juego juego) {
		this.juego=juego;
	}
	
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
		
		dibujarMano(Render.batch,juego.getJugadores(0), juego.getJugadores(1));
		BitmapFont font = new BitmapFont();
		
		Render.batch.end();
		
		juego.actualizar();
	}
	
	private Carta dibujarMano(SpriteBatch batch, Entidad jugador, Entidad rival) {
		Carta cartaDesc = null;
		
		
		
	    ArrayList<Carta> mano = jugador.getMano();
	    int espacioEntreCartas = mano.size() > 0 ? (Gdx.graphics.getWidth() / 3) / mano.size() : 0;
	    int indice = 0;

	    float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
	    
        Carta cartaAEliminar = null;
        
	    for (Carta carta : mano) {
	    	 float x = (Gdx.graphics.getWidth() / 3) + espacioEntreCartas * indice;
	         float y = 150.f;
	         float width = 150.f;
	         float height = 250.f;
	         
	        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
	        	
	                width *= 1.2f;   // Aumentar tamaño
	                height *= 1.2f;
	   	            cartaDesc = carta;
	   	 
	   	          BitmapFont bitmapFont = new BitmapFont();
				bitmapFont.draw(Render.batch, carta.getDescripcion(), 100, 100);
				
	                x -= (width - 150.f) / 2;  // Re-centrar al agrandar
	                y -= (height - 250.f) / 2;
	                
	                if (Gdx.input.isTouched()) {
	                	long tiempoActual = TimeUtils.millis();
	                	
	                    if (tiempoActual - ultimoClickTime >= cooldownMs) {
	                        jugador.tirarCarta(carta, rival);
	                        cartaAEliminar = carta;
	                        System.out.println("Se selecciono la carta " + carta.getDescripcion());
	                        ultimoClickTime = tiempoActual; // ✅ Actualizar cooldown
	                    }
	                }
	            }
	        
	        carta.getImagenCarta().dibujar(batch, x, y, width, height);
	        indice++;
	    }
	    
	    if (cartaAEliminar != null) {
	        jugador.removerCarta(cartaAEliminar);
	    }
	    
		return cartaDesc;
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
