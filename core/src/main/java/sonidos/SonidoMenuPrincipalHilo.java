package sonidos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import Utiles.Util;

public class SonidoMenuPrincipalHilo {
	
	private long idSonidoRedCorpseCorporation;
    private Sound sonidoRedCorpseCorporation;
    private boolean audioCorre;
    
    public SonidoMenuPrincipalHilo() {
    	sonidoRedCorpseCorporation = Gdx.audio.newSound(Gdx.files.internal("RedCorpseCorporationAudio.wav"));
    	audioCorre = true;
        start();
    }
    
    public void start() {
        Thread soundThread = new Thread(new Runnable() {
        	public void run() {
        		idSonidoRedCorpseCorporation = sonidoRedCorpseCorporation.play();
        }
       });
        soundThread.start();
    }
    
    public void stop() {
    	audioCorre = false;
        if (sonidoRedCorpseCorporation != null) {
        	sonidoRedCorpseCorporation.stop(idSonidoRedCorpseCorporation);
        	sonidoRedCorpseCorporation.dispose();
        }
    }
}
