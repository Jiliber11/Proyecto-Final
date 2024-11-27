
package ZejProyectoFinal;

import Parcial2.*;
import EjercicioBase1.*;


public interface iGarage {
    double calcularIngresos();
    int calcularOcupacionPorTipoVehiculo(Class<? extends Vehiculo> tipo);
}

