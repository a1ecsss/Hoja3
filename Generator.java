import java.io.*;
import java.util.*;

public class Generator {
    private static final int MAX = 3000;
    private static final String nombreArchivo = "Numeros.txt";

    private static void generarArchivo(int cantidadNumeros){
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))){
            for (int i = 0; i < cantidadNumeros; i++){
                writer.write(random.nextInt(1000) + "\n");
            } 
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
    }
}

    private static int[] leerArchivo(){
        List<Integer> listaNumeros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listaNumeros.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Convertir la lista a un array
        return listaNumeros.stream().mapToInt(Integer::intValue).toArray();
    }
    
}
