package CodeBasedTesting.statement;
import static org.junit.Assert.*;
import org.junit.Test;


public class BTreeStatementTest {

    @Test
    public void testIsEmpty() {
        // Test when the tree is empty
        BTree<Integer> bTree1 = new BTree<>(3);
        assertTrue(bTree1.isEmpty());

        // Test when the tree is not empty
        BTree<Integer> bTree2 = new BTree<>(3);
        bTree2.insert(5);
        assertFalse(bTree2.isEmpty());
    }

    @Test
    public void testGetRoot() {
        // Test when the tree is empty
        BTree<Integer> bTree1 = new BTree<>(3);
        assertNull(bTree1.getRoot());

        // Test when the tree is not empty
        BTree<Integer> bTree2 = new BTree<>(3);
        bTree2.insert(5);
        assertNotNull(bTree2.getRoot());
    }

    // We will Add more tests for other methods as needed

}
