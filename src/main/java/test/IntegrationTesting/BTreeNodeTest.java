package test.IntegrationTesting;
import algorithm.BTNode;
import algorithm.BTree;
import org.junit.Test;
import static org.junit.Assert.*;

public class BTreeNodeTest {

    @Test
    public void testInsertionAndDeletion() {
        BTree<Integer> bTree = new BTree<>(3);

        // Test insertion
        bTree.insert(5);
        bTree.insert(3);
        bTree.insert(7);

        assertEquals(3, bTree.getTreeSize());
        assertEquals(2, bTree.getHeight());

        // Test deletion
        bTree.delete(3);

        assertEquals(2, bTree.getTreeSize());
        assertEquals(1, bTree.getHeight());
    }

    @Test
    public void testInsertionAndDeletionWithOrderGreaterThan3() {
        BTree<String> bTree = new BTree<>(5);

        // Test insertion
        bTree.insert("apple");
        bTree.insert("banana");
        bTree.insert("orange");

        assertEquals(3, bTree.getTreeSize());
        assertEquals(1, bTree.getHeight());

        // Test deletion
        bTree.delete("banana");

        assertEquals(2, bTree.getTreeSize());
        assertEquals(1, bTree.getHeight());
    }

   /* @Test
    public void testInsertionAndDeletionWithEmptyTree() {
        BTree<Double> bTree = new BTree<>(4);

        // Test deletion on an empty tree
        bTree.delete(3.14);

        assertEquals(0, bTree.getTreeSize());
        assertEquals(0, bTree.getHeight());
    }
 */
}
