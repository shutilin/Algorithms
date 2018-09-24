import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 1, 8, 10, 0};


        Instant start = Instant.now();
        CustomSorts.hybridSort(array, 0, array.length - 1, 2);
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("time " + timeElapsed);
        System.out.println(Arrays.toString(array));
    }
}
