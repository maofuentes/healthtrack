package test.java.com;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.healthtrack.model.Usuario;

public class UsuarioTest {

    // Prueba 1: Verifica que el constructor asigna correctamente el nombre y el peso
    @Test
    void constructor_deberiaAsignarNombreYPeso() {
        Usuario usuario = new Usuario("Valentina", 65.0);

        assertEquals("Valentina", usuario.getNombre());
        assertEquals(65.0, usuario.getPeso(), 0.01);
    }

    // Prueba 2: Verifica que actualizarPeso modifica el valor correctamente
    @Test
    void actualizarPeso_deberiaActualizarElPesoDelUsuario() {
        Usuario usuario = new Usuario("Marco", 80.0);
        usuario.actualizarPeso(82.3);

        assertEquals(82.3, usuario.getPeso(), 0.01);
    }

    // Prueba 3: Verifica que actualizarPeso rechaza valores negativos (si se implementa esta validación)
    @Test
    void actualizarPeso_deberiaLanzarExcepcionSiEsNegativo() {
        Usuario usuario = new Usuario("Fernanda", 55.0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.actualizarPeso(-5.0);
        });

        assertEquals("El peso no puede ser negativo.", exception.getMessage());
    }
}
