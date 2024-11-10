import java.util.Arrays;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.random;

public class testLinSort {

    @Test 
    public void testIntArrayLSD() {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) array[i] = (int) (Math.random() * 10000000);

        int[] autoSort = Arrays.copyOf(array, array.length);
        linSort.radixSortLSD(array);
        Arrays.sort(autoSort);
        Assertions.assertArrayEquals(autoSort, array);
    }

    @Test
    public void testIntArrayMSD() {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) array[i] = (int) (Math.random() * 10000000);

        int[] autoSort = Arrays.copyOf(array, array.length);
        linSort.radixSortMSD(array);
        Arrays.sort(autoSort);
        Assertions.assertArrayEquals(autoSort, array);
    }

    @Test
    public void testIntCountSort() {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) array[i] = (int) (Math.random() * 10000000);
        
        int[] autoSort = Arrays.copyOf(array, array.length);
        linSort.countSort(array);
        Arrays.sort(autoSort);
        Assertions.assertArrayEquals(autoSort, array);
    }
}
