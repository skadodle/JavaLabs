import java.util.*;

public class simpleSort<T> {
    // BUBBLE SORT 

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, C extends Collection<T>> void bubbleSort(C collection) {
        T[] array = (T[]) Arrays.copyOf(collection.toArray(), 0);
        bubbleSort(array);
        collection.clear();
        collection.addAll(Arrays.asList(array));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        T[] array = (T[]) new Comparable[list.size()];
        int index = 0;
        for (T el : list) {
            array[index++] = el;
        }
        bubbleSort(array);
        list.clear();
        list.addAll(Arrays.asList(array));
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    swapped = true;
                    T el = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = el;
                }
            }
        } while (swapped);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void bubbleSort(T[] array, int start, int end) {
        T[] temp = Arrays.copyOfRange(array, start, end);
        bubbleSort(temp);
        for (int i = start; i < end; i++) { array[i] = temp[i % start]; }
    }
    // ----------------------------------------------------------------------------------------------------------
    // INSERTION SORT

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, C extends Collection<T>> void insertionSort(C collection) {
        T[] array = (T[]) Arrays.copyOf(collection.toArray(), 0);
        insertionSort(array);
        collection.clear();
        collection.addAll(Arrays.asList(array));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        T[] array = (T[]) new Comparable[list.size()];
        int index = 0;
        for (T el : list) {
            array[index++] = el;
        }
        insertionSort(array);
        list.clear();
        list.addAll(Arrays.asList(array));
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1].compareTo(array[j]) > 0; j--) {
                T el = array[j];
                array[j] = array[j - 1];
                array[j - 1] = el;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void insertionSort(T[] array, int start, int end) {
        T[] temp = Arrays.copyOfRange(array, start, end);
        insertionSort(temp);
        for (int i = start; i < end; i++) { array[i] = temp[i % start]; }
    }

    //---------------------------------------------------------------------------------------------
    // SELECTION SORT

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>, C extends Collection<T>> void selectionSort(C collection) {
        T[] array = (T[]) Arrays.copyOf(collection.toArray(), 0);
        selectionSort(array);
        collection.clear();
        collection.addAll(Arrays.asList(array));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        T[] array = (T[]) new Comparable[list.size()];
        int index = 0;
        for (T el : list) {
            array[index++] = el;
        }
        selectionSort(array);
        list.clear();
        list.addAll(Arrays.asList(array));
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T min = array[i];
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (min.compareTo(array[j]) > 0) {
                    index = j;
                    min = array[j];
                }
            }
            T el = array[i];
            array[i] = min;
            array[index] = el;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void selectionSort(T[] array, int start, int end) {
        T[] temp = Arrays.copyOfRange(array, start, end);
        selectionSort(temp);
        for (int i = start; i < end; i++) { array[i] = temp[i % start]; }
    }
}
