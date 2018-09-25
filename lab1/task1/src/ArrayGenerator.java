import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayGenerator {

    public static final int numberOfElements = 100000;
    public static final int elementRange = 1000000000;
    private static final String path = "D://BSU//3_course//Git//Algorithms//lab1//task1//input//";

    public static void generateInputData() throws Exception {

        //int numberOfElements = 100000;
        //int elementRange = 1000000000;

        //String path = "D://BSU//3_course//Git//Algorithms//lab1//task1//input//";

        for (int i=0; i<50; i++) {
            FileWriter fw = new FileWriter(path + "input" + i);
            for (int j = 0; j < numberOfElements; j++) {

                fw.write(ThreadLocalRandom.current().nextInt(0, elementRange) + " ");
            }
            fw.close();
        }

//        int[] array = new int[numberOfElements];
//        FileReader fr = new FileReader(path + "input1");
//        Scanner scan = new Scanner(fr);
//
//        for (int i = 0; i < numberOfElements; i++) {
//            array[i] = scan.nextInt();
//            //System.out.println(array[i]);
//        }
//        fr.close();
//
//        return array;
    }

    public static int[] getArray(int fileIndex) throws Exception{
        int numberOfElements = 100000;

        int[] array = new int[numberOfElements];
        FileReader fr = new FileReader(path + "input" + fileIndex);
        Scanner scan = new Scanner(fr);

        for (int i = 0; i < numberOfElements; i++) {
            array[i] = scan.nextInt();
            //System.out.println(array[i]);
        }
        fr.close();

        return array;
    }
}
