package CodeBasedTesting.condition;
import static org.junit.Assert.*;
import org.junit.Test;


public class BTreeConditionTest {
    @Test
    public void testDelete() {
        // Test deleting from an empty tree
        BTree<Integer> bTree1 = new BTree<>(3);
        bTree1.delete(5);  // No effect, tree is empty
        assertEquals(0, bTree1.getTreeSize());

        // Test deleting from a non-empty tree
        BTree<Integer> bTree2 = new BTree<>(3);
        bTree2.insert(5);
        bTree2.insert(3);
        bTree2.insert(7);
        bTree2.delete(5);
        assertEquals(2, bTree2.getTreeSize());  // Size reduced after deletion
        // Add more assertions for the desired state after deletion
    }
}
