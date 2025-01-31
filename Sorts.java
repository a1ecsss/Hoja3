import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorts {
    
    /** 
     * Insertion Sort
     */
    public static int[] insertionSort(int[] arr) {
        int[] sortedArr = arr.clone();
        for (int i = 1; i < sortedArr.length; i++) {
            int key = sortedArr[i];
            int j = i - 1;
            
            while (j >= 0 && sortedArr[j] > key) {
                sortedArr[j + 1] = sortedArr[j];
                j--;
            }
            sortedArr[j + 1] = key;
        }
        return sortedArr;
    }

    /**
     * Merge Sort
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        int[] merged = new int[arr.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            merged[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) merged[k++] = left[i++];
        while (j < right.length) merged[k++] = right[j++];

        return merged;
    }

    /**
     * Quick Sort (sin cambios)
     */
    public static List<Integer> qs(List<Integer> list) {
        if (list.size() <= 1) return list;

        int pivot = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < pivot) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(qs(left));
        sortedList.add(pivot);
        sortedList.addAll(qs(right));

        return sortedList;
    }

    /**
     * Radix Sort
     */
    public static int[] radixSort(int[] arr) {
        int[] sortedArr = arr.clone();
        int max = Arrays.stream(sortedArr).max().orElse(0);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            int[] output = new int[sortedArr.length];
            int[] count = new int[10];

            for (int num : sortedArr) {
                count[(num / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = sortedArr.length - 1; i >= 0; i--) {
                output[count[(sortedArr[i] / exp) % 10] - 1] = sortedArr[i];
                count[(sortedArr[i] / exp) % 10]--;
            }

            sortedArr = output.clone();
        }
        return sortedArr;
    }

    /**
     * Heap Sort
     */
    public static int[] heapSort(int[] arr) {
        int[] sortedArr = arr.clone();
        int n = sortedArr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sortedArr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = sortedArr[0];
            sortedArr[0] = sortedArr[i];
            sortedArr[i] = temp;
            heapify(sortedArr, i, 0);
        }
        return sortedArr;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
