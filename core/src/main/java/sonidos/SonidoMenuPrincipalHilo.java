package sonidos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import Utiles.Util;

public class SonidoMenuPrincipalHilo {
	
	private long idSonidoSoundract;
    private Sound sonidoSoundract;
    private boolean audioCorre;
    
    public SonidoMenuPrincipalHilo() {
    	sonidoSoundract = Gdx.audio.newSound(Gdx.files.internal("BalatroOrquestaSoundractProvisorio.mp3"));
    	audioCorre = true;
        start();
    }
    
    public void start() {
        Thread t = new Thread(() ->
            idSonidoSoundract =
                SonidoManager.i().playAmbientLoop(sonidoSoundract));
        t.start();
    }

    public void stop(){
    	audioCorre = false;
        SonidoManager.i().stopAmbientLoop(idSonidoSoundract);
        sonidoSoundract.dispose();
    }

}
