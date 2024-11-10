import java.util.Iterator;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testMyList {
    static myList<Integer> list = new myList<Integer>();  

    @BeforeEach
    public void before() {
        list.pushForward(5);
        list.pushForward(11);
        list.pushBack(9);
    }

    @Test 
    public void testCase() {
        myList<Integer> list = new myList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        int[] array = new int[3]; 
        int index = 0;

        Iterator<Integer> iterBegin = list.iteratorBegin();
        while (iterBegin.hasNext()) {
            array[index++] = iterBegin.next().intValue();
        }

        Assertions.assertArrayEquals(new int[] {1, 2, 3}, array);

        Iterator<Integer> iterEnd = list.iteratorEnd();
        while (iterEnd.hasNext()) {
            Assertions.assertEquals(array[2], iterEnd.next().intValue());
        }
        iterEnd = list.iteratorBegin();
        index = 0;
        while (iterEnd.hasNext()) {
            int value = iterEnd.next().intValue();
            Assertions.assertEquals(array[index++], value);
        }
    }

    @Test 
    public void testCaseSort() {
        myList<Integer> list = new myList<>();
        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            array[i] = (int) Math.round(Math.random() * 256);
            list.pushBack(array[i]);
        }

        Arrays.sort(array);

        simpleSort.bubbleSort(list);
        int index = 0;
        for (Integer el : list) 
            Assertions.assertEquals(array[index++], el);
    }

    public static void main(String[] args) {
        myList<Integer> list = new myList<Integer>();
        list.pushForward(5);
        list.pushForward(11);
        list.pushBack(9);

        list.printList();
        System.out.println("SIZE = " + list.getSize());
        
        try { list.delete(5); }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        list.printList();
        System.out.println("SIZE = " + list.getSize());

        list.pushForward(1112);
        list.pushForward(911);
        list.pushBack(52);

        list.printList();
        System.out.println("SIZE = " + list.getSize());

        try {
            System.out.println("POP BACK = " + list.popBack());
            System.out.println("POP FORWARD = " + list.popForward());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Iterator: ");
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        System.out.println("List after popping first and last");
        list.printList();
        System.out.println("SIZE = " + list.getSize());

        list.clear();
        System.out.println("SIZE AFTER CLEARING = " + list.getSize());
        
        // test ITERATOR
        main2();
        main3();
    }

    public static void main2() {
        myList<Integer> list = new myList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        System.out.println("Iterator from beginning: ");
        Iterator<Integer> iterBegin = list.iteratorBegin();
        while (iterBegin.hasNext()) {
            System.out.print(iterBegin.next() + " ");
        }
        System.out.println();

        System.out.println("Iterator from end: ");
        Iterator<Integer> iterEnd = list.iteratorEnd();
        while (iterEnd.hasNext()) {
            System.out.print(iterEnd.next() + " ");
        }
        System.out.println();
        iterEnd = list.iteratorBegin();
        while (iterEnd.hasNext()) {
            System.out.print(iterEnd.next() + " ");
        }
        System.out.println();
    }

    public static void main3() {
        myList<Integer> list = new myList<>();
        for (int i = 0; i < 50; i++) {
            list.pushBack((int) Math.round(Math.random() * 256));
        }

        list.printList();
        simpleSort.bubbleSort(list);
        list.printList();
    }
}
