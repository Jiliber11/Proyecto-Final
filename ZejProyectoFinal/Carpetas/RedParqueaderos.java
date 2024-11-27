
package ZejProyectoFinal.Carpetas;

import java.util.ArrayList;
import java.util.List;

public class RedParqueaderos {
    private List<Garaje> garajes;

    public RedParqueaderos() {
        this.garajes = new ArrayList<>();
    }

    public void agregarGaraje(Garaje garaje) {
        garajes.add(garaje);
    }

    public boolean eliminarGaraje(String direccion) {
        return garajes.removeIf(g -> g.toString().contains(direccion));
    }

    public Garaje buscarGarajePorDireccion(String direccion) {
        return garajes.stream().filter(g -> g.toString().contains(direccion)).findFirst().orElse(null);
    }

    public void listarGarajes() {
        garajes.forEach(System.out::println);
    }

    public double calcularRecaudoTotal() {
        return garajes.stream().mapToDouble(Garaje::calcularRecaudoMensual).sum();
    }
}