package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import Entidades.CuerpoAnimado;
import Entidades.Jugador;
import Utiles.Util;
import menues.MenuPrincipal;
import menues.SalaDeEspera;

public class HiloCliente extends Thread{
	
	private DatagramSocket conexion;
	private InetAddress ipServer;
	private int puerto = 8999;
	private boolean fin = false;
	
	public HiloCliente() {
	    try {
	        ipServer = InetAddress.getByName("255.255.255.255");
	        conexion = new DatagramSocket(); 
	        enviarMensaje("Conexion");
	    } catch (SocketException | UnknownHostException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void enviarMensaje(String msg) {
		System.out.println("Enviando mensaje a server");
		byte[] data=  msg.getBytes();
		DatagramPacket dp = new DatagramPacket(data, data.length,ipServer,puerto);
		try {
			conexion.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override 
	public void run(){
		do {
			System.out.println("Esperando respuesta");
			byte [] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data,data.length);
			try {
				conexion.receive(dp);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			procesarMensaje(dp);
		}while(!fin);
	}

	private void procesarMensaje(DatagramPacket dp) {
		String msg = new String(dp.getData(), 0, dp.getLength()).trim();
		if(msg.equals("OK")) {
			System.out.println("El server recibio el mensaje");
			ipServer = dp.getAddress();
		}  else if (msg.startsWith("Jugadores:")) {
	        String numero = msg.substring("Jugadores:".length());
	        try {
	            int cant = Integer.parseInt(numero);
	            SalaDeEspera.setJugadoresConectados(cant);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	        }
	    } else if(msg.equals("Empieza")) {
	        MenuPrincipal.pasarAConectado();
	        System.out.println("Ya empezo el juego");
	    }else if (msg.startsWith("INIT;")) {
	        // Formato: INIT;playerIndex;nombreEntidad;HAB1,HAB2,HAB3,...
	        String[] partes = msg.split(";");
	        int playerIndex = Integer.parseInt(partes[1]);
	        String nombreEntidad = partes[2];
	        String cartasStr = partes[3];
	        String[] cartasCodigos = cartasStr.split(",");

	        // Guardamos en red.Cliente para usarlo después
	        Cliente.setDatosInit(playerIndex, nombreEntidad, cartasCodigos);
	        System.out.println("INIT recibido: playerIndex=" + playerIndex +
	                ", entidad=" + nombreEntidad +
	                ", mano=" + cartasStr);

	    	}else if (msg.startsWith("JUGADORES;")) {
	    		String[] partes = msg.split(";");
	    		
	    		String cantJugadores = (partes[1]);
	    		for(int i=2; i< (Integer.parseInt(cantJugadores)*3)+2;i+=3) {
	    			String nombreEntidad = (partes[i]);
			        String puntos = partes[i+1];
			        String Idpersonaje = partes[i+2];
			        System.out.println("id personaje: " + Idpersonaje);     
			        Cliente.setIdPersonajesJugadores(Idpersonaje);
			        Cliente.agregarJugador(new Jugador(nombreEntidad, Integer.parseInt(puntos), null));
	    		}
	    	}
	    }
	
	
	public void cerrarConexion() {
	    if (conexion != null && !conexion.isClosed()) {
	        conexion.close();
	        System.out.println("Socket cerrado correctamente");
	    }
	}
	
	public void enviarListo() {
	    enviarMensaje("Listo");
	}
}

