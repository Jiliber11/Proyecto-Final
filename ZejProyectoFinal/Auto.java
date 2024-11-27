
package ZejProyectoFinal;

import Parcial2.*;
import EjercicioBase1.*;


public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, double precio, int cilindraje, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        ajustarValores();
    }

    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }

    private void ajustarValores() {
        if (tieneRadio) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.01);
        }
        if (tieneNavegador) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.02);
        }
        if (getCilindraje() > 2499) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.2);
        }
    }
}

