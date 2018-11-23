import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphActions {

    public static int[] dijkstra(Graph graph, int source) {
        int graphSize = graph.getNumberOfVertices();
        int[] distances = new int[graphSize];
        int[] preceedingVertices = new int[graphSize];
        boolean[] visitedVertices = new boolean[graphSize];


        for (int i = 0; i < graphSize; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        distances[source] = 0;

        for (int i = 0; i < graphSize; i++) {
            int nextVertex = getMinVertex(distances, visitedVertices);

            visitedVertices[nextVertex] = true;

            List<Integer> adjVertices = getAdjacentVertices(graph, nextVertex);

            for (int j = 0; j < adjVertices.size(); j++) {
                int currentVertex = adjVertices.get(j);
                int currentDistance = distances[nextVertex] + graph.getWeight(nextVertex, currentVertex);

                if (distances[currentVertex] > currentDistance) {
                    distances[currentVertex] = currentDistance;
                    preceedingVertices[currentVertex] = nextVertex;
                }
            }

        }

        return preceedingVertices;

    }

    private static int getMinVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int vertex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < minDistance && !visited[i]) {
                vertex = i;
                minDistance = distances[i];
            }
        }

        return  vertex;
    }

    private static List<Integer> getAdjacentVertices(Graph graph, int vertex) {

        int[][] adjMatrix = graph.getAdjacencyMatrix();
        List<Integer> incidentVertices = new ArrayList<Integer>();

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (adjMatrix[vertex][i] == 1) {
                incidentVertices.add(i);
            }
        }

        return incidentVertices;
    }

    public static void printPath (Graph G, int [] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x!=s) {
            path.add (0, x);
            x = pred[x];
        }
        path.add (0, s);
        System.out.println (path);
    }

    public static int[][] floydWarshall(Graph graph) {
        int graphSize = graph.getNumberOfVertices();
        int [][] matrix = graph.getWeightMatrix();

        for (int i = 0; i < graphSize; i++) {
            for (int j = 0; j < graphSize; j++) {
                for (int k = 0; k < graphSize; k++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }

        return matrix;
    }

    public static int findGraphCenter(Graph graph) {
        int[][] matrix = floydWarshall(graph);
        int[] maxValueFromRow = new int[graph.getNumberOfVertices()];

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            maxValueFromRow[i]  = Arrays.stream(matrix[i]).max().getAsInt();
        }

        return getMinValueIndex(maxValueFromRow);
    }

    private static int getMinValueIndex(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
