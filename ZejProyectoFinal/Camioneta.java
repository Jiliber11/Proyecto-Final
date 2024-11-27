
package ZejProyectoFinal;


public class Camioneta extends Vehiculo {
    private String tipoServicio; // SUV, Pickup, Carga u Otro
    private int numeroPasajeros;
    private boolean tieneRemolque;

    // Constructor
    public Camioneta(String marca, double precio, int cilindraje, String tipoServicio, int numeroPasajeros, boolean tieneRemolque) {
        super(marca, precio, cilindraje);
        if (!tipoServicio.equalsIgnoreCase("SUV") &&
            !tipoServicio.equalsIgnoreCase("Pickup") &&
            !tipoServicio.equalsIgnoreCase("Carga") &&
            !tipoServicio.equalsIgnoreCase("Otro")) {
            throw new IllegalArgumentException("Tipo de servicio no válido.");
        }

        this.tipoServicio = tipoServicio;

        // Validar número de pasajeros
        if (tipoServicio.equalsIgnoreCase("Pickup") || tipoServicio.equalsIgnoreCase("Carga")) {
            if (numeroPasajeros > 2) {
                throw new IllegalArgumentException("El número máximo de pasajeros para Camionetas Pickup o de Carga es 2.");
            }
        } else {
            if (numeroPasajeros > 5) {
                throw new IllegalArgumentException("El número máximo de pasajeros para Camionetas SUV u Otro es 5.");
            }
        }

        this.numeroPasajeros = numeroPasajeros;
        this.tieneRemolque = tieneRemolque;
        calcularImpuestoCirculacion();
        calcularCuotaMensualGaraje();
    }

    // Getters
    public String getTipoServicio() {
        return tipoServicio;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    // Métodos para calcular el impuesto de circulación
    @Override
    public void calcularImpuestoCirculacion() {
        double impuesto = getPrecio() * 0.05; // 5% del precio
        setImpuestoCirculacion(impuesto);
    }

    // Métodos para calcular la cuota mensual del garaje
    public void calcularCuotaMensualGaraje() {
        double cuotaBase = getPrecio() * 0.01; // Ejemplo: 1% del precio como cuota base
        double incrementoPorTipo = 0;

        // Incremento por tipo de servicio
        switch (tipoServicio.toLowerCase()) {
            case "pickup":
            case "carga":
            case "otro":
                incrementoPorTipo += 0.45; // 45% de incremento
                break;
            case "suv":
                incrementoPorTipo += 0.10; // 10% de incremento
                break;
        }

        // Incremento por número de pasajeros
        if (numeroPasajeros == 2) {
            incrementoPorTipo += 0.50; // 50% de incremento para 2 pasajeros
        } else if (numeroPasajeros > 2) {
            incrementoPorTipo += 0.60; // 60% de incremento para más de 2 pasajeros
        }

        // Incremento adicional si tiene remolque
        if (tieneRemolque) {
            incrementoPorTipo += 0.10; // 10% de incremento por remolque
        }

        // Calcular cuota mensual total
        double cuotaMensual = cuotaBase * (1 + incrementoPorTipo);
        setCuotaMesGaraje(cuotaMensual);
    }

    @Override
    public String toString() {
        return super.toString() + ", TipoServicio: " + tipoServicio +
                ", NúmeroPasajeros: " + numeroPasajeros +
                ", TieneRemolque: " + tieneRemolque;
    }
}
