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
		
		Render.batch.begin();
		
		Mesa.dibujar();
		Cartel.dibujar();
		
		dibujarMano(Render.batch,juego.getJugadorActual());
		
		dibujarMesaCartas(Render.batch);
		
		Render.batch.end();
		
		juego.actualizar();
	}
	
	private void dibujarMesaCartas(SpriteBatch batch) {
		float width = 150.f;
	    float height = 250.f;
		float x =  (Gdx.graphics.getWidth()/2.f)-width/2;
        float y = Gdx.graphics.getHeight()/2.f;
        
		if(juego.getIndiceMesa()>=1) {
			juego.getMesa().getLast().getTexturaCarta().dibujar(batch, x, y, width, height);
		}
	}

	private Carta dibujarMano(SpriteBatch batch, Entidad jugador) {
		Carta cartaDesc = null;
		
	    ArrayList<Carta> mano = jugador.getMano();
	    
	    int cantidadCartas = mano.size();
	    float anchoCarta = 150.f;
	    float alturaCarta = 250.f;
	    float espacioEntreCartas = 40.f;
	   
	    float anchoTotal = cantidadCartas * anchoCarta + (cantidadCartas - 1) * espacioEntreCartas;

	    // Calcular la posición inicial para que quede centrado
	    float inicioX = (Gdx.graphics.getWidth() - anchoTotal) / 2.f;
	    float y = 150.f;

	    float mouseX = Gdx.input.getX();
	    float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

	    Carta cartaAEliminar = null;
	    int indice = 0;
        
	    for (Carta carta : mano) {
	    	float x = inicioX + indice * (anchoCarta + espacioEntreCartas);
	        float width = anchoCarta;
	        float height = alturaCarta;
	         
	        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
	        	
	                width *= 1.2f;   // Aumentar tamaño
	                height *= 1.2f;
	                
	   	            cartaDesc = carta;
	   	 
	   	          BitmapFont bitmapFont = new BitmapFont();
	   	          
	   	          float posX = 20f, posY = Gdx.graphics.getHeight() - 20f; 
				bitmapFont.draw(Render.batch, carta.getDescripcion(), posX, posY);
				
					x -= (width - anchoCarta) / 2;
					y -= (height - alturaCarta) / 2;
	                
	                if (Gdx.input.isTouched()) {
	                	long tiempoActual = TimeUtils.millis();
	                	
	                    if (tiempoActual - ultimoClickTime >= cooldownMs) {
	                        jugador.tirarCarta(carta,juego);
	                        juego.agregarCartaMesa(carta);
	                        cartaAEliminar = carta;
	                        juego.sumarRonda();
	                        ultimoClickTime = tiempoActual; // actualiza cooldown
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
