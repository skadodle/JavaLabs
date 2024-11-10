import java.util.*;

public class effectiveSort<T> {

    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    
    // QUICK
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, C extends Collection<T>> void quickSort(C collection) {
        T[] array = collection.toArray((T[]) new Comparable[0]);
        quickSort(array);
        collection.clear();
        collection.addAll(Arrays.asList(array));
    }

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (array.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        T border = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(border) < 0) i++;
            while (array[j].compareTo(border) > 0) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }

    // HEAP
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, C extends Collection<T>> void heapSort(C collection) {
        T[] array = collection.toArray((T[]) new Comparable[0]);
        heapSort(array);
        collection.clear();
        collection.addAll(Arrays.asList(array));
    }

    private static int LEFT(int i) { return (2 * i + 1); }
    private static int RIGHT(int i) { return (2 * i + 2); }

    private static <T extends Comparable<T>> void heapify(T[] array, int i, int size) {
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        if (left < size && array[left].compareTo(array[i]) > 0) largest = left;
        if (right < size && array[right].compareTo(array[largest]) > 0) largest = right;

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, size);
        }
    }

    private static <T extends Comparable<T>> T pop(T[] array, int size) {
        if (size <= 0) {
            return null;
        }
        T top = array[0];

        array[0] = array[size - 1];
        heapify(array, 0, size - 1);
        return top;
    }

    public static <T extends Comparable<T>> void heapSort(T[] array) {
        int n = array.length;
        int i = (n - 2) / 2;
        while (i >= 0) { heapify(array, i--, n); }
        while (n > 0) { 
            array[n - 1] = pop(array, n); 
            n--; 
        }
    }

    // MERGE 
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, C extends Collection<T>> void mergeSort(C collection) {
        T[] array = collection.toArray((T[]) new Comparable[0]);
        mergeSort(array);
        collection.clear();
        collection.addAll(Arrays.asList(array));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        T[] buffer1 = Arrays.copyOf(array, array.length);
        T[] buffer2 = (T[]) new Comparable[array.length];
        T[] result = mergeSortInner(buffer1, buffer2, 0, array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    private static <T extends Comparable<T>> T[] mergeSortInner(T[] buffer1, T[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) 
            return buffer1;

        int middle = startIndex + (endIndex - startIndex) / 2;
        T[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        T[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        T[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1].compareTo(sorted2[index2]) < 0
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
