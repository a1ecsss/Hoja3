import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Generar un archivo con 3000 números aleatorios
        Generator.generarArchivo(3000);

        // Leer los números desde el archivo y almacenarlos en una lista
        List<Integer> numeros = Generator.leerArchivo();

        // Verificar si la lista está vacía
        if (numeros.isEmpty()) {
            System.out.println("No se encontraron números en el archivo.");
            return;
        }

        // Imprimir los números leídos para referencia
        //System.out.println("Números leídos del archivo: " + numeros);

        // Aplicar y mostrar diferentes algoritmos de ordenamiento
        List<Integer> copiaNumeros;

        // Insertion Sort
        copiaNumeros = new ArrayList<>(numeros);
        //System.out.println("\nOrdenamiento con Insertion Sort:");
        Sorts.insertionSort(copiaNumeros);
        //System.out.println(copiaNumeros);

        // Merge Sort
        copiaNumeros = new ArrayList<>(numeros);
        //System.out.println("\nOrdenamiento con Merge Sort:");
        Sorts.mergeSort(copiaNumeros);
        //System.out.println(copiaNumeros);

        // Quick Sort
        copiaNumeros = new ArrayList<>(numeros);
        //System.out.println("\nOrdenamiento con Quick Sort:");
        Sorts.quickSort(copiaNumeros, 0, copiaNumeros.size() - 1);
        //System.out.println(copiaNumeros);

        // Radix Sort
        copiaNumeros = new ArrayList<>(numeros);
        //System.out.println("\nOrdenamiento con Radix Sort:");
        Sorts.radixSort(copiaNumeros);
        //System.out.println(copiaNumeros);

        // Heap Sort
        copiaNumeros = new ArrayList<>(numeros);
        //System.out.println("\nOrdenamiento con Heap Sort:");
        Sorts.heapSort(copiaNumeros);
        //System.out.println(copiaNumeros);
    }
}
