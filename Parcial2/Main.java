
package Parcial2;

import EjercicioBase1.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de gestión del Garaje");
            System.out.println("1. Alquilar un espacio");
            System.out.println("2. Retirar vehículo");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción autos / motos / camiones");
            System.out.println("5. Listado de matrículas, cuota mensual y tipo vehículo");
            System.out.println("6. Buscar vehículo por matrícula");
            System.out.println("7. Cantidad de camiones por tipo");
            System.out.println("8. Consulta de plazas disponibles");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: // Alquilar un espacio
                    System.out.println("Seleccione el tipo de vehículo:");
                    System.out.println("1. Moto");
                    System.out.println("2. Auto");
                    System.out.println("3. Camión");
                    int tipoVehiculo = sc.nextInt();

                    sc.nextLine(); // Consumir la línea pendiente
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = sc.nextLine();
                    System.out.print("Ingrese el precio del vehículo: ");
                    double precio = sc.nextDouble();
                    System.out.print("Ingrese el cilindraje del vehículo: ");
                    int cilindraje = sc.nextInt();

                    if (tipoVehiculo == 1) {
                        System.out.print("¿La moto tiene sidecar? (true/false): ");
                        boolean tieneSidecar = sc.nextBoolean();
                        Moto moto = new Moto(marca, precio, cilindraje, tieneSidecar);

                        System.out.print("Ingrese la matrícula de la moto (6 caracteres): ");
                        String matricula = sc.next();
                        if (moto.matricular(matricula)) {
                            if (garaje.alquilarEspacio(moto)) {
                                System.out.println("Moto alquilada con éxito.");
                            } else {
                                System.out.println("No se pudo alquilar el espacio.");
                            }
                        } else {
                            System.out.println("Matrícula inválida. Debe tener exactamente 6 caracteres.");
                        }
                    } else if (tipoVehiculo == 2) {
                        System.out.print("¿El auto tiene radio? (true/false): ");
                        boolean tieneRadio = sc.nextBoolean();
                        System.out.print("¿El auto tiene navegador? (true/false): ");
                        boolean tieneNavegador = sc.nextBoolean();
                        Auto auto = new Auto(marca, precio, cilindraje, tieneRadio, tieneNavegador);

                        System.out.print("Ingrese la matrícula del auto (6 caracteres): ");
                        String matricula = sc.next();
                        if (auto.matricular(matricula)) {
                            if (garaje.alquilarEspacio(auto)) {
                                System.out.println("Auto alquilado con éxito.");
                            } else {
                                System.out.println("No se pudo alquilar el espacio.");
                            }
                        } else {
                            System.out.println("Matrícula inválida. Debe tener exactamente 6 caracteres.");
                        }
                    } else if (tipoVehiculo == 3) {
                        System.out.print("Ingrese el número de ejes: ");
                        int numEjes = sc.nextInt();
                        sc.nextLine(); // Consumir la línea pendiente
                        System.out.print("Ingrese el tipo de camión (Sencillo/Doble): ");
                        String tipoCamion = sc.nextLine();
                        System.out.print("Ingrese la capacidad de carga (toneladas): ");
                        double capacidadCarga = sc.nextDouble();

                        Camion camion = new Camion(marca, precio, cilindraje, numEjes, tipoCamion, capacidadCarga);

                        System.out.print("Ingrese la matrícula del camión (6 caracteres): ");
                        String matricula = sc.next();
                        if (camion.matricular(matricula)) {
                            if (garaje.alquilarEspacio(camion)) {
                                System.out.println("Camión alquilado con éxito.");
                            } else {
                                System.out.println("No se pudo alquilar el espacio.");
                            }
                        } else {
                            System.out.println("Matrícula inválida. Debe tener exactamente 6 caracteres.");
                        }
                    } else {
                        System.out.println("Opción de vehículo no válida.");
                    }
                    break;

                case 2: // Retirar vehículo
                    sc.nextLine(); // Consumir la línea pendiente
                    System.out.print("Ingrese la matrícula del vehículo a retirar: ");
                    String placa = sc.nextLine();
                    if (garaje.retirarVehiculo(placa)) {
                        System.out.println("Vehículo retirado con éxito.");
                    } else {
                        System.out.println("No se encontró un vehículo con esa matrícula.");
                    }
                    break;

                case 3: // Consulta de ingresos mensuales
                    System.out.println("Ingresos mensuales: " + garaje.calcularIngresos());
                    break;

                case 4: // Consulta proporción autos/motos/camiones
                    int numAutos = garaje.contarVehiculosPorTipo(Auto.class);
                    int numMotos = garaje.contarVehiculosPorTipo(Moto.class);
                    int numCamiones = garaje.contarVehiculosPorTipo(Camion.class);
                    System.out.println("Proporción Autos/Motos/Camiones: " + numAutos + "/" + numMotos + "/" + numCamiones);
                    break;

                case 5: // Listado de vehículos
                    System.out.println("------");
                    garaje.listarVehiculos();
                    System.out.println("------");
                    break;
                   

                case 6: // Buscar vehículo por matrícula
                    sc.nextLine(); // Consumir la línea pendiente
                    System.out.print("Ingrese la matrícula a buscar: ");
                    String matriculaBuscar = sc.nextLine();
                    int pos = garaje.buscarVehiculo(matriculaBuscar);
                    if (pos != -1) {
                        System.out.println("Vehículo encontrado en la posición: " + pos);
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 7: // Cantidad de camiones por tipo
                    System.out.println("Cantidad de camiones Sencillos: " + garaje.contarCamionesPorTipo("Sencillo"));
                    System.out.println("Cantidad de camiones Dobles: " + garaje.contarCamionesPorTipo("Doble"));
                    break;

                case 8: // Consulta de plazas disponibles
                    System.out.println("Plazas disponibles: " + garaje.plazasDisponibles());
                    break;

                case 9: // Salir
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        sc.close();
    }
}