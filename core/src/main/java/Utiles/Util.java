package Utiles;

import com.badlogic.gdx.Gdx;
import java.util.Random;

public class Util {
	
	public static int getAnchoPantalla() {
        return Gdx.graphics.getWidth();
    }

    public static int getAltoPantalla() {
        return Gdx.graphics.getHeight();
    }
    
    public static int sacarNumeroRandom(int porbabilidad) {
    	int randomNumero = (int) (Math.random() * porbabilidad) + 1;
    	return randomNumero;
    }
}
