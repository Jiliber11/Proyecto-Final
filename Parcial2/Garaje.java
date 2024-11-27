
package Parcial2;

  import EjercicioBase1.*;
import java.util.ArrayList;
import java.util.List;

public class Garaje implements iGarage {
    private static final int NUM_ESPACIOS = 20;
    private List<Vehiculo> espacios;

    public Garaje() {
        this.espacios = new ArrayList<>();
    }

    @Override
    public double calcularIngresos() {
        return espacios.stream()
                .mapToDouble(Vehiculo::getCuotaMesGaraje)
                .sum();
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Class<? extends Vehiculo> tipo) {
        return (int) espacios.stream()
                .filter(tipo::isInstance)
                .count();
    }

    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (vehiculo.getPlaca() == null) {
            System.out.println("El vehículo no tiene matrícula.");
            return false;
        }

        if (espacios.size() >= NUM_ESPACIOS) {
            System.out.println("El garaje está lleno.");
            return false;
        }

        long motos = calcularOcupacionPorTipoVehiculo(Moto.class);
        long camiones = calcularOcupacionPorTipoVehiculo(Camion.class);
        if (vehiculo instanceof Moto && motos >= NUM_ESPACIOS * 0.8) {
            System.out.println("No puede haber más del 80% de motos.");
            return false;
        }

        if (vehiculo instanceof Camion && camiones >= NUM_ESPACIOS * 0.1) {
            System.out.println("No puede haber más del 10% de camiones.");
            return false;
        }

        espacios.add(vehiculo);
        return true;
    }

    public boolean retirarVehiculo(String placa) {
        return espacios.removeIf(v -> v.getPlaca().equals(placa));
    }

    public void listarVehiculos() {
        for (Vehiculo v : espacios) {
            System.out.println("Placa: " + v.getPlaca() + ", Cuota: " + v.getCuotaMesGaraje() + ", Tipo: " + v.getClass().getSimpleName());
        }
    }

    // Nuevo método: Buscar vehículo por matrícula
    public int buscarVehiculo(String matricula) {
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getPlaca().equalsIgnoreCase(matricula)) {
                return i;
            }
        }
        return -1;
    }

    // Nuevo método: Contar camiones por tipo (Sencillo o Doble)
    public int contarCamionesPorTipo(String tipoCamion) {
        int contador = 0;
        for (Vehiculo v : espacios) {
            if (v instanceof Camion) {
                Camion camion = (Camion) v;
                if (camion.getTipoCamion().equalsIgnoreCase(tipoCamion)) {
                    contador++;
                }
            }
        }
        return contador;
    }
    public int contarVehiculosPorTipo(Class<?> tipoVehiculo) {
    int contador = 0;
    for (Vehiculo v : espacios) {
        if (tipoVehiculo.isInstance(v)) {
            contador++;
        }
    }
    return contador;
}


    // Nuevo método: Contar plazas disponibles
    public int plazasDisponibles() {
        return NUM_ESPACIOS - espacios.size();
    }
}


