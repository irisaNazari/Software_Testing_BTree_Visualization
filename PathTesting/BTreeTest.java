package PathTesting;
import algorithm.BTree;

public class BTreeTest {
    public static void main(String[] args) {
        // Test the BTree methods here
        BTree<Integer> bTree = new BTree<>(4); // Adjust the order as needed

        // Insert some keys
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);

        // Print the tree after insertions
        System.out.println("Tree after insertions:");
        System.out.println(bTree.getRoot());
        System.out.println("Height: " + bTree.getHeight());
        System.out.println();

        // Perform some deletions
        bTree.delete(5);
        bTree.delete(20);

        // Print the tree after deletions
        System.out.println("Tree after deletions:");
        System.out.println(bTree.getRoot());
        System.out.println("Height: " + bTree.getHeight());
    }

}
