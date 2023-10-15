import org.example.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class AscensorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void crearPersonaExitoso() throws Exception {
        // 1. Preparación de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Lógica de la prueba
        Persona persona = ascensor.crearPersona(2);
        // 3. Verificación o Assert
        Assert.assertEquals(2, persona.getPisoDestino());
    }

    @Test
    public void crearPersonaConAscensorOcupado() throws Exception {
        // 1. Preparación de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Lógica de la prueba
        ascensor.crearPersona(2);
        // 3. Verificación o Assert
        exception.expect(Exception.class);
        ascensor.crearPersona(3); // Intentar crear una segunda persona con el ascensor ocupado
    }

    @Test
    public void recogerPersonaExitoso() throws Exception {
        // 1. Preparación de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Lógica de la prueba
        Persona persona = ascensor.crearPersona(2);
        // 3. Verificación o Assert
        String resultado = ascensor.recogerPersona();
        Assert.assertEquals("Persona en el piso "+persona.getPisoOrigen()+" subió al ascensor.", resultado);
    }

    @Test
    public void recogerPersonaConAscensorVacio() throws Exception {
        // 1. Preparación de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Lógica de la prueba

        // 3. Verificación o Assert
        exception.expect(Exception.class);
        ascensor.recogerPersona(); // Intentar recoger una persona con el ascensor vacío
    }

    @Test
    public void dejarPersonaExitoso() throws Exception {
        // 1. Preparación de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Lógica de la prueba
        Persona persona = ascensor.crearPersona(2);
        ascensor.recogerPersona();
        String resultado = ascensor.dejarPersona();
        // 3. Verificación o Assert
        Assert.assertEquals("Persona en el piso "+persona.getPisoDestino()+" bajó del ascensor.", resultado);
    }

    @Test
    public void dejarPersonaConAscensorVacio() throws Exception {
        // 1. Preparación de la prueba
        Ascensor ascensor = new Ascensor();
        // 2. Lógica de la prueba

        // 3. Verificación o Assert
        exception.expect(Exception.class);
        ascensor.dejarPersona(); // Intentar dejar una persona con el ascensor vacío
    }
}