import java.util.Arrays;
import java.util.List;

public class simpleSort<T> {
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

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void bubbleSort(myList<T> list) {
        T[] array = (T[]) new Comparable[list.getSize()];
        int index = 0;
        for (T el : list) {
            array[index++] = el;
        }
        bubbleSort(array);
        list.clear();
        for (T el : array) {
            list.pushBack(el);
        }
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

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void insertionSort(myList<T> list) {
        T[] array = (T[]) new Comparable[list.getSize()];
        int index = 0;
        for (T el : list) {
            array[index++] = el;
        }
        insertionSort(array);
        list.clear();
        for (T el : array) {
            list.pushBack(el);
        }
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

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends Comparable<T>> void selectionSort(myList<T> list) {
        T[] array = (T[]) new Comparable[list.getSize()];
        int index = 0;
        for (T el : list) {
            array[index++] = el;
        }
        selectionSort(array);
        list.clear();
        for (T el : array) {
            list.pushBack(el);
        }
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
}
