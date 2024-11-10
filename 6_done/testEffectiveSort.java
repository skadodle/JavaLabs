import java.util.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testEffectiveSort {

    @Test
    public void testQuickSort() {
        Integer[] array = new Integer[52];
        String[] text = new String[] {"ac", "ab", "aa", "bb", "ba", "bs", "aaaaa", "aops", "poirs", "ispor"};
        for (int i = 0; i < 52; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        Integer[] autoSortInt = new Integer[52];
        String[] autoSortStr = new String[text.length];
        for (int i = 0; i < 52; i++) autoSortInt[i] = array[i];
        for (int i = 0; i < text.length; i++) autoSortStr[i] = text[i];
        Arrays.sort(autoSortInt);
        Arrays.sort(autoSortStr);

        effectiveSort.quickSort(array);
        Assertions.assertArrayEquals(autoSortInt, array);

        effectiveSort.quickSort(text);
        Assertions.assertArrayEquals(autoSortStr, text);
    }
    
    @Test 
    public void testHeapSort() {
        Integer[] array = new Integer[52];
        String[] text = new String[] {"ac", "ab", "aa", "bb", "ba", "bs", "aaaaa", "aops", "poirs", "ispor"};
        for (int i = 0; i < 52; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        Integer[] autoSortInt = new Integer[52];
        String[] autoSortStr = new String[text.length];
        for (int i = 0; i < 52; i++) autoSortInt[i] = array[i];
        for (int i = 0; i < text.length; i++) autoSortStr[i] = text[i];
        Arrays.sort(autoSortInt);
        Arrays.sort(autoSortStr);

        effectiveSort.heapSort(array);
        Assertions.assertArrayEquals(autoSortInt, array);

        effectiveSort.heapSort(text);
        Assertions.assertArrayEquals(autoSortStr, text);
    }

    @Test 
    public void testMergeSort() {
        Integer[] array = new Integer[52];
        String[] text = new String[] {"ac", "ab", "aa", "bb", "ba", "bs", "aaaaa", "aops", "poirs", "ispor"};
        for (int i = 0; i < 52; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        Integer[] autoSortInt = new Integer[52];
        String[] autoSortStr = new String[text.length];
        for (int i = 0; i < 52; i++) autoSortInt[i] = array[i];
        for (int i = 0; i < text.length; i++) autoSortStr[i] = text[i];
        Arrays.sort(autoSortInt);
        Arrays.sort(autoSortStr);

        effectiveSort.mergeSort(array);
        Assertions.assertArrayEquals(autoSortInt, array);

        effectiveSort.mergeSort(text);
        Assertions.assertArrayEquals(autoSortStr, text);
    }
    
    @Test 
    public void testCollectionQuickSort() {
        List<Integer> myList = new LinkedList<>();

        Integer[] autoSortInt = new Integer[200];
        for (int i = 0; i < 200; i++) {
            autoSortInt[i] = (int) (Math.random() * 1000);
            myList.add(autoSortInt[i]);
        }
        Arrays.sort(autoSortInt);
        effectiveSort.quickSort(myList);
        Assertions.assertArrayEquals(autoSortInt, myList.toArray());
    }

    @Test 
    public void testCollectionHeapSort() {
        List<Integer> myList = new LinkedList<>();

        Integer[] autoSortInt = new Integer[110];
        for (int i = 0; i < 110; i++) {
            autoSortInt[i] = (int) (Math.random() * 1000);
            myList.add(autoSortInt[i]);
        }
        Arrays.sort(autoSortInt);
        effectiveSort.heapSort(myList);
        Assertions.assertArrayEquals(autoSortInt, myList.toArray());
    }

    @Test 
    public void testCollectionMergeSort() {
        List<Integer> myList = new LinkedList<>();

        Integer[] autoSortInt = new Integer[110];
        for (int i = 0; i < 110; i++) {
            autoSortInt[i] = (int) (Math.random() * 1000);
            myList.add(autoSortInt[i]);
        }
        Arrays.sort(autoSortInt);
        effectiveSort.mergeSort(myList);
        Assertions.assertArrayEquals(autoSortInt, myList.toArray());
    }

    public static void main(String[] args) {
        main1();
        main2();
        main3();
    }

    private static void main1() {
        Integer[] array = new Integer[52];
        String[] text = new String[] {"ac", "ab", "aa", "bb", "ba", "bs", "aaaaa", "aops", "poirs", "ispor"};
        for (int i = 0; i < 52; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Array before: " + Arrays.deepToString(array));
        effectiveSort.quickSort(array, 0, array.length - 1);
        System.out.println("Array after: " + Arrays.deepToString(array));

        System.out.println("Text before: " + Arrays.deepToString(text));
        effectiveSort.quickSort(text, 0, text.length - 1);
        System.out.println("Text after: " + Arrays.deepToString(text));
    }

    private static void main2() {
        Integer[] array = new Integer[52];
        String[] text = new String[] {"ac", "ab", "aa", "bb", "ba", "bs", "aaaaa", "aops", "poirs", "ispor"};
        for (int i = 0; i < 52; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Array before: " + Arrays.deepToString(array));
        effectiveSort.heapSort(array);
        System.out.println("Array after: " + Arrays.deepToString(array));

        System.out.println("Text before: " + Arrays.deepToString(text));
        effectiveSort.heapSort(text);
        System.out.println("Text after: " + Arrays.deepToString(text));
    }

    private static void main3() {
        Integer[] array = new Integer[52];
        String[] text = new String[] {"ac", "ab", "aa", "bb", "ba", "bs", "aaaaa", "aops", "poirs", "ispor"};
        for (int i = 0; i < 52; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("Array before: " + Arrays.deepToString(array));
        effectiveSort.mergeSort(array);
        System.out.println("Array after: " + Arrays.deepToString(array));

        System.out.println("Text before: " + Arrays.deepToString(text));
        effectiveSort.mergeSort(text);
        System.out.println("Text after: " + Arrays.deepToString(text));
    }
}
