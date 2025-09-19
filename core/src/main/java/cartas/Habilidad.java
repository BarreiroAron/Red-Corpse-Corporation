package cartas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Entidades.Entidad;
import Entidades.Jugador;
import Pantallas.JuegoPantalla;
import Utiles.Render;
import juegos.ControladorDeJuego;
import juegos.Juego;

public enum Habilidad {
	
    MODIFICAR_PUNTOS { //modifica puntos en general
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
           // jugador.modificarPuntos(carta.getPuntosDisminuidos());
           // rival.modificarPuntos(carta.getPuntosAumentadosRival());
        }
    },
    BLOQUEAR_ROBO { //Para efectos generales (seguramente "Not today" va a usarla si o si) y redento
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
           // jugador.bloquearRobo();
        }
    },
    
    BLOQUEAR_EFECTO { //Sirve para efecto de Not today
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
            
        }
    },
    
    CAMBIO_DIRECCION { //Sirve para efecto de Cambio de ronda
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
            controlador.cambiarDireccion();
        }
    },
    
    VER_CARTAS_SIGUIENTES() { //sirve para efectos de Ojo que todo lo ve
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
        	   if (controlador instanceof Juego juego) {
                   ArrayList<Carta> mazo = juego.getMazo();
                   ArrayList<Carta> cartaMostrada = new ArrayList<>();

                   for (int i = 0; i < 3 && i < mazo.size(); i++) {
                       cartaMostrada.add(mazo.get(i));
                   }

                   juego.setCartasMostradas(cartaMostrada);

                   System.out.println("Cartas reveladas: ");
                   for (Carta c : cartaMostrada) {
                       System.out.println("- " + c.getClass().getSimpleName());
                       JOptionPane.showMessageDialog(null, //Esta parte del codigo va a ser muy primitiva por ahora
                               " " + c.getClass().getSimpleName(),
                               "Carta numero " + (mazo.indexOf(c)+1),
                               JOptionPane.INFORMATION_MESSAGE);
                   }
               }
        }
    },
    
    MEZCLAR_MAZO() { //Sirve para efectos de King Dice
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
        	ArrayList<Carta> cartasMalas= controlador.getListaPorTipoCartas(TipoDeCarta.MALA,controlador.getMesa());
        	if(cartasMalas.size()>1) {
        		controlador.pasarCartas(cartasMalas, controlador.getMazo());
        		System.out.println("Se salio de pasar cartas a eliminar por lista cartas");
        		controlador.getMesa().removeAll(cartasMalas);
        	}
        	controlador.mezclarMazo();
        }
    },

    
    
    
    REINICIAR_PARTIDA() { //Sirve para efectos de Company
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
        	controlador.marcarReinicio();
        }
    },
    
    SALTEAR_TURNO() { //sirve para efectos de Saltamontes
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
        	controlador.siguienteJugador();
        	System.out.println("Salteamos turno");
        }
    },
    
    INTERCAMBIO_PUNTOS() { //sirve para efectos de Chester
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
            
        }
    },
    
    SIN_CARTAS_EN_LA_MANO() { //sirve para efectos de Inanicion
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
            
        }
    },
    
    APARICION_ALEATORIA() { //sirve para efectos de IM HERE
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
            
        }
    },
    
    ROBAR_CARTA() { //Esta carta esta hecha para el pecado de la codicia
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
    		
    	}
    },
    
    ESTRENIMIENTO() { //Carta para estrenimiento
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
    	}
    },
    
    HAMBRE() { //Carta que se va a usar para la carta de HAMBRE CONTENIDA
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
    		
    	}
    }, 
    
    MIMICO() { //Carta que se va a usar para mimico
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
    		
    	}
    },
    
    VER_PUNTOS_RIVAL() {
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador) {
    		
    	}
    }
    ;
	
	
    public abstract void ejecutar(Carta carta, Entidad jugador, Entidad rival, ControladorDeJuego controlador);

}
