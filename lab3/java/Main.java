import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        HashTableOA ht = new HashTableOA();

//
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(i + "  " + (int) ((i % 811) * 0.38066) % 32);
//        }
        // 0 32
        // 1 33
//
////        ht.insert(0, 5);
//////        ht.insert(32, 6);
//////        ht.insert(10, 8);
//////        System.out.println(ht.retrieve(32));
//////
//////        ht.print();

//        HashTableCH ch = new HashTableCH();
//
//        ch.insert(1, 5);
//        ch.insert(8, 2);
//        ch.insert(32, 6);
//
//        System.out.println(ch.retrieve(8));
//        ch.print();
        double[] arrayOfConstants = {0.38066, 0.27364823, (Math.sqrt(5) - 1) / 2};

        for (int constantIndex = 0; constantIndex < 3; constantIndex++) {
            int[] chainLengths = new int[50];
            for (int i = 0; i < 50; i++) {
                int[] array = arrayGenerator();

                HashTableCH hashTableCH = new HashTableCH(arrayOfConstants[constantIndex]);
                for (int j = 0; j < array.length; j++) {
                    hashTableCH.insert(array[j], ThreadLocalRandom.current().nextInt(0, 1000));
                }
                chainLengths[i] = hashTableCH.getMaxCollisionChainLength();
            }

            int maxChainLength = 0;
            for (int i = 0; i < 50; i++) {
                if (chainLengths[i] > maxChainLength) {
                    maxChainLength = chainLengths[i];
                }
            }

            System.out.println(maxChainLength);
        }
    }

    private static int[] arrayGenerator() {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 1000);

        }

        return array;
    }
}
