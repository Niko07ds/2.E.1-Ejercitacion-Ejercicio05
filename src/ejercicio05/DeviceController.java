package ejercicio05;

public class DeviceController {

    // Instancia única del controlador
    private static DeviceController instance;

    // Indica si el dispositivo está disponible
    private boolean available;

    // Estado actual del dispositivo
    private String status;

    // Constructor privado para impedir otras instancias
    private DeviceController() {
        available = true;
        status = "LISTO";

        System.out.println("Controlador de dispositivo inicializado.");
    }

    // Devuelve siempre la misma instancia
    public static synchronized DeviceController getInstance() {
        if (instance == null) {
            instance = new DeviceController();
        }

        return instance;
    }

    // Comprueba si el dispositivo está disponible
    public synchronized boolean isAvailable() {
        return available;
    }

    // Envía un comando al dispositivo
    public synchronized void sendCommand(String command) {
        if (!available) {
            System.out.println("El dispositivo no está disponible.");
            return;
        }

        available = false;
        status = "EJECUTANDO: " + command;

        System.out.println("Enviando comando: " + command);

        // Simula el procesamiento del comando
        System.out.println("Comando ejecutado correctamente.");

        status = "LISTO";
        available = true;
    }

    // Lee el estado actual del dispositivo
    public synchronized String readStatus() {
        System.out.println("Leyendo estado del dispositivo...");
        return status;
    }
}
