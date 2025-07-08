package com.healthtrack.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlujoUsuarioFirefoxTest {

    private static WebDriver driver;
    private static final String BASE_URL = "http://localhost:8082";
    private static final String NOMBRE = "Marcelo";
    private static final double PESO_INICIAL = 75.5;
    private static final double PESO_ACTUALIZADO = 78.2;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup(); // No necesitas definir ruta manualmente
        driver = new FirefoxDriver();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @Order(1)
    public void registrarUsuario() {
        driver.get(BASE_URL + "/");

        driver.findElement(By.id("nombre")).sendKeys(NOMBRE);
        driver.findElement(By.id("peso")).sendKeys(String.valueOf(PESO_INICIAL));
        driver.findElement(By.tagName("button")).click();

        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @Test
    @Order(2)
    public void actualizarPeso() {
        WebElement nuevoPesoInput = driver.findElement(By.name("nuevoPeso"));
        nuevoPesoInput.clear();
        nuevoPesoInput.sendKeys(String.valueOf(PESO_ACTUALIZADO));

        WebElement botonActualizar = driver.findElement(By.xpath("//button[contains(text(),'Actualizar')]"));
        botonActualizar.click();

        assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }

    @Test
    @Order(3)
    public void verificarPesoActualizado() {
        WebElement pesoActual = driver.findElement(By.id("peso-actual"));
        String textoPeso = pesoActual.getText().replace(",", ".");
        assertEquals(String.valueOf(PESO_ACTUALIZADO), textoPeso);
    }
}
