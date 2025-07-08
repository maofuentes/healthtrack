package test.java.com;

import org.junit.jupiter.api.Test;

import main.java.com.healthtrack.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void actualizarPeso_deberiaActualizarValor() {
        // Arrange
        Usuario usuario = new Usuario("Marcelo", 70.0);

        // Act
        usuario.actualizarPeso(72.5);

        // Assert
        assertEquals(72.5, usuario.getPeso(), 0.01);
    }
}
