	package cartas;
	
	public class Carta {
		
		private int puntosAumentadosRival;
		private int puntosDisminuidos;
		private boolean robarCarta;
		private Habilidad habilidad;
		private String texturaCarta;
		private String texturaCartaEspalda;
		
		public Carta(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad, String texturaCarta, String texturaCartaEspalda) {
			this.puntosAumentadosRival = puntosAumentadosRival;
			this.puntosDisminuidos = puntosDisminuidos;
			this.robarCarta = robarCarta;
			this.habilidad = habilidad;
			this.texturaCarta = texturaCarta;
			this.texturaCartaEspalda = texturaCartaEspalda;
		}

		@Override
		public String toString() {
			return "Carta [habilidad=" + habilidad + ", puntosAumentadosRival=" + puntosAumentadosRival
					+ ", puntosDisminuidos=" + puntosDisminuidos + ", robarCarta=" + robarCarta + ", texturaCarta="
					+ texturaCarta + ", texturaCartaEspalda=" + texturaCartaEspalda + "]";
		}

		public int getPuntosAumentadosRival() {
			return puntosAumentadosRival;
		}

		public void setPuntosAumentadosRival(int puntosAumentadosRival) {
			this.puntosAumentadosRival = puntosAumentadosRival;
		}

		public int getPuntosDisminuidos() {
			return puntosDisminuidos;
		}

		public void setPuntosDisminuidos(int puntosDisminuidos) {
			this.puntosDisminuidos = puntosDisminuidos;
		}

		public boolean getRobarCarta() {
			return robarCarta;
		}

		public void setRobarCarta(boolean robarCarta) {
			this.robarCarta = robarCarta;
		}

		public Habilidad getHabilidad() {
			return habilidad;
		}

		public void setHabilidad(Habilidad habilidad) {
			this.habilidad = habilidad;
		}

		public String getTexturaCarta() {
			return texturaCarta;
		}

		public void setTexturaCarta(String texturaCarta) {
			this.texturaCarta = texturaCarta;
		}

		public String getTexturaCartaEspalda() {
			return texturaCartaEspalda;
		}

		public void setTexturaCartaEspalda(String texturaCartaEspalda) {
			this.texturaCartaEspalda = texturaCartaEspalda;
		}
		
		
	}
