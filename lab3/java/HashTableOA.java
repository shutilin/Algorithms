public class HashTableOA {

    private static final int DEFAULT_CAPACITY = 1030;
    private NodeOA[] nodes;
    private int capacity;


    public HashTableOA() {
        nodes = new NodeOA[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            nodes[i] = null;
        }
        this.capacity = DEFAULT_CAPACITY;
    }

    public void insert(int key, int value) {
        int index = getHash(key);
        int iterator = 1;
        while (nodes[index] != null) {
            index = (index + iterator * iterator) % capacity;
            iterator++;
        }
        nodes[index] = new NodeOA(key, value);
    }


    public int retrieve(int key) {

        int index = getHash(key);
        int iterator = 1;
        while (nodes[index].getKey() != key && nodes[index] != null) {
            index = (index + iterator * iterator) % capacity;
            iterator++;
        }

        if (nodes[index].getKey() == key) {
            return nodes[index].getValue();
        } else {
            throw new IllegalArgumentException("Element not found");
        }
    }

    ;

    private int getHash(int key) {
        return (int) ((key % 811) * 0.38066) % capacity;
    }


    public void print() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            System.out.println(nodes[i]);
        }
    }
}
