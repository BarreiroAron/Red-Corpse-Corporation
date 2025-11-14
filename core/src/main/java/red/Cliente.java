package red;

public class Cliente {

    private static int playerIndex;
    private static String nombreEntidad;
    private static String[] cartasIniciales;

    public static void setDatosInit(int index, String entidad, String[] cartas) {
        playerIndex = index;
        nombreEntidad = entidad;
        cartasIniciales = cartas;
    }

    public static int getPlayerIndex() {
        return playerIndex;
    }

    public static String getNombreEntidad() {
        return nombreEntidad;
    }

    public static String[] getCartasIniciales() {
        return cartasIniciales;
    }
}

