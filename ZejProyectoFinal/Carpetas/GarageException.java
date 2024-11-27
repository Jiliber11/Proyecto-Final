
package ZejProyectoFinal.Carpetas;


    public class GarageException extends Exception {
    public GarageException(String message) {
        super(message);
    }
}
    
class InvalidVehicleTypeException extends GarageException {
    public InvalidVehicleTypeException(String message) {
        super(message);
    }
}

class GarageFullException extends GarageException {
    public GarageFullException(String message) {
        super(message);
    }
}

class VehicleAlreadyRegisteredException extends GarageException {
    public VehicleAlreadyRegisteredException(String message) {
        super(message);
    }
}

class MaxTruckLimitException extends GarageException {
    public MaxTruckLimitException(String message) {
        super(message);
    }
}

class MaxMotoLimitException extends GarageException {
    public MaxMotoLimitException(String message) {
        super(message);
    }
}