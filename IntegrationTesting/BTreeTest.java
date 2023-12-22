package IntegrationTesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BTreeTest {
    @Test
    void testBTreeInsertAndDelete() {
        // Create a BTree
        BTree<Integer> bTree = new BTree<>(3); // Adjust the order as needed

        // Insert keys into the BTree
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(15);
        bTree.insert(25);

        // Check the state of the BTree after insertion
        assertEquals(5, bTree.getTreeSize());
        assertEquals(2, bTree.getHeight());

        // Perform delete operation
        bTree.delete(15);

        // Check the state of the BTree after deletion
        assertEquals(4, bTree.getTreeSize());
        assertEquals(2, bTree.getHeight());


    }
}

