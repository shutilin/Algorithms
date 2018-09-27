public class CustomSort {
    public static void merge(Item[] items, int start, int middle, int end) {
        Item[] tempArray = new Item[items.length];

        for (int i = start; i <= end; i++) {
            tempArray[i] = items[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (tempArray[i].getAge() <= tempArray[j].getAge()) {
                items[k] = tempArray[i];
                i++;
            } else {
                items[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            items[k] = tempArray[i];
            k++;
            i++;
        }

    }

    public static void mergeSort(Item[] items, int start, int end) {
        if (start < end) {
            int q = (start + end)/2;
            mergeSort(items, start, q);
            mergeSort(items, q+1, end);

            merge(items,start,q,end);
        }
    }
}
