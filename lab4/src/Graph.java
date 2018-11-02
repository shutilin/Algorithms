public class Graph {

    private int[][] adjacencyMatrix;
    private int numberOfVertices;

    public Graph(int numberOfVertices, int[][] adjacencyMatrix) {

        this.numberOfVertices = numberOfVertices;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public int vertexDegree(int vertex) {
        int vertexDegree = 0;

        for (int i = 0; i < numberOfVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 || adjacencyMatrix[i][vertex] == 1) {
                vertexDegree++;
            }
        }

        return  vertexDegree;
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

    public int getNumberOfVertices() {
        return numberOfVertices;
    }
}
