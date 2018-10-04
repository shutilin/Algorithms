import DataStructure.BinaryTree;
import DataStructure.Node;

public class Main {

    public static void main(String[] args) throws Exception{
        BinaryTree bt = new BinaryTree();
        Node root = new Node(3);
        bt.add(root);
        bt.add(new Node(1));
        bt.add(new Node(2));
        bt.add(new Node(8));
        bt.add(new Node(5));
        bt.add(new Node(0));

//        //OutputStreamWriter os = new FileOutputStream("");
//        OutputStream outputStream       = new FileOutputStream("D:\\BSU\\3_course\\algs\\res.txt");
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//
//        root.printTree(outputStreamWriter);

        System.out.println(bt.toString());
        bt.insertAtRoot(6);
        System.out.println(bt.toString());

    }
}
