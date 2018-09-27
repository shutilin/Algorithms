import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        List<Item> itemsList1 = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            itemsList1.add(new Item(
                    "First " + i,
                    ThreadLocalRandom.current().nextInt(0, 30),
                    ThreadLocalRandom.current().nextInt(300, 3000))
            );
        }

        List<Item> itemsList2 = new ArrayList<Item>();

        for (int i = 0; i < 10; i++) {
            itemsList2.add(new Item(
                    "Second " + i,
                    ThreadLocalRandom.current().nextInt(0, 30),
                    ThreadLocalRandom.current().nextInt(300, 3000))
            );
        }

        Item[] table1 = new Item[10];
        table1 = itemsList1.toArray(table1);

        Item[] table2 = new Item[10];
        table2 = itemsList2.toArray(table2);

        int j = 0;
        for (Item itemVar : itemsList1) {
            itemVar.linkItem(table2[j]);
            j++;
        }

        CustomSort.mergeSort(table1, 0, table1.length - 1);
        Item[] sortedTable2 = new Item[10];
        for (int i = 0; i < 10; i++) {
            sortedTable2[i] = table1[i].getLinkedItem();
        }

        System.out.println("Table 1 " + Arrays.toString(table1));
        System.out.println("Table 2 " + Arrays.toString(sortedTable2));


    }
}
