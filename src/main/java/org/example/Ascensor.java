package org.example;

public class Ascensor {
    private int pisoActual;
    private Persona personaEnAscensor;

    public Ascensor() {
        this.pisoActual = 1;
        this.personaEnAscensor = null;
    }

    public Persona crearPersona(int pisoDestino) throws Exception {
        int pisoOrigen = generarPisoAleatorio(pisoDestino);
        Persona persona = new Persona(pisoOrigen, pisoDestino);
        if (personaEnAscensor == null) {
            personaEnAscensor = persona;
            System.out.println("Persona creada en el piso " + pisoOrigen + " y destino " + pisoDestino + " llamó al ascensor.");
            return persona;
        } else {
            throw new Exception("El ascensor ya tiene una persona.");
        }
    }

    private int generarPisoAleatorio(int pisoDestino) {
        int pisoOrigen;
        do {
            pisoOrigen = (int) (Math.random() * 3) + 1; // Piso aleatorio entre 1 y 3
        } while (pisoOrigen == pisoDestino);
        return pisoOrigen;
    }

    public String recogerPersona() throws Exception {
        if (personaEnAscensor == null) {
            throw new Exception("El ascensor está vacío.");
        }
        int pisoOrigen = personaEnAscensor.getPisoOrigen();
        moverAscensor(pisoOrigen);
        return "Persona en el piso " + pisoActual + " subió al ascensor.";
    }

    public String dejarPersona() throws Exception {
        if (personaEnAscensor == null) {
            throw new Exception("El ascensor está vacío.");
        }
        int pisoDestino = personaEnAscensor.getPisoDestino();
        moverAscensor(pisoDestino);
        personaEnAscensor = null;
        return "Persona en el piso " + pisoActual + " bajó del ascensor.";
    }

    private void moverAscensor(int piso) {
        while (pisoActual != piso) {
            if (piso > pisoActual) {
                pisoActual++;
            } else {
                pisoActual--;
            }
            System.out.println("El ascensor se encuentra en el piso " + pisoActual);
        }
    }
}
