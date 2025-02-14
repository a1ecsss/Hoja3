import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pruebas unitarias para la clase Sorts.
 */
public class SortsTests {

    /**
     * Verifica el funcionamiento de Insertion Sort.
     */
    @Test
    public void testInsertionSort() {
        List<Integer> arr = Arrays.asList(5, 3, 8, 6, 2, 7, 4, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        Sorts.insertionSort(arr);

        assertEquals("Insertion Sort falló", expected, arr);
    }

    /**
     * Verifica el funcionamiento de Merge Sort.
     */
    @Test
    public void testMergeSort() {
        List<Integer> arr = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Sorts.mergeSort(arr);

        assertEquals("Merge Sort falló", expected, arr);
    }

    /**
     * Verifica el funcionamiento de Quick Sort.
     */
    @Test
    public void testQuickSort() {
        List<Integer> arr = Arrays.asList(3, 7, 2, 9, 1, 5, 8, 6, 4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Sorts.quickSort(arr, 0, arr.size() - 1);

        assertEquals("Quick Sort falló", expected, arr);
    }

    /**
     * Verifica el funcionamiento de Radix Sort.
     */
    @Test
    public void testRadixSort() {
        List<Integer> arr = Arrays.asList(170, 45, 75, 90, 802, 24, 2, 66);
        List<Integer> expected = Arrays.asList(2, 24, 45, 66, 75, 90, 170, 802);

        Sorts.radixSort(arr);

        assertEquals("Radix Sort falló", expected, arr);
    }

    /**
     * Verifica el funcionamiento de Heap Sort.
     */
    @Test
    public void testHeapSort() {
        List<Integer> arr = Arrays.asList(4, 10, 3, 5, 1);
        List<Integer> expected = Arrays.asList(1, 3, 4, 5, 10);

        Sorts.heapSort(arr);

        assertEquals("Heap Sort falló", expected, arr);
    }

    /**
     * Verifica qué pasa con una lista vacía.
     */
    @Test
    public void testEmptyList() {
        List<Integer> empty = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();

        Sorts.insertionSort(empty);
        assertEquals("Insertion Sort con lista vacía falló", expected, empty);

        Sorts.mergeSort(empty);
        assertEquals("Merge Sort con lista vacía falló", expected, empty);

        Sorts.quickSort(empty, 0, empty.size() - 1);
        assertEquals("Quick Sort con lista vacía falló", expected, empty);

        Sorts.radixSort(empty);
        assertEquals("Radix Sort con lista vacía falló", expected, empty);

        Sorts.heapSort(empty);
        assertEquals("Heap Sort con lista vacía falló", expected, empty);
    }

    /**
     * Verifica qué pasa con una lista de un solo elemento.
     */
    @Test
    public void testSingleElementList() {
        List<Integer> single = Arrays.asList(42);
        List<Integer> expected = Arrays.asList(42);

        Sorts.insertionSort(single);
        assertEquals("Insertion Sort con un solo elemento falló", expected, single);

        Sorts.mergeSort(single);
        assertEquals("Merge Sort con un solo elemento falló", expected, single);

        Sorts.quickSort(single, 0, single.size() - 1);
        assertEquals("Quick Sort con un solo elemento falló", expected, single);

        Sorts.radixSort(single);
        assertEquals("Radix Sort con un solo elemento falló", expected, single);

        Sorts.heapSort(single);
        assertEquals("Heap Sort con un solo elemento falló", expected, single);
    }
}
