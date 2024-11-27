
package ZejProyectoFinal;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private static final int NUM_ESPACIOS = 20;
    private List<Vehiculo> espacios;

    public Garaje() {
        this.espacios = new ArrayList<>();
    }

    // Buscar vehículo por matrícula
    public int buscarVehiculo(String matricula) {
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getPlaca().equalsIgnoreCase(matricula)) {
                return i;
            }
        }
        return -99; // No encontrado
    }

    // Contar vehículos por tipo
    public int contarVehiculosPorTipo(Class<? extends Vehiculo> tipo) {
        return (int) espacios.stream()
                .filter(tipo::isInstance)
                .count();
    }

    // Validar y alquilar espacio
    public boolean alquilarEspacio(Vehiculo vehiculo) {
        if (vehiculo.getPlaca() == null) {
            System.out.println("El vehículo no tiene matrícula.");
            return false;
        }

        if (espacios.size() >= NUM_ESPACIOS) {
            System.out.println("El garaje está lleno.");
            return false;
        }

        if (vehiculo instanceof Moto && contarVehiculosPorTipo(Moto.class) >= NUM_ESPACIOS * 0.3) {
            System.out.println("No se pueden alquilar más espacios para motos (límite del 30%).");
            return false;
        }

        if (vehiculo instanceof Camioneta && contarVehiculosPorTipo(Camioneta.class) >= NUM_ESPACIOS * 0.2) {
            System.out.println("No se pueden alquilar más espacios para camionetas (límite del 20%).");
            return false;
        }

        espacios.add(vehiculo);
        System.out.println("Vehículo alquilado con éxito.");
        return true;
    }

    // Calcular proporción Auto / Moto / Camioneta
    public void calcularProporcion() {
        int numAutos = contarVehiculosPorTipo(Auto.class);
        int numMotos = contarVehiculosPorTipo(Moto.class);
        int numCamionetas = contarVehiculosPorTipo(Camioneta.class);

        System.out.println("Proporción Auto/Moto/Camioneta: " + numAutos + "/" + numMotos + "/" + numCamionetas);
    }

    // Contar camionetas por tipo
    public void contarCamionetasPorTipo() {
        int suvs = 0;
        int pickups = 0;
        int cargas = 0;
        int otros = 0;

        for (Vehiculo v : espacios) {
            if (v instanceof Camioneta) {
                Camioneta camioneta = (Camioneta) v;
                switch (camioneta.getTipoServicio().toLowerCase()) {
                    case "suv":
                        suvs++;
                        break;
                    case "pickup":
                        pickups++;
                        break;
                    case "carga":
                        cargas++;
                        break;
                    default:
                        otros++;
                        break;
                }
            }
        }

        System.out.println("Camionetas por tipo:");
        System.out.println("SUV: " + suvs);
        System.out.println("Pickup: " + pickups);
        System.out.println("Carga: " + cargas);
        System.out.println("Otros: " + otros);
    }

    // Método para listar vehículos
    public void listarVehiculos() {
        for (Vehiculo v : espacios) {
            System.out.println("Placa: " + v.getPlaca() + ", Tipo: " + v.getClass().getSimpleName());
        }
    }

    // Método para retirar un vehículo
    public boolean retirarVehiculo(String placa) {
        return espacios.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    // Calcular ingresos mensuales
    public double calcularIngresos() {
        return espacios.stream()
                .mapToDouble(Vehiculo::getCuotaMesGaraje)
                .sum();
    }
}


