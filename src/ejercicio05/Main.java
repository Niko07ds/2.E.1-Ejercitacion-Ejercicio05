package ejercicio05;

public class Main {

    public static void main(String[] args) {

        // Obtenemos la instancia única del controlador
        DeviceController controller1 =
                DeviceController.getInstance();

        // Comprobamos si el dispositivo está disponible
        System.out.println("¿Está disponible? " +
                controller1.isAvailable());

        // Enviamos un comando al dispositivo
        controller1.sendCommand("MOVER_ADELANTE");

        // Leemos el estado actual
        System.out.println("Estado del dispositivo: " +
                controller1.readStatus());

        // Obtenemos nuevamente la instancia
        DeviceController controller2 =
                DeviceController.getInstance();

        // Comprobamos que ambas referencias son iguales
        System.out.println("¿Es el mismo controlador? " +
                (controller1 == controller2));

        // Enviamos otro comando desde la segunda referencia
        controller2.sendCommand("GIRAR_DERECHA");

        // Consultamos nuevamente el estado
        System.out.println("Estado final: " +
                controller1.readStatus());

        // Verificamos la disponibilidad final
        System.out.println("¿Está disponible? " +
                controller2.isAvailable());

        // La siguiente instrucción no compilaría porque
        // el constructor de DeviceController es privado:
        // DeviceController controller3 = new DeviceController();
    }
}
