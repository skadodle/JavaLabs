import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class linSort {

    private static final int BUCKETS = 10;

    private static int getDigit(int number, int digit) {
        return (number / (int) Math.pow(10, digit - 1)) % 10;
    }

    // LSD
    public static void radixSortLSD(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int maxDigits = (int) Math.log10(max) + 1;

        for (int digit = 1; digit <= maxDigits; digit++)
            radixSortLSD(arr, digit);
    }

    private static void radixSortLSD(int[] array, int digit) {
        int n = array.length;
        @SuppressWarnings({"unchecked", "rawtypes"})
        Queue<Integer>[] que = new Queue[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            que[i] = new LinkedList<Integer>();
        }

        //System.out.println("\n\nEXP: " + digit);

        for (int i = 0; i < n; i++) { que[getDigit(array[i], digit)].add(array[i]); }
        //for (int i = 0; i < BUCKETS; i++) { System.out.println("i-" + i + " " + que[i].toString()); }

        int index = 0;
        for (int i = 0; i < BUCKETS; i++) {
            while (que[i].size() != 0)
                array[index++] = que[i].remove();
        }
        //System.out.println("Arr: " + Arrays.toString(array));
    }

    // MSD
    public static void radixSortMSD(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int maxDigits = (int) Math.log10(max) + 1;
        radixSortMSD(array, 0, array.length, maxDigits);
    }

    private static void radixSortMSD(int[] array, int start, int end, int digit) {
        if (digit <= 0 || start >= end - 1) return;

        @SuppressWarnings({"unchecked", "rawtypes"})
        ArrayList<Integer>[] buckets = new ArrayList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = start; i < end; i++) {
            int bucketIndex = getDigit(array[i], digit);
            buckets[bucketIndex].add(array[i]);
        }

        int index = start;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }

        int bucketStart = start;
        for (ArrayList<Integer> bucket : buckets) {
            radixSortMSD(array, bucketStart, bucketStart + bucket.size(), digit - 1);
            bucketStart += bucket.size();
        }
    }

    // Count Sort
    public static void countSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt() + 1;
        int[] countArray = new int[max];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (countArray[i] != 0) {
                countArray[i]--;
                array[index++] = i;
            }
        }
    }
}
