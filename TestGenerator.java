import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.List;

/**
 * Pruebas unitarias para la clase Generator.
 */
public class TestGenerator {
    private Generator generator;
    private static final String nombreArchivo = "Numeros.txt";
    private static final int cantidadNumeros = 10;

    @Before
    public void setUp() {
        generator = new Generator();
    }

    /**
     * Verifica que el archivo se genera correctamente con la cantidad especificada de números.
     */
    @Test
    public void testGenerarArchivo() {
        // Generar el archivo con una cantidad conocida de números
        generator.generarArchivo(cantidadNumeros);

        // Verificar que el archivo se haya creado
        File archivo = new File(nombreArchivo);
        assertTrue("El archivo no fue creado", archivo.exists());

        // Verificar que el archivo no esté vacío
        assertTrue("El archivo está vacío", archivo.length() > 0);
    }

    /**
     * Verifica que el archivo generado se lea correctamente y contenga la cantidad esperada de números.
     */
    @Test
    public void testLeerArchivo() {
        // Generar y luego leer el archivo
        generator.generarArchivo(cantidadNumeros);
        List<Integer> numerosLeidos = generator.leerArchivo();

        // Verificar que la lista no sea nula
        assertNotNull("La lista de números es nula", numerosLeidos);

        // Verificar que la cantidad de números leídos sea la deseada
        assertEquals("La cantidad de números leídos no coincide", cantidadNumeros, numerosLeidos.size());

        // Verificar que todos los elementos sean enteros
        for (Integer num : numerosLeidos) {
            assertNotNull("El número es nulo", num);
        }
    }

    /**
     * Elimina el archivo generado después de las pruebas.
     */
    @After
    public void limpiarArchivo() {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}