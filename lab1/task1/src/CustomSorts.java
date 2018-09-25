public class CustomSorts {

    private static int findQ(int[] array, int start, int end) {
        int x = array[end];
        int q = start;
        int temp;

        for (int i = start; i < end; i++) {
            if (array[i] <= x) {
                temp = array[i];
                array[i] = array[q];
                array[q] = temp;

                q++;
            }
        }

        temp = array[q];
        array[q] = array[end];
        array[end] = temp;

        return q;
    }

    public static void quickSort(int[] array, int start, int end) {

        if (start < end) {
            int q = findQ(array, start, end);
            quickSort(array, start, q - 1);
            quickSort(array, q + 1, end);

        }

    }

    public static void insertionSort(int[] array, int start, int end) {
        int j, currentValue;
        for (int i = start; i < end; i++) {
            currentValue = array[i];
            j = i;
            while (j > 0 && array[j - 1] > currentValue) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = currentValue;
        }
    }

    public static void hybridSort(int[] array, int start, int end, int n) {

        if (start < end) {
            int q = findQ(array, start, end);

            if (end - start >= n) {
                quickSort(array, start, q - 1);
            } else {
                insertionSort(array, start, q - 1);
            }

            if (end - start >= n) {
                quickSort(array, q + 1, end);
            } else {
                insertionSort(array, q + 1, end);
            }
        }
    }

}
