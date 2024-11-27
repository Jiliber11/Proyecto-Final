
package ZejProyectoFinal.Carpetas;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreAdministrador;
    private int numEspacios;
    private List<Vehiculo> vehiculos;

    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String nombreAdministrador, int numEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreAdministrador = nombreAdministrador;
        this.numEspacios = numEspacios;
        this.vehiculos = new ArrayList<>();
    }

    public boolean alquilarEspacio(Vehiculo vehiculo) throws GarageException {
        if (vehiculos.size() >= numEspacios) {
            throw new GarageFullException("El garaje está lleno.");
        }

        if (vehiculos.stream().anyMatch(v -> v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca()))) {
            throw new VehicleAlreadyRegisteredException("El vehículo ya está registrado en este garaje.");
        }

        long numCamiones = vehiculos.stream().filter(v -> v instanceof Camion).count();
        if (vehiculo instanceof Camion) {
            int maxCamiones = numEspacios < 100 ? 10 : 20;
            if (numCamiones >= maxCamiones) {
                throw new MaxTruckLimitException("Se alcanzó el límite máximo de camiones en el garaje.");
            }
        }

        long numMotos = vehiculos.stream().filter(v -> v instanceof Moto).count();
        if (vehiculo instanceof Moto) {
            int maxMotos = (int) (numEspacios * 0.2);
            if (numMotos >= maxMotos) {
                throw new MaxMotoLimitException("Se alcanzó el límite máximo de motos en el garaje.");
            }
        }

        vehiculos.add(vehiculo);
        return true;
    }

    public boolean retirarVehiculo(String placa) {
        return vehiculos.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public int contarVehiculosPorTipo(Class<?> tipoVehiculo) {
        return (int) vehiculos.stream().filter(tipoVehiculo::isInstance).count();
    }

    public double calcularRecaudoMensual() {
        return vehiculos.stream().mapToDouble(Vehiculo::getCuotaMesGaraje).sum();
    }

    public void listarVehiculos() {
        vehiculos.forEach(v -> System.out.println("Placa: " + v.getPlaca() + ", Tipo: " + v.getClass().getSimpleName() + ", Cuota: " + v.getCuotaMesGaraje()));
    }

    public int getNumEspacios() {
        return numEspacios;
    }

    @Override
    public String toString() {
        return "Garaje en " + ciudad + " (" + departamento + ") - Dirección: " + direccion + " - Espacios: " + numEspacios;
    }
}