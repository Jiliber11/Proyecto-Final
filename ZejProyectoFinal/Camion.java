
package ZejProyectoFinal;

import Parcial2.*;

    
    public class Camion extends Vehiculo {
    private int numeroEjes;
    private String tipoCamion; // "Sencillo" o "Doble"
    private double capacidadCarga; // en toneladas

    public Camion(String marca, double precio, int cilindraje, String tipoCamion, int numeroEjes, double capacidadCarga) {
        super(marca, precio, cilindraje);
        this.numeroEjes = numeroEjes;
        this.tipoCamion = tipoCamion;
        this.capacidadCarga = capacidadCarga;

        if (tipoCamion.equalsIgnoreCase("Sencillo")) {
            if (numeroEjes != 2) {
                throw new IllegalArgumentException("Un camión sencillo debe tener exactamente 2 ejes.");
            }
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.75);
        } else if (tipoCamion.equalsIgnoreCase("Doble")) {
            if (numeroEjes < 3 || numeroEjes > 6) {
                throw new IllegalArgumentException("Un camión doble debe tener entre 3 y 6 ejes.");
            }
            setCuotaMesGaraje(getCuotaMesGaraje() * 2.25);
        } else {
            throw new IllegalArgumentException("El tipo de camión debe ser 'Sencillo' o 'Doble'.");
        }

        calcularImpuestoCirculacion();
    }
      // Getters y setters
    public String getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(String tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    @Override
    public void calcularImpuestoCirculacion() {
        double impuestoBase = getPrecio() * 0.09;
        double extraPorCarga = Math.floor(capacidadCarga / 5) * 10;
        setImpuestoCirculacion(impuestoBase + extraPorCarga);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + tipoCamion + " | Ejes: " + numeroEjes + " | Capacidad: " + capacidadCarga + " toneladas";
    }
}

    

