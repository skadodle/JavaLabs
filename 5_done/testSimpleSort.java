import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testSimpleSort {
    private final Integer[] array = new Integer[10000];
    private final Integer[] testArray = new Integer[10000];
    private final LinkedList<Double> list = new LinkedList<>();
    private final LinkedList<Double> testList = new LinkedList<>();

    @BeforeEach
    public void initialise() {
        for (int i = 0; i < 10000; i++) {
            array[i] = (int) (random() * 256);
            testArray[i] = array[i];

            double el = random() * 82;
            list.add(el);
            testList.add(el);
        }
    }

    @Test
    public void testCaseArrayBubble() {
        //long time = System.currentTimeMillis();
        Arrays.sort(testArray);
        //System.out.println(System.currentTimeMillis() - time);
        //time = System.currentTimeMillis();
        simpleSort.bubbleSort(array);
        //System.out.println(System.currentTimeMillis() - time);
        Assertions.assertArrayEquals(testArray, array);
    }

    @Test 
    public void testCaseArrayInsertion() {
        //long time = System.currentTimeMillis();
        Arrays.sort(testArray);
        //System.out.println(System.currentTimeMillis() - time);
        //time = System.currentTimeMillis();
        simpleSort.insertionSort(array);
        //System.out.println(System.currentTimeMillis() - time);
        Assertions.assertArrayEquals(testArray, array);
    }

    @Test 
    public void testCaseArraySelection() {
        //long time = System.currentTimeMillis();
        Arrays.sort(testArray);
        //System.out.println(System.currentTimeMillis() - time);
        //time = System.currentTimeMillis();
        simpleSort.selectionSort(array);
        //System.out.println(System.currentTimeMillis() - time);
        Assertions.assertArrayEquals(testArray, array);
    }

    @Test 
    public void testCaseListBubble() {
        //long time = System.currentTimeMillis();
        Collections.sort(testList);
        //System.out.println(System.currentTimeMillis() - time);
        //time = System.currentTimeMillis();
        simpleSort.bubbleSort(list);
        //System.out.println(System.currentTimeMillis() - time);
        assertEquals(testList, list);
    }

    @Test 
    public void testCaseListInsertion() {
        //long time = System.currentTimeMillis();
        Collections.sort(testList);
        //System.out.println(System.currentTimeMillis() - time);
        //time = System.currentTimeMillis();
        simpleSort.insertionSort(list);
        //System.out.println(System.currentTimeMillis() - time);
        assertEquals(testList, list);
    }

    @Test 
    public void testCaseListSelection() {
        //long time = System.currentTimeMillis();
        Collections.sort(testList);
        //System.out.println(System.currentTimeMillis() - time);
        //time = System.currentTimeMillis();
        simpleSort.selectionSort(list);
        //System.out.println(System.currentTimeMillis() - time);
        assertEquals(testList, list);
    }

    public static void main(String[] args) {
        Integer[] intArrayBubble = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        simpleSort.bubbleSort(intArrayBubble);
        for (int num : intArrayBubble) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] stringArrayBubble = {"banana", "apple", "cherry", "date"};
        simpleSort.bubbleSort(stringArrayBubble);
        for (String str : stringArrayBubble) {
            System.out.print(str + " ");
        }
        System.out.println();


        Integer[] intArrayInsertion = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        simpleSort.insertionSort(intArrayInsertion);
        for (int num : intArrayInsertion) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] stringArrayInsertion = {"banana", "apple", "cherry", "date"};
        simpleSort.insertionSort(stringArrayInsertion);
        for (String str : stringArrayInsertion) {
            System.out.print(str + " ");
        }
        System.out.println();


        Integer[] intArraySelection = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        simpleSort.selectionSort(intArraySelection);
        for (int num : intArraySelection) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] stringArraySelection = {"banana", "apple", "cherry", "date"};
        simpleSort.selectionSort(stringArraySelection);
        for (String str : stringArraySelection) {
            System.out.print(str + " ");
        }
        System.out.println();

        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();

        for (int i = 0; i < 25; i++) {
            list1.add((int) (random() * 100));
            list2.add((int) (random() * 100));
            list3.add((int) (random() * 100));
        }

        System.out.println("1: " + list1.toString());
        simpleSort.bubbleSort(list1);
        System.out.println(list1.toString());


        System.out.println("2: " + list2.toString());
        simpleSort.insertionSort(list2);
        System.out.println(list2.toString());


        System.out.println("3: " + list3.toString());
        simpleSort.selectionSort(list3);
        System.out.println(list3.toString());
    }
}
