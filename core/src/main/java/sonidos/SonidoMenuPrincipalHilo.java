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
        Thread t = new Thread(() ->
            idSonidoRedCorpseCorporation =
                SonidoManager.i().playAmbientLoop(sonidoRedCorpseCorporation));
        t.start();
    }

    public void stop(){
    	audioCorre = false;
        SonidoManager.i().stopAmbientLoop(idSonidoRedCorpseCorporation);
        sonidoRedCorpseCorporation.dispose();
    }

}
