package DataStructure;

public class BinaryTree {

    private Node root;

    public void add(Node inputNode) {
        if (this.root == null) {
            this.root = inputNode;
        } else {
            Node tempNode = root;
            Node parentNode;

            while (true) {
                parentNode = tempNode;

                if (inputNode.getData() < tempNode.getData()) {
                    tempNode = tempNode.getLeft();

                    if (tempNode == null) {
                        parentNode.setLeft(inputNode);
                        return;
                    }
                } else {
                    tempNode = tempNode.getRight();

                    if (tempNode == null) {

                        parentNode.setRight(inputNode);
                        return;
                    }
                }
            }
        }
    }

    public void insertAtRoot(int item) {
        this.root = insertAtRootRec(item, this.root);
    }

    private Node insertAtRootRec(int item, Node head) {
        //System.out.println("root" + this.root.getData());
        if (head == null) {
            //System.out.println("head null" + this);
            return new Node(item);
        }
        if (item < head.getData()) {
            head.setLeft(insertAtRootRec(item, head.getLeft()));
            head = rotateRight(head);
            System.out.println("rr " + this);

        } else {
            head.setRight(insertAtRootRec(item, head.getRight()));
            head = rotateLeft(head);
            System.out.println("rl " + this);

        }


        return head;

    }

    private Node rotateRight(Node h) {
        Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);

        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);

        return x;
    }

    public int size() {
        return(size(this.root));
    }

    private int size(Node node) {
        if (node == null) return(0);
        else {
            return(size(node.getLeft()) + 1 + size(node.getRight()));
        }
    }

    public String toString()
    {
       return toString(this.root);
    }

    private String toString(Node root)
    {
        String result = "";

        if(root == null)
        {
            result = "null";
        }
        else
        {
            result = result + root.getData();

            if(root.getLeft() != null || root.getRight() != null)
            {
                result = "(" + result + ", "
                        + toString(root.getLeft());
                result = result + ", "
                        + toString(root.getRight()) + ")";
            }
        }

        return result;
    }

}
