import java.io.*;
import java.util.*;

public class Generator {
    private static final String nombreArchivo = "Numeros.txt";

    // Método para generar un archivo con números aleatorios
    public static void generarArchivo(int cantidadNumeros) {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < cantidadNumeros; i++) {
                writer.write(random.nextInt(1000) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    // Método para leer los números desde el archivo y devolverlos como una lista
    public static List<Integer> leerArchivo() {
        List<Integer> listaNumeros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listaNumeros.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return listaNumeros;
    }
}
