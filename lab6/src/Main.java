import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] adj = { {0,1,1},
                        {1,0,1},
                        {1,1,0} };

        int[][] w = { {0,20,1},
                      {20,0,3},
                      {1,3,0}};

        Graph g = new Graph(3,adj,w);

        System.out.println(Arrays.toString(GraphActions.dijkstra(g, 0)));

        GraphActions.printPath(g, GraphActions.dijkstra(g, 0), 0, 1);

        int[][] matrix = GraphActions.floydWarshall(g);

        for (int i = 0; i < g.getNumberOfVertices(); i++) {
            for (int j = 0; j < g.getNumberOfVertices(); j++) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }

        System.out.println(GraphActions.findGraphCenter(g));

    }
}
