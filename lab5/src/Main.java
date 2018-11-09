
public class Main {

    public static void main(String[] args) {
        int[][] adj = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] w = {{-1,1,20},{1,-1,3},{20,3,-1}};

        Graph g = new Graph(3,adj,w);

        Kruskal kruskal = new Kruskal(g);
        Prim prim = new Prim(g);

        GraphConsoleProvider console = new GraphConsoleProvider(g);
        console.showMenu();

    }
}
