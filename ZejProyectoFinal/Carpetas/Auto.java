
package ZejProyectoFinal.Carpetas;

import ZejProyectoFinal.*;
import Parcial2.*;
import EjercicioBase1.*;


public class Auto extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Auto(String marca, String placa, double precio, int cilindraje, int tieneRadio, int tieneNavegador) {
        super(marca, precio, cilindraje);
        this.tieneRadio = (tieneRadio == 1); // Convierte int a boolean
        this.tieneNavegador = (tieneNavegador == 1); // Convierte int a boolean
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