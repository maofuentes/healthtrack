import java.util.*;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=== Bienvenido a HealthTrack ===");
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    actualizarPeso();
                    break;
                case 3:
                    mostrarInformacion();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Actualizar peso");
        System.out.println("3. Mostrar información del usuario");
        System.out.println("4. Salir");
    }

    private static void registrarUsuario() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese peso inicial (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());

        usuarios.put(nombre, new Usuario(nombre, peso));
        System.out.println("Usuario registrado exitosamente.");
    }

    private static void actualizarPeso() {
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        Usuario usuario = usuarios.get(nombre);

        if (usuario != null) {
            System.out.print("Ingrese nuevo peso (kg): ");
            double nuevoPeso = Double.parseDouble(scanner.nextLine());
            usuario.actualizarPeso(nuevoPeso);
            System.out.println("Peso actualizado correctamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void mostrarInformacion() {
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        Usuario usuario = usuarios.get(nombre);

        if (usuario != null) {
            usuario.mostrarInformacion();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}
