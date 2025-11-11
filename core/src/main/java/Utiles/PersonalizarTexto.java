package Utiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PersonalizarTexto {
    public static void configurarFuente(BitmapFont fuente, float escala, Color color, Color sombra) {
        fuente.getData().setScale(escala); 
        fuente.setColor(color);  
        fuente.getRegion().getTexture().setFilter(
        		com.badlogic.gdx.graphics.Texture.TextureFilter.Linear,
                com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
        );
    }
    
    public static void textoCarta(BitmapFont fuente, SpriteBatch batch, String texto, float x, float y) {
        fuente.setColor(Color.BLACK);
        fuente.draw(batch, texto, x + 2, y - 2);
        fuente.setColor(Color.GOLD);
        fuente.draw(batch, texto, x, y);
    }
}