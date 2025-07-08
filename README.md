## 🎯 Contexto:

La empresa HealthTrack ha desarrollado una plataforma web para el monitoreo del peso de los usuarios. La aplicación permite a los usuarios registrarse y actualizar su peso cada 48 horas. Sin embargo, la plataforma tiene un error crítico: cada vez que un usuario actualiza su peso, el sistema le resta automáticamente 1 kg en lugar de registrar el valor ingresado.

El problema surge porque no se han implementado pruebas unitarias, de integración, de regresión ni de rendimiento. Además, la empresa no tiene un pipeline de CI/CD que asegure la validación automática del código antes de su despliegue.

Como especialistas en automatización de pruebas, los estudiantes deberán evaluar el estado actual de la plataforma y proponer soluciones utilizando estrategias de pruebas unitarias, de integración, funcionales y de rendimiento. También deberán estructurar un pipeline de CI/CD para asegurar que estas pruebas se ejecuten automáticamente.

Código Base del Proyecto en Java

El siguiente código Java representa el error en la lógica del sistema. Actualmente, reduce 1 kg cada vez que un usuario actualiza su peso en lugar de registrar el valor ingresado.

## CODIGO:

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void actualizarPeso(double nuevoPeso) {
        // ERROR: En lugar de asignar el nuevo peso, se está restando 1kg.
        this.peso -= 1;
    }

    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
    }
}
    
