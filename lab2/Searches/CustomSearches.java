package shutilin;

import org.openjdk.jmh.annotations.Benchmark;

public class CustomSearches {

    public static int BinarySearch(int[] array, int start, int end, int key) {
        int middle;
        int indexResult = -1;

        while (start <= end) {
            middle = (start + end) / 2;

            if (key == array[middle]) {
                indexResult = middle;
                break;
            } else if (key < array[middle]) {
                end = middle - 1;
            } else if (key > array[middle]) {
                start = middle + 1;
            }
        }

        return indexResult;
    }

    public static int InterpolationSearch(int[] array, int start, int end, int key) {
        int middle;
        int indexResult = -1;

        while (array[start] < key && array[end] > key) {
            middle = start + ((key - array[start]) * (end - start)) / (array[end] - array[start]);

            if (key == array[middle]) {
                indexResult = middle;
                break;
            } else if (key < array[middle]) {
                end = middle - 1;
            } else if (key > array[middle]) {
                start = middle + 1;
            }
        }

        if (key == array[start]) {
            indexResult = start;
        } else if (key == array[end]) {
            indexResult = end;
        }

        return indexResult;
    }
}