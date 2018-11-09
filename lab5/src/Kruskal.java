import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal {
    Graph graph;
    private Map<Integer, Integer> marks = new HashMap<>();


    public Kruskal(Graph graph) {
        this.graph = graph;
    }


    public List<Edge> kruskal() {
        List<Edge> mst = new ArrayList<>();
        this.setMarks();
        Edge minEdge;
        while(mst.size() < graph.getNumberOfVertices() - 1) {
            minEdge = getEdgeWithMinWeight();
            mst.add(minEdge);
            changeMarks(marks.get(minEdge.getU()), marks.get(minEdge.getV()));
        }

        return mst;
    }

    private Edge getEdgeWithMinWeight() {
        int minWeight = Integer.MAX_VALUE;

        Edge edge = new Edge();

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            for (int j = 0; j < graph.getNumberOfVertices(); j++) {
                if (graph.getAdjacencyMatrix()[i][j] > 0 && graph.getWeight(i,j) < minWeight) {
                    if (marks.get(i) != marks.get(j)) {
                        edge = new Edge(i, j, graph.getWeight(i, j));
                        minWeight = graph.getWeight(i, j);
                    }
                }
            }
        }

        return edge;
    }

    private List<Integer> getIncidentVertices(int[][] adjMatrix, int vertex) {

        List<Integer> incidentVertices = new ArrayList<Integer>();

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (adjMatrix[vertex][i] == 1) {
                incidentVertices.add(i);
            }
        }

        return incidentVertices;
    }

    private void setMarks() {
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            marks.put(i,i);
        }
    }

    private void changeMarks(int old, int current) {
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (marks.get(i) == old) {
                marks.put(i, current);
            }
        }
    }
}
