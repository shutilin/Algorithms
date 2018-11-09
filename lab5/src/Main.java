import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] adj = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] w = {{-1,1,2},{1,-1,3},{2,3,-1}};

        Graph g = new Graph(3,adj,w);

        PrimsAlg prim = new PrimsAlg(g);
        System.out.println(Arrays.toString(prim.kruskal().toArray()));
        //System.out.println(Arrays.toString(prim.primMST()));
    }
}
