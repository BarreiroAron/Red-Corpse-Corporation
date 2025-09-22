package juegos;

import Entidades.Entidad;

public class HabilidadActiva {
    public enum Tipo {
        BLOQUEAR_ROBAR
        
    }

    private final Tipo tipo;
    private final Entidad objetivo;   
    private final boolean global;      
    private int turnosRestantes;
    private final String descripcion;

    public HabilidadActiva(Tipo tipo, Entidad objetivo, int turnos, String descripcion, boolean global) {
        this.tipo = tipo;
        this.objetivo = objetivo;
        this.turnosRestantes = Math.max(1, turnos);
        this.descripcion = descripcion;
        this.global = global;
    }

    public Tipo getTipo() { return tipo; }
    public Entidad getObjetivo() { return objetivo; }
    public boolean isGlobal() { return global; }
    public int getTurnosRestantes() { return turnosRestantes; }
    public String getDescripcion() { return descripcion; }

    public boolean tick() { return --turnosRestantes <= 0; }

    // Fábricas
    public static HabilidadActiva bloqueoRobarGlobal(int turnos, String desc) {
        return new HabilidadActiva(Tipo.BLOQUEAR_ROBAR, null, turnos, desc, true);
    }
    public static HabilidadActiva bloqueoRobarA(Entidad objetivo, int turnos, String desc) {
        return new HabilidadActiva(Tipo.BLOQUEAR_ROBAR, objetivo, turnos, desc, false);
    }
}
