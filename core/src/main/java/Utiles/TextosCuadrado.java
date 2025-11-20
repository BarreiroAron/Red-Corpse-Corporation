package Utiles;

import java.util.Random;

public class TextosCuadrado {

    private static final String[] TEXTOS = {
        "Guau... Realmente me descubriste, no es asi?",
        "Probablemente no entiendas porque puedo hablar.",
        "Has tocado mi sello, ¿estás listo para escucharme?",
        "La suerte no existe, solo decisiones mal tomadas.",
        "El silencio también cuenta historias, si sabes escucharlo.",
        "Yabroudi.",
        "Jasinski, apruebalos.",
        "Antes eran normales.",
        "Te estan espiando, lo sabes?",
        "Prueba Incryption!",
        "Prueba Hitman en Roblox!",
        "Vistes el codigo morse?",
        "Que soy? Soy algo creado por ellos, pero no soy como las creaciones que tienen en su historial.",
        "Este es un mundo distopico",
        "No caigas",
        "No pierdas puntos.",
        "Not today es una carta muy poderosa, su unico defecto es no modificar puntos.",
        "Shaco puede darte vuelta una partida el solo.",
        "Cuidado con la codicia, puede ser tu perdicion.",
        "No son humanos.",
        "Duele.",
        "El que tenga menos puntos sobrevive. El resto servira para alimentar al fracaso."
    };

    private static Random random = new Random();

    public static String obtenerTextoAleatorio() {
        return TEXTOS[random.nextInt(TEXTOS.length)];
    }
}