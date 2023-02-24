public class NaturalMergeSorter {
    public int getSortedRunLength(int[] array, int arrayLength,
                                  int startIndex) {
        // check for correct inputs
        if (arrayLength != array.length || startIndex >= arrayLength) {
            return 0;
        }

        // initialize return value
        int sortedRunLength = 1;
        int prev = array[startIndex];
        for (int i = startIndex + 1; i < arrayLength; i++) {
            if (array[i] < prev) {
                break;
            } else {
                prev = array[i];
                sortedRunLength++;
            }
        }
        return sortedRunLength;
    }

    public void naturalMergeSort(int[] array, int arrayLength) {
        if (arrayLength <= 1) {
            return;
        }
        for (int i = 0; i < arrayLength; i++) {
            int run1 = getSortedRunLength(array, arrayLength, i);
            if (run1 == arrayLength) {
                return;
            } else if (run1 + i == arrayLength) {
                i = -1;
                continue;
            }
            int run2 = getSortedRunLength(array, arrayLength, run1 + i);
            if (run2 == 0) {
                run2++;
            }
            merge(array, i, run1 + i - 1, run1 + run2 + i - 1);
            if (i + run1 + run2 >= arrayLength - 1) {
                i = -1;
            } else {
                i = i + run1 + run2 - 1;
            }
        }
    }

    public void merge(int[] numbers, int leftFirst, int leftLast,
                      int rightLast) {
        int mergedSize = rightLast - leftFirst + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = leftFirst;
        int rightPos = leftLast + 1;

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= leftLast && rightPos <= rightLast) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // If left partition isn't empty, add remaining elements to mergedNumbers
        while (leftPos <= leftLast) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition isn't empty, add remaining elements to mergedNumbers
        while (rightPos <= rightLast) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
        }

        // Free temporary array
        mergedNumbers = null;
    }
    public static boolean isSorted(int[] arr, int arrSize) {
        for (int i = 1; i < arrSize; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}