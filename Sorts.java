import java.util.*;

public class Sorts {

    /** 
     * Insertion Sort
     */
    public static void insertionSort(List<Integer> arr) {
        long startTime = System.nanoTime(); // Iniciar medición de tiempo

        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }

        long endTime = System.nanoTime(); // Finalizar medición de tiempo
        System.out.println("Tiempo de ejecución Insertion Sort: " + (endTime - startTime) + " ns");
    }

    /**
     * Merge Sort
     */
    public static void mergeSort(List<Integer> arr) {
        long startTime = System.nanoTime(); // Iniciar medición de tiempo
    
        mergeSortHelper(arr); // Llamar al método auxiliar sin medir tiempo interno
    
        long endTime = System.nanoTime(); // Finalizar medición de tiempo
        System.out.println("Tiempo de ejecución Merge Sort: " + (endTime - startTime) + " ns");
    }
    
    // Método auxiliar para evitar medir múltiples veces
    private static void mergeSortHelper(List<Integer> arr) {
        if (arr.size() <= 1) return;
    
        int mid = arr.size() / 2;
        List<Integer> left = new ArrayList<>(arr.subList(0, mid));
        List<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));
    
        mergeSortHelper(left);
        mergeSortHelper(right);
        merge(arr, left, right);
    }
    
    private static void merge(List<Integer> arr, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            arr.set(k++, (left.get(i) < right.get(j)) ? left.get(i++) : right.get(j++));
        }
        while (i < left.size()) arr.set(k++, left.get(i++));
        while (j < right.size()) arr.set(k++, right.get(j++));
    }
    

    /**
     * Quick Sort
     */
    public static void quickSort(List<Integer> arr, int low, int high) {
        long startTime = System.nanoTime(); // Iniciar medición de tiempo

        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }

        long endTime = System.nanoTime(); // Finalizar medición de tiempo
        if (low == 0 && high == arr.size() - 1) {
            System.out.println("Tiempo de ejecución Quick Sort: " + (endTime - startTime) + " ns");
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Radix Sort
     */
    public static void radixSort(List<Integer> arr) {
        long startTime = System.nanoTime(); // Iniciar medición de tiempo

        if (arr.isEmpty()) return;
        List<Integer> mutableArr = new ArrayList<>(arr);
        int max = Collections.max(mutableArr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(mutableArr, exp);
        }
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, mutableArr.get(i));
        }

        long endTime = System.nanoTime(); // Finalizar medición de tiempo
        System.out.println("Tiempo de ejecución Radix Sort: " + (endTime - startTime) + " ns");
    }

    private static void countingSortByDigit(List<Integer> arr, int exp) {
        List<Integer> output = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        int[] count = new int[10];

        for (int num : arr) count[(num / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        for (int i = arr.size() - 1; i >= 0; i--) {
            output.set(count[(arr.get(i) / exp) % 10] - 1, arr.get(i));
            count[(arr.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, output.get(i));
        }
    }

    /**
     * Heap Sort
     */
    public static void heapSort(List<Integer> arr) {
        long startTime = System.nanoTime(); // Iniciar medición de tiempo

        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            Collections.swap(arr, 0, i);
            heapify(arr, i, 0);
        }

        long endTime = System.nanoTime(); // Finalizar medición de tiempo
        System.out.println("Tiempo de ejecución Heap Sort: " + (endTime - startTime) + " ns");
    }

    private static void heapify(List<Integer> arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr.get(left) > arr.get(largest)) largest = left;
        if (right < n && arr.get(right) > arr.get(largest)) largest = right;

        if (largest != i) {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}
