
package ZejProyectoFinal;

import Parcial2.*;
import EjercicioBase1.*;

public class Vehiculo {
    private String placa;
    private String marca;
    private double precio;
    private int cilindraje;
    private double impuestoCirculacion;
    private double cuotaMesGaraje;

    public static final double CUOTA_BASE = 100.0;

    public Vehiculo(String marca, double precio, int cilindraje) {
        this.placa = null;
        this.marca = marca;
        this.precio = precio;
        this.cilindraje = cilindraje;
        this.cuotaMesGaraje = CUOTA_BASE;
        calcularImpuestoCirculacion();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGaraje() {
        return cuotaMesGaraje;
    }

    public void setCuotaMesGaraje(double cuota) {
        if (cuota >= 0) {
            this.cuotaMesGaraje = cuota;
        } else {
            throw new IllegalArgumentException("La cuota no puede ser negativa.");
        }
    }

    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = precio * 0.02;
    }

    public boolean matricular(String matricula) {
        if (matricula.length() == 6) {
            this.placa = matricula;
            return true;
        }
        return false;
    }
    
    public void setImpuestoCirculacion(double impuestoCirculacion) {
    if (impuestoCirculacion < 0) {
        throw new IllegalArgumentException("El impuesto de circulación no puede ser negativo.");
    }
    this.impuestoCirculacion = impuestoCirculacion;
}

}


