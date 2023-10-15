package org.example;

public class Persona {
    private int pisoOrigen;
    private int pisoDestino;

    public Persona(int pisoOrigen, int pisoDestino) {
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
    }

    public int getPisoOrigen() {
        return pisoOrigen;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}
