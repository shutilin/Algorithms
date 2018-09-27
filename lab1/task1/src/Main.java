import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {

        long timeElapsedQS, timeElapsedHS;
        long wholeTimeQS = 0, wholeTimeHS = 0;
        long timeStartQS, timeEndQS, timeStartHS, timeEndHS;
        long timeFor5050 = 0;

//        for (int j = 0; j < 10; j++) {
//
//            for (int i = 0; i < 50; i++) {
//                int[] array = ArrayGenerator.getArray(i);
//
//                timeStartQS = System.nanoTime();
//                CustomSorts.quickSort(array, 0, array.length - 1);
//                timeEndQS = System.nanoTime();
//
//                timeElapsedQS = timeEndQS - timeStartQS;
//                wholeTimeQS += timeElapsedQS;
//            }
//
//            System.out.println("QS average time: " + wholeTimeQS / 50.0);
//            wholeTimeQS = 0;
//        }

        //minimal value: 9073619.8;
        for (int j = 200; j > 5; j--) {
            for (int i = 0; i < 50; i++) {

                int[] array = ArrayGenerator.getArray(i);

                timeStartHS = System.nanoTime();
                CustomSorts.hybridSort(array, 0, array.length - 1, j);
                timeEndHS = System.nanoTime();

                timeElapsedHS = timeEndHS - timeStartHS;
                wholeTimeHS += timeElapsedHS;
            }


            if (9073619.8 > wholeTimeHS / 50.0) {
                System.out.println("QS average time: " + 9073619.8);
                System.out.println("HS average time: " + wholeTimeHS / 50.0 + " n:" + j);
            }
            //wholeTimeQS = 0;
            wholeTimeHS = 0;
            //HS average time: 9034927
        }
    }
}
