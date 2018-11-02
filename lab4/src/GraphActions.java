import java.util.*;


/*
    This is an algorithm to find an Eulerian circuit in a connected graph in which every vertex
    has even degree.
    1. Choose any vertex v and push it onto a stack. Initially all edges are unmarked.
    2. While the stack is nonempty, look at the top vertex, u, on the stack. If u has an
    unmarked incident edge, say, to a vertex w, then push w onto the stack and mark the
    edge uw. On the other hand, if u has no unmarked incident edge, then pop u off the
    stack and print it.
 */

public class GraphActions {

    private Graph graph;

    public GraphActions(Graph graph) {
        this.graph = graph;
    }

    public void BFS (int rootVertex) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(rootVertex);
        boolean[] markedVertices = new boolean[graph.getNumberOfVertices()];

        markedVertices[rootVertex] = true;

        int n, unmarkedChild;
        while (!queue.isEmpty()) {
            n = queue.peek();
            unmarkedChild = getUnmarkedChildVertex(n, markedVertices);

            if (unmarkedChild != -1) {
                markedVertices[unmarkedChild] = true;
                queue.add(unmarkedChild);
            } else {
                queue.remove();
            }
        }
    }

    private int getUnmarkedChildVertex(int vertex, boolean[] markedVertices) {
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (graph.getAdjacencyMatrix()[vertex][i] == 1) {
                if (!markedVertices[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean isCycleExist() {
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (graph.vertexDegree(i) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getEulerianCycle() {
        List<Integer> cycle = new ArrayList<Integer>();

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int[][] adjMatrix = graph.getAdjacencyMatrix();


        while(!stack.empty()) {
            int topVertex = stack.peek();
            List<Integer> incidentVertices = getIncidentVertices(adjMatrix, topVertex);
            if (!incidentVertices.isEmpty()) {
                int incidentVertex = incidentVertices.get(0);
                stack.push(incidentVertex);
                adjMatrix[topVertex][incidentVertex] = 0;
                adjMatrix[incidentVertex][topVertex] = 0;
            } else {
                cycle.add(stack.pop());
            }
        }

        return cycle;
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


}
