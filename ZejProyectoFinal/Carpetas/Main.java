
package ZejProyectoFinal.Carpetas;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RedParqueaderos red = new RedParqueaderos();

        int opcion;
        do {
            System.out.println("1. Crear Garaje");
            System.out.println("2. Eliminar Garaje");
            System.out.println("3. Listar Garajes");
            System.out.println("4. Agregar Vehículo a un Garaje");
            System.out.println("5. Retirar Vehículo de un Garaje");
            System.out.println("6. Calcular Recaudo Total");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Departamento: ");
                    String dept = sc.next();
                    System.out.print("Ciudad: ");
                    String ciudad = sc.next();
                    System.out.print("Dirección: ");
                    String dir = sc.next();
                    System.out.print("Teléfono: ");
                    String tel = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    System.out.print("Administrador: ");
                    String admin = sc.next();
                    System.out.print("Número de espacios: ");
                    int espacios = sc.nextInt();
                    red.agregarGaraje(new Garaje(dept, ciudad, dir, tel, email, admin, espacios));
                    break;
                case 2:
                    System.out.print("Dirección del garaje a eliminar: ");
                    String direccion = sc.next();
                    if (red.eliminarGaraje(direccion)) {
                        System.out.println("Garaje eliminado.");
                    } else {
                        System.out.println("Garaje no encontrado.");
                    }
                    break;
                case 3:
                    red.listarGarajes();
                    break;
                   
                case 4:
    System.out.println("Seleccione el garaje al que desea agregar un vehículo (ingrese la dirección del garaje): ");
    red.listarGarajes(); // Muestra la lista de garajes disponibles
    String dirGaraje = sc.next();
    Garaje garajeSeleccionado = red.buscarGarajePorDireccion(dirGaraje);

    if (garajeSeleccionado == null) {
        System.out.println("Garaje no encontrado.");
        break;
    }

    System.out.println("Seleccione el tipo de vehículo a agregar:");
    System.out.println("1. Auto");
    System.out.println("2. Moto");
    System.out.println("3. Camión");
    System.out.println("4. Camioneta");
    int tipoVehiculo = sc.nextInt();

    Vehiculo vehiculo = null;
    try {
        System.out.print("Ingrese la marca: ");
        String marca = sc.next();
        System.out.print("Ingrese la placa: ");
        String placa = sc.next();
        System.out.print("Ingrese el precio: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese el cilindraje: ");
        int cilindraje = sc.nextInt();

        switch (tipoVehiculo) {
            case 1: // Auto
                System.out.print("Ingrese el número de puertas: ");
                int puertas = sc.nextInt();
                System.out.print("Ingrese el número de airbags: ");
                int airbags = sc.nextInt();
                vehiculo = new Auto(marca, placa, precio, cilindraje, puertas, airbags);
                break;

            case 2: // Moto
                System.out.print("Ingrese el tipo de moto (Deportiva, Urbana, etc.): ");
                String tipoMoto = sc.next();
                vehiculo = new Moto(marca, placa, precio, cilindraje, tipoMoto);
                break;

            case 3: // Camión
                System.out.print("Ingrese el tipo de camión (Carga, Remolque, etc.): ");
                String tipoCamion = sc.next();
                System.out.print("Ingrese el número de ejes: ");
                int ejes = sc.nextInt();
                System.out.print("Ingrese la capacidad de carga (en toneladas): ");
                double capacidadCarga = sc.nextDouble();
                vehiculo = new Camion(marca, placa, precio, cilindraje, tipoCamion, ejes, capacidadCarga);
                break;

            case 4: // Camioneta
                System.out.print("Ingrese el tipo de camioneta (SUV, Pickup, Carga, Otro): ");
                String tipoCamioneta = sc.next();
                System.out.print("Ingrese el número de pasajeros: ");
                int numPasajeros = sc.nextInt();
                System.out.print("¿Tiene remolque? (true/false): ");
                boolean tieneRemolque = sc.nextBoolean();
                vehiculo = new Camioneta(marca, placa, precio, cilindraje, tipoCamioneta, numPasajeros, tieneRemolque);
                break;

            default:
                System.out.println("Tipo de vehículo inválido.");
                break;
        }

        // Intenta agregar el vehículo al garaje seleccionado
        if (garajeSeleccionado.alquilarEspacio(vehiculo)) {
            System.out.println("Vehículo agregado exitosamente.");
        }
    } catch (GarageException e) {
        System.out.println("Error: " + e.getMessage());
    }
    break;
    
             
                    case 5: // Retirar un vehículo
    System.out.println("Retirar un Vehículo");
    try {
        System.out.print("Ingrese la matrícula del vehículo a retirar: ");
        String matricula = sc.next();

        // Buscar y retirar el vehículo en el garaje seleccionado
        Vehiculo vehiculoRetirado = garaje.retirarVehiculo(matricula);

        if (vehiculoRetirado != null) {
            System.out.println("El vehículo con matrícula " + matricula + " fue retirado exitosamente.");
            System.out.println("Detalles del vehículo retirado:");
            System.out.println(vehiculoRetirado.toString());
        } else {
            System.out.println("No se encontró un vehículo con la matrícula ingresada en el garaje.");
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    break;
                    
                case 6:
                    System.out.println("Recaudo total: " + red.calcularRecaudoTotal());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        sc.close();
    }
}