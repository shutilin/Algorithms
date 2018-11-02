public class Main {
    public static void main(String[] args) {

        int[][] m = { {0,1,0,1}, {1,0,1,0}, {0,1,0,1}, {1,0,1,0} };

        Graph g = new Graph(4, m);

        GraphActions ga = new GraphActions(g);
        System.out.println(ga.isCycleExist());
        System.out.println(ga.getEulerianCycle());

    }
}
