import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GraphConsoleProvider {

    private Graph graph;

    public GraphConsoleProvider(Graph graph) {
        this.graph = graph;
    }

    public void showMenu() {


        while (true) {
            String menuOptions =
                    "1.Print graph\n" +
                            "2.Add edge\n" +
                            "3.Remove edge\n" +
                            "4.Kruskal\n" +
                            "5.Prim\n" +
                            "6.Kruskal + Prim (Merged)\n" +
                            "7.Exit";

            System.out.println(menuOptions);

            Scanner in = new Scanner(System.in);
            System.out.println("Select option ");
            int option = in.nextInt();

            if (option == 7) {
                break;
            }

            runOptionMethod(option);
        }
    }

    private void runOptionMethod(int option) {
        switch (option) {
            case 1:
                System.out.println(graph.toString());
                break;
            case 2:
                addEdge();
                break;
            case 3:
                removeEdge();
                break;
            case 4:
                kruskal();
                break;
            case 5:
                prim();
                break;
            case 6:
                merged();
                break;
            default:
                System.out.println("Incorrect option");

        }
    }

    private void addEdge() {
        Scanner in = new Scanner(System.in);
        System.out.println("First vertex: ");
        int a = in.nextInt();
        System.out.println("Second vertex: ");
        int b = in.nextInt();

        graph.addEdge(a, b);
        System.out.println("Edge was added");
        System.out.println(graph.toString());

    }

    private void removeEdge() {
        Scanner in = new Scanner(System.in);
        System.out.println("First vertex: ");
        int a = in.nextInt();
        System.out.println("Second vertex: ");
        int b = in.nextInt();

        graph.removeEdge(a, b);
        System.out.println("Edge was removed");
        System.out.println(graph.toString());
    }

    private void kruskal() {
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(Arrays.toString(kruskal.kruskal().toArray()));
    }

    private void prim() {
        Prim prim = new Prim(graph);
        System.out.println(Arrays.toString(prim.prim().toArray()));
    }

    private void merged(){
        Kruskal kruskal = new Kruskal(graph);
        Prim prim = new Prim(graph);

        List<Edge> kruskalEdges = kruskal.kruskal();
        List<Edge> primEdges = prim.prim();

        for (Edge kruskalEdge: kruskalEdges) {
            if (!primEdges.contains(kruskalEdge)) {
                primEdges.add(kruskalEdge);
            }
        }

        System.out.println(Arrays.toString(primEdges.toArray()));

    }

}
