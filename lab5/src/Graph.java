import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int[][] adjacencyMatrix;
    private int[][] weightMatrix;
    private int numberOfVertices;

    private List<Edge> edges;

    public Graph(int numberOfVertices, int[][] adjacencyMatrix, int[][] weightMatrix) {

        this.numberOfVertices = numberOfVertices;
        this.adjacencyMatrix = adjacencyMatrix;
        this.weightMatrix = weightMatrix;
        this.edges = new ArrayList<Edge>();
        this.populateEdges();

    }

    private void populateEdges() {
        for (int i = 0; i < numberOfVertices - 1; i++) {
            for (int j = i + 1; j < numberOfVertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    edges.add(new Edge(i, j, weightMatrix[i][j]));
                }
            }
        }
    }

    public int vertexDegree(int vertex) {
        int vertexDegree = 0;

        for (int i = 0; i < numberOfVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 || adjacencyMatrix[i][vertex] == 1) {
                vertexDegree++;
            }
        }

        return vertexDegree;
    }

    public void removeEdge(int a, int b) {
        this.adjacencyMatrix[a][b] = 0;
        this.adjacencyMatrix[b][a] = 0;
    }

    public void addEdge(int a, int b) {
        this.adjacencyMatrix[a][b] = 1;
        this.adjacencyMatrix[b][a] = 1;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getWeight(int firstVertex, int secondVertex) {
        return weightMatrix[firstVertex][secondVertex];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
