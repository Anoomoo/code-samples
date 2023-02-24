import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Test case array for sorting
        // Test case array: Sorted run of 3 followed by sorted run of 6
        Random random = new Random();
        int[] arr2 = IntStream.generate(() -> random.nextInt(-10, 20)).limit(10).toArray();
        int arr2Length = arr2.length;

        int[] test1 = {17, 58, 96, 24, 88, 70, 23, 64, 74, 81, 55};

        NaturalMergeSorter naturalMerge = new NaturalMergeSorter();
        int runLength = naturalMerge.getSortedRunLength(test1, test1.length, 6);
        System.out.printf("%d: %d\n", 6, runLength);

        //             naturalMerge.naturalMergeSort(arr2, arr2Length);
    }

}