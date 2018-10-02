package shutilin;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Main {

   public static void main(String[] args) throws Exception{
       org.openjdk.jmh.Main.main(args);
   }

   @State(Scope.Thread)
   public static class Setup {
       public int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
       public int length = array.length - 1;
       public int key = 4;
   }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 0)
    public void measureInterpolationSearch(Setup setup) {
        CustomSearches.InterpolationSearch(setup.array, 0, setup.length, setup.key);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1, warmups = 0)
    public void measureBinarySearch(Setup setup) {
        CustomSearches.BinarySearch(setup.array, 0, setup.length, setup.key);
    }
}
