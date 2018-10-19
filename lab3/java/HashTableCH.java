import java.util.LinkedList;

public class HashTableCH {

    private static final int DEFAULT_CAPACITY = 1030;
    private LinkedList<NodeOA>[] nodes;
    private int capacity;
    private double A;

    public HashTableCH(double A) {
        nodes = new LinkedList[DEFAULT_CAPACITY];

        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            nodes[i] = null;
        }
        this.A = A;
        this.capacity = DEFAULT_CAPACITY;
    }


    public void insert(int key, int value) {
        int index = getHash(key);
        LinkedList<NodeOA> existingValues = nodes[index];

        if (nodes[index] == null) {
            nodes[index] = new LinkedList<NodeOA>();
            nodes[index].add(new NodeOA(key, value));
        } else {
            existingValues.add(new NodeOA(key, value));
        }
    }

    public int retrieve(int key) {
        int index = getHash(key);

        for (int i = 0; i < capacity; i++) {
            NodeOA node = nodes[index].get(i);
            if (node.getKey() == key) {
                return node.getValue();
            }
        }

        throw new IllegalArgumentException("Element not found");
    }

    private int getHash(int key) {
        return (int) ((key % 811) * A) % capacity;
    }

    public void print() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            System.out.println(nodes[i]);
        }
    }

    public int getMaxCollisionChainLength() {
        int maxLength = 0;
        for (LinkedList<NodeOA> nodesList : nodes) {
            if (nodesList != null) {
                int nodeListSize = nodesList.size();
                if (nodeListSize > maxLength) {
                    maxLength = nodeListSize;
                }
            }
        }
        return maxLength;
    }
}
