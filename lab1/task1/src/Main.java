import java.time.Instant;


public class Main {
    public static void main(String[] args) throws Exception {

        long timeElapsed;
        long wholeTime = 0;
        long timeStart, timeEnd;

        for (int i=0;i<50;i++) {

            int[] array = ArrayGenerator.getArray(i);

            timeStart = System.nanoTime();
            CustomSorts.quickSort(array, 0, array.length - 1);
            timeEnd = System.nanoTime();

            timeElapsed = timeEnd - timeStart;
            wholeTime += timeElapsed;
            System.out.println("QuickSort " + timeElapsed);
        }

        System.out.printf("QS average time: " + wholeTime/50);


//        for (int i=0;i<50;i++) {
//
//            int[] array = ArrayGenerator.getArray(i);
//
//            timeStart = System.nanoTime();
//            CustomSorts.hybridSort(array, 0, array.length - 1, 50);
//            timeEnd = System.nanoTime();
//
//            timeElapsed = timeEnd - timeStart;
//            wholeTime += timeElapsed;
//            //System.out.println("Hybrid Sort " + timeElapsed);
//        }
//
//        System.out.printf("HS average time: " + wholeTime/50);
        //HS average time: 9034927

    }
}
