package FunctionalTesting;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestBTree {
    @Test
    public void testIsEmpty() {
        BTree<Integer> treeUnderTest = new BTree<>(/* Order */);

        // Test when tree is empty
        assertTrue(treeUnderTest.isEmpty());

        // Test when tree has one node
        treeUnderTest.insert(/* Some key */);
        assertFalse(treeUnderTest.isEmpty());

        // Test when tree has multiple nodes
        // Insert more keys
        assertFalse(treeUnderTest.isEmpty());
    }
    @Test
    public void testInsertAndDelete() {
        BTree<Integer> treeUnderTest = new BTree<>(/* Order */);

        // Insert keys
        treeUnderTest.insert(/* Key 1 */);
        treeUnderTest.insert(/* Key 2 */);
        treeUnderTest.insert(/* Key 3 */);

        // Test the tree size after insertions
        assertEquals(3, treeUnderTest.getTreeSize());

        // Delete keys
        treeUnderTest.delete(/* Key to delete */);

        // Test the tree size after deletions
        // Add more delete scenarios
        assertEquals(/* Expected size after deletions */, treeUnderTest.getTreeSize());
    }
    @Test
    public void testGetHeight() {
        BTree<Integer> treeUnderTest = new BTree<>(/* Order */);

        // Test when tree is empty
        assertEquals(0, treeUnderTest.getHeight());

        // Test when tree has one level
        // Insert keys
        assertEquals(1, treeUnderTest.getHeight());

        // Test when tree has multiple levels
        // Insert more keys
        assertEquals(/* Expected height */, treeUnderTest.getHeight());
    }

}
