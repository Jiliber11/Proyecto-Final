
package EjercicioBase1;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindraje, boolean tieneSidecar) {
        super(marca, precio, cilindraje);
        this.tieneSidecar = tieneSidecar;
        ajustarValores();
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    private void ajustarValores() {
        if (tieneSidecar) {
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.5);
            calcularImpuestoCirculacion();
            setCuotaMesGaraje(getCuotaMesGaraje() * 1.1);
        }
    }
}
