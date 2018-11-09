public class Edge implements Comparable<Edge>{
    private int u;
    private int v;
    private int weight;

    public Edge() {}

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.getWeight();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Edge)) {
            return false;
        }

        Edge ed = (Edge) obj;


        return ((this.u == ed.u && this.v == ed.v) ||
                (this.u == ed.v && this.v == ed.u));
    }

    @Override
    public String toString() {
        return "[ " + u + " - " + v + " ]";
    }
}
