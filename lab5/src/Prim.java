import java.util.*;

public class Prim {
    Graph graph;

    public Prim(Graph graph) {
        this.graph = graph;
    }

    class ResultNode {
        int parent;
        int weight;
        public ResultNode() {}
        public ResultNode(int parent, int weight) {
            this.parent = parent;
            this.weight = weight;
        }
    }

    public List<Edge> prim() {
        int graphSize = graph.getNumberOfVertices();
        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        boolean[] visited = new boolean[graphSize];
        int[] keys = new int[graphSize];
        ResultNode[] map = new ResultNode[graphSize];

        for (int i = 0; i < graphSize; i++) {
            keys[i] = Integer.MAX_VALUE;
            map[i] = new ResultNode();
        }


        keys[0] = 0;
        map[0].parent = -1;
//        map[0].parent = -1;


        for (int i = 0; i < graphSize; i++) {
            int currentVertex = getMinVertex(visited, keys, graphSize);

            visited[currentVertex] = true;

            for (int j = 0; j < graphSize; j++) {
                if (adjacencyMatrix[currentVertex][j]==1) {
                    if(visited[j]==false && graph.getWeight(currentVertex,j)<keys[j]) {
                        keys[j] = graph.getWeight(currentVertex,j);
                        map[j] = new ResultNode(currentVertex, keys[j]);
                    }
                }
            }
        }

        List<Edge> result = new ArrayList<Edge>();
        for (int i = 1; i < graphSize; i++) {
            result.add(new Edge(i, map[i].parent, map[i].weight));
        }

        return result;
    }


    int getMinVertex(boolean[] visited, int[] key, int graphSize) {
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < graphSize; i++) {
            if (visited[i] == false && minKey > key[i]) {
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }

}
